package modoDeFiltradoTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import modoDeFiltrado.ModoDeFiltrado;
import modoDeFiltrado.TodasLasReservas;
import publicacion.Publicacion;

public class TodasLasReservasTest {
	ModoDeFiltrado todasLasReservas;
	Publicacion publicacion;
	
	@Before
	public void setUp() throws Exception {
		// SUT
		todasLasReservas = new TodasLasReservas();
		
		// Mock
		publicacion = mock(Publicacion.class); 
	}
	
	@Test
	public void unMetodoDeFiltradoPuedeFiltrarPorTodasLasReservas() {
		List<Publicacion> listaAFiltrar = new ArrayList<>(); listaAFiltrar.add(publicacion);
		
		assertEquals(listaAFiltrar, todasLasReservas.filtrar(listaAFiltrar));
	}
}
