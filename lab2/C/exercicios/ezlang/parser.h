/* A Bison parser, made by GNU Bison 3.8.2.  */

/* Bison interface for Yacc-like parsers in C

   Copyright (C) 1984, 1989-1990, 2000-2015, 2018-2021 Free Software Foundation,
   Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <https://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* DO NOT RELY ON FEATURES THAT ARE NOT DOCUMENTED in the manual,
   especially those whose name start with YY_ or yy_.  They are
   private implementation details that can be changed or removed.  */

#ifndef YY_YY_PARSER_H_INCLUDED
# define YY_YY_PARSER_H_INCLUDED
/* Debug traces.  */
#ifndef YYDEBUG
# define YYDEBUG 0
#endif
#if YYDEBUG
extern int yydebug;
#endif

/* Token kinds.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
  enum yytokentype
  {
    YYEMPTY = -2,
    YYEOF = 0,                     /* "end of file"  */
    YYerror = 256,                 /* error  */
    YYUNDEF = 257,                 /* "invalid token"  */
    T_BEGIN = 258,                 /* T_BEGIN  */
    BOOL = 259,                    /* BOOL  */
    ELSE = 260,                    /* ELSE  */
    END = 261,                     /* END  */
    FALSE = 262,                   /* FALSE  */
    IF = 263,                      /* IF  */
    INT = 264,                     /* INT  */
    PROGRAM = 265,                 /* PROGRAM  */
    READ = 266,                    /* READ  */
    REAL = 267,                    /* REAL  */
    REPEAT = 268,                  /* REPEAT  */
    STRING = 269,                  /* STRING  */
    THEN = 270,                    /* THEN  */
    TRUE = 271,                    /* TRUE  */
    UNTIL = 272,                   /* UNTIL  */
    VAR = 273,                     /* VAR  */
    WRITE = 274,                   /* WRITE  */
    ASSIGN = 275,                  /* ASSIGN  */
    EQ = 276,                      /* EQ  */
    LT = 277,                      /* LT  */
    PLUS = 278,                    /* PLUS  */
    MINUS = 279,                   /* MINUS  */
    TIMES = 280,                   /* TIMES  */
    OVER = 281,                    /* OVER  */
    LPAR = 282,                    /* LPAR  */
    RPAR = 283,                    /* RPAR  */
    SEMI = 284,                    /* SEMI  */
    INT_VAL = 285,                 /* INT_VAL  */
    REAL_VAL = 286,                /* REAL_VAL  */
    STR_VAL = 287,                 /* STR_VAL  */
    ID = 288                       /* ID  */
  };
  typedef enum yytokentype yytoken_kind_t;
#endif

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
typedef int YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;


int yyparse (void);


#endif /* !YY_YY_PARSER_H_INCLUDED  */
