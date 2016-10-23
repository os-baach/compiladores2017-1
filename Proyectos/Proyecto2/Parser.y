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

//Aquí va la gramática 

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

