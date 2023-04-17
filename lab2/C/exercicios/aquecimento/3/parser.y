%{
#include <stdio.h>
int yylex(void);
void yyerror(char const *s);
%}
%token IF ELSE OTHER EXP LPAR RPAR ENTER 
%%
line: expr ENTER ;
expr: ifstmt | OTHER ;
ifstmt: IF LPAR EXP RPAR expr | IF LPAR EXP RPAR expr ELSE expr
%%
int main(void) {
    if (yyparse() == 0) printf("PARSE SUCCESSFUL!\n");
    else                printf("PARSE FAILED!\n");
    return 0;
}
