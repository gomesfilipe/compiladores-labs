%option outfile="scanner.c"
%option noyywrap
%option nounput
%option noinput

%{
#include "parser.h" // For the token types from bison.
int sum = 0;
%}

%%

[0-9]+                { sum += (atoi(yytext)); return NUMBER; }
"+"                   { return PLUS; }
"\n"                  { printf("sum = %d\n", sum); return ENTER; }
<<EOF>>               { return EOF; }
" "                   { /* ignore spaces */ }
.                     { printf("LEXICAL ERROR: Unknown symbol %s\n", yytext);
                        exit(EXIT_FAILURE); }
