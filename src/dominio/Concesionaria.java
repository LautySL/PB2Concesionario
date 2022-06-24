package dominio;

import java.util.Set;
import java.util.TreeSet;

public class Concesionaria {

	private String nombre;
	private Set<Coche> coches;

	public Concesionaria(String nombre) {
		this.nombre = nombre;
		this.coches = new TreeSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarCoche(Coche auto) {
		this.coches.add(auto);
		
	}

	public Integer obtenerCantidadDeCoches() {
		return this.coches.size();
	}

	public void eliminarCoche(Coche auto) {
		this.coches.remove(auto);
		
	}

}
