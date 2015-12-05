#!/bin/bash

PETSC_OPTION=""
INSTALL_DIR=$1
HDF5_STATUS=$2
PETSC_STATUS=$3

echo $HDF5_STATUS

if [ $HDF5_STATUS=="USED" ]; then
    export PATH=/opt/hdf5/bin:$PATH
    echo " HDF5_STATUS: USED"
    export LD_LIBRARY_PATH=/opt/hdf5/lib:$LD_LIBRARY_PATH
    HDF5=$(which h5fc)
    if [ "$HDF5" != "/opt/hdf5/bin/h5fc" ]; then
        export FC="gfortran"
        echo " h5fc not found, gfortran is used "
    else
        export FC="h5fc"
        echo " h5fc found "
    fi
else
    echo " HDF5_STATUS: NOT-USED"
fi


if [ $PETSC_STATUS=="USED" ]; then
    echo " PETSC_STATUS: USED"
    export PETSC_DIR=/opt/petsc-3.4.4
    PETSC_OPTION="-Dpetsc=on"
else
    echo " PETSC_STATUS: NOT-USED"
    PETSC_OPTION=""
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
make clean
#
find -iname '*cmake*' -not -name CMakeLists.txt -exec rm -rf {} \+

cmake  -Ddebug=on  PETSC_OPTION .
#
make 
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


