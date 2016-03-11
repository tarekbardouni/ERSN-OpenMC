
#!/bin/bash
openmc_project_dir=$1
openmc_xml_validation_dir=$2
openmc_relaxng_dir=$3

# delete OpenMC XML file until it is not empty
cmfd_file=$openmc_project_dir"/cmfd.xml"
plot_file=$openmc_project_dir"/plots.xml"
tallies_file=$openmc_project_dir"/tallies.xml"
#

if [ -f $cmfd_file  ]; then
     if [ -s $cmfd_file  ];then
          echo ""
     else
          rm  $cmfd_file
     fi
fi

if [ -f $plot_file ];then
      if [ -s $plot_file ];then
           echo ""
      else
           rm  $plot_file
      fi
fi

if [ -f $tallies_file ];then
      if [ -s $tallies_file ];then
           echo ""
      else
           rm  $tallies_file
      fi
fi

$openmc_xml_validation_dir -i $openmc_project_dir -r  $openmc_relaxng_dir


echo "           *********************************************"
echo "               xml files validation has been finished"
echo "           *********************************************"
echo " "
printf "Press 'CTRL+C' to exit : "
trap "exit" INT
while :
do
    sleep 10000 
done

