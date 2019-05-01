#!/bin/bash 

nndc_dir=$1
openmc_dir=$2
null=""
echo $openmc_dir
echo $nndc_dir
if [[ $nndc_dir = $null ]]; then
		echo " "
		echo " "
		echo "       Warning :    Choose NNDC directory first ! "
		echo " "
		printf "                Nothing done. Press 'CTRL+C' to exit  "
		trap "exit" INT
		while :
		do
    		    sleep 10000 
		done		 
else
	hdf5datadir="$( cd "$nndc_dir" && cd .. && mkdir nndc_hdf5 && cd nndc_hdf5 && pwd )"
	cd  $hdf5datadir
	
fi
echo " "
echo "***********************************************************************"
echo "************   Converting nndc neutron cross sections    **************"
echo "************               to hdf5 format                **************"
echo "************   ./nndc_hdf5 directory will be created     **************"
echo "***********************************************************************"
echo " "

$openmc_dir/scripts/openmc-ace-to-hdf5 --xml $nndc_dir/cross_sections.xml

echo "           *********************************************"
echo "               changing    ../config/cross_sections.dir "
echo "           *********************************************"

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
	cd $DIR
   	echo "$hdf5datadir/cross_sections.xml" > ../config/cross_sections.dir

echo "           *********************************************"
echo "               check if no error message then exit      "
echo "           *********************************************"
echo " "


printf "Press 'CTRL+C' to exit : "
trap "exit" INT
while :
do
    sleep 10000 
done

