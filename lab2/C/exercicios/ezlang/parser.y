%{
#include <stdio.h>
int yylex(void);
void yyerror(char const *s);
%}

%output "parser.c"          // File name of generated parser.
%defines "parser.h"         // Produces a 'parser.h'
%define parse.error verbose // Give proper messages when a syntax error is found.
%define parse.lac full      // Enable LAC to improve syntax error handling.

%token BEGIN BOOL ELSE END FALS IF INT PROGRAM READ REAL REPEAT STRING THEN TRU UNTIL VAR WRITE ASSIGN EQ LT PLUS MINUS TIMES OVER LPAR RPAR SEMI INT_VAL REAL_VAL STR_VAL ID 

%%
program: PROGRAM ID SEMI varssect stmtsect ;
varssect: VAR optvardecl ;
optvardecl: %empty | vardecllist ;

vardecllist: vardecllist vardecl | vardecl ;
vardecl: typespec ID SEMI ;
typespec: BOOL | INT | REAL | STRING ;
stmtsect: BEGIN stmtlist END ;
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
expr: TRU ;
expr: FALS ;
expr: INT_VAL ;
expr: REAL_VAL ;
expr: STR_VAL ;
expr: ID ;
%%

int main(void) {
    if (yyparse() == 0) printf("PARSE SUCCESSFUL!\n");
    else                printf("PARSE FAILED!\n");
    return 0;
}
