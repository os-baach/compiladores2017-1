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
	this.tabla.put(new Tripleta("MAS", Tipo.ENTERO, Tipo.ENTERO), Tipo.ERROR);
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
	this.tabla.put(new Tripleta("MENOS", Tipo.ENTERO, Tipo.ENTERO), Tipo.ERROR);
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
	this.tabla.put(new Tripleta("POR", Tipo.ENTERO, Tipo.ENTERO), Tipo.ERROR);
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
	this.tabla.put(new Tripleta("POTENCIA", Tipo.ENTERO, Tipo.ENTERO), Tipo.ERROR);
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
	this.tabla.put(new Tripleta("DIV", Tipo.ENTERO, Tipo.ENTERO), Tipo.ERROR);
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
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.ENTERO, Tipo.ENTERO), Tipo.ERROR);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.ENTERO, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.ENTERO, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.REAL, Tipo.ENTERO), Tipo.REAL);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.CADENA, Tipo.ENTERO), Tipo.ERROR);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.REAL, Tipo.REAL), Tipo.REAL);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.REAL, Tipo.CADENA), Tipo.ERROR);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.CADENA, Tipo.REAL), Tipo.ERROR);
	this.tabla.put(new Tripleta("DIVENTERA", Tipo.CADENA, Tipo.CADENA), Tipo.ERROR);
	
    }
    

    /* Busca el nombre en la tabla de tipos */
    public Tipo lookup(Tripleta t){
	return this.tabla.get(t);
    }
}
