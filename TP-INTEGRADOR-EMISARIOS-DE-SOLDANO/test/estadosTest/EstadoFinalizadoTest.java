package estadosTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import estadosPublicacion.EstadoFinalizado;
import notificaciones.Interes;
import notificaciones.Observer;
import publicacion.Inmueble;
import publicacion.Publicacion;
import publicacion.Rese�a;
import usuarioSAT.UsuarioSAT;

class EstadoFinalizadoTest {
	private EstadoFinalizado finalizado;
	private Publicacion publi;
	private UsuarioSAT usuario;
	private Rese�a rese�a;
	private Observer observer;
	private Inmueble inmueble;
	
	@BeforeEach
	void setUp() throws Exception {
		//Mock
		publi = mock(Publicacion.class);
		usuario = mock(UsuarioSAT.class);
		rese�a = mock(Rese�a.class);
		observer = mock(Observer.class);
		inmueble = mock(Inmueble.class);
		
		//SUT
		finalizado = new EstadoFinalizado();
	}
	
	@Test
	void reservarTest() {
		assertThrows(RuntimeException.class, ()->{finalizado.reservar(usuario, publi);;});
	}

	@Test
	void aprobarReservaTest() {
		assertThrows(RuntimeException.class, ()->{finalizado.aprobarReserva(usuario, publi);;});
	}
	
	@Test
	void cancelarReservarTest() {
		assertThrows(RuntimeException.class, ()->{finalizado.cancelarReservar(publi);;});
	}
	
	@Test
	void estaFinalizadoTest() {
		 assertTrue(finalizado.estaFinalizado());
	}
	
	@Test
	void estaReservadoTest() {
		assertFalse(finalizado.estaReservado());
	}
	
	@Test
	void estaDisponibleTest() {
		 assertFalse(finalizado.estaDisponible());
	}

	@Test
	void finalizarPublicacionTest() {
		assertThrows(RuntimeException.class, ()->{finalizado.finalizarPublicacion(publi);;});
	}
	
	@Test
	void suscribirTest() {
		assertThrows(RuntimeException.class, ()->{finalizado.suscribir(publi, observer);;});
	}
	
	@Test
	void notificarTest() {
		assertThrows(RuntimeException.class, ()->{finalizado.notificar(publi, Interes.CANCELACION);;});
	}
	
	@Test
	void rese�arInmuebleAsociadoTest() {
		when(publi.getInmueblePublicado()).thenReturn(inmueble);
		finalizado.rese�arInmuebleAsociado(publi, rese�a);
		verify(inmueble).agregarRese�aInmueble(rese�a);
	}
	
	@Test
	void quitarTest() {
		finalizado.quitar(publi, observer);
		verify(publi).getObserversInteresados();
	}
}

