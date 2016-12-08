/* The following code was generated by JFlex 1.4.3 on 12/7/16, 6:02 PM */

import java.util.Stack;
import java.util.Arrays;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 12/7/16, 6:02 PM from the specification file
 * <tt>Flex.flex</tt>
 */
public class Flexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int DEDENT = 8;
  public static final int CONTADOR = 2;
  public static final int YYINITIAL = 0;
  public static final int NORMAL = 10;
  public static final int EOF = 12;
  public static final int CADENA = 6;
  public static final int INDENT = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  3, 3
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\5\1\43\2\0\1\10\22\0\1\4\1\40\1\32\1\42"+
    "\1\0\1\36\2\0\1\41\1\41\1\34\1\33\1\0\1\33\1\7"+
    "\1\35\1\2\11\6\1\41\1\41\1\33\1\37\1\33\2\0\5\1"+
    "\1\31\15\1\1\27\6\1\4\0\1\1\1\0\1\11\2\1\1\13"+
    "\1\24\1\17\1\1\1\21\1\22\2\1\1\23\1\1\1\12\1\14"+
    "\1\26\1\1\1\15\1\25\1\16\1\30\1\1\1\20\3\1\1\0"+
    "\1\3\uff83\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\6\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\6\1\0\12\5\1\0\4\12\1\0"+
    "\1\13\1\14\1\15\2\5\1\16\5\5\1\17\1\14"+
    "\6\5\1\20";

  private static int [] zzUnpackAction() {
    int [] result = new int[53];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\44\0\110\0\154\0\220\0\264\0\154\0\154"+
    "\0\154\0\154\0\330\0\374\0\154\0\154\0\154\0\u0120"+
    "\0\u0144\0\u0168\0\u018c\0\u01b0\0\u01d4\0\u01f8\0\u021c\0\u0240"+
    "\0\u0264\0\u0288\0\u02ac\0\u02d0\0\u02f4\0\u0318\0\u033c\0\154"+
    "\0\u02f4\0\154\0\u0360\0\u0144\0\u0384\0\u03a8\0\330\0\u03cc"+
    "\0\u03f0\0\u0414\0\u0438\0\u045c\0\u02d0\0\154\0\u0480\0\u04a4"+
    "\0\u04c8\0\u04ec\0\u0510\0\u0534\0\330";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[53];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\43\7\1\0\43\10\1\0\43\11\45\0\43\12\2\0"+
    "\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\15"+
    "\1\22\1\23\1\13\1\24\2\13\1\25\1\26\1\13"+
    "\1\27\1\13\1\30\1\13\1\31\1\32\1\13\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\35\1\41\1\42"+
    "\1\43\1\15\1\0\2\13\3\0\1\13\2\0\21\13"+
    "\21\0\1\44\36\0\1\20\3\0\1\20\1\44\36\0"+
    "\1\44\3\0\1\44\36\0\2\13\3\0\1\13\2\0"+
    "\1\13\1\45\17\13\13\0\2\13\3\0\1\13\2\0"+
    "\3\13\1\46\15\13\13\0\2\13\3\0\1\13\2\0"+
    "\4\13\1\47\14\13\13\0\2\13\3\0\1\13\2\0"+
    "\3\13\1\24\15\13\13\0\2\13\3\0\1\13\2\0"+
    "\10\13\1\50\10\13\13\0\2\13\3\0\1\13\2\0"+
    "\1\13\1\47\4\13\1\47\12\13\13\0\2\13\3\0"+
    "\1\13\2\0\12\13\1\51\6\13\13\0\2\13\3\0"+
    "\1\13\2\0\4\13\1\52\14\13\13\0\2\13\3\0"+
    "\1\13\2\0\4\13\1\53\14\13\13\0\2\13\3\0"+
    "\1\13\2\0\1\54\20\13\12\0\10\34\1\0\21\34"+
    "\1\55\10\34\40\0\1\40\40\0\1\40\44\0\1\40"+
    "\6\0\10\43\1\56\32\43\1\56\1\0\2\13\3\0"+
    "\1\13\2\0\2\13\1\47\16\13\13\0\2\13\3\0"+
    "\1\13\2\0\5\13\1\47\13\13\13\0\2\13\3\0"+
    "\1\13\2\0\11\13\1\57\7\13\13\0\2\13\3\0"+
    "\1\13\2\0\11\13\1\60\2\13\1\61\4\13\13\0"+
    "\2\13\3\0\1\13\2\0\11\13\1\62\7\13\13\0"+
    "\2\13\3\0\1\13\2\0\17\13\1\63\1\13\13\0"+
    "\2\13\3\0\1\13\2\0\12\13\1\64\6\13\13\0"+
    "\2\13\3\0\1\13\2\0\12\13\1\61\6\13\13\0"+
    "\2\13\3\0\1\13\2\0\6\13\1\47\12\13\13\0"+
    "\2\13\3\0\1\13\2\0\13\13\1\47\5\13\13\0"+
    "\2\13\3\0\1\13\2\0\1\13\1\46\17\13\13\0"+
    "\2\13\3\0\1\13\2\0\13\13\1\65\5\13\13\0"+
    "\2\13\3\0\1\13\2\0\14\13\1\63\4\13\12\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1368];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\10\2\0\4\11\2\1\3\11\1\1\1\0"+
    "\12\1\1\0\3\1\1\11\1\0\1\11\13\1\1\11"+
    "\7\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[53];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
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
    //yybegin(DEDENT);
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



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Flexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Flexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 124) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 10: 
          { if(linestart){
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
	    yyparser.yylval = new ParserVal(new NodoMayor()); return Parser.MAYOR;

	case "<":
	    yyparser.yylval = new ParserVal(new NodoMayor()); return Parser.MENOR;

	case "<==":
	    yyparser.yylval = new ParserVal(new NodoMenorIgual()); return Parser.MENOROIGUAL;

	case ">==":
	    yyparser.yylval = new ParserVal(new NodoMayorIgual()); return Parser.MAYOROIGUAL;

	case "==":
	    yyparser.yylval = new ParserVal(new NodoIgualIgual()); return Parser.IGUALIGUAL;

	case "!=":
	    yyparser.yylval = new ParserVal(new NodoDistinto()); return Parser.DISTINTO;

	case "-=":
	    yyparser.yylval = new ParserVal(new NodoDecremento()); return Parser.DECREMENTO;

	case "+=":
	    yyparser.yylval = new ParserVal(new NodoIncremento()); return Parser.INCREMENTO;

	case "=":
	    yyparser.yylval = new ParserVal(new NodoEq()); return Parser.IGUAL;

	}
    }
          }
        case 17: break;
        case 14: 
          { if(espacio){
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
	    yyparser.yylval = new ParserVal(new NodoAnd()); return Parser.AND;

	case "or":
	    yyparser.yylval = new ParserVal(new NodoOr()); return Parser.OR;

	case "not":
	    yyparser.yylval = new ParserVal(new NodoNot()); return Parser.NOT;

	case "for":
	    yyparser.yylval = new ParserVal(new NodoFor()); return Parser.FOR;

	case "while":
	    yyparser.yylval = new ParserVal(new NodoWhile()); return Parser.WHILE;

	case "if":
	    yyparser.yylval = new ParserVal(new NodoIf()); return Parser.IF;

	case "else":
	    yyparser.yylval = new ParserVal(new NodoElse()); return Parser.ELSE;

	case "elif":
	    yyparser.yylval = new ParserVal(new NodoElif()); return Parser.ELIF;

	case "print":
	    yyparser.yylval = new ParserVal(new NodoPrint()); return Parser.PRINT;

	case "in":
	    yyparser.yylval = new ParserVal(new NodoIn()); return Parser.IN;

	}
    }
          }
        case 18: break;
        case 4: 
          { yypushback(1);
	if(dedents > 0){
		   dedents--;
		   return Parser.DEDENT;
	}else 
	      yybegin(NORMAL);
          }
        case 19: break;
        case 8: 
          { if(linestart)
	incrementa(1); espacio = false;
          }
        case 20: break;
        case 11: 
          { if(linestart){
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
    }
          }
        case 21: break;
        case 5: 
          { if(espacio){
	System.err.println("Átomo mal formado en la línea " + (yyline+1) + ".");
	System.exit(-1);
    }
    if(linestart){
	yypushback(yylength());
	yybegin(CONTADOR);
    }else{
	System.out.print("IDENTIFICADOR(" + yytext() + ")");
	espacio = true;
	yyparser.yylval = new ParserVal(new HojaIdentifier(yytext())); return Parser.IDENTIFIER;}
          }
        case 22: break;
        case 7: 
          { System.out.println("NEWLINE"); clearWhitespace(); linestart=true; espacio = false; return Parser.NEWLINE;
          }
        case 23: break;
        case 6: 
          { if(espacio){
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
    }
          }
        case 24: break;
        case 1: 
          { yypushback(1);
yybegin(NORMAL);
          }
        case 25: break;
        case 3: 
          { yypushback(1); /* Regresa un caracter que no se leyo */
	yybegin(NORMAL);
	return Parser.INDENT;
          }
        case 26: break;
        case 13: 
          { if(espacio){
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
    }
          }
        case 27: break;
        case 15: 
          { if(espacio){
	System.err.println("Átomo mal formado en la línea " + (yyline+1) + ".");
	System.exit(-1);
    }
    if(linestart){
	yypushback(yylength());
	yybegin(CONTADOR);}else{
	System.out.print("CADENA(" + quitaComillas(yytext()) + ")");
	espacio = true;
	yyparser.yylval = new ParserVal(new HojaIdentifier(yytext())); return Parser.CADENA;}
          }
        case 28: break;
        case 2: 
          { yypushback(1); /* Regresa un caracter que no se leyo */
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
        case 29: break;
        case 9: 
          { if(linestart)
	incrementa(TABULADOR); espacio = false;
          }
        case 30: break;
        case 16: 
          { if(espacio){
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
    }
          }
        case 31: break;
        case 12: 
          { if(!linestart){
System.out.println("NEWLINE");
clearWhitespace(); linestart=true; espacio = false;
return Parser.NEWLINE;
}
          }
        case 32: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {
                dedentAll();
	if(dedents > 0){
	    //yypushback(1);
	    dedents--;
	    return Parser.DEDENT;
	}else{
	    return 0;
        }
              }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
