#!/bin/bash
##################################################################
PETSC_OPTION=""
INSTALL_DIR=$1
HDF5_STATUS=$2
PETSC_STATUS=$3


##################################################################
if [ $HDF5_STATUS=="USED" ]; then
    echo "HDF5 USED"
    export PATH=/opt/hdf5/bin:$PATH
    export LD_LIBRARY_PATH=/opt/hdf5/lib:$LD_LIBRARY_PATH
    export FC=h5pfc
else
    export "HDF5 NOT USED"
fi

if [ $PETSC_STATUS=="NOT-USED" ]; then
    export PETSC_DIR=/opt/petsc-3.4.4
    export PETSC_ARCH=linux-gnu-intel
    PETSC_OPTION="-Dpetsc=on"
    echo "PTSC USED"
else
    echo "PTSC NOT USED"
fi
########################################################
#
cd  $INSTALL_DIR
#
git clone https://github.com/mit-crpg/openmc.git
#
cd openmc
#
git checkout master
#

#########################################################
make clean
#
find -iname '*cmake*' -not -name CMakeLists.txt -exec rm -rf {} \+

cmake -Ddebug=on -Dopenmp=on PETSC_OPTION .
#
make
#
sudo make install -e prefix=$INSTALL_DIR/openmc

#########################################################

echo " "
echo "              *************************************************  "
echo "                 OpenMC // OMP  version has been installed    "
echo "              *************************************************  "

echo " "
printf "Press 'CTRL+C' to exit : "
trap "exit" INT
while :
do
    sleep 10000 
done
