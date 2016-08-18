/********************************************************************************
**                                                                                                **
*********************************************************************************/
import java.util.Stack;
import java.util.Arrays;
%%
%public
%class Flexer
%standalone
%line

NNDIGIT		=       [1-9]
DIGIT		=       [0-9]       
CERO             	=        0
%%
{CERO} | {NNDIGIT}{DIGIT}*		      	{ System.out.println("INTEGER");}		

