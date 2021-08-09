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
import estadosPublicacion.EstadoReservado;
import notificaciones.Interes;
import notificaciones.Observer;
import publicacion.Inmueble;
import publicacion.Publicacion;
import publicacion.Reseña;
import tiempo.CheckTime;
import tiempo.PeriodoDeAlquiler;
import usuarioSAT.UsuarioSAT;

class EstadoReservadoTest {
	private EstadoReservado reservado;
	private Publicacion publi;
	private UsuarioSAT usuario;
	private Reseña reseña;
	private UsuarioSAT propietario;
	private Inmueble inmueble;
	private PeriodoDeAlquiler periodoDeAlquiler;
	private CheckTime checktime;
	private Cancelacion tipoDeCancelacion;
	private List<FormasDePago> formasDePagoAcpetadas;
	private UsuarioSAT usuario2;
	private Observer obs;
	
	
	@BeforeEach
	void setUp() throws Exception {
		//Mock
		usuario = mock(UsuarioSAT.class);
		usuario2 = mock(UsuarioSAT.class);
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
		reservado = new EstadoReservado();
	}
	

	@Test
	void aprobarReservaTest() {
		assertThrows(RuntimeException.class, ()->{reservado.aprobarReserva(usuario, publi);;});
	}
	
	@Test
	void cancelarReservarTest() {
		publi.reservar(usuario, FormasDePago.EFECTIVO);
		publi.reservar(usuario2, FormasDePago.EFECTIVO);
		publi.aprobarReserva(usuario);
		publi.setEstado(reservado);
		publi.cancelarReservar();
		assertEquals(usuario2, publi.getInquilino());	
	}
	
	@Test
	void cancelarReservarTestSinPendientes() {
		publi.setEstado(reservado);
		publi.cancelarReservar();
		assertTrue(publi.estaDisponible());
	}
	
	@Test
	void reseñarInmuebleAsociadoTest() {
		 assertThrows(RuntimeException.class, ()->{reservado.reseñarInmuebleAsociado(publi, reseña);;});
	}
	
	@Test
	void estaReservadoTest() {
		 assertTrue(reservado.estaReservado());
	}
	
	@Test
	void estaDisponibleTest() {
		 assertFalse(reservado.estaDisponible());
	}
	
	@Test
	void estaFinalizadoTest() {
		 assertFalse(reservado.estaFinalizado());
	}
	@Test
	void finalizarPublicacionTest() {
		when(periodoDeAlquiler.finalizoEstadia()).thenReturn(true);
		when(checktime.finalizoEstadia()).thenReturn(true);
		reservado.finalizarPublicacion(publi);
		assertTrue(publi.estaFinalizado());
	}
	
	@Test
	void suscribirTest() {
		reservado.suscribir(publi, obs);
		assertEquals(1,publi.getObserversInteresados().size());
	}
	
	@Test
	void quitarTest() {
		reservado.suscribir(publi, obs);
		reservado.suscribir(publi, obs);
		reservado.quitar(publi, obs);
		assertEquals(1,publi.getObserversInteresados().size());
	}
	
	@Test
	void notificarTestTrue() {
		when(obs.tieneElMismoInteresAsociado(Interes.BAJADEPRECIO)).thenReturn(true);
		reservado.suscribir(publi, obs);
		reservado.notificar(publi, Interes.BAJADEPRECIO);
		verify(obs).update(publi);
	}
	
	@Test
	void notificarTestFalse() {
		when(obs.tieneElMismoInteresAsociado(Interes.BAJADEPRECIO)).thenReturn(false);
		reservado.suscribir(publi, obs);
		reservado.notificar(publi, Interes.BAJADEPRECIO);
		verify(obs, never()).update(publi);
	}

}

