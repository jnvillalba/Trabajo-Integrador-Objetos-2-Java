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
import condicion.FechaDeSalidad;
import publicacion.Publicacion;
import tiempo.PeriodoDeAlquiler;

class FechaDeSalidaTest {
	private Publicacion publicacionUno;
	private Publicacion publicacionDos;
	private Publicacion publicacionTres;
	private Publicacion publicacionCuatro;
	private PeriodoDeAlquiler periodoDeAlquilerUno;
	private PeriodoDeAlquiler periodoDeAlquilerDos;
	private PeriodoDeAlquiler periodoDeAlquilerTres;
	private PeriodoDeAlquiler periodoDeAlquilerCuatro;
	private List<Publicacion> listaDePublicaciones;
	private Condicion fechaDeSalida;
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
		fechaDeSalida = new FechaDeSalidad(LocalDate.of(2021, Month.JUNE, 10));
		condicionPrueba = mock(Ciudad.class);
	}

	@Test
	void test() {
		when(publicacionUno.getPeriodoDeAlquiler()).thenReturn(periodoDeAlquilerUno);
		when(publicacionDos.getPeriodoDeAlquiler()).thenReturn(periodoDeAlquilerDos);
		when(publicacionTres.getPeriodoDeAlquiler()).thenReturn(periodoDeAlquilerTres);
		when(publicacionCuatro.getPeriodoDeAlquiler()).thenReturn(periodoDeAlquilerCuatro);
		when(periodoDeAlquilerUno.getFechaDeEgreso()).thenReturn(LocalDate.of(2021, Month.JUNE, 6));
		when(periodoDeAlquilerDos.getFechaDeEgreso()).thenReturn(LocalDate.of(2021, Month.JUNE, 12));
		when(periodoDeAlquilerTres.getFechaDeEgreso()).thenReturn(LocalDate.of(2021, Month.JUNE, 9));
		when(periodoDeAlquilerCuatro.getFechaDeEgreso()).thenReturn(LocalDate.of(2021, Month.JUNE, 10));
		ArrayList<Publicacion> listaEsperada = new ArrayList<Publicacion>();
		listaEsperada.add(publicacionUno);
		listaEsperada.add(publicacionTres);
		assertEquals(listaEsperada, fechaDeSalida.filtar(listaDePublicaciones));
	}
	
	@Test
	void agregarTest() {
		 assertThrows(RuntimeException.class, ()->{ fechaDeSalida.agregar(condicionPrueba);;});
	}
	
	@Test
	void eliminarTest() {
		 assertThrows(RuntimeException.class, ()->{ fechaDeSalida.eliminar(condicionPrueba);;});
	}
	
	@Test
	void obtenerHijoTest() {
		 assertThrows(RuntimeException.class, ()->{ fechaDeSalida.obtenerHijo(1);;});
	}
}
