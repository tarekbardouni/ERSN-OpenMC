#!/bin/bash

INSTALL_DIR=$1
DEBUG_STATUS=$2
OPENMP_STATUS=$3
echo "            ****** Directory     : " $INSTALL_DIR
echo "            ****** DEBUG_STATUS  : " $DEBUG_STATUS
echo "            ****** openmp_STATUS : " $OPENMP_STATUS


export FC=gfortran
export HDF5_ROOT=/opt/hdf5

if [ $DEBUG_STATUS=="USED" ]; then
	DEBUG_OPTION='-Ddebug=on'
else
        DEBUG_OPTION=' '
fi

#
cd  $INSTALL_DIR
#
git clone https://github.com/mit-crpg/openmc.git
#
cd openmc
#
git checkout master
#
mkdir build && cd build
make clean
#
find -iname '*cmake*' -not -name CMakeLists.txt -exec rm -rf {} \+

cmake $DEBUG_OPTION ..
#
make 
sudo make install 
sudo make install -e prefix=$INSTALL_DIR/openmc

echo "              *************************************************  "
echo "                 OpenMC sequential version has been installed    "
echo "              *************************************************  "

echo " "
printf "Press 'CTRL+C' to exit : "
trap "exit" INT
while :
do
    sleep 10000 
done


