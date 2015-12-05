#!/bin/bash
#
wget http://ftp.mcs.anl.gov/pub/petsc/release-snapshots/petsc-3.4.4.tar.gz
#
tar -xzvf petsc-3.4.4.tar.gz
#
cd petsc*; ./configure --prefix=/opt/petsc-3.4.4 --download-f-blas-lapack \
   --with-shared-libraries \
            --with-fortran-datatypes
#
make PETSC_ARCH=linux-gnu-intel  PETSC_DIR= /opt/petsc-3.4.4
# make check
sudo make install
#
cd ..
#
rm  petsc-3.4.4.tar.gz
#
rm -R petsc-3.4.4/

echo "               ******************************************"
echo "                PETSC-3.4.4 installing has been finished"
echo "               ******************************************"

echo " "
printf "Press 'CTRL+C' to exit : "
trap "exit" INT
while :
do
    sleep 10000 
done

