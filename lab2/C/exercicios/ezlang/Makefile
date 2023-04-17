
all: bison flex gcc
	@echo "Done."

bison: parser.y
	bison parser.y

flex: ezlang.l
	flex ezlang.l

gcc: ezlang.c parser.c
	gcc -Wall ezlang.c parser.c -ly

clean:
	@rm -f *.o *.output ezlang.c parser.h parser.c a.out
