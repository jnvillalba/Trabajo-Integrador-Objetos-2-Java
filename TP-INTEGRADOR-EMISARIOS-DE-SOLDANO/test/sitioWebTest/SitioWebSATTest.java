package sitioWebTest;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import condicion.Ciudad;
import condicion.Condicion;
import publicacion.Inmueble;
import publicacion.Publicacion;
import publicacion.Reseña;
import sistemaSAT.Entidad;
import sistemaSAT.ModuloAdministracion;
import sistemaSAT.ModuloDePuntaje;
import sistemaSAT.SitioWebSAT;
import usuarioSAT.UsuarioSAT;

class SitioWebSATTest {
	private ArrayList<Publicacion> publicacionesRegistradas;
	private ModuloAdministracion moduloAdministracion;
	private ModuloDePuntaje moduloPuntaje;
	private Publicacion publicacionPrueba;
	private Condicion condicionTest;
	private SitioWebSAT sitioWebSAT;
	private UsuarioSAT usarioPrueba;
	private Inmueble inmueblePrueba;
	private UsuarioSAT usarioPruebaUno;
	private UsuarioSAT usarioPruebaDos;
	private UsuarioSAT usarioPruebaTres;
	private UsuarioSAT usarioPruebaCuatro;
	private UsuarioSAT usarioPruebaCinco;
	private UsuarioSAT usarioPruebaSeis;
	private UsuarioSAT usarioPruebaSiete;
	private UsuarioSAT usarioPruebaOcho;
	private UsuarioSAT usarioPruebaNueve;
	private UsuarioSAT usarioPruebaDiez;
	private UsuarioSAT usarioPruebaOnce;
	private UsuarioSAT usarioPruebaDoce;
	private Publicacion publicacionPruebaDos;
	private Publicacion publicacionPruebaTres;
	private Publicacion publicacionPruebaUno;
	private Publicacion publicacionPruebaCuatro;
	private Publicacion publicacionPruebaCinco;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		publicacionPruebaUno = mock(Publicacion.class);
		publicacionPruebaDos = mock(Publicacion.class);
		publicacionPruebaTres = mock(Publicacion.class);
		publicacionPruebaCuatro = mock(Publicacion.class);
		publicacionPruebaCinco = mock(Publicacion.class);
		usarioPrueba = mock(UsuarioSAT.class);
		moduloAdministracion = mock(ModuloAdministracion.class);
		moduloPuntaje = mock(ModuloDePuntaje.class);
		condicionTest = mock(Ciudad.class);
		inmueblePrueba = mock(Inmueble.class);
		publicacionesRegistradas = new ArrayList<Publicacion>();
		usarioPruebaUno = mock(UsuarioSAT.class);
		usarioPruebaDos = mock(UsuarioSAT.class);
		usarioPruebaTres = mock(UsuarioSAT.class);
		usarioPruebaCuatro = mock(UsuarioSAT.class);
		usarioPruebaCinco = mock(UsuarioSAT.class);
		usarioPruebaSeis = mock(UsuarioSAT.class);
		usarioPruebaSiete = mock(UsuarioSAT.class);
		usarioPruebaOcho = mock(UsuarioSAT.class);
		usarioPruebaNueve = mock(UsuarioSAT.class);
		usarioPruebaDiez = mock(UsuarioSAT.class);
		usarioPruebaOnce = mock(UsuarioSAT.class);
		usarioPruebaDoce = mock(UsuarioSAT.class);
		
