%{
  int dif = 'a' - 'A';
%}

%%
[A-Z] { printf("%c", yytext[0] + dif); }
%%
