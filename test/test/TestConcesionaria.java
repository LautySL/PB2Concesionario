package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import dominio.Coche;
import dominio.Concesionaria;
import dominio.patenteInvalida;
import dominio.patenteNoExisteException;

public class TestConcesionaria {

	@Test
	public void crearConcesionaria() {
		Concesionaria c = new Concesionaria("Consesionaria con S");

	}

	@Test
	public void crearCoche() {
		// patente, marca, modelo, precio
		Coche auto = new Coche("HSS 911", "Fiat", "Palio", 10.0);
	}

	@Test
	public void queSePuedaAgregarUnAutoALaConcesionaria() {
		Concesionaria concesionaria = new Concesionaria("MrGuarango");
		Coche auto = new Coche("HSS 911", "Fiat", "Palio", 10.0);

		concesionaria.agregarCoche(auto);
		Integer valorEsperado = 1;
		Integer valorObtenido = concesionaria.obtenerCantidadDeCoches();
		assertEquals(valorEsperado, valorObtenido);
		// assertEquals(1, concesionaria.obtenerCantidadDeCoches());

	}

	@Test
	public void queSePuedaEliminarUnAutoALaConcesionaria() {
		Concesionaria concesionaria = new Concesionaria("MrGuarango");
		Coche auto = new Coche("HSS 911", "Fiat", "Palio", 10.0);
		Coche auto2 = new Coche("JOB 809", "no se", "tampoco se", 10.0);

		concesionaria.agregarCoche(auto);
		concesionaria.agregarCoche(auto2);
		concesionaria.eliminarCoche(auto);

		Integer valorEsperado = 1;
		Integer valorObtenido = concesionaria.obtenerCantidadDeCoches();
		assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void queSePuedanMostrarTodosLosCochesDeLaConcesionaria() {
		Concesionaria concesionaria = new Concesionaria("MrGuarango");
		Coche auto = new Coche("HSS 911", "Fiat", "Palio", 10.0);
		Coche auto2 = new Coche("JOB 809", "no se", "tampoco se", 10.0);
		concesionaria.agregarCoche(auto);
		concesionaria.agregarCoche(auto2);
		System.out.println(concesionaria.mostrarCoches());

	}

	@Test
	public void queNoSePuedaAgregarDosAutosConLaMismaPatente() {
		Concesionaria concesionaria = new Concesionaria("MrGuarango");
		Coche auto = new Coche("HSS 911", "Fiat", "Palio", 10.0);
		Coche auto2 = new Coche("HSS 911", "no se", "tampoco se", 10.0);
		concesionaria.agregarCoche(auto);
		concesionaria.agregarCoche(auto2);
		Integer resultadoEsperado = 1;
		// espera 1 solo auto, no puede esperar 2 porq tienen la misma patente.
		Integer resultadoObtenido = concesionaria.obtenerCantidadDeCoches();

		assertEquals(resultadoEsperado, resultadoObtenido);

	}

	@Test
	public void queSePuedaBuscarUnAutoPorPatente() throws patenteNoExisteException, patenteInvalida {
		Concesionaria concesionaria = new Concesionaria("MrGuarango");
		String patente = "HSSFHSIHO";
		Coche auto = new Coche(patente, "Fiat", "Palio", 10.0);
		concesionaria.agregarCoche(auto);
		Coche cocheEncontrado = concesionaria.buscarPorPatente(patente);
		assertEquals(patente, cocheEncontrado.getPatente());
	}

	@Test
	public void queSePuedaBuscarAutosPorMarca() {
		Concesionaria concesionaria = new Concesionaria("MrGuarango");
		String marca = "Fiat";
		Coche auto = new Coche("HSS 911", marca, "Palio", 10.0);
		String marca2 = "Toyota";
		Coche auto2 = new Coche("HSS 911", marca2, "tampoco se", 10.0);

		concesionaria.agregarCoche(auto);
		concesionaria.agregarCoche(auto2);

		// creo dos listas como referencia a los resultados que espero y obtengo. los
		// agregro a la lista esperada y si en la lista de coches obtenidos está la
		// marca que estoy buscando --- ya no puedo analizar mas codigo
		ArrayList<Coche> cocheEsperado = new ArrayList<>();
		ArrayList<Coche> cocheObtenido = new ArrayList<>();
		cocheEsperado.add(auto);
		cocheEsperado.add(auto2);
		cocheObtenido = concesionaria.buscarPorMarca(marca);
		// que carajo hice no se no pregunten pero creo q esta bien
		assertEquals(cocheEsperado.get(0).getMarca(), cocheObtenido.get(1).getMarca());
	}

	@Test
	public void queSePuedaOrdenarPorMarcaYModelo() {

	}

	@Test
	public void queSePuedaOrdenarCochesPorPrecioYPatente() {

	}

	@Test
	public void validarQueSeProduzcaUnaExcepcionSiLaPatenteEsInvalida() {

	}

	@Test
	public void queAnteUnAutoInexistenteTermineConPatenteNoExisteException() {

	}

	@Test
	public void queNoSePuedaBuscarUnAutoPorPatenteSiLaPatenteNoExiste() {

	}

	@Test
	public void testAEleccion() {

	}
}
