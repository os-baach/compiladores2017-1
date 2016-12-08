public class Tripleta{
    private String operacion;
    private Tipo tipo1;
    private Tipo tipo2;
    private Tipo tipo3;
    private Tipo tipo4;
    
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
    
}
