%{
  import java.lang.Math;
  import java.io.*;
%}

/*YACC Declarations*/
%token DEDENT INDENT NEWLINE
%token PARENTESISI PARENTESISD DOSPUNTOS PUNTOYCOMA
%token MAS MENOS POR POTENCIA DIV DIVENTERA MODULO
%token MAYOR MENOR MENOROIGUAL MAYOROIGUAL IGUALIGUAL DISTINTO
%token DECREMENTO INCREMENTO IGUAL
%token BOOLEAN AND OR NOT
%token FOR WHILE IF ELSE ELIF PRINT IN
%token CADENA IDENTIFIER
%token ENTERO REAL

 /*Gramática*/
%%

 /* file_input: (NEWLINE | stmt)* ENDMARKER  */
file_input: {System.out.println("Reconocimiento exitoso");}
| aux0 {$$ = $1;} 
;

aux0: NEWLINE
| stmt {$$ = $1;}
| aux0 NEWLINE
| aux0 stmt
;

/* stmt: simple_stmt | compound_stmt  */
stmt: simple_stmt {$$ = $1;}
| compound_stmt {$$ = $1;}
;

/* simple_stmt: small_stmt [';'] NEWLINE  */
simple_stmt: small_stmt NEWLINE {$$ = $1;}
| small_stmt PUNTOYCOMA NEWLINE
;

/* small_stmt: expr_stmt | print_stmt  */
small_stmt: expr_stmt {$$ = $1;}
| print_stmt {$$ = $1;}
;

/* expr_stmt: test [('='|augassign) test]  */
expr_stmt: test {$$ = $1;}
| test IGUAL test
| test augassign test
;

/* augassign: '+=' | '-='  */
augassign: INCREMENTO
| DECREMENTO
;

/* print_stmt: 'print' [test] */
print_stmt: PRINT
| PRINT test
;

/* compound_stmt: if_stmt | while_stmt  */
compound_stmt: if_stmt {$$ = $1;}
| while_stmt {$$ = $1;}
;

/* if_stmt: 'if' test ':' suite ('elif' test ':' suite)* ['else' ':' suite]  */
if_stmt: IF test DOSPUNTOS suite {$$ = $2; $$ = $4;}
| IF test DOSPUNTOS suite ELSE DOSPUNTOS suite
| IF test DOSPUNTOS suite aux1 ELSE DOSPUNTOS suite
;

aux1: ELIF test DOSPUNTOS suite {$$ = $2; $$ = $4;}
| aux1 ELIF test DOSPUNTOS suite
;

/* while_stmt: 'while' test ':' suite  */
while_stmt: WHILE test DOSPUNTOS suite {$$ = $2; $$ = $4;}
;

/* suite: simple_stmt | NEWLINE INDENT stmt+ DEDENT  */
suite: simple_stmt {$$ = $1;}
| NEWLINE INDENT aux2 DEDENT
;

aux2: stmt {$$ = $1;}
| aux2 stmt
;

/* test: or_test  */
test: or_test {$$ = $1;}
;

/* or_test: and_test ('or' and_test)* */
or_test: and_test {$$ = $1;}
| and_test aux3
;

aux3: OR and_test
| aux3 OR and_test
;

/* and_test: not_test ('and' not_test)* */
and_test: not_test {$$ = $1;}
| not_test aux4
;

aux4: AND not_test
| aux4 AND not_test
;

/* not_test: 'not' not_test | comparison  */
not_test: NOT not_test
| comparison {$$ = $1;}
;

/* comparison: expr (comp_op expr)* */
comparison: expr {$$ = $1;}
| expr aux5
;

aux5: comp_op expr {$$ = $1;}
| aux5 comp_op expr
;

/* comp_op: '<'|'>'|'=='|'>='|'<='|'!='|'in'|'not' 'in' */
comp_op: MENOR
| MAYOR
| IGUALIGUAL
| MAYOROIGUAL
| MENOROIGUAL
| DISTINTO
| IN
| NOT IN
;

/* expr: term (('+'|'-') term)*  */
expr: term {$$ = $1;}
| term aux6
;

aux6: MAS term
| MENOS term
| aux6 MAS term
| aux6 MENOS term
;

/* term: factor (('*'|'/'|'%'|'//') factor)*  */
term: factor {$$ = $1;}
| factor aux7
;

aux7: POR factor
| DIV factor
| MODULO factor
| DIVENTERA factor
| aux7 POR factor
| aux7 DIV factor
| aux7 MODULO factor
| aux7 DIVENTERA factor
;

/* factor: ('+'|'-') factor | power  */
factor: MAS factor
| MENOS factor
| power {$$ = $1;}
;

/* power: atom ['**' factor]  */
power: atom {$$ = $1;}
| atom POTENCIA factor
;

/* atom: ENTERO | REAL | CADENA | BOOLEAN | IDENTIFIER  */
atom: ENTERO
| REAL
| CADENA
| BOOLEAN
| IDENTIFIER
;

%%

private Flexer lexer;
/* interface to the lexer */
private int yylex () {
  int yyl_return = -1;
  try {
    yyl_return = lexer.yylex();
  }
  catch (IOException e) {
    System.err.println("IO error :"+e);
  }
  return yyl_return;
}
/* error reporting */
public void yyerror (String error) {
  System.err.println ("Error: " + error);
}
/* lexer is created in the constructor */
public Parser(Reader r) {
  lexer = new Flexer(r, this);
}
/* that's how you use the parser */
public static void main(String args[]) throws IOException {
  Parser yyparser = new Parser(new FileReader(args[0]));
  yyparser.yyparse();
}

