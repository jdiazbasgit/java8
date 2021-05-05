package java8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class EjemploColecciones {

	public static void main(String[] args) {

		ArrayList<Integer> lista = new ArrayList<>();
		for (int i = 1; i < 100; i++) {
			Double d = Math.random() * 100 + 1;
			lista.add(d.intValue());
		}

		Set<Viaje> viajes = new HashSet<>();

		Viaje v1 = new Viaje("Madrid", "Barcelona");
		Viaje v2 = new Viaje("Madrid", "Bilbao");
		Viaje v3 = new Viaje("Cadiz", "Barcelona");
		Viaje v4 = new Viaje("Cadiz", "Valencia");
		Viaje v5 = new Viaje("La Coruña", "Gijon");
		viajes.add(v1);
		viajes.add(v2);
		viajes.add(v3);
		viajes.add(v4);
		viajes.add(v5);

		/*
		 * for (Viaje viaje : viajes) { System.out.println(viaje.getOrigen()); }
		 */

		// lista.stream().forEach((c)->System.out.println(c));

		// System.out.println("==========DESORDENADO IVA===============");

		// lista.stream().filter(c -> c > 30).map(c -> c * 0.21).forEach(
		// System.out::println);

		System.out.println("============ORDENADO IVA=============");

		lista.stream().filter((c) -> c < 30).map((c) -> c * 0.21).sorted().forEach(System.out::println);

		// System.out.println("============DESORDENADO BASE IMPONIBLE=============");
		// lista.stream().filter((c) -> c < 30).forEach( System.out::println);

		// System.out.println("============ORDENADO NATURAL
		// BASEIMPONIBLE=============");
		// lista.stream().filter((c) -> c < 30).sorted().forEach( System.out::println);

		System.out.println("============SUMADO BASE IMPONIBLE=============");
		System.out.println(lista.stream().filter(c -> c < 30).mapToDouble(c -> c * 1.21).sum());
		/*
		 * System.out.println("============SUMADO IVA=============");
		 * System.out.println(lista.stream().filter(c -> c < 30).map(c -> c *
		 * 0.21).mapToDouble(c -> c).sum()); /
		 */
		System.out.println("============MAXIMO=============");
		lista.stream().filter(c -> c < 30).mapToDouble(c -> c * 0.21).max().ifPresent(System.out::println);

		System.out.println("============MINIMO=============");
		lista.stream().filter(c -> c < 30).mapToInt(c -> c).min().ifPresent(System.out::println);

		System.out.println("============ORDENADO CONDICIONADO=============");

		List<Persona> personas = new ArrayList<>();

		Persona pepe = new Persona("Pepe Garcia", "calle del pez 1", "99999999", new ArrayList<>());

		Persona luis = new Persona("Luis Fernandez", "calle Alcalá", "99345699", new ArrayList<>());

		pepe.getViajes().add(new Viaje("Madirid", "Barcelona"));
		pepe.getViajes().add(new Viaje("Bilbao", "Sevilla"));
		luis.getViajes().add(new Viaje("Barcelona", "La Coruña"));
		luis.getViajes().add(new Viaje("Madirid", "Cadiz"));
		personas.add(pepe);
		personas.add(luis);

		System.out.println("============SIN ORDENAR=============");
		personas.stream().forEach((p) -> System.out.println(p.getNombre()));
		
		

		System.out.println("============ORDENADO=============");
		personas.stream().sorted((pa, pb) -> pa.getNombre().compareTo(pb.getNombre()))
				.forEach((p) -> System.out.println(p.getNombre()));

		
		  System.out.println("===============NOMBRES DE VIAJEROS===========");
		  personas.forEach(c -> System.out.println(c.getTelefono()));
		  
		  System.out.println("===============DESTINOS===========");
		  
		  
		personas.stream().map(p -> p.getViajes()).flatMap(v -> v.stream()).map(v ->
		  v.getDestino()).collect(Collectors.toList()).forEach(System.out::println);;
		  
		
		 

	}
}

class Persona {

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Persona(String nombre, String direccion, String telefono, List<Viaje> viajes) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.viajes = viajes;
	}

	public List<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}

	private String nombre, direccion, telefono;
	private List<Viaje> viajes;
}

class Viaje implements Comparable<Viaje> {
	private String origen, destino;

	public String getOrigen() {
		return origen;
	}

	public Viaje(String origen, String destino) {
		super();
		this.origen = origen;
		this.destino = destino;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	@Override
	public int compareTo(Viaje otro) {
		// TODO Auto-generated method stub
		return this.getOrigen().compareTo(otro.getOrigen());
	}

	/*
	 * @Override public int hashCode() { return this.getOrigen().hashCode() + 1; }
	 * 
	 * @Override public boolean equals(Object obj) { Viaje otro = (Viaje) obj;
	 * return this.getOrigen().equals(otro.getOrigen()); }
	 */

}
