public interface Visitante {

    public void visita(Nodo n);
    public void visita(NodoMas n);
    public void visita(NodoMenos n);
    public void visita(NodoPor n);
    public void visita(NodoPotencia n);
    public void visita(NodoDiv n);
    public void visita(NodoDivEntera n);
    public void visita(NodoModulo n);
    public void visita(NodoEq n);
    public void visita(NodoMayor n);
    public void visita(NodoMenor n);
    public void visita(NodoMenorIgual n);
    public void visita(NodoMayorIgual n);
    public void visita(NodoIgualIgual n);
    public void visita(NodoDistinto n);
    public void visita(NodoDecremento n);
    public void visita(NodoIncremento n);
    public void visita(NodoAnd n);
    public void visita(NodoOr n);
    public void visita(NodoNot n);
    public void visita(NodoFor n);
    public void visita(NodoWhile n);
    public void visita(NodoIf n);
    public void visita(NodoElse n);
    public void visita(NodoElif n);
    public void visita(NodoIn n);
    public void visita(NodoPrint n);
    public void visita(HojaIdentifier h);
    public void visita(HojaEntera h);
    public void visita(HojaReal h);
    public void visita(HojaBoolean h);
    public void visita(HojaCadena h);
    
}
