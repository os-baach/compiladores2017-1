/* Clase principal de Nodos(Componente(?)) */
public class Nodo{
    int value; /* Valor dentro del nodo, aunque no entiendo por qué es int */
    
    /* Regresa el valor del nodo */
    public int getValue(){
	return value;
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


