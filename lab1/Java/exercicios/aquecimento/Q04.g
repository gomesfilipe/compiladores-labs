lexer grammar Q04;

fragment PLACACARRO : [A-Z][A-Z][A-Z]'-'[0-9][0-9][0-9][0-9] ;

WS     : [ \t\n]+ -> skip ;
PLACA : PLACACARRO { System.out.println(getText()); } ;
