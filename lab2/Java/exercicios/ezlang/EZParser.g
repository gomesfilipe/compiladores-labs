parser grammar EZParser;
options {
  tokenVocab = EZLexer;
}

program: 
  PROGRAM ID SEMI varssect stmtsect
;

varssect:
  VAR vardecl*
;

// varssect: 
//   VAR optvardecl
// ;

// optvardecl:
//   vardecllist?
// ;

// vardecllist: 
//   vardecllist vardecl 
// | vardecl 
// ;

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
   IF expr THEN stmt+ END
|  IF expr THEN stmt+ ELSE stmt+ END 
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
  expr (TIMES | OVER) expr
| expr (PLUS | MINUS) expr
| expr (EQ | LT) expr
| LPAR expr RPAR 
| TRUE 
| FALSE 
| INT_VAL 
| REAL_VAL 
| STR_VAL
| ID 
;
