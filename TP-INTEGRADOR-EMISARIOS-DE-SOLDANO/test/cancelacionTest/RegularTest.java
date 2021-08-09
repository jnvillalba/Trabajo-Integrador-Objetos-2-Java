package cancelacionTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cancelacion.Cancelacion;
import cancelacion.Intermedia;
import cancelacion.Regular;
import publicacion.Publicacion;
import tiempo.PeriodoDeAlquiler;

@SuppressWarnings("unused")
class RegularTest {
	private Cancelacion cancelacionRegular;
	private Publicacion publicacion;
	private PeriodoDeAlquiler periodoDeAlquiler;
	
	@BeforeEach
	void setUp() {
		cancelacionRegular = new Regular();
		publicacion = mock(Publicacion.class);
		periodoDeAlquiler = mock(PeriodoDeAlquiler.class);
	}

	@Test
	void montoACobrarTestGratuita() {
		LocalDate fechaActual = LocalDate.of(2021, 06, 1);
		LocalDate fechaDeIngreso = LocalDate.of(2021, 06, 12);
		when(publicacion.getPeriodoDeAlquiler()).thenReturn(periodoDeAlquiler);
		when(periodoDeAlquiler.getFechaDeIngreso()).thenReturn(fechaDeIngreso);
		when(periodoDeAlquiler.getFechaDeIngreso()).thenReturn(fechaDeIngreso);
		assertEquals(0, cancelacionRegular.montoACobrar(publicacion, fechaActual));
	}
	
	@Test
	void montoACobrarTestPaga() {
		LocalDate fechaActual = LocalDate.of(2021, 06, 1);
		LocalDate fechaDeIngreso = LocalDate.of(2021, 06, 5);
		when(publicacion.getPeriodoDeAlquiler()).thenReturn(periodoDeAlquiler);
		when(publicacion.getPrecioPorDia()).thenReturn(150);
		when(periodoDeAlquiler.getFechaDeIngreso()).thenReturn(fechaDeIngreso);
		assertEquals(300, cancelacionRegular.montoACobrar(publicacion, fechaActual));
	}
}
