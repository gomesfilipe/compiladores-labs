#!/bin/bash
ROOT=/home/filipe/git/compiladores-labs/lab2/Java
ANTLR_PATH=$ROOT/tools/antlr-4.11.1-complete.jar
CLASS_PATH_OPTION="-cp .:$ANTLR_PATH"

GRAMMAR_NAME=EZ
GEN_PATH=parser

DATA=$ROOT/exercicios/ezlang
IN=$DATA/in
OUT=$DATA/out02

cd $GEN_PATH
for infile in `ls $IN/*.ezl`; do
	base=$(basename $infile)
	outfile=$OUT/${base/.ezl/.out}
	echo Running $base
	java $CLASS_PATH_OPTION org.antlr.v4.gui.TestRig $GRAMMAR_NAME \
		program $infile 2>&1 | diff -w $outfile -
done
