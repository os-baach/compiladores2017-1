import java.util.Stack;
import java.util.Arrays;

%%

%public
%class Flexer
%standalone
%line
%column

%{
  private Stack<Integer> s;
  private int whitespace;

  /* Incrementa blancos en i */
  public void incrementa(int i){
      whitespace+=i;
  }

  /* Vuelve 0 a los blancos */
  public void clearWhitespace(){
      whitespace = 0;
  } 
	
  public int peek(){
    return s.peek();
  }

  public void push(int i){
    s.push(i);
  }

  public void pop(){
    s.pop();
  }

%}

/* Construímos el stack */
%init{
  s = new Stack<>();
  s.push(0);
  whitespace = 0;
%init}

LETRA = [a-zA-Z]
DIGITO = [0-9]
OPERADOR = "=" | ">" | "<" | "!" | "-" | "+" | "/" | "%" | "(" | ")" | "'" | ":" | "\""
CARACTER_VALIDO = {LETRA} | {DIGITO} | {OPERADOR} | _
NEWLINE = [\r|\n|\r\n]
ESPACIO = " "
TAB = "\t"
WHITESPACE = {ESPACIO} | {TAB}
CADENA_VALIDA = {CARACTER_VALIDO}+ ({CARACTER_VALIDO} | {WHITESPACE})*

%%

{NEWLINE} {System.out.println("NEWLINE"); clearWhitespace();}
{ESPACIO} {incrementa(1);}
{TAB} {incrementa(4);}
{CADENA_VALIDA} {if((whitespace) > peek()){
		       push(whitespace);
		       System.out.print("INDENT(" + (whitespace) + ")");
		       }
		   else if(whitespace < peek()){
		       pop();
		       yypushback(yylength());
		       System.out.println("DEDENT");
		   }
		}

