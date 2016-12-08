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
	System.out.println("Que pedo Dx");
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
	System.out.println("Nodo DivEntera");
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
	Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("DIVENTERA", t1, t2)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoModulo n){
	System.out.println("Nodo Modulo");
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("MODULO",t1,t2)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoEq n){
	System.out.println("Nodo Eq");
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("EQ",t1,t2)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoMayor n){
	System.out.println("Nodo Mayor");
        Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("MAYOR",t1,t2)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoMenor n){
	System.out.println("Nodo Menor");
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("MENOR",t1,t2)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoMenorIgual n){
	System.out.println("Nodo MenorIgual");
        Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("MENORIGUAL",t1,t2)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoMayorIgual n){
	System.out.println("Nodo MayorIgual");
        Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("MAYORIGUAL",t1,t2)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoIgualIgual n){
	System.out.println("Nodo IgualIgual");
        Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("IGUALIGUAL",t1,t2)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoDistinto n){
	System.out.println("Nodo Distinto");
        Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("DISTINTO",t1,t2)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoDecremento n){
	System.out.println("Nodo Decremento");
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("DECREMENTO",t1,t2)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoIncremento n){
	System.out.println("Nodo Incremento");
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("INCREMENTO",t1,t2)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoAnd n){
	System.out.println("Nodo And");
        Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("AND",t1,t2)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoOr n){
	System.out.println("Nodo Or");
        Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("OR",t1,t2)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoNot n){
	System.out.println("Nodo Not");
        Nodo hijo = n.hijos.get(0);
	Tipo t = hijo.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("NOT",t)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoFor n){
	System.out.println("Nodo For");
	//este no importa, no está en la gramática
    }

    @Override
    public void visita(NodoWhile n){
	System.out.println("Nodo While");
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("WHILE",t1,t2)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoIf n){
	System.out.println("Nodo If"); 
	    Nodo fst = n.hijos.get(0);
	    Nodo snd = n.hijos.get(1);
	    Nodo thd = n.hijos.get(2);
	    Nodo fhd = n.hijos.get(3);
	    Tipo t1 = fst.getTipo();
	    Tipo t2 = snd.getTipo();
	    Tipo t3 = thd.getTipo();
	    Tipo t4 = fhd.getTipo();
	    if(n.hijos.size() == 2) {
	    n.setTipo(tabla.lookup(new Tripleta("IF",t1,t2)));
	    System.out.println(n.getTipo());
	    } else if(n.hijos.size() == 3) {
		n.setTipo(tabla.lookup(new Tripleta("IF",t1,t2,t3)));
		System.out.println(n.getTipo());
	    } else if(n.hijos.size() == 4) {
		n.setTipo(tabla.lookup(new Tripleta("IF",t1,t2,t3,t4)));
		System.out.println(n.getTipo());
	    }
    }

    @Override
    public void visita(NodoElse n){
	System.out.println("Nodo Else");
        Nodo hijo = n.hijos.get(0);
	Tipo t = hijo.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("ELSE",t)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoElif n){
	System.out.println("Nodo Elif");
	Nodo fst = n.hijos.get(0);
	Nodo snd = n.hijos.get(1);
	Nodo thd = n.hijos.get(2);
	Tipo t1 = fst.getTipo();
	Tipo t2 = snd.getTipo();
	Tipo t3 = thd.getTipo();
	if(n.hijos.size() == 2) {
	    n.setTipo(tabla.lookup(new Tripleta("ELIF",t1,t2)));
	    System.out.println(n.getTipo());
	} else if(n.hijos.size() == 3) {
	    n.setTipo(tabla.lookup(new Tripleta("IF",t1,t2,t3)));
	    System.out.println(n.getTipo());
	}
    }

    @Override
    public void visita(NodoIn n){
	System.out.println("Nodo In");
	Nodo izq = n.hijos.get(0);
	Nodo der = n.hijos.get(1);
        Tipo t1 = izq.getTipo();
	Tipo t2 = der.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("IN",t1,t2)));
	System.out.println(n.getTipo());
    }

    @Override
    public void visita(NodoPrint n){
	System.out.println("Nodo Print");
	Nodo hijo = n.hijos.get(0);
	Tipo t = hijo.getTipo();
	n.setTipo(tabla.lookup(new Tripleta("PRINT",t)));
	System.out.println(n.getTipo());
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
