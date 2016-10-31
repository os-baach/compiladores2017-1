/* Clase principal de Nodos(Componente(?)) */
public class Nodo{
    int value; /* Valor dentro del nodo, aunque no entiendo por qué es int */
    Nodo izq; /* Hijo izquierdo */
    Nodo der; /* Hijo derecho */
    
    /* Regresa el valor del nodo */
    public int getValue(){
	return value;
    }

    /* Establece para el nodo un nuevo valor (sólo para hojas) */
    public void setValue(int val){
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

/* Clase Hoja. Vacía por ahora. */
class Hoja extends Nodo{
}

/* Hoja con elemento entero */
class HojaEntera extends Hoja
{
    /* Construye una hoja entera con valor v */
    HojaEntera(int v){
	value=v;
    }

    /* Regresa el valor de la hoja entera... No era necesario 
       sobrescribirlo(?) */
    public int getValue(){
	return this.value;
    }    
}


