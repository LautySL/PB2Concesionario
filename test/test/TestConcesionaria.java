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
		// ESTO DE ALGUNA MANERA ESTA MAL
		Concesionaria concesionaria = new Concesionaria("Milanesa");
		String marca = "BMW";
		Coche auto1 = new Coche("AF 546 HJ", marca, "M3", 130000.0);
		String marca2 = "BMW";
		Coche auto2 = new Coche("AG 377 AJ", marca2, "M2", 950000.0);

		concesionaria.agregarCoche(auto1);
		concesionaria.agregarCoche(auto2);

		// creo dos listas como referencia a los resultados que espero y obtengo. los
		// agregro a la lista esperada y si en la lista de coches obtenidos está la
		// marca que estoy buscando --- ya no puedo analizar mas codigo
		ArrayList<Coche> autosEsperados = new ArrayList<>();
		ArrayList<Coche> autosObtenidos = new ArrayList<>();
		autosEsperados.add(auto1);
		autosEsperados.add(auto2);

		autosObtenidos = concesionaria.buscarPorMarca(marca);
		// que carajo hice no se no pregunten pero creo q esta bien
		assertEquals(autosEsperados.get(0).getMarca(), autosObtenidos.get(1).getMarca());
		// actualizacion del analisis: comparo las marcas de las listas, si son iguales
		// es true pero que carajos hace el get() ?????.
		//  el get de arrayList se usa para obtener el elemento de un índice específico dentro de la lista.
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
