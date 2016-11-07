//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";






//#line 2 "Parser.y"
  import java.lang.Math;
  import java.io.*;
//#line 20 "Parser.java"




public class Parser
             implements ParserTokens
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    1,    1,    1,    1,    2,    2,    3,    3,
    5,    5,    6,    6,    6,    9,    9,    7,    7,    4,
    4,   10,   10,   10,   13,   13,   11,   12,   12,   14,
   14,    8,   15,   15,   17,   17,   16,   16,   19,   19,
   18,   18,   20,   20,   22,   22,   23,   23,   23,   23,
   23,   23,   23,   23,   23,   21,   21,   25,   25,   25,
   25,   24,   24,   27,   27,   27,   27,   27,   27,   27,
   27,   26,   26,   26,   28,   28,   29,   29,   29,   29,
   29,
};
final static short yylen[] = {                            2,
    0,    1,    1,    1,    2,    2,    1,    1,    2,    3,
    1,    1,    1,    3,    3,    1,    1,    1,    2,    1,
    1,    4,    7,    8,    4,    5,    4,    1,    4,    1,
    2,    1,    1,    2,    2,    3,    1,    2,    2,    3,
    2,    1,    1,    2,    2,    3,    1,    1,    1,    1,
    1,    1,    1,    2,    1,    1,    2,    2,    2,    3,
    3,    1,    2,    2,    2,    2,    2,    3,    3,    3,
    3,    2,    2,    1,    1,    3,    1,    1,    1,    1,
    1,
};
final static short yydefred[] = {                         0,
    3,    0,    0,   80,    0,    0,    0,    0,   79,   81,
   77,   78,    0,    0,    4,    7,    8,    0,   11,   12,
    0,   20,   21,   32,    0,    0,   42,    0,    0,    0,
   74,    0,   72,   73,   41,    0,    0,   19,    5,    6,
    9,    0,   17,   16,    0,    0,    0,    0,    0,    0,
   48,   47,   51,   50,   49,   52,   55,    0,   53,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   10,   14,   15,   35,    0,   39,    0,   54,
    0,   45,   58,   59,    0,    0,   64,   65,   67,   66,
    0,    0,    0,    0,   76,    0,   28,   27,    0,   36,
   40,   46,   60,   61,   68,   69,   71,   70,    0,    0,
    0,    0,   30,    0,    0,    0,    0,    0,   29,   31,
   23,    0,    0,    0,   25,   24,    0,   26,
};
final static short yydgoto[] = {                         13,
   14,   15,   97,   17,   18,   19,   20,   21,   46,   22,
   23,   98,  112,  114,   24,   25,   48,   26,   50,   27,
   28,   60,   61,   29,   64,   30,   69,   31,   32,
};
final static short yysindex[] = {                      -158,
    0,  -69,  -69,    0, -247, -247, -247, -247,    0,    0,
    0,    0,    0, -140,    0,    0,    0, -234,    0,    0,
 -187,    0,    0,    0, -264, -256,    0,  115, -252, -246,
    0, -231,    0,    0,    0, -218, -208,    0,    0,    0,
    0, -194,    0,    0, -247, -247, -247, -206, -247, -196,
    0,    0,    0,    0,    0,    0,    0, -197,    0,  115,
  -69,  -69,  -69, -202,  -69,  -69,  -69,  -69, -156,  -69,
 -226, -226,    0,    0,    0,    0, -247,    0, -247,    0,
  -69,    0,    0,    0,  -69,  -69,    0,    0,    0,    0,
  -69,  -69,  -69,  -69,    0, -149,    0,    0, -186,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   74, -145,
 -247, -184,    0, -205, -226, -144, -142, -247,    0,    0,
    0, -226, -226, -141,    0,    0, -226,    0,
};
final static short yyrindex[] = {                       127,
    0,    0,    0,    0,    0,    0,    0, -185,    0,    0,
    0,    0,    0,  130,    0,    0,    0,    0,    0,    0,
 -179,    0,    0,    0,  100, -248,    0,  -10,   27,  -73,
    0, -103,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  122,    0,  -16,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   94,
    0,    0,    0,   53,    0,    0,    0,    0,  -43,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    1,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
    0,  -14,    2,    0,    0,    0,    0,   -3,    0,    0,
    0,  -66,    0,    0,    0,  -37,    0,    4,    0,    0,
  -40,    0,   62,  -35,    0,    5,    0,    0,    0,
};
final static int YYTABLESIZE=406;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         40,
   22,   16,   36,   37,   38,   99,   33,   34,   35,   76,
   37,   62,   63,   37,   37,   16,    2,    3,   47,   65,
   82,   66,   67,   68,   41,   49,   83,   84,   42,   37,
   37,   37,   96,    4,   37,   70,    5,    2,    3,  100,
  102,   74,   75,   71,    9,   10,   11,   12,  121,  103,
  104,  119,   78,   72,    4,  125,  126,    5,    2,    3,
  128,   85,   86,    8,   73,    9,   10,   11,   12,   87,
   88,   89,   90,   18,   95,    4,   77,   18,    5,   13,
    6,    7,  101,   13,    8,   79,    9,   10,   11,   12,
   43,   44,   45,   80,  113,  105,  106,  107,  108,  120,
    1,  110,  111,  117,  118,    2,    3,  116,  109,   91,
   16,   92,   93,   94,  124,   16,  115,  122,   39,  123,
  127,   81,    4,    2,    3,    5,    1,    6,    7,    2,
    0,    8,    0,    9,   10,   11,   12,    0,    0,    0,
    4,    0,    0,    5,    0,    6,    7,    0,    0,    8,
    0,    9,   10,   11,   12,   75,    0,    0,   75,   75,
   75,   75,   75,    0,   75,   75,   75,   75,   75,   75,
   75,   75,   75,   75,   75,   75,   75,    0,   75,   75,
   75,    0,    0,    0,    0,   62,    0,   75,   62,   62,
   62,   62,    0,    0,    2,    3,    0,   62,   62,   62,
   62,   62,   62,   62,   62,   62,   62,    0,   62,   62,
   62,    4,    0,    0,    0,   63,    0,   62,   63,   63,
   63,   63,    9,   10,   11,   12,    0,   63,   63,   63,
   63,   63,   63,   63,   63,   63,   63,    0,   63,   63,
   63,    0,   38,    0,    0,   38,   38,   63,   43,    0,
    0,   43,   43,    0,    0,    0,    0,   22,    0,   22,
    0,   38,   38,   38,   22,   22,   38,   43,   43,   43,
    0,   43,   43,    0,    0,    0,    0,    0,    0,    0,
    0,   22,    0,    0,   22,   56,   22,   22,   56,   56,
   22,    0,   22,   22,   22,   22,    0,   56,   56,   56,
   56,   56,   56,   56,   56,   56,   56,    0,   56,   56,
   56,   57,    0,    0,   57,   57,    0,   56,    0,    0,
    0,    0,    0,   57,   57,   57,   57,   57,   57,   57,
   57,   57,   57,    0,   57,   57,   57,    2,    3,    0,
    0,    0,    0,   57,    0,    0,    0,    0,    0,    0,
    0,    0,   44,    0,    4,   44,   44,    5,   33,    6,
    7,   33,   33,    8,    0,    9,   10,   11,   12,    0,
    0,   44,   44,   44,    0,   44,   44,   33,   33,   33,
   34,    0,    0,   34,   34,   51,   52,   53,   54,   55,
   56,   57,    0,    0,    0,    0,    0,    0,   58,   34,
   34,   34,    0,    0,    0,   59,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         14,
    0,    0,    6,    7,    8,   72,    2,    3,    5,   47,
  259,  264,  265,  262,  263,   14,  264,  265,  283,  266,
   61,  268,  269,  270,  259,  282,   62,   63,  263,  278,
  279,  280,  259,  281,  283,  267,  284,  264,  265,   77,
   81,   45,   46,  262,  292,  293,  294,  295,  115,   85,
   86,  257,   49,  262,  281,  122,  123,  284,  264,  265,
  127,  264,  265,  290,  259,  292,  293,  294,  295,   65,
   66,   67,   68,  259,   70,  281,  283,  263,  284,  259,
  286,  287,   79,  263,  290,  282,  292,  293,  294,  295,
  278,  279,  280,  291,  109,   91,   92,   93,   94,  114,
  259,  288,  289,  288,  289,  264,  265,  111,  258,  266,
  109,  268,  269,  270,  118,  114,  262,  262,  259,  262,
  262,   60,  281,  264,  265,  284,    0,  286,  287,    0,
   -1,  290,   -1,  292,  293,  294,  295,   -1,   -1,   -1,
  281,   -1,   -1,  284,   -1,  286,  287,   -1,   -1,  290,
   -1,  292,  293,  294,  295,  259,   -1,   -1,  262,  263,
  264,  265,  266,   -1,  268,  269,  270,  271,  272,  273,
  274,  275,  276,  277,  278,  279,  280,   -1,  282,  283,
  284,   -1,   -1,   -1,   -1,  259,   -1,  291,  262,  263,
  264,  265,   -1,   -1,  264,  265,   -1,  271,  272,  273,
  274,  275,  276,  277,  278,  279,  280,   -1,  282,  283,
  284,  281,   -1,   -1,   -1,  259,   -1,  291,  262,  263,
  264,  265,  292,  293,  294,  295,   -1,  271,  272,  273,
  274,  275,  276,  277,  278,  279,  280,   -1,  282,  283,
  284,   -1,  259,   -1,   -1,  262,  263,  291,  259,   -1,
   -1,  262,  263,   -1,   -1,   -1,   -1,  257,   -1,  259,
   -1,  278,  279,  280,  264,  265,  283,  278,  279,  280,
   -1,  282,  283,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  281,   -1,   -1,  284,  259,  286,  287,  262,  263,
  290,   -1,  292,  293,  294,  295,   -1,  271,  272,  273,
  274,  275,  276,  277,  278,  279,  280,   -1,  282,  283,
  284,  259,   -1,   -1,  262,  263,   -1,  291,   -1,   -1,
   -1,   -1,   -1,  271,  272,  273,  274,  275,  276,  277,
  278,  279,  280,   -1,  282,  283,  284,  264,  265,   -1,
   -1,   -1,   -1,  291,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  259,   -1,  281,  262,  263,  284,  259,  286,
  287,  262,  263,  290,   -1,  292,  293,  294,  295,   -1,
   -1,  278,  279,  280,   -1,  282,  283,  278,  279,  280,
  259,   -1,   -1,  262,  263,  271,  272,  273,  274,  275,
  276,  277,   -1,   -1,   -1,   -1,   -1,   -1,  284,  278,
  279,  280,   -1,   -1,   -1,  291,
};
}
final static short YYFINAL=13;
final static short YYMAXTOKEN=295;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"DEDENT","INDENT","NEWLINE","PARENTESISI","PARENTESISD",
"DOSPUNTOS","PUNTOYCOMA","MAS","MENOS","POR","POTENCIA","DIV","DIVENTERA",
"MODULO","MAYOR","MENOR","MENOROIGUAL","MAYOROIGUAL","IGUALIGUAL","DISTINTO",
"EQ","DECREMENTO","INCREMENTO","IGUAL","BOOLEAN","AND","OR","NOT","FOR","WHILE",
"IF","ELSE","ELIF","PRINT","IN","CADENA","IDENTIFIER","ENTERO","REAL",
};
final static String yyrule[] = {
"$accept : file_input",
"file_input :",
"file_input : aux0",
"aux0 : NEWLINE",
"aux0 : stmt",
"aux0 : aux0 NEWLINE",
"aux0 : aux0 stmt",
"stmt : simple_stmt",
"stmt : compound_stmt",
"simple_stmt : small_stmt NEWLINE",
"simple_stmt : small_stmt PUNTOYCOMA NEWLINE",
"small_stmt : expr_stmt",
"small_stmt : print_stmt",
"expr_stmt : test",
"expr_stmt : test IGUAL test",
"expr_stmt : test augassign test",
"augassign : INCREMENTO",
"augassign : DECREMENTO",
"print_stmt : PRINT",
"print_stmt : PRINT test",
"compound_stmt : if_stmt",
"compound_stmt : while_stmt",
"if_stmt : IF test DOSPUNTOS suite",
"if_stmt : IF test DOSPUNTOS suite ELSE DOSPUNTOS suite",
"if_stmt : IF test DOSPUNTOS suite aux1 ELSE DOSPUNTOS suite",
"aux1 : ELIF test DOSPUNTOS suite",
"aux1 : aux1 ELIF test DOSPUNTOS suite",
"while_stmt : WHILE test DOSPUNTOS suite",
"suite : simple_stmt",
"suite : NEWLINE INDENT aux2 DEDENT",
"aux2 : stmt",
"aux2 : aux2 stmt",
"test : or_test",
"or_test : and_test",
"or_test : and_test aux3",
"aux3 : OR and_test",
"aux3 : aux3 OR and_test",
"and_test : not_test",
"and_test : not_test aux4",
"aux4 : AND not_test",
"aux4 : aux4 AND not_test",
"not_test : NOT not_test",
"not_test : comparison",
"comparison : expr",
"comparison : expr aux5",
"aux5 : comp_op expr",
"aux5 : aux5 comp_op expr",
"comp_op : MENOR",
"comp_op : MAYOR",
"comp_op : IGUALIGUAL",
"comp_op : MAYOROIGUAL",
"comp_op : MENOROIGUAL",
"comp_op : DISTINTO",
"comp_op : IN",
"comp_op : NOT IN",
"comp_op : EQ",
"expr : term",
"expr : term aux6",
"aux6 : MAS term",
"aux6 : MENOS term",
"aux6 : aux6 MAS term",
"aux6 : aux6 MENOS term",
"term : factor",
"term : factor aux7",
"aux7 : POR factor",
"aux7 : DIV factor",
"aux7 : MODULO factor",
"aux7 : DIVENTERA factor",
"aux7 : aux7 POR factor",
"aux7 : aux7 DIV factor",
"aux7 : aux7 MODULO factor",
"aux7 : aux7 DIVENTERA factor",
"factor : MAS factor",
"factor : MENOS factor",
"factor : power",
"power : atom",
"power : atom POTENCIA factor",
"atom : ENTERO",
"atom : REAL",
"atom : CADENA",
"atom : BOOLEAN",
"atom : IDENTIFIER",
};

