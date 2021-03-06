import java.util.List;
import java.util.LinkedList;

/* Clase principal de Nodos(Componente(?)) */
public class Nodo{
    Object value; /* Valor dentro del nodo */
    List<Nodo> hijos; /* Hijos del nodo */
    Nodo padre; /* El papá */
    Tipo tipo; /* Tipo del Nodo */
    
    public void acepta(Visitante v){
	v.visita(this);
    }
    
    /* Inicializa la lista de hijos del nodo */
    public Nodo(){
	this.hijos = new LinkedList<Nodo>();
    }

    /* Regresa el Tipo del Nodo */
    public Tipo getTipo(){
	return this.tipo;
    }

    /* Establece el Tipo del Nodo */
    public void setTipo(Tipo tipo){
	this.tipo = tipo;
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

    /* Nos dice si el nodo tiene hijo izquierdo */
    public boolean hayIzquierdo(){
	return this.hijos.size() >= 1;
    }

    /* Nos dice si el nodo tiene hijo derecho */
    public boolean hayDerecho(){
	return this.hijos.size() >= 2;
    }
    
    /* Mete un hijo izquierdo en la lista */
    public void meteHijoIzq(Nodo izq){
	if(!hayIzquierdo()){
	    this.hijos.add(0, izq);
	    izq.padre = this;
	}
	else
	    this.hijos.get(0).meteHijoIzq(izq);
    }
    
    /* Le pone al nodo un nuevo hijo a la derecha */
    public void meteHijoDer(Nodo der){
	if(!hayDerecho()){
	    this.hijos.add(der);
	    der.padre = this;
	}
	else
	    this.hijos.get(1).meteHijoDer(der);
    }

    public void meteInicio(Nodo nodo){
	this.hijos.add(0,nodo);
    }

    public void meteHijo(Nodo nodo){
	this.hijos.add(nodo);
	nodo.padre = this;
    }

    /* Regresa a El papá */
    public Nodo getPadre(){
	return this.padre;
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
    public String imprimeSubarbol(){
	String regreso = this.toString(); // Cadena a regresar
	for(int counter = this.hijos.size()-1; counter >= 0; counter--){
	    Nodo der = this.hijos.get(counter);
	    regreso += "(" + der.imprimeSubarbol() + ") ";
	}
	return regreso;
    }
}

/* Clase NodoMas */
class NodoMas extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa '+' */
    @Override
    public String toString(){
	return "+";
    }
}

/* Clase NodoMenos */
class NodoMenos extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa '-' */
    @Override
    public String toString(){
	return "-";
    }
}

/* Clase NodoPor */
class NodoPor extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa '*' */
    @Override
    public String toString(){
	return "*";
    }
}

/* Clase NodoPotencia */
class NodoPotencia extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa '**' */
    @Override
    public String toString(){
	return "**";
    }
}

/* Clase NodoDiv */
class NodoDiv extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa '/' */
    @Override
    public String toString(){
	return "/";
    }
}

/* Clase NodoDivEntera */
class NodoDivEntera extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa '//' */
    @Override
    public String toString(){
	return "//";
    }
}

/* Clase NodoModulo */
class NodoModulo extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa '%' */
    @Override
    public String toString(){
	return "%";
    }
}

/* Clase NodoEq */
class NodoEq extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa '=' */
    @Override
    public String toString(){
	return "=";
    }
}

/* Clase NodoMayor */
class NodoMayor extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa '>' */
    @Override
    public String toString(){
	return ">";
    }
}

/* Clase NodoMenor */
class NodoMenor extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa '<' */
    @Override
    public String toString(){
	return "<";
    }
}

/* Clase NodoMenorIgual */
class NodoMenorIgual extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa '<=' */
    @Override
    public String toString(){
	return "<=";
    }
}

/* Clase NodoMayorIgual */
class NodoMayorIgual extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa '>=' */
    @Override
    public String toString(){
	return ">=";
    }
}

/* Clase NodoIgualIgual */
class NodoIgualIgual extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa '==' */
    @Override
    public String toString(){
	return "==";
    }
}

/* Clase NodoDistinto */
class NodoDistinto extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa '!=' */
    @Override
    public String toString(){
	return "!=";
    }
}

/* Clase NodoDecremento */
class NodoDecremento extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa '-=' */
    @Override
    public String toString(){
	return "-=";
    }
}

/* Clase NodoDecremento */
class NodoIncremento extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa '+=' */
    @Override
    public String toString(){
	return "+=";
    }
}

/* Clase NodoAnd*/
class NodoAnd extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa 'and' */
    @Override
    public String toString(){
	return "and";
    }
}

/* Clase NodoOr*/
class NodoOr extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa 'or' */
    @Override
    public String toString(){
	return "or";
    }
}

/* Clase NodoNot*/
class NodoNot extends Nodo{
    
    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa 'not' */
    @Override
    public String toString(){
	return "not";
    }
}

/* Clase NodoFor*/
class NodoFor extends Nodo{
    
    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa 'for' */
    @Override
    public String toString(){
	return "for";
    }
}

/* Clase NodoWhile*/
class NodoWhile extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa 'while' */
    @Override
    public String toString(){
	return "while";
    }
}

/* Clase NodoIf*/
class NodoIf extends Nodo{
    
    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa 'if' */
    @Override
    public String toString(){
	return "if";
    }
}

/* Clase NodoElse*/
class NodoElse extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa 'else' */
    @Override
    public String toString(){
	return "else";
    }
}

/* Clase NodoElif*/
class NodoElif extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa 'elif' */
    @Override
    public String toString(){
	return "elif";
    }
}

/* Clase NodoIn*/
class NodoIn extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

    /* Regresa 'in' */
    @Override
    public String toString(){
	return "in";
    }
}

/* Clase NodoPrint. No sé si esta es necesaria. */
class NodoPrint extends Nodo{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }

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

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }
    
    /* Construye una hoja de identificador */
    HojaIdentifier(String id){
	super();
	value = id;
	this.tipo = Tipo.CADENA;
    }
}

/* Hoja con elemento entero */
class HojaEntera extends Hoja
{
    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }
    
    /* Construye una hoja entera con valor v */
    HojaEntera(Integer v){
	super();
	value = v;
	this.tipo = Tipo.ENTERO;
    }
}
/* Hoja con elemento real */
class HojaReal extends Hoja
{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }
    
    /* Construye una hoja entera con valor v */
    HojaReal(Double v){
	super();
       	value = v;
	this.tipo = Tipo.REAL;
    }
}

/* Hoja con elemento boolean */
class HojaBoolean extends Hoja
{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }
    
    /* Construye una hoja boolean con valor v */
    HojaBoolean(Boolean v){
	super();
	value = v;
	this.tipo = Tipo.BOOLEAN;
    }
}

/* Hoja con elemento cadena */
class HojaCadena extends Hoja
{

    @Override
    public void acepta(Visitante v){
	v.visita(this);
    }
    
    /* Construye una hoja entera con valor v */
    HojaCadena(String v){
	super();
	value = v;
	this.tipo = Tipo.CADENA;
    }
}


