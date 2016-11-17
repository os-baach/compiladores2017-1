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
   /* Regresa '+' */
    @Override
    public String toString(){
	return "+";
    }
}

/* Clase NodoMenos */
class NodoMenos extends Nodo{
    /* Regresa '-' */
    @Override
    public String toString(){
	return "-";
    }
}

/* Clase NodoPor */
class NodoPor extends Nodo{
    /* Regresa '*' */
    @Override
    public String toString(){
	return "*";
    }
}

/* Clase NodoPotencia */
class NodoPotencia extends Nodo{
    /* Regresa '**' */
    @Override
    public String toString(){
	return "**";
    }
}

/* Clase NodoDiv */
class NodoDiv extends Nodo{
    /* Regresa '/' */
    @Override
    public String toString(){
	return "/";
    }
}

/* Clase NodoDivEntera */
class NodoDivEntera extends Nodo{
    /* Regresa '//' */
    @Override
    public String toString(){
	return "//";
    }
}

/* Clase NodoModulo */
class NodoModulo extends Nodo{
    /* Regresa '%' */
    @Override
    public String toString(){
	return "%";
    }
}

/* Clase NodoEq */
class NodoEq extends Nodo{
    /* Regresa '=' */
    @Override
    public String toString(){
	return "=";
    }
}

/* Clase NodoMayor */
class NodoMayor extends Nodo{
    /* Regresa '>' */
    @Override
    public String toString(){
	return ">";
    }
}

/* Clase NodoMenor */
class NodoMenor extends Nodo{
    /* Regresa '<' */
    @Override
    public String toString(){
	return "<";
    }
}

/* Clase NodoMenorIgual */
class NodoMenorIgual extends Nodo{
    /* Regresa '<=' */
    @Override
    public String toString(){
	return "<=";
    }
}

/* Clase NodoMayorIgual */
class NodoMayorIgual extends Nodo{
    /* Regresa '>=' */
    @Override
    public String toString(){
	return ">=";
    }
}

/* Clase NodoIgualIgual */
class NodoIgualIgual extends Nodo{
    /* Regresa '==' */
    @Override
    public String toString(){
	return "==";
    }
}

/* Clase NodoDistinto */
class NodoDistinto extends Nodo{
    /* Regresa '!=' */
    @Override
    public String toString(){
	return "!=";
    }
}

/* Clase NodoDecremento */
class NodoDecremento extends Nodo{
    /* Regresa '-=' */
    @Override
    public String toString(){
	return "-=";
    }
}

/* Clase NodoDecremento */
class NodoIncremento extends Nodo{
    /* Regresa '+=' */
    @Override
    public String toString(){
	return "+=";
    }
}

/* Clase NodoAnd*/
class NodoAnd extends Nodo{
    /* Regresa 'and' */
    @Override
    public String toString(){
	return "and";
    }
}

/* Clase NodoOr*/
class NodoOr extends Nodo{
    /* Regresa 'or' */
    @Override
    public String toString(){
	return "or";
    }
}

/* Clase NodoNot*/
class NodoNot extends Nodo{
    /* Regresa 'not' */
    @Override
    public String toString(){
	return "not";
    }
}

/* Clase NodoFor*/
class NodoFor extends Nodo{
    /* Regresa 'for' */
    @Override
    public String toString(){
	return "for";
    }
}

/* Clase NodoWhile*/
class NodoWhile extends Nodo{
    /* Regresa 'while' */
    @Override
    public String toString(){
	return "while";
    }
}

/* Clase NodoIf*/
class NodoIf extends Nodo{
    /* Regresa 'if' */
    @Override
    public String toString(){
	return "if";
    }
}

/* Clase NodoElse*/
class NodoElse extends Nodo{
    /* Regresa 'else' */
    @Override
    public String toString(){
	return "else";
    }
}

/* Clase NodoElif*/
class NodoElif extends Nodo{
    /* Regresa 'elif' */
    @Override
    public String toString(){
	return "elif";
    }
}

/* Clase NodoIn*/
class NodoIn extends Nodo{
    /* Regresa 'in' */
    @Override
    public String toString(){
	return "in";
    }
}

/* Clase NodoPrint. No sé si esta es necesaria. */
class NodoPrint extends Nodo{
    /* Regresa 'print' */
    @Override
    public String toString(){
	return "print";
    }
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


