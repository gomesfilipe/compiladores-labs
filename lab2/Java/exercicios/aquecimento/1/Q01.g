grammar Q01;

begin:
    expr
;

expr:
    LPAR expr RPAR
|   CHAR
;

LPAR    : '(' ;
RPAR    : ')' ;
CHAR    : 'a' ;
WS      : [ \t\n]+ -> skip ;
UNKNOWN : . { System.out.println("Error line " + getLine() + ": Unknown token " + getText()) ; System.exit(0); } ;
