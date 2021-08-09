package notificacionesTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import notificaciones.Interes;
import notificaciones.ObserverCancelacion;
import publicacion.Publicacion;

class ObserverCancelacionTest {
	private ObserverCancelacion observer;
	private Publicacion publicacionUno;
	
	@BeforeEach
	void setUp() {
		observer = new ObserverCancelacion();
		publicacionUno = mock(Publicacion.class);
	}

	@Test
	void updateTest() {
		observer.update(publicacionUno);
	}
	
	@Test
	void tieneElMismoInteresAsociadoTestCasoVerdadero() {
		assertTrue(observer.tieneElMismoInteresAsociado(Interes.CANCELACION));
	}

	@Test
	void tieneElMismoInteresAsociadoTestCasoFalso() {
		assertFalse(observer.tieneElMismoInteresAsociado(Interes.BAJADEPRECIO));
	}
}
