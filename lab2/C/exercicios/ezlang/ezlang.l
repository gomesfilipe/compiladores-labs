%option yylineno
%option outfile="ezlang.c"
%option noyywrap
%option nounput
%option noinput

%{
#include "parser.h" // For the token types from bison.
%}

int_val ([1-9][0-9]*)|0
real_val {int_val}\.{int_val}
str_val \"[^"]*\"
id [A-Za-z][A-Za-z0-9_\-]*

%%
"{"[^\}]*"}" { }
[ \t\n\r]+   { }
"begin"      { /*return BEGIN;*/ }
"bool"       { return BOOL; }
"else"       { return ELSE; }
"end"        { return END; }
"false"      { return FALS; }
"if"         { return IF; }
"int"        { return INT; }
"program"    { return PROGRAM; }
"read"       { return READ; }
"real"       { return REAL; }
"repeat"     { return REPEAT; }
"string"     { return STRING; }
"then"       { return THEN; }
"true"       { return TRU; }
"until"      { return UNTIL; }
"var"        { return VAR; }
"write"      { return WRITE; }
":="         { return ASSIGN; }
"="          { return EQ; }
"<"          { return LT; }
"+"          { return PLUS; }
"-"          { return MINUS; }
"*"          { return TIMES; }
"/"          { return OVER; }
"("          { return LPAR; }
")"          { return RPAR; }
";"          { return SEMI; }
{int_val}    { /*return INT_VAL;*/ } 
{real_val}   { /*return REAL_VAL;*/ }
{str_val}    { /*return STR_VAL;*/ }
{id}         { /*return ID;*/ }
.            { printf("LEXICAL ERROR (%d): Unknown symbol %s\n",yylineno, yytext); exit(EXIT_FAILURE); }
%%
