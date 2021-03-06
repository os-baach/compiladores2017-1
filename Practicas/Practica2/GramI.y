%{
  import java.lang.Math;
  import java.io.*;
%}

%token<ival> NUMBER
%token MAS MENOS MULT DIV
%type<ival> F T  S E 
%%

S: E {System.out.println("Reconocimiento exitoso de: "+$$);}
;

E: E MAS T {$$ = $1;}
| E MENOS T {$$ = $1;}
| T
;

T: T MULT F {$$ = $1;}
| T DIV F {$$ = $1;}
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
