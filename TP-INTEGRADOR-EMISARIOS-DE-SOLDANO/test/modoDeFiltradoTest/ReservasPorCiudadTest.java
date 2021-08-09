package modoDeFiltradoTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import modoDeFiltrado.ModoDeFiltrado;
import modoDeFiltrado.ReservasPorCiudad;
import publicacion.Inmueble;
import publicacion.Publicacion;

public class ReservasPorCiudadTest {
	ModoDeFiltrado reservasPorCiudad;
	Publicacion publicacion;
	Inmueble inmueble;
	
	@Before
	public void setUp() throws Exception {
		// SUT
		reservasPorCiudad = new ReservasPorCiudad("Buenos Aires");
		
		// Mock
		publicacion = mock(Publicacion.class); 
		inmueble = mock(Inmueble.class);
	}
	
	@Test
	public void unMetodoDeFiltradoPuedeFiltrarPorTodasLasReservas() {
		List<Publicacion> listaAFiltrar = new ArrayList<>(); listaAFiltrar.add(publicacion);
		when(publicacion.getInmueblePublicado()).thenReturn(inmueble);
		when(inmueble.getCiudad()).thenReturn("Buenos Aires");
		
		assertEquals(listaAFiltrar, reservasPorCiudad.filtrar(listaAFiltrar));
	}
	
	@Test
	public void unMetodoDeFiltradoPuedeFiltrarPorTodasLasReservasCasoFalso() {
		List<Publicacion> listaAFiltrar = new ArrayList<>(); listaAFiltrar.add(publicacion);
		when(publicacion.getInmueblePublicado()).thenReturn(inmueble);
		when(inmueble.getCiudad()).thenReturn("Wilde");
		
		assertEquals(new ArrayList<Publicacion>(), reservasPorCiudad.filtrar(listaAFiltrar));
	}
}
