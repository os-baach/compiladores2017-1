public class VisitantePrint implements Visitante {

    private TablaOp tabla = new TablaOp();
    private TablaS tablaS = new TablaS();
    
    @Override
    public void visita(Nodo n){
	if(n instanceof NodoMas){
	    visita((NodoMas)n);
	}
	if(n instanceof NodoMenos){
	    visita((NodoMenos)n);
	}
	if(n instanceof NodoPor){
	    visita((NodoPor)n);
	}
	if(n instanceof NodoPotencia){
	    visita((NodoPotencia)n);
	}
	if(n instanceof NodoDiv){
	    visita((NodoDiv)n);
	}
	if(n instanceof NodoDivEntera){
	    visita((NodoDivEntera)n);
	}
	if(n instanceof NodoModulo){
	    visita((NodoModulo)n);
	}
	if(n instanceof NodoEq){
	    visita((NodoEq)n);
	}
	if(n instanceof NodoMayor){
	    visita((NodoMayor)n);
	}
	if(n instanceof NodoMenor){
	    visita((NodoMenor)n);
	}
	if(n instanceof NodoMenorIgual){
	    visita((NodoMenorIgual)n);
	}
	if(n instanceof NodoMayorIgual){
	    visita((NodoMayorIgual)n);
	}
	if(n instanceof NodoIgualIgual){
	    visita((NodoIgualIgual)n);
	}
	if(n instanceof NodoDistinto){
	    visita((NodoDistinto)n);
	}
	if(n instanceof NodoDecremento){
	    visita((NodoDecremento)n);
	}
	if(n instanceof NodoIncremento){
	    visita((NodoIncremento)n);
	}
	if(n instanceof NodoAnd){
	    visita((NodoAnd)n);
	}
	if(n instanceof NodoOr){
	    visita((NodoOr)n);
	}
	if(n instanceof NodoNot){
	    visita((NodoNot)n);
	}
	if(n instanceof NodoWhile){
	    visita((NodoWhile)n);
	}
	if(n instanceof NodoIf){
	    visita((NodoIf)n);
	}	
	if(n instanceof NodoElse){
	    visita((NodoElse)n);
	}
	if(n instanceof NodoElif){
	    visita((NodoElif)n);
	}
	if(n instanceof NodoIn){
	    visita((NodoIn)n);
	}
	if(n instanceof NodoPrint){
	    visita((NodoPrint)n);
	}
	if(n instanceof HojaIdentifier){
	    visita((HojaIdentifier)n);
	}
	
	if(n instanceof HojaEntera){
	    visita((HojaEntera)n);
	}
	
	if(n instanceof HojaReal){
	    visita((HojaReal)n);
	}
	
	if(n instanceof HojaBoolean){
	    visita((HojaBoolean)n);
	}
	
	if(n instanceof HojaCadena){
	    visita((HojaCadena)n);
	}
    }

    @Override
    public void visita(NodoMas n){
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	visita(izq);
	visita(der);
	Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("MAS", t1, t2)));
	System.out.println("Nodo Mas:" + n.getTipo());
    }

    @Override
    public void visita(NodoMenos n){
        Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	visita(izq);
	visita(der);
	Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("MENOS", t1, t2)));
	System.out.println("Nodo Menos: " + n.getTipo());
    }

    @Override
    public void visita(NodoPor n){
        Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	visita(izq);
	visita(der);
	Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("POR", t1, t2)));
	System.out.println("Nodo Por: " + n.getTipo());	
    }

    @Override
    public void visita(NodoPotencia n){
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	visita(izq);
	visita(der);
	Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("POTENCIA", t1, t2)));
	System.out.println("Nodo Potencia:" + n.getTipo());
    }

    @Override
    public void visita(NodoDiv n){
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	visita(izq);
	visita(der);
	Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("DIV", t1, t2)));
	System.out.println("Nodo Div:" + n.getTipo());
	
    }

    @Override
    public void visita(NodoDivEntera n){
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	visita(izq);
	visita(der);
	Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("DIVENTERA", t1, t2)));
	System.out.println("Nodo DivEntera:" + n.getTipo());
    }

    @Override
    public void visita(NodoModulo n){
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	visita(izq);
	visita(der);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("MODULO",t1,t2)));
	System.out.println("Nodo Modulo:" + n.getTipo());
    }

    @Override
    public void visita(NodoEq n){
	Nodo izq = n.hijos.get(1);
	Nodo der = n.hijos.get(0);
	Tipo t1,t2; /* Tipos de los nodos a igualar */
	if(izq instanceof HojaIdentifier){    
	    visita(der);
	    t2 = der.getTipo();
	    tablaS.insert((String)izq.getValue(), t2);
	    t1 = t2;
	}else{
	    visita(izq);
	    visita(der);
	    t1 = izq.getTipo();
	    t2 = der.getTipo();
	}
	n.setTipo(tabla.lookup(new Tripleta("EQ",t1,t2)));
	System.out.println("Nodo Eq:" + n.getTipo());
    }

    @Override
    public void visita(NodoMayor n){
        Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	visita(izq);
	visita(der);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("MAYOR",t1,t2)));
	System.out.println("Nodo Mayor: " + n.getTipo());
    }

    @Override
    public void visita(NodoMenor n){
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	visita(izq);
	visita(der);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("MENOR",t1,t2)));
	System.out.println("Nodo Menor:" + n.getTipo());
    }

    @Override
    public void visita(NodoMenorIgual n){
        Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	visita(izq);
	visita(der);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("MENORIGUAL",t1,t2)));
	System.out.println("Nodo MenorIgual:" + n.getTipo());
    }

    @Override
    public void visita(NodoMayorIgual n){
        Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	visita(izq);
	visita(der);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("MAYORIGUAL",t1,t2)));
	System.out.println("Nodo MayorIgual:" + n.getTipo());
    }

    @Override
    public void visita(NodoIgualIgual n){
        Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	visita(izq);
	visita(der);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("IGUALIGUAL",t1,t2)));
	System.out.println("Nodo IgualIgual:" + n.getTipo());
    }

    @Override
    public void visita(NodoDistinto n){
        Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	visita(izq);
	visita(der);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("DISTINTO",t1,t2)));
	System.out.println("Nodo Distinto:" + n.getTipo());
    }

    @Override
    public void visita(NodoDecremento n){
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	visita(izq);
	visita(der);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("DECREMENTO",t1,t2)));
	System.out.println("Nodo Decremento:" + n.getTipo());
    }

    @Override
    public void visita(NodoIncremento n){
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	visita(izq);
	visita(der);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("INCREMENTO",t1,t2)));
	System.out.println("Nodo Incremento:" + n.getTipo());
    }

    @Override
    public void visita(NodoAnd n){
        Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	visita(izq);
	visita(der);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("AND",t1,t2)));
	System.out.println("Nodo And: " + n.getTipo());
    }

    @Override
    public void visita(NodoOr n){
        Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	visita(izq);
	visita(der);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("OR",t1,t2)));
	System.out.println("Nodo Or: " + n.getTipo());
    }

    @Override
    public void visita(NodoNot n){
        Nodo hijo = n.hijos.get(0);
	visita(hijo);
	Tipo t = hijo.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("NOT",t)));
	System.out.println("Nodo Not: " + n.getTipo());
    }

    @Override
    public void visita(NodoFor n){
	System.out.println("Nodo For");
	//este no importa, no está en la gramática
    }

    @Override
    public void visita(NodoWhile n){
	Nodo izq = n.hijos.get(1);
	Nodo der = n.hijos.get(0);
	visita(izq);
	visita(der);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("WHILE",t1,t2)));
	System.out.println("Nodo While: " + n.getTipo());
    }

    @Override
    public void visita(NodoIf n){ 
	if(n.hijos.size() == 2) {
	    Nodo fst = n.hijos.get(1);
	    Nodo snd = n.hijos.get(0);
	    visita(fst);
	    visita(snd);
	    Tipo t1 = fst.getTipo();
	    Tipo t2 = snd.getTipo();
	    n.setTipo(tabla.lookup(new Tripleta("IF",t1,t2)));
	    System.out.println("Nodo If: " + n.getTipo());
	} else if(n.hijos.size() == 3) {
	    Nodo fst = n.hijos.get(2);
	    Nodo snd = n.hijos.get(1);
	    Nodo thd = n.hijos.get(0);
	    visita(fst);
	    visita(snd);
	    visita(thd);
	    Tipo t1 = fst.getTipo();
	    Tipo t2 = snd.getTipo();
	    Tipo t3 = thd.getTipo();
	    n.setTipo(tabla.lookup(new Tripleta("IF",t1,t2,t3)));
	    System.out.println("Nodo If: " + n.getTipo());
	} else if(n.hijos.size() == 4) {
	    Nodo fst = n.hijos.get(3);
	    Nodo snd = n.hijos.get(2);
	    Nodo thd = n.hijos.get(1);
	    Nodo fhd = n.hijos.get(0);
	    visita(fst);
	    visita(snd);
	    visita(thd);
	    visita(fhd);
	    Tipo t1 = fst.getTipo();
	    Tipo t2 = snd.getTipo();
	    Tipo t3 = thd.getTipo();
	    Tipo t4 = fhd.getTipo();
	    n.setTipo(tabla.lookup(new Tripleta("IF",t1,t2,t3,t4)));
	    System.out.println("Nodo If: " + n.getTipo());
	}
    }

    @Override
    public void visita(NodoElse n){
        Nodo hijo = n.hijos.get(0);
	visita(hijo);
	Tipo t = hijo.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("ELSE",t)));
	System.out.println("Nodo Else: " + n.getTipo());
    }

    @Override
    public void visita(NodoElif n){
	if(n.hijos.size() == 2) {
	    Nodo fst = n.hijos.get(1);
	    Nodo snd = n.hijos.get(0);
	    visita(fst);
	    visita(snd);
	    Tipo t1 = fst.getTipo();
	    Tipo t2 = snd.getTipo();
	    n.setTipo(tabla.lookup(new Tripleta("ELIF",t1,t2)));
	    System.out.println("Nodo Elif: " + n.getTipo());
	} else if(n.hijos.size() == 3) {
	    Nodo fst = n.hijos.get(2);
	    Nodo snd = n.hijos.get(1);
	    Nodo thd = n.hijos.get(0);
	    visita(fst);
	    visita(snd);
	    visita(thd);
	    Tipo t1 = fst.getTipo();
	    Tipo t2 = snd.getTipo();
	    Tipo t3 = thd.getTipo();
	    n.setTipo(tabla.lookup(new Tripleta("IF",t1,t2,t3)));
	    System.out.println("Nodo Elif: " + n.getTipo());
	}
    }

    @Override
    public void visita(NodoIn n){
	Nodo izq = n.hijos.get(1);
	Nodo der = n.hijos.get(0);
	visita(izq);
	visita(der);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("IN",t1,t2)));
	System.out.println("Nodo In: " + n.getTipo());
    }

    @Override
    public void visita(NodoPrint n){
	Nodo hijo = n.hijos.get(0);
	visita(hijo);
	Tipo t = hijo.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("PRINT",t)));
	System.out.println("Nodo Print: " + n.getTipo());
    }
    
    @Override
    public void visita(HojaIdentifier h){
	Tipo t = tablaS.lookup((String)h.value);
	if(t == null){
	    System.err.println("Variable no inicializada");
	    System.exit(-1);
	}else{
	    h.setTipo(t);
	    System.out.println("Hoja Identificador: " +  h.value + " " + h.getTipo());
	}
    }

    @Override
    public void visita(HojaEntera h){
	System.out.println("Hoja Entera: " + h.value + " " + h.getTipo());
    }

    @Override
    public void visita(HojaReal h){
	System.out.println("Hoja Real: " + h.value + " " + h.getTipo());
    }

    @Override
    public void visita(HojaBoolean h){
	System.out.println("Hoja Boolean: " + h.value + " " + h.getTipo());
    }

    @Override
    public void visita(HojaCadena h){
	System.out.println("Hoja Cadena: " + h.value + " " + h.getTipo());
    }

}
