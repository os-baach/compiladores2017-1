import java.util.Stack;
import java.util.Arrays;

%%

%public
%class Flexer
%byaccj
%line
%state CONTADOR INDENT CADENA DEDENT NORMAL EOF
%unicode

%{
private static final int TABULADOR = 4; /* Número de espacios por tabulador */
private Stack<Integer> s;
private int whitespace;
private boolean espacio; /* Nos dice si la siguiente cadena debe ser un espacio */
private boolean linestart; /* Nos dice si no hemos leído cadenas válidas en la línea */
private int dedents = 0; /* Contador de DEDENTS */
private boolean indent = false; /* Nos dice si hubo INDENT */

private Parser yyparser;

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
/* INDENT */
push(whitespace);
System.out.print("INDENT(" + (whitespace) + ")");
indent = true;
}else{
/* Contamos DEDENTS */
while(whitespace < peek()){
pop();
dedents++;
if(whitespace > peek()){
System.err.println("Error de indentación. Línea " + (yyline+1) + "."); 
System.exit(-1);
}        
System.out.println("DEDENT");
}
yybegin(DEDENT);
}	
linestart = false;
}

/* Vacía la pila e imprime DEDENT por cada elemento en ella (excepto el primero) */
public void dedentAll(){
while(peek() != 0){
System.out.println("DEDENT");
pop();
dedents++;
}
yybegin(DEDENT);
}

/* Quita las comillas al principio y final de la cadena s */
public String quitaComillas(String s){
return s.replace("\"", "");
}

/** Nuevo constructor
* @param FileReader r
* @param Parser parser - parser
*/
public Flexer(java.io.Reader r, Parser parser){
    this(r);
    this.yyparser = parser;
    s = new Stack<>();
    s.push(0);
    whitespace = 0;
    linestart = true;
    espacio = false;
}

%}

LETRA = [a-zA-Z]
DIGITO = [0-9]
NEWLINE = [\r|\n|\r\n] 
ESPACIO = " "
TAB = "\t"
IDENTIFICADOR = ({LETRA} | _) ({LETRA} | {DIGITO} | _)*
ENTERO = [1-9]{DIGITO}* | 0
REAL = "."{DIGITO}+ | {ENTERO}"."{DIGITO}+ | {ENTERO}"."
CARACTER_VALIDO = [^\r\n]--["\""|"\\"]
KEYWORD = "and" | "or" | "not" | "for" | "while" | "if" | "else" | "elif" | "print" | "in"
BOOLEANO = "True" | "False"
CADENA = "\""{CARACTER_VALIDO}*"\""
OPERADOR = "+" | "-" | "*" | "**" | "/" | "//" | "%" | ">" | "<" | "<=" | ">=" | "==" | "!=" | "-=" | "+=" | "="
SEPARADOR = "(" | ")" | ":" | ";"
TODOS_CARACTERES = [^\r\n]
COMENTARIO = "#" {TODOS_CARACTERES}* {NEWLINE}? 

%%

<YYINITIAL>{
.     {yypushback(1);
yybegin(NORMAL);}
}

<CONTADOR>{
.       {yypushback(1); /* Regresa un caracter que no se leyo */
/* Rutina para contar indentación */
if(whitespace > peek()){
/* INDENT */
push(whitespace);
System.out.print("INDENT(" + (whitespace) + ")");
yybegin(INDENT);
}else{
/* Contamos DEDENTS */
while(whitespace < peek()){
pop();
dedents++;
if(whitespace > peek()){
System.err.println("Error de indentación. Línea " + (yyline+1) + "."); 
System.exit(-1);
}        
System.out.println("DEDENT");
}
yybegin(DEDENT);
}	
linestart = false;
}
}

<DEDENT>{
.	{yypushback(1);
	if(dedents > 0){
		   dedents--;
		   return Parser.DEDENT;
	}else 
	      yybegin(NORMAL);}
}

<INDENT>{
.	{yypushback(1); /* Regresa un caracter que no se leyo */
	yybegin(NORMAL);
	return Parser.INDENT;
}
}

