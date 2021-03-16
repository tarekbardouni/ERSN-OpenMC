#!/bin/bash 

openmc_dir=$1

null=""
echo $openmc_dir " has been chosen !"
pwd
myscripts_dir="$(pwd)"
echo $myscripts_dir

if [[ $openmc_dir = $null ]]; then
	DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
	cd $DIR
   	tmp=$(cat ../config/cross_sections.dir)
   	xsfolder=${tmp%/*} 
	datadir="$(dirname "$xsfolder")"
	if [ -d "$datadir" ]; then
 		cd $datadir
		openmc_dir=$(pwd)
		echo $datadir
	else
		echo $datadir
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
	datadir="$openmc_dir/data"
	if [ -d "$datadir" ]; then
		cd  $datadir
		echo "/data exists"
		pwd
	else
		echo "/data doesn't exist"
		mkdir $datadir
		cd $datadir
		pwd			 
	fi
fi
echo " "
echo "***********************************************************************"
echo "************   Downloading nndc neutron cross sections   **************"
echo "************          to the following path :            **************"
echo "************                  "/data"                    **************"
echo "***********************************************************************"
echo " "

pwd
if [[ -f "/usr/bin/python3" ]]; then
    echo "************   copying /usr/bin/python3 to /usr/bin/python   **************"
    sudo cp /usr/bin/python3 /usr/bin/python
else 
    echo "************   copying /usr/bin/python2 to /usr/bin/python   **************"sudo cp /usr/bin/python2 /usr/bin/python
fi
python $openmc_dir/openmc/scripts/openmc-get-nndc-data



printf "Press 'CTRL+C' to exit : "
trap "exit" INT
while :
do
    sleep 10000 
done

