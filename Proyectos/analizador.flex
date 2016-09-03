import java.util.Stack;
import java.util.Arrays;

%%

%public
%class Flexer
%standalone
%line
%column

%{
  public Stack<Integer> s;

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
%init}

LETRA = [a-zA-Z]
DIGITO = [0-9]
OPERADOR = "=" | ">" | "<" | "!" | "-" | "+" | "/" | "%" | "(" | ")" | "'" | ":" | "\""
CARACTER_VALIDO = {LETRA} | {DIGITO} | {OPERADOR} | _
CADENA_VALIDA = {CARACTER_VALIDO}+ ({CARACTER_VALIDO} | " " | \t)*
NEWLINE = [\r|\n|\r\n]
WHITESPACE = {NEWLINE} | [ \t\f]

%%

<YYINITIAL>{
{NEWLINE} {System.out.println("NEWLINE");}
{CADENA_VALIDA} {if((yycolumn-1) > peek()){
		       push(yycolumn);
		       System.out.print("INDENT(" + (yycolumn) + ")");
		       }
		   else if(yycolumn < peek()){
		       pop();
		       yypushback(yylength());
		       System.out.println("DEDENT");
		   }
		}
{WHITESPACE} {/* Lo ignora */}
}

