package tiempoTest;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tiempo.PeriodoDeAlquiler;

class PeriodoDeAlquilerTest {
	private PeriodoDeAlquiler unaQuincena;
	private LocalDate inicio;
	private LocalDate fin;
	private PeriodoDeAlquiler checkOut;
	
	@BeforeEach
	void setUp() throws Exception {
		fin = LocalDate.of(2021, 01, 16);
		inicio = LocalDate.of(2021, 01, 1);
		
		unaQuincena = new PeriodoDeAlquiler(inicio, fin);
		checkOut = new PeriodoDeAlquiler(inicio, LocalDate.now());
	}
	
	
	@Test
	void TestPeriodoDeAlquilerDe15Dias() {
		assertEquals(unaQuincena.diasAlquiladosTotales(), 15);
	}
	
	@Test
	void getFechaDeIngresoTest() {
		assertEquals(unaQuincena.getFechaDeIngreso(), inicio);
	}
	
	@Test
	void getFechaDeEgresoTest() {
		assertEquals(unaQuincena.getFechaDeEgreso(), fin);
	}
	
	
	@Test
	void finalizoEstadiaTest() {
		assertTrue(checkOut.finalizoEstadia());
	}

}