<NORMAL>{

{COMENTARIO} {if(!linestart){
System.out.println("NEWLINE");
clearWhitespace(); linestart=true; espacio = false;
return Parser.NEWLINE;
}}

{SEPARADOR} {
if(linestart){
yypushback(yylength());
yybegin(CONTADOR);
}else{
System.out.print("SEPARADOR(" + yytext() + ")");
espacio=false;
switch(yytext()){
case "(":
return Parser.PARENTESISI;

case ")":
return Parser.PARENTESISD;

case ":":
return Parser.DOSPUNTOS;

case ";":
return Parser.PUNTOYCOMA;

}
}}

{OPERADOR} {
if(linestart){
yypushback(yylength());
yybegin(CONTADOR);
}else{
System.out.print("OPERADOR(" + yytext() + ")");
espacio=false;
switch(yytext()){
case "+":
yyparser.yylval = new ParserVal(new NodoMas()); return Parser.MAS;

case "-":
yyparser.yylval = new ParserVal(new NodoMenos()); return Parser.MENOS;

case "*":
yyparser.yylval = new ParserVal(new NodoPor()); return Parser.POR;

case "**":
yyparser.yylval = new ParserVal(new NodoPotencia()); return Parser.POTENCIA;

case "/":
yyparser.yylval = new ParserVal(new NodoDiv()); return Parser.DIV;

case "//":
yyparser.yylval = new ParserVal(new NodoDivEntera()); return Parser.DIVENTERA;

case "%":
yyparser.yylval = new ParserVal(new NodoModulo()); return Parser.MODULO;

case ">":
return Parser.MAYOR;

case "<":
return Parser.MENOR;

case "<==":
return Parser.MENOROIGUAL;

case ">==":
return Parser.MAYOROIGUAL;

case "==":
return Parser.IGUALIGUAL;

case "!=":
return Parser.DISTINTO;

case "-=":
return Parser.DECREMENTO;

case "+=":
return Parser.INCREMENTO;

case "=":
yyparser.yylval = new ParserVal(new NodoEq()); return Parser.IGUAL;

}
}}

{NEWLINE} {System.out.println("NEWLINE"); clearWhitespace(); linestart=true; espacio = false; return Parser.NEWLINE;}
{ESPACIO} {if(linestart)
incrementa(1); espacio = false;}

{TAB} {if(linestart)
incrementa(TABULADOR); espacio = false;}

{BOOLEANO} {if(espacio){
System.err.println("Átomo mal formado en la línea " + (yyline+1) + ".");
System.exit(-1);
}
if(linestart){
yypushback(yylength());
yybegin(CONTADOR);
}else{
System.out.print("BOOLEANO(" + yytext() + ")");
espacio = true;
yyparser.yylval = new ParserVal(new HojaBoolean(Boolean.parseBoolean(yytext()))); return Parser.BOOLEAN; 
}}

{KEYWORD} {if(espacio){
System.err.println("Átomo mal formado en la línea " + (yyline+1) + ".");
System.exit(-1);
}
if(linestart){
yypushback(yylength());
yybegin(CONTADOR);
}else{
System.out.print("KEYWORD(" + yytext() + ")");
espacio = true;
switch(yytext()){
case "and":
return Parser.AND;

case "or":
return Parser.OR;

case "not":
return Parser.NOT;

case "for":
return Parser.FOR;

case "while":
return Parser.WHILE;

case "if":
return Parser.IF;

case "else":
return Parser.ELSE;

case "elif":
return Parser.ELIF;

case "print":
yyparser.yylval = new ParserVal(new NodoPrint()); return Parser.PRINT;

case "in":
return Parser.IN;

}
}}

{CADENA} {if(espacio){
System.err.println("Átomo mal formado en la línea " + (yyline+1) + ".");
System.exit(-1);
}
if(linestart){
yypushback(yylength());
yybegin(CONTADOR);}else{
System.out.print("CADENA(" + quitaComillas(yytext()) + ")");
espacio = true;
return Parser.CADENA;
}}

{IDENTIFICADOR}	{if(espacio){
System.err.println("Átomo mal formado en la línea " + (yyline+1) + ".");
System.exit(-1);
}
if(linestart){
yypushback(yylength());
yybegin(CONTADOR);
}else{
System.out.print("IDENTIFICADOR(" + yytext() + ")");
espacio = true;
yyparser.yylval = new ParserVal(new HojaIdentifier(yytext())); return Parser.IDENTIFIER;}}

{ENTERO} {if(espacio){
System.err.println("Átomo mal formado en la línea " + (yyline+1) + ".");
System.exit(-1);
espacio = true;}

if(linestart){
yypushback(yylength());
yybegin(CONTADOR);
}else{
System.out.print("ENTERO(" + yytext() + ")");
espacio = true;
yyparser.yylval = new ParserVal(new HojaEntera(Integer.parseInt(yytext()))); return Parser.ENTERO;
}}

{REAL} {if(espacio){
System.err.println("Átomo mal formado en la línea " + (yyline+1) + ".");
System.exit(-1);
}
if(linestart){
yypushback(yylength());
	 yybegin(CONTADOR);
		 }else{
		 System.out.print("REAL(" + yytext() + ")");
		 espacio = true;
		 yyparser.yylval = new ParserVal(new HojaReal(Double.parseDouble(yytext()))); return Parser.REAL; 
		 }}
}

<<EOF>> {dedentAll(); System.exit(0);}
