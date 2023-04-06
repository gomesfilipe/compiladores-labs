lexer grammar Q03;

fragment DIGIT : [0-9a-fA-F] ;

WS     : [ \t\n]+ -> skip ;
HEX : '0'[xX] (DIGIT)? (DIGIT)? (DIGIT)? (DIGIT)? (DIGIT)? (DIGIT)? (DIGIT)? (DIGIT)? { System.out.println(getText()); } ;
