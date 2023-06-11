parser grammar EZParser;
options {
  tokenVocab = EZLexer;
}

@header {
    package parser;
}

program: 
  PROGRAM ID SEMI varssect stmtsect
;

varssect:
  VAR vardecl*
;

vardecl:
  typespec ID SEMI 
;

typespec: 
  BOOL #bool
| INT  #int
| REAL #real
| STRING #string
;

stmtsect:
  BEGIN stmt+ END
;

stmt: 
  assignstmt 
| ifstmt 
| readstmt 
| repeatstmt 
| writestmt
;

assignstmt: 
  ID ASSIGN expr SEMI
;

ifstmt: 
   IF expr THEN stmt+ END #sample_if
|  IF expr THEN ifblock=stmt+ ELSE elseblock=stmt+ END #if_else 
;

readstmt: 
  READ ID SEMI
;

repeatstmt:
  REPEAT stmt+ UNTIL expr
;

writestmt: 
  WRITE expr SEMI
;

expr:
  expr op = (TIMES | OVER) expr #times_over_expr
| expr op = (PLUS | MINUS) expr #plus_minus_expr
| expr op = (EQ | LT) expr #eq_lt_epr
| LPAR expr RPAR #par_expr
| TRUE #true
| FALSE #false
| INT_VAL #int_val
| REAL_VAL #real_val
| STR_VAL #str_val
| ID #id
;
