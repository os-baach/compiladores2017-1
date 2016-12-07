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
   23,   23,   23,   23,   21,   21,   25,   25,   25,   25,
   24,   24,   27,   27,   27,   27,   27,   27,   27,   27,
   26,   26,   26,   28,   28,   29,   29,   29,   29,   29,
};
final static short yylen[] = {                            2,
    0,    1,    1,    1,    2,    2,    1,    1,    2,    3,
    1,    1,    1,    3,    3,    1,    1,    1,    2,    1,
    1,    4,    7,    8,    4,    5,    4,    1,    4,    1,
    2,    1,    1,    2,    2,    3,    1,    2,    2,    3,
    2,    1,    1,    2,    2,    3,    1,    1,    1,    1,
    1,    1,    1,    2,    1,    2,    2,    2,    3,    3,
    1,    2,    2,    2,    2,    2,    3,    3,    3,    3,
    2,    2,    1,    1,    3,    1,    1,    1,    1,    1,
};
final static short yydefred[] = {                         0,
    3,    0,    0,   79,    0,    0,    0,    0,   78,   80,
   76,   77,    0,    0,    4,    7,    8,    0,   11,   12,
    0,   20,   21,   32,    0,    0,   42,    0,    0,    0,
   73,    0,   71,   72,   41,    0,    0,   19,    6,    5,
    9,    0,   17,   16,    0,    0,    0,    0,    0,    0,
   48,   47,   51,   50,   49,   52,    0,   53,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   10,   14,   15,   35,    0,   39,    0,   54,    0,
   45,   57,   58,    0,    0,   63,   64,   66,   65,    0,
    0,    0,    0,   75,    0,   28,   27,    0,   36,   40,
   46,   59,   60,   67,   68,   70,   69,    0,    0,    0,
    0,   30,    0,    0,    0,    0,    0,   29,   31,   23,
    0,    0,    0,   25,   24,    0,   26,
};
final static short yydgoto[] = {                         13,
   14,   15,   96,   17,   18,   19,   20,   21,   46,   22,
   23,   97,  111,  113,   24,   25,   48,   26,   50,   27,
   28,   59,   60,   29,   63,   30,   68,   31,   32,
};
final static short yysindex[] = {                      -159,
    0, -201, -201,    0,  -79,  -79,  -79,  -79,    0,    0,
    0,    0,    0, -142,    0,    0,    0, -219,    0,    0,
 -266,    0,    0,    0, -260, -240,    0,  110, -210, -157,
    0, -221,    0,    0,    0, -214, -204,    0,    0,    0,
    0, -197,    0,    0,  -79,  -79,  -79, -206,  -79, -213,
    0,    0,    0,    0,    0,    0, -207,    0,  110, -201,
 -201, -201, -163, -201, -201, -201, -201, -150, -201, -119,
 -119,    0,    0,    0,    0,  -79,    0,  -79,    0, -201,
    0,    0,    0, -201, -201,    0,    0,    0,    0, -201,
 -201, -201, -201,    0, -173,    0,    0, -134,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   46, -137,  -79,
 -132,    0, -205, -119, -133, -131,  -79,    0,    0,    0,
 -119, -119, -123,    0,    0, -119,    0,
};
final static short yyrindex[] = {                       103,
    0,    0,    0,    0,    0,    0,    0, -186,    0,    0,
    0,    0,    0,  128,    0,    0,    0,    0,    0,    0,
 -155,    0,    0,    0, -212,   92,    0,   65,  -29,  -83,
    0, -245,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  -22,    0,   98,
    0,    0,    0,    0,    0,    0,    0,    0,   71,    0,
    0,    0,   26,    0,    0,    0,    0,  -54,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    1,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
    0,  -14,    2,    0,    0,    0,    0,   -3,    0,    0,
    0,  -65,    0,    0,    0,  -37,    0,    4,    0,    0,
  -45,    0,   83,   75,    0,    5,    0,    0,    0,
};
final static int YYTABLESIZE=400;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         40,
   22,   16,   36,   37,   38,   98,   33,   34,   35,   75,
   43,   44,   45,   74,   81,   16,   74,   74,   74,   74,
   74,   47,   74,   74,   74,   74,   74,   74,   74,   74,
   74,   74,   74,   74,  101,   74,   74,   74,   99,   41,
   49,   73,   74,   42,   74,   69,   33,   70,  120,   33,
   33,  118,   77,   61,   62,  124,  125,   71,    2,    3,
  127,   72,    2,    3,   33,   33,   33,   78,   86,   87,
   88,   89,   18,   94,    4,   76,   18,    5,    4,    6,
    7,  100,   79,    8,  108,    9,   10,   11,   12,    9,
   10,   11,   12,  112,  104,  105,  106,  107,  119,    1,
   84,   85,    1,   13,    2,    3,  115,   13,   64,   16,
   65,   66,   67,  123,   16,   90,   39,   91,   92,   93,
    4,    2,    3,    5,  114,    6,    7,    2,  121,    8,
  122,    9,   10,   11,   12,   82,   83,    4,  126,   95,
    5,   80,    6,    7,    2,    3,    8,    0,    9,   10,
   11,   12,  109,  110,  116,  117,    0,    0,  102,  103,
    4,    0,    0,    5,    0,    0,    0,    0,    0,    8,
    0,    9,   10,   11,   12,   61,    0,    0,   61,   61,
   61,   61,    0,    0,    2,    3,    0,   61,   61,   61,
   61,   61,   61,   61,   61,   61,    0,   61,   61,   61,
    4,    0,    0,    5,   62,    0,   61,   62,   62,   62,
   62,    9,   10,   11,   12,    0,   62,   62,   62,   62,
   62,   62,   62,   62,   62,    0,   62,   62,   62,   55,
    0,    0,   55,   55,    0,   62,   34,    0,    0,   34,
   34,   55,   55,   55,   55,   55,   55,   55,   55,   55,
    0,   55,   55,   55,   34,   34,   34,   22,    0,   22,
   55,    0,    0,    0,   22,   22,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   22,    0,    0,   22,   56,   22,   22,   56,   56,   22,
    0,   22,   22,   22,   22,    0,   56,   56,   56,   56,
   56,   56,   56,   56,   56,    0,   56,   56,   56,    2,
    3,    0,    0,    0,    0,   56,    0,    0,    0,    0,
    0,    0,    0,   43,    0,    4,   43,   43,    5,   44,
    6,    7,   44,   44,    8,    0,    9,   10,   11,   12,
    0,   43,   43,   43,    0,   43,   43,   44,   44,   44,
   37,   44,   44,   37,   37,    0,   38,    0,    0,   38,
   38,    0,    0,    0,    0,    0,    0,    0,   37,   37,
   37,    0,    0,   37,   38,   38,   38,    0,    0,   38,
   51,   52,   53,   54,   55,   56,    0,    0,    0,    0,
    0,    0,   57,    0,    0,    0,    0,    0,    0,   58,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         14,
    0,    0,    6,    7,    8,   71,    2,    3,    5,   47,
  277,  278,  279,  259,   60,   14,  262,  263,  264,  265,
  266,  282,  268,  269,  270,  271,  272,  273,  274,  275,
  276,  277,  278,  279,   80,  281,  282,  283,   76,  259,
  281,   45,   46,  263,  290,  267,  259,  262,  114,  262,
  263,  257,   49,  264,  265,  121,  122,  262,  264,  265,
  126,  259,  264,  265,  277,  278,  279,  281,   64,   65,
   66,   67,  259,   69,  280,  282,  263,  283,  280,  285,
  286,   78,  290,  289,  258,  291,  292,  293,  294,  291,
  292,  293,  294,  108,   90,   91,   92,   93,  113,  259,
  264,  265,    0,  259,  264,  265,  110,  263,  266,  108,
  268,  269,  270,  117,  113,  266,  259,  268,  269,  270,
  280,  264,  265,  283,  262,  285,  286,    0,  262,  289,
  262,  291,  292,  293,  294,   61,   62,  280,  262,  259,
  283,   59,  285,  286,  264,  265,  289,   -1,  291,  292,
  293,  294,  287,  288,  287,  288,   -1,   -1,   84,   85,
  280,   -1,   -1,  283,   -1,   -1,   -1,   -1,   -1,  289,
   -1,  291,  292,  293,  294,  259,   -1,   -1,  262,  263,
  264,  265,   -1,   -1,  264,  265,   -1,  271,  272,  273,
  274,  275,  276,  277,  278,  279,   -1,  281,  282,  283,
  280,   -1,   -1,  283,  259,   -1,  290,  262,  263,  264,
  265,  291,  292,  293,  294,   -1,  271,  272,  273,  274,
  275,  276,  277,  278,  279,   -1,  281,  282,  283,  259,
   -1,   -1,  262,  263,   -1,  290,  259,   -1,   -1,  262,
  263,  271,  272,  273,  274,  275,  276,  277,  278,  279,
   -1,  281,  282,  283,  277,  278,  279,  257,   -1,  259,
  290,   -1,   -1,   -1,  264,  265,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  280,   -1,   -1,  283,  259,  285,  286,  262,  263,  289,
   -1,  291,  292,  293,  294,   -1,  271,  272,  273,  274,
  275,  276,  277,  278,  279,   -1,  281,  282,  283,  264,
  265,   -1,   -1,   -1,   -1,  290,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  259,   -1,  280,  262,  263,  283,  259,
  285,  286,  262,  263,  289,   -1,  291,  292,  293,  294,
   -1,  277,  278,  279,   -1,  281,  282,  277,  278,  279,
  259,  281,  282,  262,  263,   -1,  259,   -1,   -1,  262,
  263,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  277,  278,
  279,   -1,   -1,  282,  277,  278,  279,   -1,   -1,  282,
  271,  272,  273,  274,  275,  276,   -1,   -1,   -1,   -1,
   -1,   -1,  283,   -1,   -1,   -1,   -1,   -1,   -1,  290,
};
}
final static short YYFINAL=13;
final static short YYMAXTOKEN=294;
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
"DECREMENTO","INCREMENTO","IGUAL","BOOLEAN","AND","OR","NOT","FOR","WHILE","IF",
"ELSE","ELIF","PRINT","IN","CADENA","IDENTIFIER","ENTERO","REAL",
};
final static String yyrule[] = {
"$accept : file_input",
"file_input :",
"file_input : aux0",
"aux0 : NEWLINE",
"aux0 : stmt",
"aux0 : aux0 stmt",
"aux0 : aux0 NEWLINE",
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
  System.err.println ("Error: " + lexer.yytext());
}
/* lexer is created in the constructor */
public Parser(Reader r) {
  lexer = new Flexer(r, this);
  yydebug = true;
}
/* that's how you use the parser */
public static void main(String args[]) throws IOException {
  Parser yyparser = new Parser(new FileReader(args[0]));
  yyparser.yyparse();
}

