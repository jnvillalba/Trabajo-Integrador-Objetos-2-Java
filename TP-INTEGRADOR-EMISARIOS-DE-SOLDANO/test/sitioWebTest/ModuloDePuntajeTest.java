package sitioWebTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicacion.Inmueble;
import publicacion.Reseña;
import sistemaSAT.ModuloDePuntaje;
import usuarioSAT.UsuarioSAT;

class ModuloDePuntajeTest {
	private ModuloDePuntaje modulo;
	private Reseña reseñaUno;
	private Reseña reseñaDos;
	private Reseña reseñaTres;
	private Reseña reseñaCuatro;
	private Inmueble inmueblePrueba;
	private UsuarioSAT usarioPrueba;
	
	@BeforeEach
	void setUp() {
		modulo = new ModuloDePuntaje();
		reseñaUno =  mock(Reseña.class);
		reseñaDos =  mock(Reseña.class);
		reseñaTres =  mock(Reseña.class);
		reseñaCuatro =  mock(Reseña.class);
		inmueblePrueba = mock(Inmueble.class);
		usarioPrueba = mock(UsuarioSAT.class);
	}

	@Test
	void categoriasConPromedioDePuntajesTest() {
		ArrayList<Reseña> reseñas = new ArrayList<Reseña>();
		reseñas.add(reseñaUno);
		reseñas.add(reseñaDos);
		reseñas.add(reseñaTres);
		reseñas.add(reseñaCuatro);
		HashSet<String> categorias = new HashSet<String>();
		categorias.add("Limpio");
		categorias.add("Ordenado");
		when(reseñaUno.getPuntaje()).thenReturn(5);
		when(reseñaDos.getPuntaje()).thenReturn(1);
		when(reseñaTres.getPuntaje()).thenReturn(3);
		when(reseñaCuatro.getPuntaje()).thenReturn(2);
		when(reseñaUno.getNombreCategoria()).thenReturn("Limpio");
		when(reseñaDos.getNombreCategoria()).thenReturn("Ordenado");
		when(reseñaTres.getNombreCategoria()).thenReturn("Limpio");
		when(reseñaCuatro.getNombreCategoria()).thenReturn("Ordenado");
		HashMap<String, Double> categoriasPromediadas = new HashMap<String, Double>();
		categoriasPromediadas.put("Limpio", (double) 4.0);
		categoriasPromediadas.put("Ordenado", (double) 1.5);
		assertEquals(categoriasPromediadas, modulo.categoriasConPromedioDePuntajes(reseñas, categorias));
	}
	
	@Test
	void puntajeTotalInmuebleTest() {
		ArrayList<Reseña> reseñas = new ArrayList<Reseña>();
		reseñas.add(reseñaUno);
		reseñas.add(reseñaDos);
		reseñas.add(reseñaTres);
		reseñas.add(reseñaCuatro);
		when(reseñaUno.getPuntaje()).thenReturn(5);
		when(reseñaDos.getPuntaje()).thenReturn(1);
		when(reseñaTres.getPuntaje()).thenReturn(3);
		when(reseñaCuatro.getPuntaje()).thenReturn(2);
		when(inmueblePrueba.getReseñas()).thenReturn(reseñas);
		assertEquals(2.75, modulo.puntajeTotalInmueble(inmueblePrueba));
	}
	
	@Test
	void puntajeTotalPropietarioTest() {
		ArrayList<Reseña> reseñas = new ArrayList<Reseña>();
		reseñas.add(reseñaUno);
		reseñas.add(reseñaDos);
		reseñas.add(reseñaTres);
		reseñas.add(reseñaCuatro);
		when(reseñaUno.getPuntaje()).thenReturn(5);
		when(reseñaDos.getPuntaje()).thenReturn(1);
		when(reseñaTres.getPuntaje()).thenReturn(3);
		when(reseñaCuatro.getPuntaje()).thenReturn(2);
		when(usarioPrueba.getReseñasComoPropietario()).thenReturn(reseñas);
		assertEquals(2.75, modulo.puntajeTotalPropietario(usarioPrueba));
	}
}