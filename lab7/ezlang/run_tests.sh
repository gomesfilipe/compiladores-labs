#!/bin/bash

YEAR=$(pwd | grep -o '20..-.')
DATA=/home/juliana/compiladores-labs/lab7/ezlang
IN=$DATA/out07
OUT=$DATA/out07

EXE=./tmsim

for infile in `ls $IN/c*.tm`; do
    base=$(basename $infile)
    outfile=$OUT/${base/.tm/.out}
    echo Running $base
    $EXE < $infile > $outfile
done
