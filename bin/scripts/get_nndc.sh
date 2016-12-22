#!/bin/bash

openmc_dir=$1
if [  $openmc_dir !="" ]; then
   tmp=$(cat ../config/cross_sections.dir)
   xfolder=${tmp%/*} 
   cd $xfolder
   cd ../..
   openmc_dir=$(pwd)
fi
cd  $openmc_dir/openmc/data
#
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

