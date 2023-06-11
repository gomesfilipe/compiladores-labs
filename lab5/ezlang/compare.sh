#!/bin/bash
ROOT=/home/filipe/git/compiladores-labs/lab5
# ROOT=/home/fgasouza/compiladores-labs/lab4
ANTLR_PATH=$ROOT/tools/antlr-4.11.1-complete.jar
CLASS_PATH_OPTION="-cp .:$ANTLR_PATH"

# GRAMMAR_NAME=EZ
BIN_PATH=bin

# DATA=/home/filipe/git/compiladores-labs/lab4/ezlang
DATA=$ROOT/ezlang
IN=$DATA/in
OUT=$DATA/out05

# for infile in `ls myout/*.dot`; do
#   base=$(basename $infile)
#   outfile=$OUT/${base/.ezl/.dot}
#   echo Running $base
#   # java $CLASS_PATH_OPTION:$BIN_PATH Main < $infile 2>&1 | diff -w $outfile -
#   diff -w $infile $outfile
# done

# for infile in `ls $IN/*.ezl`; do
#   base=$(basename $infile)
#   echo Running $base
#   make run < $infile
# done

make run < in/c01.ezl 2> myout/c01.dot 
make run < in/c02.ezl 2> myout/c02.dot
make run < in/c03.ezl 2> myout/c03.dot
make run < in/c04.ezl 2> myout/c04.dot
make run < in/c05.ezl 2> myout/c05.dot
make run < in/c06.ezl 2> myout/c06.dot
make run < in/c07.ezl 2> myout/c07.dot
make run < in/c08.ezl 2> myout/c08.dot
make run < in/c09.ezl 2> myout/c09.dot
make run < in/c10.ezl 2> myout/c10.dot

diff -w myout/c01.dot out05/c01.dot
diff -w myout/c02.dot out05/c02.dot
diff -w myout/c03.dot out05/c03.dot
diff -w myout/c04.dot out05/c04.dot
diff -w myout/c05.dot out05/c05.dot
diff -w myout/c06.dot out05/c06.dot
diff -w myout/c07.dot out05/c07.dot
diff -w myout/c08.dot out05/c08.dot
diff -w myout/c09.dot out05/c09.dot
diff -w myout/c10.dot out05/c10.dot

# for infile in `ls $IN/*.ezl`; do
#   base=$(basename $infile)
#   outfile=$OUT/${base/.ezl/.out}
#   echo Running $base
#   # java $CLASS_PATH_OPTION:$BIN_PATH Main < $infile 2>&1 | diff -w $outfile -
#   java $CLASS_PATH_OPTION:$BIN_PATH Main < $infile 2>&1 | diff -w $outfile -
# done
