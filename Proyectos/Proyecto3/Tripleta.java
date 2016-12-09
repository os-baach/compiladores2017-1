public class Tripleta{
    private String operacion;
    private Tipo tipo1;
    private Tipo tipo2;
    private Tipo tipo3;
    private Tipo tipo4;

    /* Regresa la operación de la tripleta */
    public String getOperacion(){
	return this.operacion;
    }

    /* Regresa el primer tipo de la tripleta */
    public Tipo getTipo1(){
	return this.tipo1;
    }

    /* Regresa el segundo tipo de la tripleta */
    public Tipo getTipo2(){
	return this.tipo2;
    }

    /* Regresa el tercer tipo de la tripleta */
    public Tipo getTipo3(){
	return this.tipo3;
    }

    /* Regresa el cuarto tipo de la tripleta */
    public Tipo getTipo4(){
	return this.tipo4;
    }

    
    
    public Tripleta(String operacion, Tipo tipo1){
	this.operacion = operacion;
	this.tipo1 = tipo1;
    }
    
    public Tripleta(String operacion, Tipo tipo1, Tipo tipo2){
	this.operacion = operacion;
	this.tipo1 = tipo1;
	this.tipo2 = tipo2;
    }

    public Tripleta(String operacion, Tipo tipo1, Tipo tipo2, Tipo tipo3){
	this.operacion = operacion;
	this.tipo1 = tipo1;
	this.tipo2 = tipo2;
	this.tipo3 = tipo3;
    }

    public Tripleta(String operacion, Tipo tipo1, Tipo tipo2, Tipo tipo3, Tipo tipo4){
	this.operacion = operacion;
	this.tipo1 = tipo1;
	this.tipo2 = tipo2;
	this.tipo3 = tipo3;
	this.tipo4 = tipo4;
    }

    @Override public boolean equals(Object o){
	if(!(o instanceof Tripleta))
	    return false;
	Tripleta t = (Tripleta) o; /* Tripleta a comparar */
	return this.operacion.equals(t.getOperacion()) && this.tipo1 == t.getTipo1()
	    && this.tipo2 == t.getTipo2() && this.tipo3 == t.getTipo3() && this.tipo4 == t.getTipo4();  
    }


    @Override public int hashCode() {
	int hash = this.operacion.hashCode();
	if(tipo1 != null)
	    hash = hash * 31 + this.tipo1.hashCode();
	if(tipo2 != null)
	    hash = hash * 31 + this.tipo2.hashCode();
	if(tipo3 != null)
	    hash = hash * 31 + this.tipo3.hashCode();
	if(tipo4 != null)
	    hash = hash * 31 + this.tipo4.hashCode();
	return hash;
    }

    public Tipo getFst(String operacion, Tipo t1, Tipo t2, Tipo t3){
	return t1;
    }
    
}
