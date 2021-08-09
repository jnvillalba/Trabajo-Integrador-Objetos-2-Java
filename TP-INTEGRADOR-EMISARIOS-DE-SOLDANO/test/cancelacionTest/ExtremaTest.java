package cancelacionTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cancelacion.Cancelacion;
import cancelacion.Extrema;
import publicacion.Publicacion;

class ExtremaTest {
	private Cancelacion cancelacionExtrema;
	private Publicacion publicacion;
	private LocalDate fechaPrueba;
	
	@BeforeEach
	void setUp() {
		cancelacionExtrema = new Extrema();
		publicacion = mock(Publicacion.class);
		fechaPrueba = mock(LocalDate.class);
	}

	@Test
	void montoACobrarTestGratuita() {
		when(publicacion.getMontoTotal()).thenReturn(1000);
		assertEquals(1000, cancelacionExtrema.montoACobrar(publicacion, fechaPrueba));
	}
}
