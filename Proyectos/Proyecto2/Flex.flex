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
}
yybegin(NORMAL);}
}

<INDENT>{
.	{yypushback(1); /* Regresa un caracter que no se leyo */
return Parser.INDENT;
yybegin(NORMAL);
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
break;
case ")":
return Parser.PARENTESISD;
break;
case ":":
return Parser.DOSPUNTOS;
break;
case ";":
return Parser.PUNTOYCOMA;
break;
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
return Parser.MAS;
break;
case "-":
return Parser.MENOS;
break;
case "*":
return Parser.POR;
break;
case "**":
return Parser.POTENCIA;
break;
case "/":
return Parser.DIV;
break;
case "//":
return Parser.DIVENTERA;
break;
case "%":
return Parser.MODULO;
break;
case ">":
return Parser.MAYOR;
break;
case "<":
return Parser.MENOR;
break;
case "<==":
return Parser.MENOROIGUAL;
break;
case ">==":
return Parser.MAYOROIGUAL;
break;
case "==":
return Parser.IGUALIGUAL;
break;
case "!=":
return Parser.DISTINTO;
break;
case "-=":
return Parser.DECREMENTO;
break;
case "+=":
return Parser.INCREMENTO;
break;
case "=":
return Parser.IGUAL;
break;
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
return Parser.BOOLEAN;
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
break;
case "or":
return Parser.OR;
break;
case "not":
return Parser.NOT;
break;
case "for":
return Parser.FOR;
break;
case "while":
return Parser.WHILE;
break;
case "if":
return Parser.IF;
break;
case "else":
return Parser.ELSE;
break;
case "elif":
return Parser.ELIF;
break;
case "print":
return Parser.PRINT;
break;
case "in":
return Parser.IN;
break;
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
return Parser.IDENTIFIER;}}

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
return Parser.ENTERO;
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
		 return Parser.REAL;
		 }}
}

<<EOF>> {dedentAll(); System.exit(0);}
