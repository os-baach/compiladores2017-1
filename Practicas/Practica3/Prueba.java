public class Prueba{
    public static void main(String args[]){
    HojaEntera raiz = new HojaEntera(5);
    HojaEntera izq1 = new HojaEntera(4);
    HojaEntera izq2 = new HojaEntera(8);
    HojaEntera der1 = new HojaEntera(2);
    HojaEntera der3 = new HojaEntera(9);
    HojaEntera izq3 = new HojaEntera(10);

    raiz.nuevoHijo(izq1);
    raiz.nuevoHijo(der1);
    izq1.nuevoHijo(izq2);
    der1.nuevoHijo(izq3);
    der1.nuevoHijo(der3);

    raiz.imprimeSubarbol("", true);
}

}
