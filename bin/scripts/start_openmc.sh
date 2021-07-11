
#!/bin/bash
#------------------------------------------------------------------------------
export HDF5_ROOT=/opt/hdf5
export OPENMC_CROSS_SECTIONS=$1
#------------------------------------------------------------------------------
openmcexecutable=$2
openmcproject_dir=$3
options_1=$4
options_2=$5
options_3=$6
options_4=$7
options_5=$8
options_6=$9
options_7=$10
options_8=$11
options_9=$12
usergmail=$13
#
options=$(echo $options_1 $options_2 $options_3 $options_4 $options_5 $options_6 $options_7 $options_8 $options_9)

OPT=$(echo $options | sed -e "s/empty/""/g")
echo "*************************************************************************"
echo "*****                  choosen options to run OpenMC                *****"
echo "*************************************************************************"
echo "  " $OPT
echo "*************************************************************************"
#
#------------------------------------------------------------------------------
#
cd  $openmcproject_dir 
#
$openmcexecutable   $OPT
#------------------------------------------------------------------------------

if [ "$usergmail" != "" ];then
   echo "THE SIMULATION IS FINISHED" | mutt -s "ERSN-OPENMC ALERT"  $usergmail -a ./tallies.out
   echo " An email has been sent to your mail box "
fi

echo " "
echo "           *********************************************"
echo "                   OpenMC simulation has finished"
echo "           *********************************************"
echo " "
printf "Press 'CTRL+C' to exit : "
trap "exit" INT
while :
do
    sleep 10000 
done

