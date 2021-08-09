package condicionTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import condicion.CantidadDeHuespedes;
import condicion.Ciudad;
import condicion.CompuestaAND;
import condicion.Condicion;
import condicion.PrecioMaximo;
import publicacion.Inmueble;
import publicacion.Publicacion;

class CompuestoANDTest {
	private Publicacion publicacionUno;
	private Publicacion publicacionDos;
	private Publicacion publicacionTres;
	private Inmueble inmueblePruebaUno;
	private Inmueble inmueblePruebaDos;
	private Inmueble inmueblePruebaTres;
	private CompuestaAND compuestoAND;
	private Condicion ciudadPrueba;
	private Condicion precioMaximo;
	private Condicion cantidadDeHuespedesRequeridos;
	private List<Publicacion> listaDePublicaciones;
	
	@BeforeEach
	void setUpBeforeClass() throws Exception {
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
		compuestoAND = new CompuestaAND(); 
		ciudadPrueba = new Ciudad("MDQ");
		precioMaximo = new PrecioMaximo(1800);
		cantidadDeHuespedesRequeridos = new CantidadDeHuespedes(4);
	}

	@Test
	void filtarTest() {
		/* 
		   Se queda con aquellas publicaciones con ciudad MDQ = [publicacionDos,publicacionTres].
		   De las publicaciones filtradas anteriormente que tengan CantidadDeHuespedes >= 4 [publicacionTres]. 
		   De las publicaciones filtradas anteriormente que tengan como maximo 1800 [publicacionTres].
		*/
		compuestoAND.agregar(ciudadPrueba);
		compuestoAND.agregar(cantidadDeHuespedesRequeridos);
		compuestoAND.agregar(precioMaximo);
		when(publicacionUno.getInmueblePublicado()).thenReturn(inmueblePruebaUno);
		when(publicacionDos.getInmueblePublicado()).thenReturn(inmueblePruebaDos);
		when(publicacionTres.getInmueblePublicado()).thenReturn(inmueblePruebaTres);
		when(inmueblePruebaUno.getCiudad()).thenReturn("Berazategui");
		when(inmueblePruebaDos.getCiudad()).thenReturn("MDQ");
		when(inmueblePruebaTres.getCiudad()).thenReturn("MDQ");
		when(inmueblePruebaDos.getCapacidadDeHabitantes()).thenReturn(3);
		when(inmueblePruebaTres.getCapacidadDeHabitantes()).thenReturn(4);
		when(publicacionTres.getMontoTotal()).thenReturn(1400);
		ArrayList<Publicacion> listaEsperada = new ArrayList<Publicacion>();
		listaEsperada.add(publicacionTres);
		assertEquals(listaEsperada, compuestoAND.filtar(listaDePublicaciones));	
	}
	
	@Test
	void eliminarTest() {
		compuestoAND.agregar(ciudadPrueba);
		compuestoAND.eliminar(ciudadPrueba);
		ArrayList<Publicacion> listaEsperada = new ArrayList<Publicacion>();
		assertEquals(listaEsperada, compuestoAND.filtar(listaDePublicaciones));
	}
	
	@Test
	void obtenerHijoTest() {
		compuestoAND.agregar(ciudadPrueba);
		assertEquals(ciudadPrueba, compuestoAND.obtenerHijo(0));
	}
}
