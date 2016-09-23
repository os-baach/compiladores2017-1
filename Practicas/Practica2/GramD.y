%{
  import java.lang.Math;
  import java.io.*;
%}

%token NUMBER
%token MAS MENOS MULT DIV

%%

S: E {System.out.println("Reconocimiento exitoso de: "+$$);}
;

E: T MAS E {$$ = $3;}
| T MENOS E {$$ = $3;}
| T
;

T: F MULT T {$$ = $3;}
| F DIV T {$$ = $3;}
| F
;

F: NUMBER {$$ = $1;}
| MENOS NUMBER {$$ = $2;}
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
