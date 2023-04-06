lexer grammar Q02;

fragment UPPERCASE : [A-Z] ;

WS     : [ \t\n]+ -> skip ;
UPPER : UPPERCASE { System.out.print(getText().toLowerCase()); } ;
CHAR: . { System.out.print(getText()); } ;
