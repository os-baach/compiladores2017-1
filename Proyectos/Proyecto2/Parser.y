%{
  import java.lang.Math;
  import java.io.*;
%}

/*YACC Declarations*/
%token DEDENT INDENT NEWLINE
%token PARENTESISI PARENTESISD DOSPUNTOS PUNTOYCOMA
%token MAS MENOS POR POTENCIA DIV DIVENTERA MODULO
%token MAYOR MENOR MENORIGUAL MAYORIGUAL IGUALIGUAL DISTINTO
%token DECREMENTO INCREMENTO IGUAL
%token BOOLEAN AND OR NOT
%token FOR WHILE IF ELSE ELIF PRINT IN
%token CADENA IDENTIFIER
%token ENTERO REAL

 /*Gramática*/
%%

 /* file_input: (NEWLINE | stmt)* ENDMARKER  */
file_input: {System.out.println("Reconocimiento exitoso");}
| aux0 {$$ = $1; System.out.println($$.getValue());} 
;

aux0: NEWLINE
| stmt {$$ = $1;}
| aux0 NEWLINE
| aux0 stmt
;

/* stmt: simple_stmt | compound_stmt  */
stmt: simple_stmt
| compound_stmt
;

/* simple_stmt: small_stmt [';'] NEWLINE  */
simple_stmt: small_stmt NEWLINE
| small_stmt PUNTOYCOMA NEWLINE
;

/* small_stmt: expr_stmt | print_stmt  */
small_stmt: expr_stmt
| print_stmt
;

/* expr_stmt: test [('='|augassign) test]  */
expr_stmt: test
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
compound_stmt: if_stmt
| while_stmt
;

/* if_stmt: 'if' test ':' suite ('elif' test ':' suite)* ['else' ':' suite]  */
if_stmt: IF test DOSPUNTOS suite
| IF test DOSPUNTOS suite ELSE DOSPUNTOS suite
| IF test DOSPUNTOS suite aux1 ELSE DOSPUNTOS suite
;

aux1: ELIF test DOSPUNTOS suite
| aux1 ELIF test DOSPUNTOS suite
;

/* while_stmt: 'while' test ':' suite  */
while_stmt: WHILE test DOSPUNTOS suite
;

/* suite: simple_stmt | NEWLINE INDENT stmt+ DEDENT  */
suite: simple_stmt
| NEWLINE INDENT aux2 DEDENT
;

aux2: stmt
| aux2 stmt
;

/* test: or_test  */
test: or_test
;

/* or_test: and_test ('or' and_test)* */
or_test: and_test
| and_test aux3
;

aux3: OR and_test
| aux3 OR and_test
;

/* and_test: not_test ('and' not_test)* */
and_test: not_test
| not_test aux4
;

aux4: AND not_test
| aux4 AND not_test
;

/* not_test: 'not' not_test | comparison  */
not_test: NOT not_test
| comparison
;

/* comparison: expr (comp_op expr)* */
comparison: expr
| expr aux5
;

aux5: comp_op expr
| aux5 comp_op expr
;

/* comp_op: '<'|'>'|'=='|'>='|'<='|'!='|'in'|'not' 'in' */
comp_op: MENOR
| MAYOR
| IGUALIGUAL
| MAYORIGUAL
| MENORIGUAL
| DISTINTO
| IN
| NOT IN
;

/* expr: term (('+'|'-') term)*  */
expr: term
| term aux6
;

aux6: MAS term
| MENOS term
| aux6 MAS term
| aux6 MENOS term
;

/* term: factor (('*'|'/'|'%'|'//') factor)*  */
term: factor
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
| power
;

/* power: atom ['**' factor]  */
power: atom
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

