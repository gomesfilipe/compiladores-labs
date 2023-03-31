%option yylineno

int_val ([1-9][0-9]*)|0
real_val {int_val}\.{int_val}
str_val \"[^"]*\"
id [A-Za-z][A-Za-z0-9_\-]*

%%
"{"[^\}]*"}" { }
[ \t\n\r]+   { }
"begin"      { printf("%d: %s -> %s\n", yylineno, yytext, "BEGIN"); }
"bool"       { printf("%d: %s -> %s\n", yylineno, yytext, "BOOL"); }
"else"       { printf("%d: %s -> %s\n", yylineno, yytext, "ELSE"); }
"end"        { printf("%d: %s -> %s\n", yylineno, yytext, "END"); }
"false"      { printf("%d: %s -> %s\n", yylineno, yytext, "FALSE"); }
"if"         { printf("%d: %s -> %s\n", yylineno, yytext, "IF"); }
"int"        { printf("%d: %s -> %s\n", yylineno, yytext, "INT"); }
"program"    { printf("%d: %s -> %s\n", yylineno, yytext, "PROGRAM"); }
"read"       { printf("%d: %s -> %s\n", yylineno, yytext, "READ"); }
"real"       { printf("%d: %s -> %s\n", yylineno, yytext, "REAL"); }
"repeat"     { printf("%d: %s -> %s\n", yylineno, yytext, "REPEAT"); }
"string"     { printf("%d: %s -> %s\n", yylineno, yytext, "STRING"); }
"then"       { printf("%d: %s -> %s\n", yylineno, yytext, "THEN"); }
"true"       { printf("%d: %s -> %s\n", yylineno, yytext, "TRUE"); }
"until"      { printf("%d: %s -> %s\n", yylineno, yytext, "UNTIL"); }
"var"        { printf("%d: %s -> %s\n", yylineno, yytext, "VAR"); }
"write"      { printf("%d: %s -> %s\n", yylineno, yytext, "WRITE"); }
":="         { printf("%d: %s -> %s\n", yylineno, yytext, "ASSIGN"); }
"="          { printf("%d: %s -> %s\n", yylineno, yytext, "EQ"); }
"<"          { printf("%d: %s -> %s\n", yylineno, yytext, "LT"); }
"+"          { printf("%d: %s -> %s\n", yylineno, yytext, "PLUS"); }
"-"          { printf("%d: %s -> %s\n", yylineno, yytext, "MINUS"); }
"*"          { printf("%d: %s -> %s\n", yylineno, yytext, "TIMES"); }
"/"          { printf("%d: %s -> %s\n", yylineno, yytext, "OVER"); }
"("          { printf("%d: %s -> %s\n", yylineno, yytext, "LPAR"); }
")"          { printf("%d: %s -> %s\n", yylineno, yytext, "RPAR"); }
";"          { printf("%d: %s -> %s\n", yylineno, yytext, "SEMI"); }
{int_val}    { printf("%d: %s -> %s\n", yylineno, yytext, "INT_VAL"); } 
{real_val}   { printf("%d: %s -> %s\n", yylineno, yytext, "REAL_VAL"); }
{str_val}    { printf("%d: %s -> %s\n", yylineno, yytext, "STR_VAL"); }
{id}         { printf("%d: %s -> %s\n", yylineno, yytext, "ID"); }
.            { printf("LEXICAL ERROR (%d): Unknown symbol %s\n",yylineno, yytext); return 0; }
%%
