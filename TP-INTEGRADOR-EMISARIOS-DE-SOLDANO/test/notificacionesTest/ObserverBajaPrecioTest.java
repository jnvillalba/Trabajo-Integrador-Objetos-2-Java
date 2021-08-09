package notificacionesTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import notificaciones.Interes;
import notificaciones.ObserverBajaDePrecio;
import publicacion.Publicacion;

class ObserverBajaPrecioTest {

	private ObserverBajaDePrecio observer;
	private Publicacion publicacionUno;
	
	@BeforeEach
	void setUp() {
		observer = new ObserverBajaDePrecio();
		publicacionUno = mock(Publicacion.class);
	}

	@Test
	void updateTest() {
		observer.update(publicacionUno);
	}

	@Test
	void tieneElMismoInteresAsociadoTestCasoVerdadero() {
		assertTrue(observer.tieneElMismoInteresAsociado(Interes.BAJADEPRECIO));
	}

	@Test
	void tieneElMismoInteresAsociadoTestCasoFalso() {
		assertFalse(observer.tieneElMismoInteresAsociado(Interes.CANCELACION));
	}
}