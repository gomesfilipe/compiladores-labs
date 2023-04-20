grammar Q02;

begin:
    expr
;

expr:
    LPAR expr RPAR
|   expr TIMES expr | expr OVER expr
|   expr PLUS expr | expr MINUS expr
|   NUMBER
;

NUMBER  : [0-9]+ ;
PLUS    : '+' ;
MINUS   : '-' ;
TIMES   : '*' ;
OVER    : '/';
LPAR    : '(' ;
RPAR    : ')' ;
WS      : [ \t\n]+ -> skip ;
UNKNOWN : . { System.out.println("Error line " + getLine() + ": Unknown token " + getText()) ; System.exit(0); } ;
