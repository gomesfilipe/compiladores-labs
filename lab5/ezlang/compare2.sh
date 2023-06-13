#!/bin/bash
# ROOT=/home/filipe/git/compiladores-labs/lab5
ROOT=/home/fgasouza/compiladores-labs/lab5
ANTLR_PATH=$ROOT/tools/antlr-4.11.1-complete.jar
CLASS_PATH_OPTION="-cp .:$ANTLR_PATH"

# GRAMMAR_NAME=EZ
BIN_PATH=bin

# DATA=/home/filipe/git/compiladores-labs/lab4/ezlang
DATA=$ROOT/ezlang
IN=$DATA/in
OUT=$DATA/out05

for infile in `ls $IN/c*.ezl`; do
    base=$(basename $infile)
    outfile=$OUT/${base/.ezl/.out}
    echo Running $base
    java $CLASS_PATH_OPTION:$BIN_PATH Main < $infile 2>/dev/null | diff -w $outfile -
done
