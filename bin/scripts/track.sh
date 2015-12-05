
#!/bin/bash

trackpy_dir=$1
track_option=$2
track_file=$3
file_name=$4
$trackpy_dir  $track_option $track_file $file_name

echo '            *****************************************'
echo '             track file conversion has been finished'
echo '            *****************************************'

echo " "
printf "Press 'CTRL+C' to exit : "
trap "exit" INT
while :
do
    sleep 10000 
done