		sitioWebSAT = new SitioWebSAT(moduloAdministracion, moduloPuntaje);
	}

	@Test
	void registrarUsuarioTest() {
		sitioWebSAT.registrarUsuario(usarioPrueba);
		assertEquals(1, sitioWebSAT.getUsuariosSAT().size());
	}
	
	@Test
	void registrarPublicacionTest() {	
		publicacionesRegistradas.add(publicacionPrueba);
		sitioWebSAT.registrarPublicaciones(publicacionesRegistradas, usarioPrueba);
		assertEquals(1, sitioWebSAT.getPublicacionesRegistradas().size());
	}
	
	@Test
	void buscarPublicacionesTest() {
		sitioWebSAT.buscarPublicaciones(condicionTest);
		verify(condicionTest).filtar(publicacionesRegistradas);
	}
	
	@Test
	void getCategoriasConPromedioInmuebleTest() {
		ArrayList<Reseña> reseñas = new ArrayList<Reseña>();
		HashSet<String> categorias = new HashSet<String>();
		sitioWebSAT.getCategoriasConPromedioInmueble(inmueblePrueba);
		when(inmueblePrueba.getReseñas()).thenReturn(reseñas);
		when(moduloAdministracion.getCategoriasDeEntidad(Entidad.INMUEBLE)).thenReturn(categorias);
		verify(moduloPuntaje).categoriasConPromedioDePuntajes(reseñas, categorias);
	}
	
	@Test
	void getCategoriasConPromedioPropietarioTest() {
		ArrayList<Reseña> reseñas = new ArrayList<Reseña>();
		HashSet<String> categorias = new HashSet<String>();
		sitioWebSAT.getCategoriasConPromedioPropietario(usarioPrueba);
		when(usarioPrueba.getReseñasComoPropietario()).thenReturn(reseñas);
		when(moduloAdministracion.getCategoriasDeEntidad(Entidad.PROPIETARIO)).thenReturn(categorias);
		verify(moduloPuntaje).categoriasConPromedioDePuntajes(reseñas, categorias);
	}
	
	@Test
	void inquilinosQueMasAlquilaronTest() {
		sitioWebSAT.registrarUsuario(usarioPruebaUno);
		sitioWebSAT.registrarUsuario(usarioPruebaDos);
		sitioWebSAT.registrarUsuario(usarioPruebaTres);
		sitioWebSAT.registrarUsuario(usarioPruebaCuatro);
		sitioWebSAT.registrarUsuario(usarioPruebaCinco);
		sitioWebSAT.registrarUsuario(usarioPruebaSeis);
		sitioWebSAT.registrarUsuario(usarioPruebaSiete);
		sitioWebSAT.registrarUsuario(usarioPruebaOcho);
		sitioWebSAT.registrarUsuario(usarioPruebaNueve);
		sitioWebSAT.registrarUsuario(usarioPruebaDiez);
		sitioWebSAT.registrarUsuario(usarioPruebaOnce);
		sitioWebSAT.registrarUsuario(usarioPruebaDoce);
		when(usarioPruebaUno.cantidadDeReservas()).thenReturn(9);
		when(usarioPruebaDos.cantidadDeReservas()).thenReturn(8);
		when(usarioPruebaTres.cantidadDeReservas()).thenReturn(7);
		when(usarioPruebaCuatro.cantidadDeReservas()).thenReturn(1);
		when(usarioPruebaCinco.cantidadDeReservas()).thenReturn(5);
		when(usarioPruebaSeis.cantidadDeReservas()).thenReturn(4);
		when(usarioPruebaSiete.cantidadDeReservas()).thenReturn(6);
		when(usarioPruebaOcho.cantidadDeReservas()).thenReturn(11);
		when(usarioPruebaNueve.cantidadDeReservas()).thenReturn(12);
		when(usarioPruebaDiez.cantidadDeReservas()).thenReturn(3);
		when(usarioPruebaOnce.cantidadDeReservas()).thenReturn(2);
		when(usarioPruebaDoce.cantidadDeReservas()).thenReturn(10);
		HashMap<UsuarioSAT, Integer> map = new HashMap<UsuarioSAT, Integer>();
		map.put(usarioPruebaNueve, 12);
		map.put(usarioPruebaOcho, 11);
		map.put(usarioPruebaDoce, 10);
		map.put(usarioPruebaUno, 9);
		map.put(usarioPruebaDos, 8);
		map.put(usarioPruebaTres, 7);
		map.put(usarioPruebaSiete, 6);
		map.put(usarioPruebaCinco, 5);
		map.put(usarioPruebaSeis, 4);
		map.put(usarioPruebaDiez, 3);
		assertEquals(map, sitioWebSAT.inquilinosQueMasAlquilaron());
	}
	
	@Test
	void obtenerTodasLasPublicacionesSinReservaTest() {
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionPruebaUno);
		publicaciones.add(publicacionPruebaDos);
		publicaciones.add(publicacionPruebaTres);
		publicaciones.add(publicacionPruebaCuatro);
		publicaciones.add(publicacionPruebaCinco);
		sitioWebSAT.registrarPublicaciones(publicaciones, usarioPrueba);
		when(publicacionPruebaUno.estaDisponible()).thenReturn(true);
		when(publicacionPruebaDos.estaDisponible()).thenReturn(true);
		when(publicacionPruebaTres.estaDisponible()).thenReturn(false);
		when(publicacionPruebaCuatro.estaDisponible()).thenReturn(true);
		when(publicacionPruebaCinco.estaDisponible()).thenReturn(false);
		assertEquals(3, sitioWebSAT.obtenerTodasLasPublicacionesSinReserva().size());
	}
	
	@Test
	void obtenerTasaDeOcupacionDelSitioTest() {
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionPruebaUno);
		publicaciones.add(publicacionPruebaDos);
		publicaciones.add(publicacionPruebaTres);
		publicaciones.add(publicacionPruebaCuatro);
		publicaciones.add(publicacionPruebaCinco);
		sitioWebSAT.registrarPublicaciones(publicaciones, usarioPrueba);
		when(publicacionPruebaUno.estaReservado()).thenReturn(true);
		when(publicacionPruebaDos.estaReservado()).thenReturn(true);
		when(publicacionPruebaTres.estaReservado()).thenReturn(false);
		when(publicacionPruebaCuatro.estaReservado()).thenReturn(true);
		when(publicacionPruebaCinco.estaReservado()).thenReturn(false);
		assertEquals(60, sitioWebSAT.obtenerTasaDeOcupacionDelSitio());
	}
}



