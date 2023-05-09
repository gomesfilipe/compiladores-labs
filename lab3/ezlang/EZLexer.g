lexer grammar EZLexer;

@header {
    package parser;
}

fragment INT_VALUE  : ([1-9][0-9]*)|'0' ;
fragment REAL_VALUE : INT_VALUE '.' INT_VALUE ;
fragment STR_VALUE  : '"'~["]*'"' ;
fragment ID_VALUE   : [A-Za-z][A-Za-z0-9_\-]* ;

WS : ([ \t\n\r]+) -> skip ;
COMMENT : ('{'~[}]*'}') -> skip ;
BEGIN : 'begin' ;
BOOL : 'bool' ;
ELSE : 'else' ;
END : 'end' ;
FALSE : 'false' ;
IF : 'if' ;
INT : 'int' ;
PROGRAM : 'program' ;
READ : 'read' ;
REAL : 'real' ;
REPEAT : 'repeat' ;
STRING : 'string' ;
THEN : 'then' ;
TRUE : 'true' ;
UNTIL : 'until' ;
VAR : 'var' ;
WRITE : 'write' ;
ASSIGN : ':=' ;
EQ : '=' ;
LT : '<' ;
MINUS : '-' ;
OVER : '/' ;
PLUS : '+' ;
SEMI : ';' ;
TIMES : '*' ;
LPAR : '(' ;
RPAR : ')' ;
INT_VAL : INT_VALUE ;
REAL_VAL: REAL_VALUE;
STR_VAL : STR_VALUE ;
ID : ID_VALUE ;
UNKNOWN : . ;
