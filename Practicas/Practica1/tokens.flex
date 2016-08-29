import java.util.Stack;
import java.util.Arrays;
%%
%public
%class Flexer
%standalone
%line

LETRA	=	[a-zA-Z]
DIGIT	=	[0-9]
OTROS	=	[_]
PUNTO	=	[.]
NNDIGIT		=       [1-9]
CERO             	=        0
ENTERO = {CERO} | {NNDIGIT}{DIGIT}*

%%

({LETRA}|{OTROS})({LETRA}|{OTROS}|{DIGIT})*	{System.out.println("IDENTIFICADOR(" + yytext() + ")"); }

{ENTERO}		      	{ System.out.println("INTEGER("+yytext()+")");}		


({ENTERO})({PUNTO})(({DIGIT})*)   	{ System.out.println("REAL("+yytext()+")");}		
