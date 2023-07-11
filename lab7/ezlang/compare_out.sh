#!/bin/bash
ROOT=/home/juliana/compiladores-labs/lab7
# ROOT=/home/fgasouza/compiladores-labs/lab5
ANTLR_PATH=$ROOT/tools/antlr-4.11.1-complete.jar
CLASS_PATH_OPTION="-cp .:$ANTLR_PATH"

BIN_PATH=bin

DATA=$ROOT/ezlang
IN=$ROOT/ezlang/out07
OUT=$ROOT/ezlang/out07_diff

for infile in `ls $IN/c*.out`; do
    base=$(basename $infile)
    # outfile=$OUT/${base/.ezl/.out}
    outfile=$OUT/$base
    echo Running $base
    $infile diff -w $outfile -
done

# for infile in `ls $IN/c*.ezl`; do
#     base=$(basename $infile)
#     outfile=$OUT/${base/.ezl/.tm}
#     #outfile=$DATA/out07_diff/$base
#     echo Running $base
#     java $CLASS_PATH_OPTION:$BIN_PATH Main $infile | diff -w $outfile -
# done
