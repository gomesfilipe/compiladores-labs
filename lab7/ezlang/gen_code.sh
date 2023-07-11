#!/bin/bash

YEAR=$(pwd | grep -o '20..-.')
ROOT=/home/juliana/compiladores-labs/lab7
ANTLR_PATH=$ROOT/tools/antlr-4.11.1-complete.jar
CLASS_PATH_OPTION="-cp .:$ANTLR_PATH"

GRAMMAR_NAME=EZ
BIN_PATH=bin

DATA=$ROOT/ezlang
IN=$DATA/in
OUT=$DATA/out07

for infile in `ls $IN/c*.ezl`; do
    base=$(basename $infile)
    outfile=$OUT/${base/.ezl/.tm}
    echo
    echo Compiling $base
    java $CLASS_PATH_OPTION:$BIN_PATH Main $infile 1> $outfile
done
