#!/bin/bash
#
export FC=gfortran

wget ftp://ftp.hdfgroup.org/HDF5/current/src/hdf5-*.tar.gz
#
tar -xzvf hdf5-*.tar.gz

cd hdf5-*; ./configure --prefix=/opt/hdf5  --enable-fortran \
           --enable-fortran2003
#
make
# make check
sudo make install
#
cd ..
rm  hdf5-*.tar.gz
rm -R hdf5-*;

echo "           *********************************************"
echo "               installation of hdf5 has been finished"
echo "           *********************************************"
echo " "
printf "Press 'CTRL+C' to exit : "
trap "exit" INT
while :
do
    sleep 10000 
done

