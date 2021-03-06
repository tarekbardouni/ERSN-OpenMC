from __future__ import print_function
import os
import shutil
import subprocess
import sys
import tarfile
import glob
import hashlib
import argparse

from six.moves import input
from six.moves.urllib.request import urlopen

import openmc.data


description = """
Download ENDF/B-VII.1 ACE data from NNDC and convert it to an HDF5 library for
use with OpenMC. This data is used for OpenMC's regression test suite.
"""


class CustomFormatter(argparse.ArgumentDefaultsHelpFormatter,
                      argparse.RawDescriptionHelpFormatter):
    pass

parser = argparse.ArgumentParser(
    description=description,
    formatter_class=CustomFormatter
)
parser.add_argument('-b', '--batch', action='store_true',
                    help='supresses standard in')
parser.add_argument('--libver', choices=['earliest', 'latest'],
                    default='earliest', help="Output HDF5 versioning. Use "
                    "'earliest' for backwards compatibility or 'latest' for "
                    "performance")
args = parser.parse_args()


baseUrl = 'http://www.nndc.bnl.gov/endf/b7.1/aceFiles/'
files = ['ENDF-B-VII.1-neutron-293.6K.tar.gz',
         'ENDF-B-VII.1-tsl.tar.gz']
checksums = ['9729a17eb62b75f285d8a7628ace1449',
             'e17d827c92940a30f22f096d910ea186']
block_size = 16384

# ==============================================================================
# DOWNLOAD FILES FROM NNDC SITE

filesComplete = []
for f in files:
    # Establish connection to URL
    url = baseUrl + f
    req = urlopen(url)

    # Get file size from header
    if sys.version_info[0] < 3:
        file_size = int(req.info().getheaders('Content-Length')[0])
    else:
        file_size = req.length
    downloaded = 0

    # Check if file already downloaded
    if os.path.exists(f):
        if os.path.getsize(f) == file_size:
            print('Skipping ' + f)
            filesComplete.append(f)
            continue
        else:
            overwrite = input('Overwrite {0}? ([y]/n) '.format(f))
            if overwrite.lower().startswith('n'):
                continue

    # Copy file to disk
    print('Downloading {0}... '.format(f), end='')
    with open(f, 'wb') as fh:
        while True:
            chunk = req.read(block_size)
            if not chunk: break
            fh.write(chunk)
            downloaded += len(chunk)
            status = '{0:10}  [{1:3.2f}%]'.format(
                downloaded, downloaded * 100. / file_size)
            print(status + chr(8)*len(status), end='')
        print('')
        filesComplete.append(f)

# ==============================================================================
# VERIFY MD5 CHECKSUMS

print('Verifying MD5 checksums...')
for f, checksum in zip(files, checksums):
    downloadsum = hashlib.md5(open(f, 'rb').read()).hexdigest()
    if downloadsum != checksum:
        raise IOError("MD5 checksum for {} does not match. If this is your first "
                      "time receiving this message, please re-run the script. "
                      "Otherwise, please contact OpenMC developers by emailing "
                      "openmc-users@googlegroups.com.".format(f))

# ==============================================================================
# EXTRACT FILES FROM TGZ

for f in files:
    if f not in filesComplete:
        continue

    # Extract files
    suffix = f[f.rindex('-') + 1:].rstrip('.tar.gz')
    with tarfile.open(f, 'r') as tgz:
        print('Extracting {0}...'.format(f))
        tgz.extractall(path='nndc/' + suffix)

# Move ACE files down one level
for filename in glob.glob('nndc/293.6K/ENDF-B-VII.1-neutron-293.6K/*'):
    shutil.move(filename, 'nndc/293.6K/')

# ==============================================================================
# FIX ZAID ASSIGNMENTS FOR VARIOUS S(A,B) TABLES

def fix_zaid(table, old, new):
    filename = os.path.join('nndc', 'tsl', table)
    with open(filename, 'r') as fh:
        text = fh.read()
    text = text.replace(old, new, 1)
    with open(filename, 'w') as fh:
        fh.write(text)

print('Fixing ZAIDs for S(a,b) tables')
fix_zaid('bebeo.acer', '8016', '   0')
fix_zaid('obeo.acer', '4009', '   0')

# ==============================================================================
# PROMPT USER TO DELETE .TAR.GZ FILES

# Ask user to delete
if not args.batch:
    response = input('Delete *.tar.gz files? ([y]/n) ')
else:
    response = 'y'

# Delete files if requested
if not response or response.lower().startswith('y'):
    for f in files:
        if os.path.exists(f):
            print('Removing {0}...'.format(f))
            os.remove(f)

# ==============================================================================
# GENERATE HDF5 LIBRARY

# get a list of all ACE files
ace_files = sorted(glob.glob(os.path.join('nndc', '**', '*.ace*')))

# Get path to fission energy release data
data_dir = os.path.dirname(sys.modules['openmc.data'].__file__)
fer_file = os.path.join(data_dir, 'fission_Q_data_endfb71.h5')

# Call the ace-to-hdf5 conversion script
pwd = os.path.dirname(os.path.realpath(__file__))
ace2hdf5 = os.path.join(pwd, 'openmc-ace-to-hdf5')
subprocess.call([ace2hdf5,
                 '-d', 'nndc_hdf5',
                 '--fission_energy_release', fer_file,
                 '--libver', args.libver] + ace_files)
