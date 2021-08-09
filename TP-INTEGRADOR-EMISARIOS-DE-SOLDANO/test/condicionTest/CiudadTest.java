package condicionTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import condicion.Ciudad;
import condicion.Condicion;
import publicacion.Inmueble;
import publicacion.Publicacion;

@SuppressWarnings("unused")
class CiudadTest {
	private Publicacion publicacionUno;
	private Publicacion publicacionDos;
	private Publicacion publicacionTres;
	private Inmueble inmueblePruebaUno;
	private Inmueble inmueblePruebaDos;
	private Inmueble inmueblePruebaTres;
	private List<Publicacion> listaDePublicaciones;
	private Condicion ciudad;
	private Condicion condicionPrueba;
	
	@BeforeEach
	void setUpBeforeClass() {
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
		ciudad = new Ciudad("MDQ");
		condicionPrueba = mock(Ciudad.class);
	}

	@Test
	void filtrarTest() {
		when(publicacionUno.getInmueblePublicado()).thenReturn(inmueblePruebaUno);
		when(publicacionDos.getInmueblePublicado()).thenReturn(inmueblePruebaDos);
		when(publicacionTres.getInmueblePublicado()).thenReturn(inmueblePruebaTres);
		when(inmueblePruebaUno.getCiudad()).thenReturn("Berazategui");
		when(inmueblePruebaDos.getCiudad()).thenReturn("MDQ");
		when(inmueblePruebaTres.getCiudad()).thenReturn("MDQ");
		ArrayList<Publicacion> listaEsperada = new ArrayList<Publicacion>();
		listaEsperada.add(publicacionDos);
		listaEsperada.add(publicacionTres);
		assertEquals(listaEsperada, ciudad.filtar(listaDePublicaciones));
	}
	
	@Test
	void agregarTest() {
		 assertThrows(RuntimeException.class, ()->{ ciudad.agregar(condicionPrueba);;});
	}
	
	@Test
	void eliminarTest() {
		 assertThrows(RuntimeException.class, ()->{ ciudad.eliminar(condicionPrueba);;});
	}
	
	@Test
	void obtenerHijoTest() {
		 assertThrows(RuntimeException.class, ()->{ ciudad.obtenerHijo(1);;});
	}
}
