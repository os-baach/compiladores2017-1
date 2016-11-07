/* Clase principal de Nodos(Componente(?)) */
public class Nodo{
    Object value; /* Valor dentro del nodo */
    Nodo izq; /* Hijo izquierdo */
    Nodo der; /* Hijo derecho */
    
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
/* Hoja con elemento cadena */
class HojaCadena extends Hoja
{
    /* Construye una hoja entera con valor v */
    HojaCadena(String v){
	value = v;
    }
}
