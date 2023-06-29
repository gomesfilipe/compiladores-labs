#!/bin/bash
# ROOT=/home/filipe/git/compiladores-labs/lab5
ROOT=/home/fgasouza/compiladores-labs/lab5
ANTLR_PATH=$ROOT/tools/antlr-4.11.1-complete.jar
CLASS_PATH_OPTION="-cp .:$ANTLR_PATH"

BIN_PATH=bin

DATA=$ROOT/ezlang
IN=$DATA/in
OUT=$DATA/out05
MYOUT=$DATA/myout

for infile in `ls $IN/*.ezl`; do
    base=$(basename $infile)
    echo Running $base
    dotfile=$MYOUT/${base/.ezl/.dot}
    dotfileout=$OUT/${base/.ezl/.dot}
    make run < $infile 2> $dotfile > /dev/null
    diff -w $dotfile $dotfileout
done
