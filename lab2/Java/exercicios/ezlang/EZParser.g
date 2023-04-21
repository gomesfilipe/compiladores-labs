parser grammar EZParser;
options {
  tokenVocab = EZLexer;
}

program: 
  PROGRAM ID SEMI varssect stmtsect
;

varssect: 
  VAR optvardecl
;

optvardecl:
  vardecllist?
;

vardecllist: 
  vardecllist vardecl 
| vardecl 
;

vardecl:
  typespec ID SEMI 
;

typespec: 
  BOOL
| INT 
| REAL 
| STRING
;

stmtsect: 
  BEGIN stmtlist END
;

stmtlist: 
  stmtlist stmt 
| stmt 
;

stmt: 
  ifstmt 
| repeatstmt 
| assignstmt 
| readstmt 
| writestmt
;

ifstmt: 
  IF expr THEN stmtlist END
| IF expr THEN stmtlist ELSE stmtlist END 
;

repeatstmt: 
  REPEAT stmtlist UNTIL expr
;

assignstmt: 
  ID ASSIGN expr SEMI
;

readstmt: 
  READ ID SEMI
;

writestmt: 
  WRITE expr SEMI
;

expr:
  LPAR expr RPAR 
| expr OVER expr | expr TIMES expr 
| expr PLUS expr | expr MINUS expr 
| expr EQ expr | expr LT expr
| TRUE 
| FALSE 
| INT_VAL 
| REAL_VAL 
| STR_VAL
| ID 
;
