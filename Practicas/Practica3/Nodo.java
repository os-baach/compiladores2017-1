import java.util.List;
import java.util.LinkedList;

/* Clase principal de Nodos(Componente(?)) */
public class Nodo{
    Object value; /* Valor dentro del nodo */
    List<Nodo> hijos; /* Hijos del nodo */

    /* Inicializa la lista de hijos del nodo */
    public Nodo(){
	this.hijos = new LinkedList<Nodo>();
    }

    /* Regresa el valor del nodo */
    @Override
    public String toString(){
	return value.toString();
    }
    
    /* Regresa el valor del nodo */
    public Object getValue(){
	return value;
    }

    /* Regresa la lista de hijos del nodo */
    public List<Nodo> getHijos(){
	return this.hijos;
    }

    /* Le pone al nodo un nuevo hijo */
    public void nuevoHijo(Nodo n){
	this.hijos.add(n);
    }
    
    /* Establece para el nodo un nuevo valor (sólo para hojas) */
    public void setValue(Object val){
	this.value = val;
    }
    
    /* Imprime el subárbol con este nodo como su raíz 
     * indent - Valor de indentación para que el árbol se vea bien
     * ultimo - Nos dice si el nodo es el último del subárbol (se imprime 
       distinto)
     */
    public void imprimeSubarbol(String indent, boolean ultimo){
	System.out.print(indent);
	if(ultimo){
	    System.out.print("\\-");
	    indent += "  ";
	}else{
	    System.out.print("|-");
	    indent += "|  ";
	}
	System.out.println(this);
	int longitud = this.hijos.size(); //Número de hijos
	for (int i = 0; i < longitud; i++)
	    hijos.get(i).imprimeSubarbol(indent, i == longitud - 1);
    }
}

/* Clase NodoMas */
class NodoMas extends Nodo{
    
}

/* Clase NodoMenos */
class NodoMenos extends Nodo{
    
}

/* Clase NodoPor */
class NodoPor extends Nodo{
    
}

/* Clase NodoPotencia */
class NodoPotencia extends Nodo{
    
}

/* Clase NodoDiv */
class NodoDiv extends Nodo{
    
}

/* Clase NodoDivEntera */
class NodoDivEntera extends Nodo{
    
}

/* Clase NodoModulo */
class NodoModulo extends Nodo{
    
}

/* Clase NodoEq */
class NodoEq extends Nodo{
    
}

/* Clase NodoMayor */
class NodoMayor extends Nodo{
    
}

/* Clase NodoMenor */
class NodoMenor extends Nodo{
    
}

/* Clase NodoMenorIgual */
class NodoMenorIgual extends Nodo{
    
}

/* Clase NodoMayorIgual */
class NodoMayorIgual extends Nodo{
    
}

/* Clase NodoIgualIgual */
class NodoIgualIgual extends Nodo{
    
}

/* Clase NodoDistinto */
class NodoDistinto extends Nodo{
    
}

/* Clase NodoDecremento */
class NodoDecremento extends Nodo{
    
}

/* Clase NodoDecremento */
class NodoIncremento extends Nodo{
    
}

/* Clase NodoAnd*/
class NodoAnd extends Nodo{
    
}

/* Clase NodoOr*/
class NodoOr extends Nodo{
    
}

/* Clase NodoNot*/
class NodoNot extends Nodo{
    
}

/* Clase NodoFor*/
class NodoFor extends Nodo{
    
}

/* Clase NodoWhile*/
class NodoWhile extends Nodo{
    
}

/* Clase NodoIf*/
class NodoIf extends Nodo{
    
}

/* Clase NodoElse*/
class NodoElse extends Nodo{
    
}

/* Clase NodoElif*/
class NodoElif extends Nodo{
    
}

/* Clase NodoIn*/
class NodoIn extends Nodo{
    
}

/* Clase NodoDosPuntos*/
class NodoDosPuntos extends Nodo{
    
}

/* Clase NodoDosPuntos*/
class NodoPuntoYComa extends Nodo{
    
}

/* Clase NodoPrint. No sé si esta es necesaria. */
class NodoPrint extends Nodo{
    
}

/* Clase Hoja. Vacía por ahora. */
class Hoja extends Nodo{

}

/* Hoja con identificador como elemento */
class HojaIdentifier extends Hoja{

    /* Construye una hoja de identificador */
    HojaIdentifier(String id){
	super();
	value = id;
    }
	
}

/* Hoja con elemento entero */
class HojaEntera extends Hoja
{
    /* Construye una hoja entera con valor v */
    HojaEntera(Integer v){
	super();
	value = v;
    }
}
/* Hoja con elemento real */
class HojaReal extends Hoja
{
    /* Construye una hoja entera con valor v */
    HojaReal(Double v){
	super();
       	value = v;
    }
}

/* Hoja con elemento boolean */
class HojaBoolean extends Hoja
{
    /* Construye una hoja boolean con valor v */
    HojaBoolean(Boolean v){
	super();
	value = v;
    }
}

/* Hoja con elemento cadena */
class HojaCadena extends Hoja
{
    /* Construye una hoja entera con valor v */
    HojaCadena(String v){
	super();
	value = v;
    }
}


