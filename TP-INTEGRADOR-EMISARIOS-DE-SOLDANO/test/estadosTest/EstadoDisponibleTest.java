package estadosTest;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cancelacion.Cancelacion;
import enumerativos.FormasDePago;
import estadosPublicacion.EstadoDisponible;
import notificaciones.Interes;
import notificaciones.Observer;
import publicacion.Inmueble;
import publicacion.Publicacion;
import publicacion.Reseña;
import tiempo.CheckTime;
import tiempo.PeriodoDeAlquiler;
import usuarioSAT.UsuarioSAT;

class EstadoDisponibleTest {
	private EstadoDisponible disponible;
	private Publicacion publi;
	private UsuarioSAT usuario;
	private Reseña reseña;
	private UsuarioSAT propietario;
	private Inmueble inmueble;
	private PeriodoDeAlquiler periodoDeAlquiler;
	private CheckTime checktime;
	private Cancelacion tipoDeCancelacion;
	private List<FormasDePago> formasDePagoAcpetadas;
	private Observer obs;
	
	
	@BeforeEach
	void setUp() throws Exception {
		//Mock
		usuario = mock(UsuarioSAT.class);
		reseña = mock(Reseña.class);
		propietario = mock(UsuarioSAT.class);
		inmueble = mock(Inmueble.class);
		periodoDeAlquiler = mock(PeriodoDeAlquiler.class);
		checktime = mock(CheckTime.class);
		tipoDeCancelacion = mock(Cancelacion.class);
		obs = mock(Observer.class);
		
		//SUT
		formasDePagoAcpetadas = Arrays.asList(FormasDePago.EFECTIVO, FormasDePago.TARJETA_DE_DEBITO);
		
		publi = new Publicacion(1500, propietario, inmueble, formasDePagoAcpetadas,
								periodoDeAlquiler, checktime, tipoDeCancelacion);
		disponible = new EstadoDisponible();
		publi.setEstado(disponible);
	}
	
	@Test
	void aprobarReservaTestRemoverInquilinoPendiente() {
		publi.reservar(usuario, FormasDePago.EFECTIVO);
		disponible.aprobarReserva(usuario, publi);
		assertEquals(0, publi.getInquilinosPendientes().size());	
	}
	
	@Test
	void aprobarReservaTestFormaDePagoInquilino() {
		publi.reservar(usuario, FormasDePago.EFECTIVO);
		disponible.aprobarReserva(usuario, publi);
		assertEquals(FormasDePago.EFECTIVO, publi.getFormaDePagoInquilino());
	}
	
	@Test
	void aprobarReservaTestCambioDeEstado() {
		publi.reservar(usuario, FormasDePago.EFECTIVO);
		disponible.aprobarReserva(usuario, publi);
		assertTrue(publi.estaReservado());
	}
	
	@Test
	void aprobarReservaTestSeReservo() {
		publi.reservar(usuario, FormasDePago.EFECTIVO);
		disponible.aprobarReserva(usuario, publi);
		verify(usuario).aprobarReserva(publi);
	}
	
	@Test
	void cancelarReservarTest() {
		assertThrows(RuntimeException.class, ()->{disponible.cancelarReservar(publi);;});
	}
	
	@Test
	void reseñarInmuebleAsociadoTest() {
		assertThrows(RuntimeException.class, ()->{disponible.reseñarInmuebleAsociado(publi, reseña);;});
	}
	
	@Test
	void estaDisponibleTest() {
		assertTrue(disponible.estaDisponible());
	}
	
	@Test
	void estaReservadoTest() {
		 assertFalse(disponible.estaReservado());
	}

	@Test
	void estaFinalizadoTest() {
		disponible.finalizarPublicacion(publi);
		assertTrue(publi.estaFinalizado());
	}
	
	@Test
	void quitarTest() {
		disponible.suscribir(publi, obs);
		disponible.suscribir(publi, obs);
		disponible.quitar(publi, obs);
		assertEquals(1,publi.getObserversInteresados().size());
	}
	
	@Test
	void notificarTestTrue() {
		when(obs.tieneElMismoInteresAsociado(Interes.BAJADEPRECIO)).thenReturn(true);
		disponible.suscribir(publi, obs);
		disponible.notificar(publi, Interes.BAJADEPRECIO);
		verify(obs).update(publi);
	}
	
	@Test
	void notificarTestFalse() {
		when(obs.tieneElMismoInteresAsociado(Interes.BAJADEPRECIO)).thenReturn(false);
		disponible.suscribir(publi, obs);
		disponible.notificar(publi, Interes.BAJADEPRECIO);
		verify(obs, never()).update(publi);
	}
}

