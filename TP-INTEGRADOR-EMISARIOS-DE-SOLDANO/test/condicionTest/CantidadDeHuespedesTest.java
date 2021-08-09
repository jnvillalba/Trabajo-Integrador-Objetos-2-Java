package condicionTest;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import condicion.CantidadDeHuespedes;
import condicion.Ciudad;
import condicion.Condicion;
import publicacion.Inmueble;
import publicacion.Publicacion;

@SuppressWarnings("unused")
class CantidadDeHuespedesTest {
	private Publicacion publicacionUno;
	private Publicacion publicacionDos;
	private Publicacion publicacionTres;
	private Inmueble inmueblePruebaUno;
	private Inmueble inmueblePruebaDos;
	private Inmueble inmueblePruebaTres;
	private List<Publicacion> listaDePublicaciones;
	private Condicion cantidadDeHuespedes;
	private Condicion condicionPrueba;
	
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
		cantidadDeHuespedes = new CantidadDeHuespedes(4);
		condicionPrueba = mock(Ciudad.class);
	}

	@Test
	void filtrarTest() {
		when(publicacionUno.getInmueblePublicado()).thenReturn(inmueblePruebaUno);
		when(publicacionDos.getInmueblePublicado()).thenReturn(inmueblePruebaDos);
		when(publicacionTres.getInmueblePublicado()).thenReturn(inmueblePruebaTres);
		when(inmueblePruebaUno.getCapacidadDeHabitantes()).thenReturn(5);
		when(inmueblePruebaDos.getCapacidadDeHabitantes()).thenReturn(2);
		when(inmueblePruebaTres.getCapacidadDeHabitantes()).thenReturn(4);
		ArrayList<Publicacion> listaEsperada = new ArrayList<Publicacion>();
		listaEsperada.add(publicacionUno);
		listaEsperada.add(publicacionTres);
		assertEquals(listaEsperada, cantidadDeHuespedes.filtar(listaDePublicaciones));
	}
	
	@Test
	void agregarTest() {
		 assertThrows(RuntimeException.class, ()->{ cantidadDeHuespedes.agregar(condicionPrueba);;});
	}
	
	@Test
	void eliminarTest() {
		 assertThrows(RuntimeException.class, ()->{ cantidadDeHuespedes.eliminar(condicionPrueba);;});
	}
	
	@Test
	void obtenerHijoTest() {
		 assertThrows(RuntimeException.class, ()->{ cantidadDeHuespedes.obtenerHijo(1);;});
	}
}
