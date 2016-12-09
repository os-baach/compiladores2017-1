import java.util.Hashtable;
/* Representa a la tabla de operaciones */
public class TablaOp{
    private Hashtable<Tripleta, Tipo> tabla;

    public TablaOp(){
	this.tabla = new Hashtable<>();
	/* Operación MAS */
	this.tabla.put(new Tripleta("MAS", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.ENTERO);
	this.tabla.put(new Tripleta("MAS", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.ENTERO);
	this.tabla.put(new Tripleta("MAS", Tipo.BOOLEAN, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("MAS", Tipo.BOOLEAN, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("MAS", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.ENTERO);
	this.tabla.put(new Tripleta("MAS", Tipo.REAL, Tipo.BOOLEAN), Tipo.REAL);
	this.tabla.put(new Tripleta("MAS", Tipo.CADENA, Tipo.BOOLEAN), Tipo.ERROR);
	this.tabla.put(new Tripleta("MAS", Tipo.ENTERO, Tipo.ENTERO), Tipo.ENTERO);
	this.tabla.put(new Tripleta("MAS", Tipo.ENTERO, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("MAS", Tipo.ENTERO, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("MAS", Tipo.REAL, Tipo.ENTERO), Tipo.REAL);
	this.tabla.put(new Tripleta("MAS", Tipo.CADENA, Tipo.ENTERO), Tipo.ERROR);
	this.tabla.put(new Tripleta("MAS", Tipo.REAL, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("MAS", Tipo.REAL, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("MAS", Tipo.CADENA, Tipo.REAL), Tipo.ERROR);
	this.tabla.put(new Tripleta("MAS", Tipo.CADENA, Tipo.CADENA), Tipo.CADENA);
	/* Operación MENOS */
	this.tabla.put(new Tripleta("MENOS", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.ENTERO);
	this.tabla.put(new Tripleta("MENOS", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.ENTERO);
	this.tabla.put(new Tripleta("MENOS", Tipo.BOOLEAN, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("MENOS", Tipo.BOOLEAN, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("MENOS", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.ENTERO);
	this.tabla.put(new Tripleta("MENOS", Tipo.REAL, Tipo.BOOLEAN), Tipo.REAL);
	this.tabla.put(new Tripleta("MENOS", Tipo.CADENA, Tipo.BOOLEAN), Tipo.ERROR);
	this.tabla.put(new Tripleta("MENOS", Tipo.ENTERO, Tipo.ENTERO), Tipo.ENTERO);
	this.tabla.put(new Tripleta("MENOS", Tipo.ENTERO, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("MENOS", Tipo.ENTERO, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("MENOS", Tipo.REAL, Tipo.ENTERO), Tipo.REAL);
	this.tabla.put(new Tripleta("MENOS", Tipo.CADENA, Tipo.ENTERO), Tipo.ERROR);
	this.tabla.put(new Tripleta("MENOS", Tipo.REAL, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("MENOS", Tipo.REAL, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("MENOS", Tipo.CADENA, Tipo.REAL), Tipo.ERROR);
	this.tabla.put(new Tripleta("MENOS", Tipo.CADENA, Tipo.CADENA), Tipo.ERROR);
	/* Operación POR */
	this.tabla.put(new Tripleta("POR", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.ENTERO);
	this.tabla.put(new Tripleta("POR", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.ENTERO);
	this.tabla.put(new Tripleta("POR", Tipo.BOOLEAN, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("POR", Tipo.BOOLEAN, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("POR", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.ENTERO);
	this.tabla.put(new Tripleta("POR", Tipo.REAL, Tipo.BOOLEAN), Tipo.REAL);
	this.tabla.put(new Tripleta("POR", Tipo.CADENA, Tipo.BOOLEAN), Tipo.ERROR);
	this.tabla.put(new Tripleta("POR", Tipo.ENTERO, Tipo.ENTERO), Tipo.ENTERO);
	this.tabla.put(new Tripleta("POR", Tipo.ENTERO, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("POR", Tipo.ENTERO, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("POR", Tipo.REAL, Tipo.ENTERO), Tipo.REAL);
	this.tabla.put(new Tripleta("POR", Tipo.CADENA, Tipo.ENTERO), Tipo.ERROR);
	this.tabla.put(new Tripleta("POR", Tipo.REAL, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("POR", Tipo.REAL, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("POR", Tipo.CADENA, Tipo.REAL), Tipo.ERROR);
	this.tabla.put(new Tripleta("POR", Tipo.CADENA, Tipo.CADENA), Tipo.ERROR);
	/* Operación POTENCIA */
	this.tabla.put(new Tripleta("POTENICA", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.ENTERO);
	this.tabla.put(new Tripleta("POTENCIA", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.ENTERO);
	this.tabla.put(new Tripleta("POTENCIA", Tipo.BOOLEAN, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("POTENCIA", Tipo.BOOLEAN, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("POTENCIA", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.ENTERO);
	this.tabla.put(new Tripleta("POTENCIA", Tipo.REAL, Tipo.BOOLEAN), Tipo.REAL);
	this.tabla.put(new Tripleta("POTENCIA", Tipo.CADENA, Tipo.BOOLEAN), Tipo.ERROR);
	this.tabla.put(new Tripleta("POTENCIA", Tipo.ENTERO, Tipo.ENTERO), Tipo.ENTERO);
	this.tabla.put(new Tripleta("POTENCIA", Tipo.ENTERO, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("POTENCIA", Tipo.ENTERO, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("POTENCIA", Tipo.REAL, Tipo.ENTERO), Tipo.REAL);
	this.tabla.put(new Tripleta("POTENCIA", Tipo.CADENA, Tipo.ENTERO), Tipo.ERROR);
	this.tabla.put(new Tripleta("POTENCIA", Tipo.REAL, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("POTENCIA", Tipo.REAL, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("POTENCIA", Tipo.CADENA, Tipo.REAL), Tipo.ERROR);
	this.tabla.put(new Tripleta("POTENCIA", Tipo.CADENA, Tipo.CADENA), Tipo.ERROR);
	
	/* Operación DIV */
	this.tabla.put(new Tripleta("DIV", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.ENTERO);
	this.tabla.put(new Tripleta("DIV", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.ENTERO);
	this.tabla.put(new Tripleta("DIV", Tipo.BOOLEAN, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("DIV", Tipo.BOOLEAN, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("DIV", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.ENTERO);
	this.tabla.put(new Tripleta("DIV", Tipo.REAL, Tipo.BOOLEAN), Tipo.REAL);
	this.tabla.put(new Tripleta("DIV", Tipo.CADENA, Tipo.BOOLEAN), Tipo.ERROR);
	this.tabla.put(new Tripleta("DIV", Tipo.ENTERO, Tipo.ENTERO), Tipo.ENTERO);
	this.tabla.put(new Tripleta("DIV", Tipo.ENTERO, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("DIV", Tipo.ENTERO, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("DIV", Tipo.REAL, Tipo.ENTERO), Tipo.REAL);
	this.tabla.put(new Tripleta("DIV", Tipo.CADENA, Tipo.ENTERO), Tipo.ERROR);
	this.tabla.put(new Tripleta("DIV", Tipo.REAL, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("DIV", Tipo.REAL, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("DIV", Tipo.CADENA, Tipo.REAL), Tipo.ERROR);
	this.tabla.put(new Tripleta("DIV", Tipo.CADENA, Tipo.CADENA), Tipo.ERROR);

	/* Operación DIVENTERA */
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.ENTERO);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.ENTERO);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.BOOLEAN, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.BOOLEAN, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.ENTERO);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.REAL, Tipo.BOOLEAN), Tipo.REAL);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.CADENA, Tipo.BOOLEAN), Tipo.ERROR);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.ENTERO, Tipo.ENTERO), Tipo.ENTERO);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.ENTERO, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.ENTERO, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.REAL, Tipo.ENTERO), Tipo.REAL);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.CADENA, Tipo.ENTERO), Tipo.ERROR);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.REAL, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.REAL, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.CADENA, Tipo.REAL), Tipo.ERROR);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.CADENA, Tipo.CADENA), Tipo.ERROR);
	/* Operación MODULO */
	this.tabla.put(new Tripleta("MODULO", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.ENTERO);
	this.tabla.put(new Tripleta("MODULO", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.ENTERO);
	this.tabla.put(new Tripleta("MODULO", Tipo.BOOLEAN, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("MODULO", Tipo.BOOLEAN, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("MODULO", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.ENTERO);
	this.tabla.put(new Tripleta("MODULO", Tipo.REAL, Tipo.BOOLEAN), Tipo.REAL);
	this.tabla.put(new Tripleta("MODULO", Tipo.CADENA, Tipo.BOOLEAN), Tipo.ERROR);
	this.tabla.put(new Tripleta("MODULO", Tipo.ENTERO, Tipo.ENTERO), Tipo.ENTERO);
	this.tabla.put(new Tripleta("MODULO", Tipo.ENTERO, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("MODULO", Tipo.ENTERO, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("MODULO", Tipo.REAL, Tipo.ENTERO), Tipo.REAL);
	this.tabla.put(new Tripleta("MODULO", Tipo.CADENA, Tipo.ENTERO), Tipo.ERROR);
	this.tabla.put(new Tripleta("MODULO", Tipo.REAL, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("MODULO", Tipo.REAL, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("MODULO", Tipo.CADENA, Tipo.REAL), Tipo.ERROR);
	this.tabla.put(new Tripleta("MODULO", Tipo.CADENA, Tipo.CADENA), Tipo.ERROR);
	/* Operación EQ */
	/* Operación MAYOR */
	this.tabla.put(new Tripleta("MAYOR", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYOR", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYOR", Tipo.BOOLEAN, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYOR", Tipo.BOOLEAN, Tipo.CADENA), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYOR", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYOR", Tipo.REAL, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYOR", Tipo.CADENA, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYOR", Tipo.ENTERO, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYOR", Tipo.ENTERO, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYOR", Tipo.ENTERO, Tipo.CADENA), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYOR", Tipo.REAL, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYOR", Tipo.CADENA, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYOR", Tipo.REAL, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYOR", Tipo.REAL, Tipo.CADENA), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYOR", Tipo.CADENA, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYOR", Tipo.CADENA, Tipo.CADENA), Tipo.BOOLEAN);
	/* Operación MENOR */
	this.tabla.put(new Tripleta("MENOR", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENOR", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENOR", Tipo.BOOLEAN, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENOR", Tipo.BOOLEAN, Tipo.CADENA), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENOR", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENOR", Tipo.REAL, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENOR", Tipo.CADENA, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENOR", Tipo.ENTERO, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENOR", Tipo.ENTERO, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENOR", Tipo.ENTERO, Tipo.CADENA), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENOR", Tipo.REAL, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENOR", Tipo.CADENA, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENOR", Tipo.REAL, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENOR", Tipo.REAL, Tipo.CADENA), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENOR", Tipo.CADENA, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENOR", Tipo.CADENA, Tipo.CADENA), Tipo.BOOLEAN);	
	/* Operación MENORIGUAL */
	this.tabla.put(new Tripleta("MENORIGUAL", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENORIGUAL", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENORIGUAL", Tipo.BOOLEAN, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENORIGUAL", Tipo.BOOLEAN, Tipo.CADENA), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENORIGUAL", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENORIGUAL", Tipo.REAL, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENORIGUAL", Tipo.CADENA, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENORIGUAL", Tipo.ENTERO, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENORIGUAL", Tipo.ENTERO, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENORIGUAL", Tipo.ENTERO, Tipo.CADENA), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENORIGUAL", Tipo.REAL, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENORIGUAL", Tipo.CADENA, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENORIGUAL", Tipo.REAL, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENORIGUAL", Tipo.REAL, Tipo.CADENA), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENORIGUAL", Tipo.CADENA, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MENORIGUAL", Tipo.CADENA, Tipo.CADENA), Tipo.BOOLEAN);	
	/* Operación MAYORIGUAL */
	this.tabla.put(new Tripleta("MAYORIGUAL", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYORIGUAL", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYORIGUAL", Tipo.BOOLEAN, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYORIGUAL", Tipo.BOOLEAN, Tipo.CADENA), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYORIGUAL", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYORIGUAL", Tipo.REAL, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYORIGUAL", Tipo.CADENA, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYORIGUAL", Tipo.ENTERO, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYORIGUAL", Tipo.ENTERO, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYORIGUAL", Tipo.ENTERO, Tipo.CADENA), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYORIGUAL", Tipo.REAL, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYORIGUAL", Tipo.CADENA, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYORIGUAL", Tipo.REAL, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYORIGUAL", Tipo.REAL, Tipo.CADENA), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYORIGUAL", Tipo.CADENA, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("MAYORIGUAL", Tipo.CADENA, Tipo.CADENA), Tipo.BOOLEAN);	
	/* Operación IGUALIGUAL */
	this.tabla.put(new Tripleta("IGUALIGUAL", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("IGUALIGUAL", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("IGUALIGUAL", Tipo.BOOLEAN, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("IGUALIGUAL", Tipo.BOOLEAN, Tipo.CADENA), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("IGUALIGUAL", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("IGUALIGUAL", Tipo.REAL, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("IGUALIGUAL", Tipo.CADENA, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("IGUALIGUAL", Tipo.ENTERO, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("IGUALIGUAL", Tipo.ENTERO, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("IGUALIGUAL", Tipo.ENTERO, Tipo.CADENA), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("IGUALIGUAL", Tipo.REAL, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("IGUALIGUAL", Tipo.CADENA, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("IGUALIGUAL", Tipo.REAL, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("IGUALIGUAL", Tipo.REAL, Tipo.CADENA), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("IGUALIGUAL", Tipo.CADENA, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("IGUALIGUAL", Tipo.CADENA, Tipo.CADENA), Tipo.BOOLEAN);		
	/* Operación DISTINTO */
	this.tabla.put(new Tripleta("DISTINTO", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("DISTINTO", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("DISTINTO", Tipo.BOOLEAN, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("DISTINTO", Tipo.BOOLEAN, Tipo.CADENA), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("DISTINTO", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("DISTINTO", Tipo.REAL, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("DISTINTO", Tipo.CADENA, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("DISTINTO", Tipo.ENTERO, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("DISTINTO", Tipo.ENTERO, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("DISTINTO", Tipo.ENTERO, Tipo.CADENA), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("DISTINTO", Tipo.REAL, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("DISTINTO", Tipo.CADENA, Tipo.ENTERO), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("DISTINTO", Tipo.REAL, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("DISTINTO", Tipo.REAL, Tipo.CADENA), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("DISTINTO", Tipo.CADENA, Tipo.REAL), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("DISTINTO", Tipo.CADENA, Tipo.CADENA), Tipo.BOOLEAN);		
	/* Operación DECREMENTO */
	this.tabla.put(new Tripleta("DECREMENTO", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.ENTERO);
	this.tabla.put(new Tripleta("DECREMENTO", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.ENTERO);
	this.tabla.put(new Tripleta("DECREMENTO", Tipo.BOOLEAN, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("DECREMENTO", Tipo.BOOLEAN, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("DECREMENTO", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.ENTERO);
	this.tabla.put(new Tripleta("DECREMENTO", Tipo.REAL, Tipo.BOOLEAN), Tipo.REAL);
	this.tabla.put(new Tripleta("DECREMENTO", Tipo.CADENA, Tipo.BOOLEAN), Tipo.ERROR);
	this.tabla.put(new Tripleta("DECREMENTO", Tipo.ENTERO, Tipo.ENTERO), Tipo.ENTERO);
	this.tabla.put(new Tripleta("DECREMENTO", Tipo.ENTERO, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("DECREMENTO", Tipo.ENTERO, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("DECREMENTO", Tipo.REAL, Tipo.ENTERO), Tipo.REAL);
	this.tabla.put(new Tripleta("DECREMENTO", Tipo.CADENA, Tipo.ENTERO), Tipo.ERROR);
	this.tabla.put(new Tripleta("DECREMENTO", Tipo.REAL, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("DECREMENTO", Tipo.REAL, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("DECREMENTO", Tipo.CADENA, Tipo.REAL), Tipo.ERROR);
	this.tabla.put(new Tripleta("DECREMENTO", Tipo.CADENA, Tipo.CADENA), Tipo.ERROR);
	/* Operación INCREMENTO */
	this.tabla.put(new Tripleta("INCREMENTO", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.ENTERO);
	this.tabla.put(new Tripleta("INCREMENTO", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.ENTERO);
	this.tabla.put(new Tripleta("INCREMENTO", Tipo.BOOLEAN, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("INCREMENTO", Tipo.BOOLEAN, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("INCREMENTO", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.ENTERO);
	this.tabla.put(new Tripleta("INCREMENTO", Tipo.REAL, Tipo.BOOLEAN), Tipo.REAL);
	this.tabla.put(new Tripleta("INCREMENTO", Tipo.CADENA, Tipo.BOOLEAN), Tipo.ERROR);
	this.tabla.put(new Tripleta("INCREMENTO", Tipo.ENTERO, Tipo.ENTERO), Tipo.ENTERO);
	this.tabla.put(new Tripleta("INCREMENTO", Tipo.ENTERO, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("INCREMENTO", Tipo.ENTERO, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("INCREMENTO", Tipo.REAL, Tipo.ENTERO), Tipo.REAL);
	this.tabla.put(new Tripleta("INCREMENTO", Tipo.CADENA, Tipo.ENTERO), Tipo.ERROR);
	this.tabla.put(new Tripleta("INCREMENTO", Tipo.REAL, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("INCREMENTO", Tipo.REAL, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("INCREMENTO", Tipo.CADENA, Tipo.REAL), Tipo.ERROR);
	this.tabla.put(new Tripleta("INCREMENTO", Tipo.CADENA, Tipo.CADENA), Tipo.ERROR);
	/* Operación AND */
	if(Tipo.BOOLEAN.equals("True") ){
	this.tabla.put(new Tripleta("AND", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("AND", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.ENTERO);
        this.tabla.put(new Tripleta("AND", Tipo.BOOLEAN, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("AND", Tipo.BOOLEAN, Tipo.CADENA), Tipo.CADENA);
	this.tabla.put(new Tripleta("AND", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.ENTERO);
        this.tabla.put(new Tripleta("AND", Tipo.REAL, Tipo.BOOLEAN), Tipo.REAL);
        this.tabla.put(new Tripleta("AND", Tipo.CADENA, Tipo.BOOLEAN), Tipo.REAL);
	} else if(Tipo.BOOLEAN.equals("False")) {
	    this.tabla.put(new Tripleta("AND", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.BOOLEAN);
	    this.tabla.put(new Tripleta("AND", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.BOOLEAN);
	    this.tabla.put(new Tripleta("AND", Tipo.BOOLEAN, Tipo.REAL), Tipo.BOOLEAN);
	    this.tabla.put(new Tripleta("AND", Tipo.BOOLEAN, Tipo.CADENA), Tipo.BOOLEAN);
	    this.tabla.put(new Tripleta("AND", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.BOOLEAN);
	    this.tabla.put(new Tripleta("AND", Tipo.REAL, Tipo.BOOLEAN), Tipo.BOOLEAN);
	    this.tabla.put(new Tripleta("AND", Tipo.CADENA, Tipo.BOOLEAN), Tipo.BOOLEAN);
	}
	/* Operación OR */
	if(Tipo.BOOLEAN.equals("False") ){
	this.tabla.put(new Tripleta("OR", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("OR", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.ENTERO);
        this.tabla.put(new Tripleta("OR", Tipo.BOOLEAN, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("OR", Tipo.BOOLEAN, Tipo.CADENA), Tipo.CADENA);
	this.tabla.put(new Tripleta("OR", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.ENTERO);
        this.tabla.put(new Tripleta("OR", Tipo.REAL, Tipo.BOOLEAN), Tipo.REAL);
        this.tabla.put(new Tripleta("OR", Tipo.CADENA, Tipo.BOOLEAN), Tipo.REAL);
	} else if(Tipo.BOOLEAN.equals("True")) {
	    this.tabla.put(new Tripleta("OR", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.BOOLEAN);
	    this.tabla.put(new Tripleta("OR", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.BOOLEAN);
	    this.tabla.put(new Tripleta("OR", Tipo.BOOLEAN, Tipo.REAL), Tipo.BOOLEAN);
	    this.tabla.put(new Tripleta("OR", Tipo.BOOLEAN, Tipo.CADENA), Tipo.BOOLEAN);
	    this.tabla.put(new Tripleta("OR", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.BOOLEAN);
	    this.tabla.put(new Tripleta("OR", Tipo.REAL, Tipo.BOOLEAN), Tipo.BOOLEAN);
	    this.tabla.put(new Tripleta("OR", Tipo.CADENA, Tipo.BOOLEAN), Tipo.BOOLEAN);
	}
	/* Operación NOT */
	this.tabla.put(new Tripleta("NOT",Tipo.BOOLEAN),Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("NOT",Tipo.ENTERO),Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("NOT",Tipo.REAL),Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("NOT",Tipo.CADENA),Tipo.BOOLEAN);
	/* Operación WHILE */
	this.tabla.put(new Tripleta("WHILE", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.VOID);
	this.tabla.put(new Tripleta("WHILE", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.VOID);
	this.tabla.put(new Tripleta("WHILE", Tipo.BOOLEAN, Tipo.REAL), Tipo.VOID);
	this.tabla.put(new Tripleta("WHILE", Tipo.BOOLEAN, Tipo.CADENA), Tipo.VOID);
	this.tabla.put(new Tripleta("WHILE", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.VOID);
	this.tabla.put(new Tripleta("WHILE", Tipo.ENTERO, Tipo.ENTERO), Tipo.VOID);
	this.tabla.put(new Tripleta("WHILE", Tipo.ENTERO, Tipo.REAL), Tipo.VOID);
	this.tabla.put(new Tripleta("WHILE", Tipo.ENTERO, Tipo.CADENA), Tipo.VOID);
	this.tabla.put(new Tripleta("WHILE", Tipo.REAL, Tipo.BOOLEAN), Tipo.VOID);
	this.tabla.put(new Tripleta("WHILE", Tipo.REAL, Tipo.ENTERO), Tipo.VOID);
	this.tabla.put(new Tripleta("WHILE", Tipo.REAL, Tipo.REAL), Tipo.VOID);
	this.tabla.put(new Tripleta("WHILE", Tipo.REAL, Tipo.CADENA), Tipo.VOID);
	this.tabla.put(new Tripleta("WHILE", Tipo.CADENA, Tipo.BOOLEAN), Tipo.VOID);
	this.tabla.put(new Tripleta("WHILE", Tipo.CADENA, Tipo.ENTERO), Tipo.VOID);
	this.tabla.put(new Tripleta("WHILE", Tipo.CADENA, Tipo.REAL), Tipo.VOID);
	this.tabla.put(new Tripleta("WHILE", Tipo.CADENA, Tipo.CADENA), Tipo.VOID);
	/* Operación IF */
	this.tabla.put(new Tripleta("IF", Tipo.BOOLEAN, Tipo.BOOLEAN), Tipo.VOID);
	this.tabla.put(new Tripleta("IF", Tipo.BOOLEAN, Tipo.ENTERO), Tipo.VOID);
	this.tabla.put(new Tripleta("IF", Tipo.BOOLEAN, Tipo.REAL), Tipo.VOID);
	this.tabla.put(new Tripleta("IF", Tipo.BOOLEAN, Tipo.CADENA), Tipo.VOID);
	this.tabla.put(new Tripleta("IF", Tipo.ENTERO, Tipo.BOOLEAN), Tipo.VOID);
	this.tabla.put(new Tripleta("IF", Tipo.ENTERO, Tipo.ENTERO), Tipo.VOID);
	this.tabla.put(new Tripleta("IF", Tipo.ENTERO, Tipo.REAL), Tipo.VOID);
	this.tabla.put(new Tripleta("IF", Tipo.ENTERO, Tipo.CADENA), Tipo.VOID);
	this.tabla.put(new Tripleta("IF", Tipo.REAL, Tipo.BOOLEAN), Tipo.VOID);
	this.tabla.put(new Tripleta("IF", Tipo.REAL, Tipo.ENTERO), Tipo.VOID);
	this.tabla.put(new Tripleta("IF", Tipo.REAL, Tipo.REAL), Tipo.VOID);
	this.tabla.put(new Tripleta("IF", Tipo.REAL, Tipo.CADENA), Tipo.VOID);
	this.tabla.put(new Tripleta("IF", Tipo.CADENA, Tipo.BOOLEAN), Tipo.VOID);
	this.tabla.put(new Tripleta("IF", Tipo.CADENA, Tipo.ENTERO), Tipo.VOID);
	this.tabla.put(new Tripleta("IF", Tipo.CADENA, Tipo.REAL), Tipo.VOID);
	this.tabla.put(new Tripleta("IF", Tipo.CADENA, Tipo.CADENA), Tipo.VOID);
	
	/* Operación ELSE */
	this.tabla.put(new Tripleta("ELSE",Tipo.BOOLEAN),Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("ELSE",Tipo.ENTERO),Tipo.ENTERO);
	this.tabla.put(new Tripleta("ELSE",Tipo.REAL),Tipo.REAL);
	this.tabla.put(new Tripleta("ELSE",Tipo.CADENA),Tipo.CADENA);
	/* Operación ELIF */
	/* Operación IN */
	/* Operación PRINT */
	this.tabla.put(new Tripleta("PRINT",Tipo.BOOLEAN),Tipo.BOOLEAN);
	this.tabla.put(new Tripleta("PRINT",Tipo.ENTERO),Tipo.ENTERO);
	this.tabla.put(new Tripleta("PRINT",Tipo.REAL),Tipo.REAL);
	this.tabla.put(new Tripleta("PRINT",Tipo.CADENA),Tipo.CADENA);
    }
    

    /* Busca el nombre en la tabla de tipos */
    public Tipo lookup(Tripleta t){
	return this.tabla.get(t);
    }
}
