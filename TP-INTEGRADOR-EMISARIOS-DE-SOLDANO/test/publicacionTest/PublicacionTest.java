package publicacionTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cancelacion.Cancelacion;
import enumerativos.FormasDePago;
import estadosPublicacion.EstadoDisponible;
import estadosPublicacion.EstadoFinalizado;
import notificaciones.Observer;
import publicacion.Inmueble;
import publicacion.Publicacion;
import publicacion.Reseña;
import tiempo.CheckTime;
import tiempo.PeriodoDeAlquiler;
import usuarioSAT.UsuarioSAT;

class PublicacionTest {
	private UsuarioSAT propietario;
	private Inmueble inmueble;
	private List<FormasDePago> formasDePagoAcpetadas;
	private PeriodoDeAlquiler periodoDeAlquiler;
	private CheckTime checktime;
	private Cancelacion tipoDeCancelacion;
	private Publicacion publicacionPrueba;
	private Reseña reseña;
	private EstadoFinalizado estado;
	private EstadoDisponible disponible;
	private Observer obs;
	
	@BeforeEach
	void setUp() throws Exception {
		
	//MOCK
	propietario = mock(UsuarioSAT.class);
	inmueble = mock(Inmueble.class);
	periodoDeAlquiler = mock(PeriodoDeAlquiler.class);
	checktime = mock(CheckTime.class);
	tipoDeCancelacion = mock(Cancelacion.class);
	reseña = mock(Reseña.class);
	estado = mock(EstadoFinalizado.class);
	disponible = mock(EstadoDisponible.class);
	obs = mock(Observer.class);
	//SUT
	formasDePagoAcpetadas = Arrays.asList(FormasDePago.EFECTIVO, FormasDePago.TARJETA_DE_DEBITO);
		
	publicacionPrueba = new Publicacion(1500, propietario, inmueble, formasDePagoAcpetadas,
											periodoDeAlquiler, checktime, tipoDeCancelacion);
	}
	
	//Getters
	@Test
	void getPropietarioTest() {
		assertEquals(propietario, publicacionPrueba.getPropietario());
	}
	
	@Test
	void getInmueblePublicadoTest() {
		assertEquals(inmueble, publicacionPrueba.getInmueblePublicado());
	}
	
	@Test
	void getPeriodoDeAlquilerTest() {
		assertEquals(periodoDeAlquiler, publicacionPrueba.getPeriodoDeAlquiler());
	}
	
	@Test
	void getCheckTimeTest() {
		assertEquals(checktime, publicacionPrueba.getCheckTime());
	}
	
	@Test
	void getPrecioPorDiaTest() {
		assertEquals(1500, publicacionPrueba.getPrecioPorDia());
	}
	
	@Test
	void getFormasDePagoTest() {
		assertEquals(formasDePagoAcpetadas, publicacionPrueba.getFormasDePago());
	}
	
	@Test
	void getTipoDeCancelacionTest() {
		assertEquals(tipoDeCancelacion, publicacionPrueba.getTipoDeCancelacion());
	}
	
	@Test
	void getMontoTotalTest() {
		when(periodoDeAlquiler.diasAlquiladosTotales()).thenReturn(15);
		assertEquals(1500*15, publicacionPrueba.getMontoTotal());
	}
	
	@Test
	void cargarReseñarInmuebleAsociadoTest() {
		publicacionPrueba.setEstado(estado);
		publicacionPrueba.cargarReseñarInmuebleAsociado(reseña);
		verify(estado).reseñarInmuebleAsociado(publicacionPrueba, reseña);
	}
	@Test
	void finalizarPublicacionTest() {
		publicacionPrueba.setEstado(disponible);
		publicacionPrueba.finalizarPublicacion();
		verify(disponible).finalizarPublicacion(publicacionPrueba);
	}
	
	@Test
	void suscribirTest() {
		publicacionPrueba.setEstado(disponible);
		publicacionPrueba.suscribir(obs);
		verify(disponible).suscribir(publicacionPrueba, obs);
	}
	
	@Test
	void quitarTest() {
		publicacionPrueba.setEstado(disponible);
		publicacionPrueba.suscribir(obs);
		publicacionPrueba.quitar(obs);
		verify(disponible).quitar(publicacionPrueba, obs);
	}
	
}
