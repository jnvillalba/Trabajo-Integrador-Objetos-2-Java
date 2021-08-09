package modoDeFiltradoTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import modoDeFiltrado.ModoDeFiltrado;
import modoDeFiltrado.ReservasFuturas;
import publicacion.Publicacion;
import tiempo.PeriodoDeAlquiler;

public class ReservasFuturasTest {
	ModoDeFiltrado reservasFuturas;
	Publicacion publicacionConFechaDeIngresoAyer;
	Publicacion publicacionConFechaDeIngresoFutura;
	List<Publicacion> listaAFiltrar;
	PeriodoDeAlquiler periodoDeAlquilerAyer;
	PeriodoDeAlquiler periodoDeAlquilerFuturo;
	
	@Before
	public void setUp() throws Exception {
		// SUT
		reservasFuturas = new ReservasFuturas();
		
		// Mock
		publicacionConFechaDeIngresoAyer = mock(Publicacion.class);
		publicacionConFechaDeIngresoFutura = mock(Publicacion.class);
		periodoDeAlquilerAyer = mock(PeriodoDeAlquiler.class);
		periodoDeAlquilerFuturo = mock(PeriodoDeAlquiler.class);
		
		listaAFiltrar = new ArrayList<>();
	}
	
	@Test
	public void unMetodoDeFiltradoPuedeFiltrarPorTodasLasReservas() {
		int añoSiguiente = LocalDate.now().getYear() + 1;
		LocalDate fechaAyer = LocalDate.of(2021, Month.JUNE, 19);
		LocalDate fechaFutura = LocalDate.of(añoSiguiente, Month.JUNE, 20);
		when(publicacionConFechaDeIngresoAyer.getPeriodoDeAlquiler()).thenReturn(periodoDeAlquilerAyer);
		when(publicacionConFechaDeIngresoFutura.getPeriodoDeAlquiler()).thenReturn(periodoDeAlquilerFuturo);
		when(periodoDeAlquilerAyer.getFechaDeIngreso()).thenReturn(fechaAyer);
		when(periodoDeAlquilerFuturo.getFechaDeIngreso()).thenReturn(fechaFutura);
		listaAFiltrar.add(publicacionConFechaDeIngresoAyer); listaAFiltrar.add(publicacionConFechaDeIngresoFutura);
		List<Publicacion> listaEsperada = new ArrayList<>(); listaEsperada.add(publicacionConFechaDeIngresoFutura);
		
		assertEquals(listaEsperada, reservasFuturas.filtrar(listaAFiltrar));
	}
}
