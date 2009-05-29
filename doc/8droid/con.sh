wavs=$(ls *.wav)

for file in $wavs
do
  basename=`basename "$file" .wav`
  oggenc -o $basename.ogg $file
done
