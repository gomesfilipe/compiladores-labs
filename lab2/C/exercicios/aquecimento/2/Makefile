
all: bison flex gcc
	@echo "Done."

bison: parser.y
	bison --defines=parser.h parser.y

flex: scanner.l
	flex scanner.l

gcc: scanner.c parser.c
	gcc -Wall scanner.c parser.c -ly

clean:
	@rm -f *.o *.output scanner.c parser.h parser.c a.out
