public abstract class VisitantePrint implements Visitante {
    
    @Override
    public void visita(Nodo n){
	System.out.print("Nodo Genérico");
    }

    @Override
    public void visita(NodoMas n){
	System.out.print("Nodo Mas");
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	String valor = (String)n.value;
	if(izq.value instanceof Boolean && der.value instanceof Boolean)
	    n.setValue(Boolean.parseBoolean(valor));	
	if(izq.value instanceof Integer && der.value instanceof Integer)
	    n.setValue(Integer.parseInt(valor));
	if(izq.value instanceof Double && der.value instanceof Double)
	    n.setValue(Double.parseDouble(valor));
	if(izq.value instanceof String && der.value instanceof String) {
	    n.setValue(valor);
	} else {
	    System.out.print("Error de tipos: no son cadenas");
	}
    }

    @Override
    public void visita(NodoMenos n){
	System.out.print("Nodo Menos");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoPor n){
	System.out.print("Nodo Por");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoPotencia n){
	System.out.print("Nodo Potencia");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoDiv n){
	System.out.print("Nodo Div");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoDivEntera n){
	System.out.print("Nodo DivEntera");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoModulo n){
	System.out.print("Nodo Modulo");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoEq n){
	System.out.print("Nodo Eq");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoMayor n){
	System.out.print("Nodo Mayor");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoMenor n){
	System.out.print("Nodo Menor");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoMenorIgual n){
	System.out.print("Nodo MenorIgual");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoMayorIgual n){
	System.out.print("Nodo MayorIgual");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoIgualIgual n){
	System.out.print("Nodo IgualIgual");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoDistinto n){
	System.out.print("Nodo Distinto");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoDecremento n){
	System.out.print("Nodo Decremento");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoIncremento n){
	System.out.print("Nodo Incremento");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoAnd n){
	System.out.print("Nodo And");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoOr n){
	System.out.print("Nodo Or");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoNot n){
	System.out.print("Nodo Not");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoFor n){
	System.out.print("Nodo For");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoWhile n){
	System.out.print("Nodo While");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoIf n){
	System.out.print("Nodo If");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoElse n){
	System.out.print("Nodo Else");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoElif n){
	System.out.print("Nodo Elif");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoIn n){
	System.out.print("Nodo In");
	//falta lo de los hijos
    }

    @Override
    public void visita(NodoPrint n){
	System.out.print("Nodo Print");
	//falta lo de los hijos
    }
    
    @Override
    public void visita(HojaIdentifier h){
	System.out.print("Hoja Identifier");
	System.out.print("Identificador: " +  h.value);
    }

    @Override
    public void visita(HojaEntera h){
	System.out.print("Hoja Entera");
	System.out.print("Entera: " + h.value);
    }

    @Override
    public void visita(HojaReal h){
	System.out.print("Hoja Real");
	System.out.print("Real: " + h.value);
    }

    @Override
    public void visita(HojaBoolean h){
	System.out.print("Hoja Boolean");
	System.out.print("Boolean: " + h.value);
    }

    @Override
    public void visita(HojaCadena h){
	System.out.print("Hoja Cadena");
	System.out.print("Cadena: " + h.value);
    }

}
