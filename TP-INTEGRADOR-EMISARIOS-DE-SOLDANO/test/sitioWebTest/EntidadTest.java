package sitioWebTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaSAT.Entidad;

class EntidadTest {
	private Entidad inmuble;
	private Entidad inquilino;
	
	@BeforeEach
	void setUp() throws Exception {
		inmuble = Entidad.INMUEBLE;
		inquilino = Entidad.INQUILINO;
	}

	@Test
	void esLaEntidadBuscadaTestCasoFalso() {
		assertFalse(inmuble.esLaEntidadBuscada(inquilino));
	}
	
	@Test
	void esLaEntidadBuscadaTestCasoVerdadero() {
		assertTrue(inmuble.esLaEntidadBuscada(inmuble));
	}

}
