grammar Q01;

WS     : [ \t\n]+ -> skip ;
LPAR   : '(' ;
RPAR   : ')' ;
CHAR   : 'a' ;
ENTER  : '\n' ;

line:
    expr ENTER
;

expr:
    LPAR expr RPAR
|   CHAR
;
