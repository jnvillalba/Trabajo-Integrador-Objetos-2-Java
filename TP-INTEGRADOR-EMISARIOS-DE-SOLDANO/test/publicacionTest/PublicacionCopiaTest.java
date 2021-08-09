package publicacionTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cancelacion.Cancelacion;
import enumerativos.FormasDePago;
import estadosPublicacion.EstadoReservado;
import publicacion.Inmueble;
import tiempo.CheckTime;
import tiempo.PeriodoDeAlquiler;
import usuarioSAT.UsuarioSAT;

class PublicacionCopiaTest {
	private PublicacionCopia publicacion;
	private UsuarioSAT propietario;
	private UsuarioSAT inquilinoNuevo;
	private UsuarioSAT inquilinoNuevo2;
	private UsuarioSAT inquilinoNuevo3;
	private Inmueble inmueble;
	private List<FormasDePago> formasDePagoAcpetadas;
	private PeriodoDeAlquiler periodoDeAlquiler;
	private CheckTime checktime;
	private Cancelacion tipoDeCancelacion;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//MOCK
		
		propietario = mock(UsuarioSAT.class);
		inmueble = mock(Inmueble.class);
		periodoDeAlquiler = mock(PeriodoDeAlquiler.class);
		checktime = mock(CheckTime.class);
		tipoDeCancelacion = mock(Cancelacion.class);
		inquilinoNuevo = mock(UsuarioSAT.class);
		inquilinoNuevo2 = mock(UsuarioSAT.class);
		inquilinoNuevo3 = mock(UsuarioSAT.class);
		
		//SUT
		formasDePagoAcpetadas = Arrays.asList(FormasDePago.EFECTIVO, FormasDePago.TARJETA_DE_DEBITO);
		
		publicacion = new PublicacionCopia(1500, propietario, inmueble, formasDePagoAcpetadas,
												periodoDeAlquiler, checktime, tipoDeCancelacion);
	}
	
	@Test
	void getInquilinosPendientesTest() {
		assertEquals(0,publicacion.getInquilinosPendientes().size());
	}
	
	@Test
	void setInquilinoTest() {
		publicacion.setInquilino(inquilinoNuevo);
		assertEquals(publicacion.getInquilino(), inquilinoNuevo);
	}
	
	@Test
	void setEstadoTest() {
		publicacion.setEstado(new EstadoReservado());
		assertTrue(publicacion.estaReservado());
	}
	
	@Test
	void agregarAInquilinosPendientesTest() {
		publicacion.agregarAInquilinosPendientes(inquilinoNuevo);
		assertEquals(1,publicacion.getInquilinosPendientes().size());
	}
	
	@Test
	void removerAInquilinosPendientesTest() {
		publicacion.agregarAInquilinosPendientes(inquilinoNuevo);
		publicacion.agregarAInquilinosPendientes(inquilinoNuevo2);
		publicacion.agregarAInquilinosPendientes(inquilinoNuevo3);
		publicacion.removerAInquilinosPendientes(inquilinoNuevo);
		assertEquals(2,publicacion.getInquilinosPendientes().size());
	}
	
	@Test
	void setFormaDePagoInquilinoTest() {
		publicacion.setFormaDePagoInquilino(FormasDePago.EFECTIVO);
		assertEquals(publicacion.getFormaDePagoInquilino(), FormasDePago.EFECTIVO);
	}
}
