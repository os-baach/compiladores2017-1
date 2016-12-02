import java.util.LinkedList;
public class Prueba{

public static void main(String args[]){
    LinkedList<Integer> l = new LinkedList<>();
    l.add(5);
    l.add(0, 1);
    for(Integer elem : l)
	System.out.println(elem);
}
}
