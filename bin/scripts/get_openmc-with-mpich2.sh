#!/bin/bash
petsc=""
HDF5_STATUS=$2
PETSC_STATUS=$3

if [ $HDF5_STATUS=="USED" ]; then
      export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/opt/hdf5/lib
      export FC=h5pfc
else
      export FC=mpif90
fi


if [ $PETSC_STATUS=="USED" ]; then
      export  PETSC_DIR= /opt/petsc-3.4.4
      export PETSC_ARCH=linux-gnu-intel
      PETSC_OPTION="-Dpetsc=on"
else
      echo " PETSC NOT USED"     
fi
cd  $install_dir
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

cmake -Ddebug=on $PETSC_OPTION .
#
make
#
sudo make install -e prefix=$install_dir/openmc

echo "    ***********************************************************************************"
echo "            Parallel version (MPICH2) of OpenMC has been installed succesfully"
echo "    ***********************************************************************************"

echo " "
printf "Press 'CTRL+C' to exit : "
trap "exit" INT
while :
do
    sleep 10000 
done

