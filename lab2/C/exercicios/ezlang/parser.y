%output "parser.c"          // File name of generated parser.
%defines "parser.h"         // Produces a 'parser.h'
%define parse.error verbose // Give proper messages when a syntax error is found.
%define parse.lac full      // Enable LAC to improve syntax error handling.

%{
#include <stdio.h>
#include <stdlib.h>
int yylex(void);
void yyerror(char const *s);
extern int yylineno;
%}

%token T_BEGIN BOOL ELSE END FALSE IF INT PROGRAM READ REAL REPEAT STRING THEN TRUE UNTIL VAR WRITE ASSIGN EQ LT PLUS MINUS TIMES OVER LPAR RPAR SEMI INT_VAL REAL_VAL STR_VAL ID 
%left T_BEGIN BOOL ELSE END FALSE IF INT PROGRAM READ REAL REPEAT STRING THEN TRUE UNTIL VAR WRITE EQ LPAR RPAR SEMI INT_VAL REAL_VAL STR_VAL ID 
%left ASSIGN LT
%left PLUS MINUS
%left TIMES OVER


%%
program: PROGRAM ID SEMI varssect stmtsect ;
varssect: VAR optvardecl ;
optvardecl: %empty | vardecllist ;

vardecllist: vardecllist vardecl | vardecl ;
vardecl: typespec ID SEMI ;
typespec: BOOL | INT | REAL | STRING ;
stmtsect: T_BEGIN stmtlist END ;
stmtlist: stmtlist stmt | stmt ;
stmt: ifstmt | repeatstmt | assignstmt | readstmt | writestmt ;

ifstmt: IF expr THEN stmtlist END ;
ifstmt: IF expr THEN stmtlist ELSE stmtlist END ;

repeatstmt: REPEAT stmtlist UNTIL expr ;
assignstmt: ID ASSIGN expr SEMI ;
readstmt: READ ID SEMI ;
writestmt: WRITE expr SEMI ;

expr: expr LT expr ;
expr: expr EQ expr ;
expr: expr PLUS expr ;
expr: expr MINUS expr ;
expr: expr TIMES expr ;
expr: expr OVER expr ;
expr: LPAR expr RPAR ;
expr: TRUE ;
expr: FALSE ;
expr: INT_VAL ;
expr: REAL_VAL ;
expr: STR_VAL ;
expr: ID ;
%%

void yyerror (char const *s) {
    printf("SYNTAX ERROR (%d): %s\n", yylineno, s);
    exit(EXIT_FAILURE);
}

int main(void) {
    if (yyparse() == 0) printf("PARSE SUCCESSFUL!\n");
    // else                printf("PARSE FAILED!\n");
    return 0;
}