//#line 185 "Parser.y"

private Flexer lexer;
/* interface to the lexer */
private int yylex () {
  int yyl_return = -1;
  try {
    yyl_return = lexer.yylex();
  }
  catch (IOException e) {
    System.err.println("IO error :"+e);
  }
  return yyl_return;
}
/* error reporting */
public void yyerror (String error) {
  System.err.println ("Error: " + error);
}
/* lexer is created in the constructor */
public Parser(Reader r) {
  lexer = new Flexer(r, this);
}
/* that's how you use the parser */
public static void main(String args[]) throws IOException {
  Parser yyparser = new Parser(new FileReader(args[0]));
  yyparser.yyparse();
}

//#line 439 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 21 "Parser.y"
{System.out.println("Reconocimiento exitoso");}
break;
case 2:
//#line 22 "Parser.y"
{yyval = val_peek(0);}
break;
case 4:
//#line 26 "Parser.y"
{yyval = val_peek(0);}
break;
case 7:
//#line 32 "Parser.y"
{yyval = val_peek(0);}
break;
case 8:
//#line 33 "Parser.y"
{yyval = val_peek(0);}
break;
case 9:
//#line 37 "Parser.y"
{yyval = val_peek(1);}
break;
case 11:
//#line 42 "Parser.y"
{yyval = val_peek(0);}
break;
case 12:
//#line 43 "Parser.y"
{yyval = val_peek(0);}
break;
case 13:
//#line 47 "Parser.y"
{yyval = val_peek(0);}
break;
case 20:
//#line 63 "Parser.y"
{yyval = val_peek(0);}
break;
case 21:
//#line 64 "Parser.y"
{yyval = val_peek(0);}
break;
case 22:
//#line 68 "Parser.y"
{yyval = val_peek(2); yyval = val_peek(0);}
break;
case 25:
//#line 73 "Parser.y"
{yyval = val_peek(2); yyval = val_peek(0);}
break;
case 27:
//#line 78 "Parser.y"
{yyval = val_peek(2); yyval = val_peek(0);}
break;
case 28:
//#line 82 "Parser.y"
{yyval = val_peek(0);}
break;
case 30:
//#line 86 "Parser.y"
{yyval = val_peek(0);}
break;
case 32:
//#line 91 "Parser.y"
{yyval = val_peek(0);}
break;
case 33:
//#line 95 "Parser.y"
{yyval = val_peek(0);}
break;
case 37:
//#line 104 "Parser.y"
{yyval = val_peek(0);}
break;
case 42:
//#line 114 "Parser.y"
{yyval = val_peek(0);}
break;
case 43:
//#line 118 "Parser.y"
{yyval = val_peek(0);}
break;
case 45:
//#line 122 "Parser.y"
{yyval = val_peek(1);}
break;
case 56:
//#line 139 "Parser.y"
{yyval = val_peek(0);}
break;
case 62:
//#line 150 "Parser.y"
{yyval = val_peek(0);}
break;
case 73:
//#line 166 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo izq = (Nodo) val_peek(0).obj; n.setHijoIzq(izq); yyval = new ParserVal((Object)n);}
break;
case 74:
//#line 167 "Parser.y"
{yyval = val_peek(0);}
break;
case 75:
//#line 171 "Parser.y"
{yyval = val_peek(0);}
break;
case 76:
//#line 172 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo izq = (Nodo) val_peek(2).obj; Nodo der = (Nodo) val_peek(0).obj; n.setHijoIzq(izq); n.setHijoDer(der); yyval = new ParserVal((Object)n);}
break;
case 77:
//#line 177 "Parser.y"
{yyval = val_peek(0);}
break;
case 78:
//#line 178 "Parser.y"
{yyval = val_peek(0);}
break;
case 79:
//#line 179 "Parser.y"
{yyval = val_peek(0);}
break;
case 80:
//#line 180 "Parser.y"
{yyval = val_peek(0);}
break;
case 81:
//#line 181 "Parser.y"
{yyval = val_peek(0);}
break;
//#line 720 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
