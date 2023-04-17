%option outfile="scanner.c"
%option noyywrap
%option nounput
%option noinput

%{
#include "parser.h" // For the token types from bison.
%}

%%

"if"    { return IF; }
"else"  { return ELSE; }
"other" { return OTHER; }
[0-1]   { return EXP; }
"("     { return LPAR; }
")"     { return RPAR; }
"\n"    { return ENTER; }
<<EOF>> { return EOF; }
" "     { /* ignore spaces */ }
.       { printf("LEXICAL ERROR: Unknown symbol %s\n", yytext);
          exit(EXIT_FAILURE); }
