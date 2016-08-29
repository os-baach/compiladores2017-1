import java.util.Stack;
import java.util.Arrays;
%%
%public
%class Flexer
%standalone
%line

LETRA	=	[c]
PALABRA	= 	[ab] 
ORACION	=	{PALABRA} | {PALABRA}*{LETRA}

%%

(ORACION) {System.out.println("Aceptado");}