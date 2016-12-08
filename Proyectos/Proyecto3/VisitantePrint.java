public class VisitantePrint implements Visitante {

    private TablaOp tabla = new TablaOp();

    @Override
    public void visita(Nodo n){
	System.out.print("Nodo Genérico");
    }

    @Override
    public void visita(NodoMas n){
	System.out.println("Nodo Mas");
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("MAS", t1, t2)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoMenos n){
	System.out.println("Nodo Menos");
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("MENOS", t1, t2)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoPor n){
	System.out.println("Nodo Por");
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("POR", t1, t2)));
	System.out.println(n.getTipo());    
    }

    @Override
    public void visita(NodoPotencia n){
	System.out.println("Nodo Potencia");
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("POTENCIA", t1, t2)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoDiv n){
	System.out.println("Nodo Div");
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("DIV", t1, t2)));
	System.out.println(n.getTipo());
	
    }

    @Override
    public void visita(NodoDivEntera n){
	System.out.print("Nodo DivEntera");
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("DIVENTERA", t1, t2)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoModulo n){
	System.out.print("Nodo Modulo");
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	String valor = (String)n.value;
	if(izq.value instanceof Boolean){
	    if(der.value instanceof Boolean) 
		n.setValue(Integer.parseInt(valor));
	    if(der.value instanceof Integer)
		n.setValue(Integer.parseInt(valor));
	    if(der.value instanceof Double)
		n.setValue(Integer.parseInt(valor));
	} else {
	    if(der.value instanceof String)
		System.out.print("Error de tipos: modulo incorrecto");
	}
	if(izq.value instanceof Integer){
	    if(der.value instanceof Boolean) 
		n.setValue(Integer.parseInt(valor));
	    if(der.value instanceof Integer)
		n.setValue(Integer.parseInt(valor));
	    if(der.value instanceof Double)
		n.setValue(Integer.parseInt(valor));
	} else {
	    if(der.value instanceof String)
		System.out.print("Error de tipos: modulo incorrecto");
	}
	if(izq.value instanceof Double){
	    if(der.value instanceof Boolean) 
		n.setValue(Integer.parseInt(valor));
	    if(der.value instanceof Integer)
		n.setValue(Integer.parseInt(valor));
	    if(der.value instanceof Double)
		n.setValue(Integer.parseInt(valor));
	} else {
	    if(der.value instanceof String)
		System.out.print("Error de tipos: modulo incorrecto");
	}
	if(izq.value instanceof String && der.value instanceof String) {
	    n.setValue(valor);
	} else {
	    System.out.print("Error de tipos: modulo incorrecto");
	}
    }

    @Override
    public void visita(NodoEq n){
	System.out.print("Nodo Eq");
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	String valor = (String)n.value;
        if(izq.value instanceof String){
	    if(der.value instanceof String)
		n.setValue(valor);
	    if(der.value instanceof Integer)
		n.setValue(Integer.parseInt(valor));
	    if(der.value instanceof Double)
		n.setValue(Double.parseDouble(valor));
	    if(der.value instanceof Boolean)
		n.setValue(Boolean.parseBoolean(valor));
	} else {
	    System.out.print("Error de tipos: Asignación incorrecta");
	}
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
	System.out.println("Hoja Identificador: " +  h.value);
    }

    @Override
    public void visita(HojaEntera h){
	System.out.println("Hoja Entera: " + h.value);
    }

    @Override
    public void visita(HojaReal h){
	System.out.println("Hoja Real: " + h.value);
    }

    @Override
    public void visita(HojaBoolean h){
	System.out.println("Hoja Boolean: " + h.value);
    }

    @Override
    public void visita(HojaCadena h){
	System.out.println("Hoja Cadena: " + h.value);
    }

}
