package condicionTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import condicion.CantidadDeHuespedes;
import condicion.Ciudad;
import condicion.CompuestaOR;
import condicion.Condicion;
import condicion.PrecioMaximo;
import publicacion.Inmueble;
import publicacion.Publicacion;

class CompuestoORTest {
	private Publicacion publicacionUno;
	private Publicacion publicacionDos;
	private Publicacion publicacionTres;
	private Inmueble inmueblePruebaUno;
	private Inmueble inmueblePruebaDos;
	private Inmueble inmueblePruebaTres;
	private Condicion compuestoOR;
	private Condicion ciudadPrueba;
	private Condicion precioMaximo;
	private Condicion cantidadDeHuespedesRequeridos;
	private List<Publicacion> listaDePublicaciones;
	
	@BeforeEach
	void setUp() {
		publicacionUno = mock(Publicacion.class);
		publicacionDos = mock(Publicacion.class);
		publicacionTres = mock(Publicacion.class);
		inmueblePruebaUno = mock(Inmueble.class);
		inmueblePruebaDos = mock(Inmueble.class);
		inmueblePruebaTres = mock(Inmueble.class);
		listaDePublicaciones = new ArrayList<Publicacion>();
		listaDePublicaciones.add(publicacionUno);
		listaDePublicaciones.add(publicacionDos);
		listaDePublicaciones.add(publicacionTres);
		compuestoOR = new CompuestaOR(); 
		ciudadPrueba = new Ciudad("MDQ");
		precioMaximo = new PrecioMaximo(1800);
		cantidadDeHuespedesRequeridos = new CantidadDeHuespedes(4);
	}

	@Test
	void filtrarTest() {
		/* 
		   Se queda con aquellas publicaciones con ciudad MDQ = [publicacionDos,publicacionTres].
		   O Las  publicaciones que tengan CantidadDeHuespedes >= 4 [publicacionTres]. 
		   O las publicaciones que tengan como maximo 1800 [publicacionTres].
		*/
		compuestoOR.agregar(ciudadPrueba);
		compuestoOR.agregar(cantidadDeHuespedesRequeridos);
		compuestoOR.agregar(precioMaximo);
		when(publicacionUno.getInmueblePublicado()).thenReturn(inmueblePruebaUno);
		when(publicacionDos.getInmueblePublicado()).thenReturn(inmueblePruebaDos);
		when(publicacionTres.getInmueblePublicado()).thenReturn(inmueblePruebaTres);
		when(inmueblePruebaUno.getCiudad()).thenReturn("Berazategui");
		when(inmueblePruebaDos.getCiudad()).thenReturn("MDQ");
		when(inmueblePruebaTres.getCiudad()).thenReturn("MDQ");
		when(inmueblePruebaUno.getCapacidadDeHabitantes()).thenReturn(3);
		when(inmueblePruebaDos.getCapacidadDeHabitantes()).thenReturn(3);
		when(inmueblePruebaTres.getCapacidadDeHabitantes()).thenReturn(4);
		when(publicacionUno.getMontoTotal()).thenReturn(5000);
		when(publicacionDos.getMontoTotal()).thenReturn(1400);
		when(publicacionTres.getMontoTotal()).thenReturn(1400);
		ArrayList<Publicacion> listaEsperada = new ArrayList<Publicacion>();
		listaEsperada.add(publicacionDos);
		listaEsperada.add(publicacionTres);
		assertTrue(compuestoOR.filtar(listaDePublicaciones).containsAll(listaEsperada));	
	}
	
	@Test
	void eliminarTest() {
		compuestoOR.agregar(ciudadPrueba);
		compuestoOR.eliminar(ciudadPrueba);
		ArrayList<Publicacion> listaEsperada = new ArrayList<Publicacion>();
		assertEquals(listaEsperada, compuestoOR.filtar(listaDePublicaciones));
	}
	
	@Test
	void obtenerHijoTest() {
		compuestoOR.agregar(ciudadPrueba);
		assertEquals(ciudadPrueba, compuestoOR.obtenerHijo(0));
	}

}
