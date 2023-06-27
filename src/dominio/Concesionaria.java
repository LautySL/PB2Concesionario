package dominio;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Concesionaria {

	private String nombre;
	private Set<Coche> coches;

	public Concesionaria(String nombre) {
		this.nombre = nombre;
		this.coches = new TreeSet<>();
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

	public String mostrarCoches() {
		// TODO Auto-generated method stub
		return this.coches.toString();
	}

	public Coche buscarPorPatente(String patente) throws patenteNoExisteException, patenteInvalida {
		for (Coche coche : coches) {
			if (coche.getPatente().equals(patente) && patenteValida(patente))
				return coche;
		}
		throw new patenteNoExisteException("La patente no existe");
	}

	public ArrayList<Coche> buscarPorMarca(String marca) {
		// creo una coleccion de autos encontrados, lo recorro y si la marca de ese auto
		// q estoy por registrar es igual a la marca que le paso por parametro entonces
		// agreco ese coche a la coleccion y retorno la coleccion.
		ArrayList<Coche> autosEncontrados = new ArrayList<>();
		for (Coche coche : coches) {
			if (coche.getMarca().equals(marca)) {
				autosEncontrados.add(coche);
			}
		}
		return autosEncontrados;
	}

	public boolean patenteValida(String patente) throws patenteInvalida {
		if (patente.length() >= 9) {
			
			return true;
		}
		throw new patenteInvalida("la patente es invalida");
	}

	public TreeSet<Coche> ordenarPorMarcaYModelo() {
		TreeSet<Coche> autosOrdenados = new TreeSet<>(new OrdenarAutosPorMarcaYModelo());
		
		autosOrdenados.addAll(coches);
		
		return autosOrdenados;
	}

	public TreeSet<Coche> ordenarPorPrecioYPatente() {
		TreeSet<Coche> autosOrdenados = new TreeSet<>(new OrdenarAutosPorPrecioYPatente());
		
		autosOrdenados.addAll(coches);
		
		return autosOrdenados;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
