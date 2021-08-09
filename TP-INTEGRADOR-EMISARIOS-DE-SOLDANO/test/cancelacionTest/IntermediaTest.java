package cancelacionTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cancelacion.Cancelacion;
import cancelacion.Intermedia;
import publicacion.Publicacion;
import tiempo.PeriodoDeAlquiler;

class IntermediaTest {
	private Cancelacion cancelacionIntermedia;
	private Publicacion publicacion;
	private PeriodoDeAlquiler periodoDeAlquiler;
	
	@BeforeEach
	void setUp() throws Exception {
		cancelacionIntermedia = new Intermedia();
		publicacion = mock(Publicacion.class);
		periodoDeAlquiler = mock(PeriodoDeAlquiler.class);
	}

	@Test
	void montoACobrarTestGratuito() {
		LocalDate fechaActual = LocalDate.of(2021, 06, 1);
		LocalDate fechaDeIngreso = LocalDate.of(2021, 06, 25);
		when(publicacion.getPeriodoDeAlquiler()).thenReturn(periodoDeAlquiler);
		when(periodoDeAlquiler.getFechaDeIngreso()).thenReturn(fechaDeIngreso);
		assertEquals(0, cancelacionIntermedia.montoACobrar(publicacion, fechaActual));
	}
	
	@Test
	void montoACobrarTestMitadDePrecio() {
		LocalDate fechaActual = LocalDate.of(2021, 06, 1);
		LocalDate fechaDeIngreso = LocalDate.of(2021, 06, 11);
		when(publicacion.getPeriodoDeAlquiler()).thenReturn(periodoDeAlquiler);
		when(periodoDeAlquiler.getFechaDeIngreso()).thenReturn(fechaDeIngreso);
		when(publicacion.getMontoTotal()).thenReturn(1000);
		assertEquals(500, cancelacionIntermedia.montoACobrar(publicacion, fechaActual));
	}
	
	@Test
	void montoACobrarTestTotalidad() {
		LocalDate fechaActual = LocalDate.of(2021, 06, 5);
		LocalDate fechaDeIngreso = LocalDate.of(2021, 06, 10);
		when(publicacion.getPeriodoDeAlquiler()).thenReturn(periodoDeAlquiler);
		when(periodoDeAlquiler.getFechaDeIngreso()).thenReturn(fechaDeIngreso);
		when(publicacion.getMontoTotal()).thenReturn(1000);
		assertEquals(1000, cancelacionIntermedia.montoACobrar(publicacion, fechaActual));
	}
}
