import java.util.Stack;
import java.util.Arrays;
%%
%public
%class Flexer
%byaccj
%line
%unicode
%debug
%{
	private Parser yyparser;

	public Flexer(java.io.Reader r,Parser parser) {

	this(r);
	this.yyparser = parser;
	
	}

%}

NUMBER = [0-9]
MAS = ("+")
MENOS = ("-")
MULT = ("*")
DIV = ("/")

%%

{NUMBER}    { yyparser.yylval=new ParserVal(Integer.parseInt(yytext())); return Parser.NUMBER;}
{MAS}	    { return Parser.MAS; }
{MENOS}	    { return Parser.MENOS; }
{MULT}	    { return Parser.MULT; }
{DIV} 	    { return Parser.DIV; }

<<EOF>>	    { return 0; }
[^] 	    {}
