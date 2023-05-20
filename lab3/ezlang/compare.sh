#!/bin/bash

YEAR=$(pwd | grep -o '20..-.')
# ROOT=/home/zambon/Teaching/$YEAR/CC/labs
ROOT=/home/fgasouza/compiladores-labs/lab3/
ANTLR_PATH=$ROOT/tools/antlr-4.11.1-complete.jar
CLASS_PATH_OPTION="-cp .:$ANTLR_PATH"

GRAMMAR_NAME=EZ
BIN_PATH=bin

DATA=/home/fgasouza/compiladores-labs/lab3/ezlang
IN=$DATA/in
OUT=$DATA/out03

for infile in `ls $IN/*.ezl`; do
  base=$(basename $infile)
  outfile=$OUT/${base/.ezl/.out}
  echo Running $base
  java $CLASS_PATH_OPTION:$BIN_PATH Main $infile 2>&1 | diff -w $outfile -
done
