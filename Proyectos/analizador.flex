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
OPERADOR = "=" | ">" | "<" | "!" | "-" | "+" | "/" | "%" | "(" | ")" | "'" | ":" | ";" 
CARACTER_VALIDO = {LETRA} | {DIGITO} | {OPERADOR} | _
NEWLINE = [\r|\n|\r\n]

%%

<YYINITIAL>{
{NEWLINE} {System.out.println("NEWLINE");}
{CARACTER_VALIDO} {if(yycolumn > peek()){
		       push(yycolumn);
		       System.out.print("INDENT(" + yycolumn + ")");
		       }
		   else if(yycolumn < peek()){
		       pop();
		       yypushback(yylength());
		       System.out.println("DEDENT");
		   }
		}
}

