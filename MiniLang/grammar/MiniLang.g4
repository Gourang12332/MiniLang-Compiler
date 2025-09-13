grammar MiniLang;

program : statement* EOF ;

statement
    : assignment
    | printStmt
    ;

assignment : IDENT '=' expr ';' ;
printStmt  : 'print' expr ';' ;

expr
    : expr op=('*'|'/') expr   # MulDiv
    | expr op=('+'|'-') expr   # AddSub
    | INT                      # Int
    | IDENT                    # Var
    | '(' expr ')'             # Parens
    ;

IDENT : [a-zA-Z_] [a-zA-Z_0-9]* ;
INT   : [0-9]+ ;
WS    : [ \t\r\n]+ -> skip ;
COMMENT : '//' ~[\r\n]* -> skip ;
