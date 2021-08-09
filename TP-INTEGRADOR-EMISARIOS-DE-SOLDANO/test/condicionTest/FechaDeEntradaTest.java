package condicionTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import condicion.Ciudad;
import condicion.Condicion;
import condicion.FechaDeEntrada;
import publicacion.Publicacion;
import tiempo.PeriodoDeAlquiler;

class FechaDeEntradaTest {
	private Publicacion publicacionUno;
	private Publicacion publicacionDos;
	private Publicacion publicacionTres;
	private Publicacion publicacionCuatro;
	private PeriodoDeAlquiler periodoDeAlquilerUno;
	private PeriodoDeAlquiler periodoDeAlquilerDos;
	private PeriodoDeAlquiler periodoDeAlquilerTres;
	private PeriodoDeAlquiler periodoDeAlquilerCuatro;
	private List<Publicacion> listaDePublicaciones;
	private Condicion fechaDeEntrada;
	private Condicion condicionPrueba;
	
	@BeforeEach
	void setUp() throws Exception {
		publicacionUno = mock(Publicacion.class);
		publicacionDos = mock(Publicacion.class);
		publicacionTres = mock(Publicacion.class);
		publicacionCuatro = mock(Publicacion.class);
		periodoDeAlquilerUno = mock(PeriodoDeAlquiler.class);
		periodoDeAlquilerDos = mock(PeriodoDeAlquiler.class);
		periodoDeAlquilerTres = mock(PeriodoDeAlquiler.class);
		periodoDeAlquilerCuatro = mock(PeriodoDeAlquiler.class);
		listaDePublicaciones = new ArrayList<Publicacion>();
		listaDePublicaciones.add(publicacionUno);
		listaDePublicaciones.add(publicacionDos);
		listaDePublicaciones.add(publicacionTres);
		listaDePublicaciones.add(publicacionCuatro);
		fechaDeEntrada = new FechaDeEntrada(LocalDate.of(2021, Month.JUNE, 10));
		condicionPrueba = mock(Ciudad.class);
	}

	@Test
	void test() {
		when(publicacionUno.getPeriodoDeAlquiler()).thenReturn(periodoDeAlquilerUno);
		when(publicacionDos.getPeriodoDeAlquiler()).thenReturn(periodoDeAlquilerDos);
		when(publicacionTres.getPeriodoDeAlquiler()).thenReturn(periodoDeAlquilerTres);
		when(publicacionCuatro.getPeriodoDeAlquiler()).thenReturn(periodoDeAlquilerCuatro);
		when(periodoDeAlquilerUno.getFechaDeIngreso()).thenReturn(LocalDate.of(2021, Month.JUNE, 12));
		when(periodoDeAlquilerDos.getFechaDeIngreso()).thenReturn(LocalDate.of(2021, Month.JUNE, 9));
		when(periodoDeAlquilerTres.getFechaDeIngreso()).thenReturn(LocalDate.of(2021, Month.JUNE, 11));
		when(periodoDeAlquilerCuatro.getFechaDeIngreso()).thenReturn(LocalDate.of(2021, Month.JUNE, 10));
		ArrayList<Publicacion> listaEsperada = new ArrayList<Publicacion>();
		listaEsperada.add(publicacionUno);
		listaEsperada.add(publicacionTres);
		assertEquals(listaEsperada, fechaDeEntrada.filtar(listaDePublicaciones));
	}
	
	@Test
	void agregarTest() {
		 assertThrows(RuntimeException.class, ()->{ fechaDeEntrada.agregar(condicionPrueba);;});
	}
	
	@Test
	void eliminarTest() {
		 assertThrows(RuntimeException.class, ()->{ fechaDeEntrada.eliminar(condicionPrueba);;});
	}
	
	@Test
	void obtenerHijoTest() {
		 assertThrows(RuntimeException.class, ()->{ fechaDeEntrada.obtenerHijo(1);;});
	}

}
