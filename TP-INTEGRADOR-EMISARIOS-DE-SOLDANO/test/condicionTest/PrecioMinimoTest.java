package condicionTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import condicion.Ciudad;
import condicion.Condicion;
import condicion.PrecioMinimo;
import publicacion.Publicacion;

class PrecioMinimoTest {
	private Publicacion publicacionUno;
	private Publicacion publicacionDos;
	private Publicacion publicacionTres;
	private List<Publicacion> listaDePublicaciones;
	private Condicion condicionPrueba;
	private Condicion precioMinimo;
	
	@BeforeEach
	void setUp() {
		publicacionUno = mock(Publicacion.class);
		publicacionDos = mock(Publicacion.class);
		publicacionTres = mock(Publicacion.class);
		listaDePublicaciones = new ArrayList<Publicacion>();
		listaDePublicaciones.add(publicacionUno);
		listaDePublicaciones.add(publicacionDos);
		listaDePublicaciones.add(publicacionTres);
		precioMinimo = new PrecioMinimo(900);
		condicionPrueba = mock(Ciudad.class);
	}

	@Test
	void filtrarTest() {
		when(publicacionUno.getMontoTotal()).thenReturn(800);
		when(publicacionDos.getMontoTotal()).thenReturn(1600);
		when(publicacionTres.getMontoTotal()).thenReturn(900);
		ArrayList<Publicacion> listaEsperada = new ArrayList<Publicacion>();
		listaEsperada.add(publicacionDos);
		listaEsperada.add(publicacionTres);
		assertEquals(listaEsperada, precioMinimo.filtar(listaDePublicaciones));
	}

	@Test
	void agregarTest() {
		 assertThrows(RuntimeException.class, ()->{ precioMinimo.agregar(condicionPrueba);;});
	}
	
	@Test
	void eliminarTest() {
		 assertThrows(RuntimeException.class, ()->{ precioMinimo.eliminar(condicionPrueba);;});
	}
	
	@Test
	void obtenerHijoTest() {
		 assertThrows(RuntimeException.class, ()->{ precioMinimo.obtenerHijo(1);;});
	}
}