//#line 434 "Parser.java"
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
//#line 20 "Parser.y"
{Nodo n = (Nodo) yyval.obj; System.out.println(n == null); System.out.println(n.imprimeSubarbol()); System.out.println("Reconocimiento exitoso");}
break;
case 2:
//#line 21 "Parser.y"
{Nodo n = (Nodo) yyval.obj; System.out.println(n == null); System.out.println(n.imprimeSubarbol()); System.out.println("Reconocimiento exitoso");}
break;
case 4:
//#line 25 "Parser.y"
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
case 10:
//#line 39 "Parser.y"
{yyval = val_peek(2);}
break;
case 11:
//#line 43 "Parser.y"
{yyval = val_peek(0);}
break;
case 12:
//#line 44 "Parser.y"
{yyval = val_peek(0);}
break;
case 13:
//#line 48 "Parser.y"
{yyval = val_peek(0);}
break;
case 14:
//#line 49 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo izq = (Nodo) val_peek(2).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoIzq(izq); n.meteHijoDer(der); yyval = new ParserVal((Object)n);}
break;
case 15:
//#line 50 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo izq = (Nodo) val_peek(2).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoIzq(izq); n.meteHijoDer(der); yyval = new ParserVal((Object)n);}
break;
case 16:
//#line 54 "Parser.y"
{yyval = val_peek(0);}
break;
case 17:
//#line 55 "Parser.y"
{yyval = val_peek(0);}
break;
case 19:
//#line 60 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo izq = (Nodo) val_peek(0).obj; n.meteHijoDer(izq); yyval = new ParserVal((Object)n);}
break;
case 20:
//#line 64 "Parser.y"
{yyval = val_peek(0);}
break;
case 21:
//#line 65 "Parser.y"
{yyval = val_peek(0);}
break;
case 22:
//#line 69 "Parser.y"
{Nodo n = (Nodo) val_peek(3).obj; Nodo izq = (Nodo) val_peek(2).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoIzq(der); n.meteHijoDer(izq); yyval = new ParserVal((Object)n);}
break;
case 23:
//#line 70 "Parser.y"
{Nodo n = (Nodo) val_peek(6).obj; Nodo izq = (Nodo) val_peek(5).obj; Nodo der = (Nodo) val_peek(3).obj; Nodo felse = (Nodo) val_peek(2).obj; Nodo otro = (Nodo) val_peek(0).obj;  n.meteHijo(felse); n.meteHijo(der); n.meteHijo(izq); felse.meteHijo(otro); yyval = new ParserVal((Object)n);}
break;
case 24:
//#line 71 "Parser.y"
{Nodo n = (Nodo) val_peek(7).obj; Nodo test = (Nodo) val_peek(6).obj; Nodo sucede = (Nodo) val_peek(4).obj; Nodo elif = (Nodo)val_peek(3).obj; Nodo felse = (Nodo)val_peek(2).obj; Nodo otro = (Nodo)val_peek(0).obj; n.meteHijo(felse); n.meteHijo(elif); n.meteHijo(sucede); n.meteHijo(test); felse.meteHijo(otro); yyval = new ParserVal((Object)n);}
break;
case 25:
//#line 74 "Parser.y"
{Nodo n = (Nodo) val_peek(3).obj; Nodo izq = (Nodo) val_peek(2).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoIzq(der); n.meteHijoDer(izq); yyval = new ParserVal((Object)n);}
break;
case 26:
//#line 75 "Parser.y"
{Nodo aux = (Nodo) val_peek(4).obj; Nodo elif = (Nodo) val_peek(3).obj; Nodo cond = (Nodo) val_peek(2).obj; Nodo suc = (Nodo) val_peek(0).obj; aux.meteInicio(elif); elif.meteHijoIzq(suc); elif.meteHijoDer(cond); yyval = new ParserVal((Object)aux);}
break;
case 27:
//#line 79 "Parser.y"
{Nodo n = (Nodo) val_peek(3).obj; Nodo izq = (Nodo) val_peek(2).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoIzq(der); n.meteHijoDer(izq); yyval = new ParserVal((Object)n);}
break;
case 28:
//#line 83 "Parser.y"
{yyval = val_peek(0);}
break;
case 29:
//#line 84 "Parser.y"
{yyval = val_peek(1);}
break;
case 30:
//#line 87 "Parser.y"
{yyval = val_peek(0);}
break;
case 31:
//#line 88 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo hijo = (Nodo) val_peek(0).obj; n.meteHijoDer(hijo); yyval = new ParserVal((Object)n);}
break;
case 32:
//#line 92 "Parser.y"
{yyval = val_peek(0);}
break;
case 33:
//#line 96 "Parser.y"
{yyval = val_peek(0);}
break;
case 34:
//#line 97 "Parser.y"
{Nodo n = (Nodo) val_peek(0).obj; Nodo hijo = (Nodo) val_peek(1).obj; n.meteHijoDer(hijo); yyval = new ParserVal((Object)n);}
break;
case 35:
//#line 100 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoDer(der); yyval = new ParserVal((Object)n);}
break;
case 36:
//#line 101 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo izq = (Nodo) val_peek(2).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoIzq(der); n.meteHijoDer(izq); yyval = new ParserVal((Object)n);}
break;
case 37:
//#line 105 "Parser.y"
{yyval = val_peek(0);}
break;
case 38:
//#line 106 "Parser.y"
{Nodo n = (Nodo) val_peek(0).obj; Nodo hijo = (Nodo) val_peek(1).obj; n.meteHijoDer(hijo); yyval = new ParserVal((Object)n);}
break;
case 39:
//#line 109 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoDer(der); yyval = new ParserVal((Object)n);}
break;
case 40:
//#line 110 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo izq = (Nodo) val_peek(2).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoIzq(der); n.meteHijoDer(izq); yyval = new ParserVal((Object)n);}
break;
case 41:
//#line 114 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo izq = (Nodo) val_peek(0).obj; n.meteHijoIzq(izq); yyval = new ParserVal((Object)n);}
break;
case 42:
//#line 115 "Parser.y"
{yyval = val_peek(0);}
break;
case 43:
//#line 119 "Parser.y"
{yyval = val_peek(0);}
break;
case 44:
//#line 120 "Parser.y"
{Nodo n = (Nodo) val_peek(0).obj; Nodo hijo = (Nodo) val_peek(1).obj; n.meteHijoDer(hijo); yyval = new ParserVal((Object)n);}
break;
case 45:
//#line 123 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoDer(der); yyval = new ParserVal((Object)n);}
break;
case 46:
//#line 124 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo izq = (Nodo) val_peek(2).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoIzq(izq); n.meteHijoDer(der); yyval = new ParserVal((Object)n);}
break;
case 47:
//#line 128 "Parser.y"
{yyval = val_peek(0);}
break;
case 48:
//#line 129 "Parser.y"
{yyval = val_peek(0);}
break;
case 49:
//#line 130 "Parser.y"
{yyval = val_peek(0);}
break;
case 50:
//#line 131 "Parser.y"
{yyval = val_peek(0);}
break;
case 51:
//#line 132 "Parser.y"
{yyval = val_peek(0);}
break;
case 52:
//#line 133 "Parser.y"
{yyval = val_peek(0);}
break;
case 53:
//#line 134 "Parser.y"
{yyval = val_peek(0);}
break;
case 54:
//#line 135 "Parser.y"
{yyval = val_peek(1); yyval = val_peek(0);}
break;
case 55:
//#line 139 "Parser.y"
{yyval = val_peek(0);}
break;
case 56:
//#line 140 "Parser.y"
{Nodo n = (Nodo) val_peek(0).obj; Nodo hijo = (Nodo) val_peek(1).obj; n.meteHijoDer(hijo); yyval = new ParserVal((Object)n);}
break;
case 57:
//#line 143 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoDer(der); yyval = new ParserVal((Object)n);}
break;
case 58:
//#line 144 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoDer(der); yyval = new ParserVal((Object)n);}
break;
case 59:
//#line 145 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo izq = (Nodo) val_peek(2).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoIzq(der); n.meteHijoDer(izq); yyval = new ParserVal((Object)n);}
break;
case 60:
//#line 146 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo izq = (Nodo) val_peek(2).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoIzq(der); n.meteHijoDer(izq); yyval = new ParserVal((Object)n);}
break;
case 61:
//#line 150 "Parser.y"
{yyval = val_peek(0);}
break;
case 62:
//#line 151 "Parser.y"
{Nodo n = (Nodo) val_peek(0).obj; Nodo hijo = (Nodo) val_peek(1).obj; n.meteHijoDer(hijo); yyval = new ParserVal((Object)n);}
break;
case 63:
//#line 154 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoDer(der); yyval = new ParserVal((Object)n);}
break;
case 64:
//#line 155 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoDer(der); yyval = new ParserVal((Object)n);}
break;
case 65:
//#line 156 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoDer(der); yyval = new ParserVal((Object)n);}
break;
case 66:
//#line 157 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoDer(der); yyval = new ParserVal((Object)n);}
break;
case 67:
//#line 158 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo izq = (Nodo) val_peek(2).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoIzq(der); n.meteHijoDer(izq); yyval = new ParserVal((Object)n);}
break;
case 68:
//#line 159 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo izq = (Nodo) val_peek(2).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoIzq(der); n.meteHijoDer(izq); yyval = new ParserVal((Object)n);}
break;
case 69:
//#line 160 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo izq = (Nodo) val_peek(2).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoIzq(der); n.meteHijoDer(izq); yyval = new ParserVal((Object)n);}
break;
case 70:
//#line 161 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo izq = (Nodo) val_peek(2).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoIzq(der); n.meteHijoDer(izq); yyval = new ParserVal((Object)n);}
break;
case 71:
//#line 165 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo izq = (Nodo) val_peek(0).obj; n.meteHijoDer(izq); yyval = new ParserVal((Object)n);}
break;
case 72:
//#line 166 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo izq = (Nodo) val_peek(0).obj; n.meteHijoDer(izq); yyval = new ParserVal((Object)n);}
break;
case 73:
//#line 167 "Parser.y"
{yyval = val_peek(0);}
break;
case 74:
//#line 171 "Parser.y"
{yyval = val_peek(0);}
break;
case 75:
//#line 172 "Parser.y"
{Nodo n = (Nodo) val_peek(1).obj; Nodo izq = (Nodo) val_peek(2).obj; Nodo der = (Nodo) val_peek(0).obj; n.meteHijoIzq(der); n.meteHijoDer(izq); yyval = new ParserVal((Object)n);}
break;
case 76:
//#line 177 "Parser.y"
{yyval = val_peek(0);}
break;
case 77:
//#line 178 "Parser.y"
{yyval = val_peek(0);}
break;
case 78:
//#line 179 "Parser.y"
{yyval = val_peek(0);}
break;
case 79:
//#line 180 "Parser.y"
{yyval = val_peek(0);}
break;
case 80:
//#line 181 "Parser.y"
{yyval = val_peek(0);}
break;
//#line 887 "Parser.java"
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
