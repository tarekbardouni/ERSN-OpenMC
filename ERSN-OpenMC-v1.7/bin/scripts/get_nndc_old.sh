#!/bin/bash 

openmc_dir=$1
null=""
if [[ $openmc_dir = $null ]]; then
	DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
	cd $DIR
   	tmp=$(cat ../config/cross_sections.dir)
   	xsfolder=${tmp%/*} 
	datadir="$(dirname "$xsfolder")"
	if [ -d "$datadir" ]; then
 		cd $datadir
		openmc_dir=$(pwd)
	else
		echo " "
		echo " "
		echo "       Warning :    OpenMC must be installed first ! "
		echo " "
		printf "                Nothing done. Press 'CTRL+C' to exit  "
		trap "exit" INT
		while :
		do
    		    sleep 10000 
		done		 
	fi
else
	datadir="$openmc_dir/openmc/data"
	if [ -d "$datadir" ]; then
		cd  $datadir
	else
		echo " "
		echo " "
		echo "       Warning :    OpenMC must be installed first ! "
		echo " "
		printf "               Nothing done. Press 'CTRL+C' to exit : "
		trap "exit" INT
		while :
		do
    		    sleep 10000 
		done		 
	fi
fi
echo " "
echo "***********************************************************************"
echo "************   Downloading nndc neutron cross sections   **************"
echo "************          to the following path :            **************"
echo "************               "openmc/data"                   **************"
echo "***********************************************************************"
echo " "

python get_nndc_data.py




echo "           *********************************************"
echo "               download of nndc data has been finished"
echo "           *********************************************"
echo " "
printf "Press 'CTRL+C' to exit : "
trap "exit" INT
while :
do
    sleep 10000 
done

