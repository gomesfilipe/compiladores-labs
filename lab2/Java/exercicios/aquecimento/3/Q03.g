grammar Q03;

begin:
    expr ENTER
;

expr:
    ifstmt | OTHER
;

ifstmt:
    IF LPAR EXP RPAR expr 
|   IF LPAR EXP RPAR expr ELSE expr
;

IF      : 'if' ;
ELSE    : 'else' ;
OTHER   : 'other' ;
EXP     : [0-1] ;
LPAR    : '(' ;
RPAR    : ')' ;
ENTER   : '\n' ;
WS      : [ \t]+ -> skip ;
UNKNOWN : . { System.out.println("Error line " + getLine() + ": Unknown token " + getText()) ; System.exit(0); } ;
