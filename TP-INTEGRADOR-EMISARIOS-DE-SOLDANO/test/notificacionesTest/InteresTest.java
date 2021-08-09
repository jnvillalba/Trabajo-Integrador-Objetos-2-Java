package notificacionesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import notificaciones.Interes;

class InteresTest {
	private Interes interesUno;
	private Interes interesDos;
	private Interes interesTres;
	@BeforeEach
	void setUp() throws Exception {
		interesUno = Interes.BAJADEPRECIO;
		interesDos = Interes.RESERVA;
		interesTres = Interes.RESERVA;
	}

	@Test
	void esElInteresBuscadoTestCasoVerdadero() {
		assertTrue(interesTres.esElInteresBuscado(interesDos));
	}

	@Test
	void esElInteresBuscadoTestCasoFalso() {
		assertFalse(interesUno.esElInteresBuscado(interesDos));
	}
}