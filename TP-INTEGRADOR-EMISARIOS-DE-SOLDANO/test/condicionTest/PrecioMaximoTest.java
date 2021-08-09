package condicionTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import condicion.Ciudad;
import condicion.Condicion;
import condicion.PrecioMaximo;
import publicacion.Inmueble;
import publicacion.Publicacion;

@SuppressWarnings("unused")
class PrecioMaximoTest {
	private Publicacion publicacionUno;
	private Publicacion publicacionDos;
	private Publicacion publicacionTres;
	private List<Publicacion> listaDePublicaciones;
	private Condicion condicionPrueba;
	private Condicion precioMaximo;
	
	@BeforeEach
	void setUp() {
		publicacionUno = mock(Publicacion.class);
		publicacionDos = mock(Publicacion.class);
		publicacionTres = mock(Publicacion.class);
		listaDePublicaciones = new ArrayList<Publicacion>();
		listaDePublicaciones.add(publicacionUno);
		listaDePublicaciones.add(publicacionDos);
		listaDePublicaciones.add(publicacionTres);
		precioMaximo = new PrecioMaximo(1400);
		condicionPrueba = mock(Ciudad.class);
	}

	@Test
	void filtrarTest() {
		when(publicacionUno.getMontoTotal()).thenReturn(800);
		when(publicacionDos.getMontoTotal()).thenReturn(1600);
		when(publicacionTres.getMontoTotal()).thenReturn(900);
		ArrayList<Publicacion> listaEsperada = new ArrayList<Publicacion>();
		listaEsperada.add(publicacionUno);
		listaEsperada.add(publicacionTres);
		assertEquals(listaEsperada, precioMaximo.filtar(listaDePublicaciones));
	}
	
	@Test
	void agregarTest() {
		 assertThrows(RuntimeException.class, ()->{ precioMaximo.agregar(condicionPrueba);;});
	}
	
	@Test
	void eliminarTest() {
		 assertThrows(RuntimeException.class, ()->{ precioMaximo.eliminar(condicionPrueba);;});
	}
	
	@Test
	void obtenerHijoTest() {
		 assertThrows(RuntimeException.class, ()->{ precioMaximo.obtenerHijo(1);;});
	}
}
