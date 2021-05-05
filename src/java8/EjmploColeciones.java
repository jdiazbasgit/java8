package java8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EjmploColeciones {

	public static void main(String[] args) {

		//List<String> lista = new ArrayList<>();
		Set<String> lista=new HashSet<>();
		
		lista.add("b");
		lista.add("c");
		lista.add("b");
		lista.add("c");
		
		lista.add("a");
		lista.add("a");
		lista.add("a");
		lista.add("b");
		lista.add("a");
		lista.add("a");
		lista.add("b");
		lista.add("c");
		lista.add("b");
		lista.add("c");
		
		for (String string : lista) {
			System.out.println(string);
		}
		
		
	}
	
	
	
	
}
