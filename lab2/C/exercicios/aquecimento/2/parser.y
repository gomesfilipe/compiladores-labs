%{
#include <stdio.h>
int yylex(void);
void yyerror(char const *s);
%}
%token NUMBER OP LPAR RPAR ENTER
%%
line: expr ENTER ;
expr: LPAR expr RPAR | expr OP expr | NUMBER ;
%%
int main(void) {
    if (yyparse() == 0) printf("PARSE SUCCESSFUL!\n");
    else                printf("PARSE FAILED!\n");
    return 0;
}
