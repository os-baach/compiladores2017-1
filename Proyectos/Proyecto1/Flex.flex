import java.util.Stack;
import java.util.Arrays;

%%

%public
%class Flexer
%standalone
%line

%{
  private static final int TABULADOR = 4; /* Número de espacios por tabulador */
  private Stack<Integer> s;
  private int whitespace;
  private boolean espacio; /* Nos dice si la siguiente cadena debe ser un espacio */
  private boolean linestart; /* Nos dice si no hemos leído cadenas válidas en la línea */ 

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

  public void cuentaIndentacion(){
  if(whitespace > peek()){
      push(whitespace);
      System.out.print("INDENT(" + (whitespace) + ")");
   }else{
	while(whitespace < peek()){
        pop();
        if(whitespace > peek()){
          System.err.println("Error de indentación. Línea " + (yyline+1) + ".");
	  System.exit(-1);
        }        
        System.out.println("DEDENT");
	}
    }
    linestart = false;
  }

  /* Vacía la pila e imprime DEDENT por cada elemento en ella (excepto el primero) */
  public void dedentAll(){
      while(peek() != 0){
          System.out.println("DEDENT");
	  pop();
      }
  }

  /* Quita las comillas al principio y final de la cadena s */
  public String quitaComillas(String s){
      return s.replace("\"", "");
  }

%}

/* Construímos el stack */
%init{
  s = new Stack<>();
  s.push(0);
  whitespace = 0;
  linestart = true;
  espacio = false;
%init}

LETRA = [a-zA-Z]
DIGITO = [0-9]
NEWLINE = [\r|\n|\r\n] 
ESPACIO = " "
TAB = "\t"
IDENTIFICADOR = ({LETRA} | _) ({LETRA} | {DIGITO} | _)*
ENTERO = [1-9]{DIGITO}* | 0
REAL = "."{DIGITO}+ | {ENTERO}"."{DIGITO}+ | {ENTERO}"."
CARACTER_VALIDO = [[^\r\n]--["\""|"\\"]]
KEYWORD = "and" | "or" | "not" | "for" | "while" | "if" | "else" | "elif" | "print" | "in"
BOOLEANO = "True" | "False"
CADENA = "\""{CARACTER_VALIDO}*"\""
OPERADOR = "+" | "-" | "*" | "**" | "/" | "//" | "%" | ">" | "<" | "<=" | ">=" | "==" | "!=" | "-=" | "+=" | "="
SEPARADOR = "(" | ")" | ":" | ";"
TODOS_CARACTERES = [^\r\n]
COMENTARIO = "#" {TODOS_CARACTERES}* {NEWLINE}? 

%%

{COMENTARIO} {if(!linestart){
		System.out.println("NEWLINE"); clearWhitespace(); linestart=true; espacio = false;
	     }}
{SEPARADOR} {
	if(linestart)
	cuentaIndentacion();
	System.out.print("SEPARADOR(" + yytext() + ")");
	espacio=false;
	}
{OPERADOR} {
	if(linestart)
	cuentaIndentacion();
	System.out.print("OPERADOR(" + yytext() + ")");
	espacio=false;
	}
{NEWLINE} {System.out.println("NEWLINE"); clearWhitespace(); linestart=true; espacio = false;}
{ESPACIO} {if(linestart)
		incrementa(1); espacio = false;}
{TAB} {if(linestart)
           incrementa(TABULADOR); espacio = false;}
{BOOLEANO} {if(espacio){
	  System.err.println("Átomo mal formado en la línea " + (yyline+1) + ".");
	  System.exit(-1);
       }
	 if(linestart)
	 cuentaIndentacion();
	 System.out.print("BOOLEANO(" + yytext() + ")");
	 espacio = true;}
	 
{KEYWORD} {if(espacio){
	  System.err.println("Átomo mal formado en la línea " + (yyline+1) + ".");
	  System.exit(-1);
       }
	 if(linestart)
	 cuentaIndentacion();
	 System.out.print("KEYWORD(" + yytext() + ")");
	 espacio = true;}
	 
{CADENA} {if(espacio){
	 System.err.println("Átomo mal formado en la línea " + (yyline+1) + ".");
	  System.exit(-1);
       }
	 if(linestart)
		     cuentaIndentacion();
		 System.out.print("CADENA(" + quitaComillas(yytext()) + ")");
		 espacio = true;}
{IDENTIFICADOR}	{if(espacio){
		System.err.println("Átomo mal formado en la línea " + (yyline+1) + ".");
		 System.exit(-1);
       }

		if(linestart)
		     cuentaIndentacion();
		 System.out.print("IDENTIFICADOR(" + yytext() + ")");
		 espacio = true;}
{ENTERO} {if(espacio){
	 System.err.println("Átomo mal formado en la línea " + (yyline+1) + ".");
	 System.exit(-1);
       espacio = true;}

	 if(linestart)
		     cuentaIndentacion();
		 System.out.print("ENTERO(" + yytext() + ")");
		 espacio = true;}
{REAL} {if(espacio){
	System.err.println("Átomo mal formado en la línea " + (yyline+1) + ".");
	  System.exit(-1);
       }
       if(linestart)
		 cuentaIndentacion();
		 System.out.print("REAL(" + yytext() + ")");
		 espacio = true;}

<<EOF>> {dedentAll(); System.exit(0);}
