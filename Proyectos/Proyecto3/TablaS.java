import java.util.Hashtable;
/* Representa a la tabla de símbolos */
public class TablaS{
    private Hashtable<String, Tipo> tabla;

    public TablaS(){
	this.tabla = new Hashtable<>();
    }
    

    /* Busca el nombre en la tabla de tipos */
    public Tipo lookup(String name){
	return this.tabla.get(name);
    }

    /* Inserta un elemento en la tabla de símbolos */
    public void insert(String name, Tipo info){
	this.tabla.put(name, info);
    }
}
