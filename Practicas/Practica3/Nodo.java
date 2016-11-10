/* Clase principal de Nodos(Componente(?)) */
public class Nodo{
    Object value; /* Valor dentro del nodo */
    Nodo izq; /* Hijo izquierdo */
    Nodo der; /* Hijo derecho */

    /* Regresa el valor del nodo */
    @Override
    public String toString(){
	return value.toString();
    }
    
    /* Regresa el valor del nodo */
    public Object getValue(){
	return value;
    }

    /* Establece para el nodo un nuevo valor (sólo para hojas) */
    public void setValue(Object val){
	this.value = val;
    }

    /* Regresa al hijo derecho del Nodo */
    public Nodo getHijoIzq(){
	return this.izq;
    }

    /* Regresa al hijo derecho del Nodo */
    public Nodo getHijoDer(){
	return this.der;
    }

    /* Establece un nuevo hijo izquierdo para el Nodo */
    public void setHijoIzq(Nodo i){
	this.izq = i;
    }

    /* Establece un nuevo hijo derecho para el Nodo */
    public void setHijoDer(Nodo d){
	this.der = d;
    }

    /* Nos dice si hay hijo izquierdo */
    public boolean hayIzquierdo(){
	return this.izq != null;
    }

    /* Nos dice si hay hijo derecho */
    public boolean hayDerecho(){
	return this.der != null;
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
        if(hayIzquierdo())
	    if(hayDerecho())
		this.izq.imprimeSubarbol(indent, false);
	    else
		this.izq.imprimeSubarbol(indent, true);
	if(hayDerecho())
	    this.der.imprimeSubarbol(indent, true);
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
	value = id;
    }
	
}

/* Hoja con elemento entero */
class HojaEntera extends Hoja
{
    /* Construye una hoja entera con valor v */
    HojaEntera(Integer v){
	value = v;
    }
}
/* Hoja con elemento real */
class HojaReal extends Hoja
{
    /* Construye una hoja entera con valor v */
    HojaReal(Double v){
	value = v;
    }
}

/* Hoja con elemento boolean */
class HojaBoolean extends Hoja
{
    /* Construye una hoja boolean con valor v */
    HojaBoolean(Boolean v){
	value = v;
    }
}

/* Hoja con elemento cadena */
class HojaCadena extends Hoja
{
    /* Construye una hoja entera con valor v */
    HojaCadena(String v){
	value = v;
    }
}


