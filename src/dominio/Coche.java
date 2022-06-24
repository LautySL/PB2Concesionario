package dominio;

import java.util.Objects;

public class Coche implements Comparable<Coche> {

	private String patente;
	private String marca;
	private String modelo;
	private Double precio;

	public Coche(String patente, String marca, String modelo, Double precio) {
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public int compareTo(Coche o) {
		return this.patente.compareTo(o.getPatente());
	}

	@Override
	public String toString() {
		//return "Coche [patente=" + patente + ", marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + "]";
		return "Coche [patente=" + this.getPatente() + ", marca=" + this.getMarca() + ", modelo=" + this.getModelo() + ", precio=" + this.getPrecio() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(marca, modelo, patente, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo)
				&& Objects.equals(patente, other.patente) && Objects.equals(precio, other.precio);
	}

}
