#!/bin/bash

INSTALL_DIR=$1
DEBUG_STATUS=$2
OPENMP_STATUS=$3
OPENMC_VERSION=$4

echo "            ****** Directory     : " $INSTALL_DIR
echo "            ****** DEBUG_STATUS  : " $DEBUG_STATUS
echo "            ****** openmp_STATUS : " $OPENMP_STATUS
echo "            ****** OpenMC_Version : " $OPENMC_VERSION

export FC=gfortran
if [ -d /opt/hdf5 ]
then
	export HDF5_ROOT=/opt/hdf5
fi

if [ $DEBUG_STATUS == "USED" ]; then
	export DEBUG_OPTION='-Ddebug=on'
else
        export DEBUG_OPTION=' '
fi

if [ $OPENMP_STATUS == "USED" ]; then
	export OPENMP_OPTION='-Dopenmp=on'
else
        export OPENMP_OPTION=' '
fi
#
cd  $INSTALL_DIR

if [ $OPENMC_VERSION == "develop" ]
then
        git clone https://github.com/openmc-dev/openmc.git
        cd openmc
elif  [ $OPENMC_VERSION == "stable" ]
then
        wget https://github.com/openmc-dev/openmc/archive/v0.10.0.tar.gz
        tar zxvf v0.10.0.tar.gz
        mv openmc-0.10.0 openmc
        cd openmc
else
	echo " ***********    Check OpenMC version ! ********** "
fi

#
git checkout master
#
mkdir build && cd build
make clean
#
find -iname '*cmake*' -not -name CMakeLists.txt -exec rm -rf {} \+
cmake $OPENMP_OPTION $DEBUG_OPTION ..
#
make -j4 
sudo make install 
#make install -e prefix=$INSTALL_DIR/openmc

echo "              *************************************************  "
echo "                 OpenMC parallel version has been installed      "
echo "              *************************************************  "

echo " "
printf "Press 'CTRL+C' to exit : "
trap "exit" INT
while :
do
    sleep 10000 
done


