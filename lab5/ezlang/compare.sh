#!/bin/bash

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
