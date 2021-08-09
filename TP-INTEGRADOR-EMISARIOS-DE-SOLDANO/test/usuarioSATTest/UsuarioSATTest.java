package usuarioSATTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import modoDeFiltrado.ModoDeFiltrado;
import publicacion.Inmueble;
import publicacion.Publicacion;
import publicacion.Reseña;
import usuarioSAT.UsuarioSAT;

public class UsuarioSATTest {
	UsuarioSAT usuario;
	UsuarioSATCopia usuarioCopia;
	Inmueble inmueblePrueba;
	Inmueble inmueblePruebaDos;
	Publicacion publicacionUno;
	Publicacion publicacionDos;
	Publicacion publicacionTres;
	Publicacion publicacionCuatro;
	ModoDeFiltrado filtrarTodas;
	Reseña reseña;
	
	@Before
	public void setUp() throws Exception {
		// SUT
		usuario = new UsuarioSAT("", "", 0);
		// Esta clase copia la creo para poder testear las listas.
		usuarioCopia = new UsuarioSATCopia("", "", 0);
		
		// Mocks
		inmueblePrueba = mock(Inmueble.class);
		inmueblePruebaDos = mock(Inmueble.class);
		publicacionUno = mock(Publicacion.class);
		publicacionDos = mock(Publicacion.class);
		publicacionTres = mock(Publicacion.class);
		publicacionCuatro = mock(Publicacion.class);
		filtrarTodas = mock(ModoDeFiltrado.class);
		reseña = mock(Reseña.class);
	}
	
	@Test
	public void sePuedeObtenerLaListaDeInmueblesDelUsuario() {
		List<Inmueble> listaEsperada = new ArrayList<>();
		assertEquals(listaEsperada, usuario.getInmuebles());
	}
	
	@Test
	public void elUsuarioPuedeCargarUnInmuebleEnElSitio() {
		List<String> lista1 = new ArrayList<>();
		List<String> lista2 = new ArrayList<>();
		
		usuario.darDeAltaInmueble("", 0, "", "", "", lista1, 0, lista2);
		
		assertEquals(1, usuario.getInmuebles().size());
	}
	
	@Test
	public void sePuedenObtenerTodasLasReservasHechasPorElUsuario() {
		List<Publicacion> listaEsperada = new ArrayList<>(); listaEsperada.add(publicacionUno);
		usuarioCopia.historialDeReservas.add(publicacionUno);
		when(filtrarTodas.filtrar(usuarioCopia.historialDeReservas)).thenReturn(usuarioCopia.historialDeReservas);
		
		assertEquals(listaEsperada, usuarioCopia.getReservas(filtrarTodas));
	}
	
	@Test
	public void seConocenLasCiudadesEnLasQueSeTieneReserva() {
		String ciudadBuscada = "Buenos Aires";
		List<String> listaEsperada = new ArrayList<>(); listaEsperada.add(ciudadBuscada);
		when(publicacionUno.getInmueblePublicado()).thenReturn(inmueblePrueba);
		when(inmueblePrueba.getCiudad()).thenReturn(ciudadBuscada);
		usuarioCopia.historialDeReservas.add(publicacionUno);
		
		assertEquals(listaEsperada, usuarioCopia.getCiudadesConReserva(ciudadBuscada));
	}
	
	@Test
	public void elUsuarioPuedeRecibirUnaReseñaComoInquilino() {
		List<Reseña> listaEsperada = new ArrayList<>(); listaEsperada.add(reseña);
		
		usuario.agregarReseñaInquilino(reseña);
		
		assertEquals(listaEsperada, usuario.getReseñasComoInquilino());
	}
	
	@Test
	public void elUsuarioPuedeRecibirUnaReseñaComoPropietario() {
		List<Reseña> listaEsperada = new ArrayList<>(); listaEsperada.add(reseña);
		
		usuario.agregarReseñaPropietario(reseña);
		
		assertEquals(listaEsperada, usuario.getReseñasComoPropietario());
	}
	
	@Test
	public void unUsuarioPuedeAprobarUnaReservaHecha() {
		UsuarioSAT inquilino = mock(UsuarioSAT.class);
		
		usuario.aprobarInquilino(publicacionUno, inquilino);
		
		verify(publicacionUno).aprobarReserva(inquilino);
	}
	
	@Test
	public void unUsuarioPuedeCancelarUnaReservaQueHizo() {
		UsuarioSAT propietario = new UsuarioSAT(null, null, 0);
		propietario.aprobarInquilino(publicacionUno, usuario);
		
		usuario.cancelarReservaHecha(publicacionUno);
		
		assertTrue(usuario.getReservas(filtrarTodas).isEmpty());
	}
	
	@Test
	public void elUsuarioConoceLaCantidadDeVecesQueAlquilo() {
		usuario.aprobarReserva(publicacionUno);
		
		assertEquals(1, usuario.cantidadDeReservas());
	}
	
	@Test
	public void cantidadDePublicacionesConInmuebleTest() {
		List<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionUno);
		publicaciones.add(publicacionDos);
		publicaciones.add(publicacionTres);
		publicaciones.add(publicacionCuatro);
		usuario.cargarPublicaciones(publicaciones);
		when(publicacionUno.getInmueblePublicado()).thenReturn(inmueblePrueba);
		when(publicacionDos.getInmueblePublicado()).thenReturn(inmueblePrueba);
		when(publicacionTres.getInmueblePublicado()).thenReturn(inmueblePrueba);
		when(publicacionCuatro.getInmueblePublicado()).thenReturn(inmueblePrueba);
		assertEquals(4, usuario.cantidadDePublicacionesConInmueble(inmueblePrueba));
	}
	
	@Test
	public void cantidadDeAlquileresRealizadosTest() {
		List<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionUno);
		publicaciones.add(publicacionDos);
		publicaciones.add(publicacionTres);
		publicaciones.add(publicacionCuatro);
		usuario.cargarPublicaciones(publicaciones);
		assertEquals(4, usuario.cantidadDeAlquileresRealizados());
	}
	
	@Test
	public void inmueblesQueAlquiloTest() {
		HashSet<Inmueble> inmuebles = new HashSet<Inmueble>();
		inmuebles.add(inmueblePrueba);
		inmuebles.add(inmueblePruebaDos);
		List<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionUno);
		publicaciones.add(publicacionDos);
		publicaciones.add(publicacionTres);
		publicaciones.add(publicacionCuatro);
		usuario.cargarPublicaciones(publicaciones);
		when(publicacionUno.getInmueblePublicado()).thenReturn(inmueblePrueba);
		when(publicacionDos.getInmueblePublicado()).thenReturn(inmueblePruebaDos);
		when(publicacionTres.getInmueblePublicado()).thenReturn(inmueblePrueba);
		when(publicacionCuatro.getInmueblePublicado()).thenReturn(inmueblePruebaDos);
		assertEquals(inmuebles, usuario.inmueblesQueAlquilo());
	}
	
}
