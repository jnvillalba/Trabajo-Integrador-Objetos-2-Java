package sitioWebTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicacion.Reseña;

class ModuloDePuntajeCopyTest {
	private ModuloDePuntajeCopy modulo;
	private Reseña reseñaUno;
	private Reseña reseñaDos;
	private Reseña reseñaTres;
	private Reseña reseñaCuatro;
	
	@BeforeEach
	void setUp() {
		modulo = new ModuloDePuntajeCopy();
		reseñaUno =  mock(Reseña.class);
		reseñaDos =  mock(Reseña.class);
		reseñaTres =  mock(Reseña.class);
		reseñaCuatro =  mock(Reseña.class);
	}

	@Test
	void sumatoriaTotalDePuntajesTest() {
		ArrayList<Integer> listaDeNumeros = new ArrayList<Integer>();
		listaDeNumeros.add(2);
		listaDeNumeros.add(5);
		listaDeNumeros.add(3);
		assertEquals(10, modulo.sumatoriaTotalDePuntajes(listaDeNumeros));
	}

	@Test
	void promedioDePuntajeTest() {
		ArrayList<Integer> listaDeNumeros = new ArrayList<Integer>();
		listaDeNumeros.add(2);
		listaDeNumeros.add(5);
		listaDeNumeros.add(3);
		assertEquals(3.3333333333333335 , modulo.promedioDePuntaje(listaDeNumeros));
	}
	
	@Test
	void categoriasParaPuntajeTest() {
		HashMap<String, List<Integer>> categoriasConAcumulacion = new HashMap<String, List<Integer>>();
		categoriasConAcumulacion.put("Limpio", new ArrayList<Integer>());
		categoriasConAcumulacion.put("Ordenado", new ArrayList<Integer>());
		HashSet<String> categorias = new HashSet<String>();
		categorias.add("Limpio");
		categorias.add("Ordenado");
		assertEquals(categoriasConAcumulacion , modulo.categoriasParaPuntaje(categorias));
	}
	
	@Test
	void categoriasConListaDePuntajesTest() {
		ArrayList<Reseña> reseñas = new ArrayList<Reseña>();
		reseñas.add(reseñaUno);
		reseñas.add(reseñaDos);
		reseñas.add(reseñaTres);
		reseñas.add(reseñaCuatro);
		HashSet<String> categorias = new HashSet<String>();
		categorias.add("Limpio");
		categorias.add("Ordenado");
		HashMap<String, List<Integer>> categoriasConAcumulacion = new HashMap<String, List<Integer>>();
		ArrayList<Integer> listaUno = new ArrayList<Integer>();
		ArrayList<Integer> listaDos = new ArrayList<Integer>();
		listaUno.add(5);
		listaUno.add(3);
		listaDos.add(2);
		listaDos.add(4);
		categoriasConAcumulacion.put("Limpio", listaUno);
		categoriasConAcumulacion.put("Ordenado", listaDos);
		when(reseñaUno.getPuntaje()).thenReturn(5);
		when(reseñaDos.getPuntaje()).thenReturn(2);
		when(reseñaTres.getPuntaje()).thenReturn(3);
		when(reseñaCuatro.getPuntaje()).thenReturn(4);
		when(reseñaUno.getNombreCategoria()).thenReturn("Limpio");
		when(reseñaDos.getNombreCategoria()).thenReturn("Ordenado");
		when(reseñaTres.getNombreCategoria()).thenReturn("Limpio");
		when(reseñaCuatro.getNombreCategoria()).thenReturn("Ordenado");
		assertEquals(categoriasConAcumulacion , modulo.categoriasConListaDePuntajes(reseñas, categorias));
	}
	
	@Test
	void puntajeTotalTest() {		
		ArrayList<Reseña> reseñas = new ArrayList<Reseña>();
		reseñas.add(reseñaUno);
		reseñas.add(reseñaDos);
		reseñas.add(reseñaTres);
		reseñas.add(reseñaCuatro);
		when(reseñaUno.getPuntaje()).thenReturn(5);
		when(reseñaDos.getPuntaje()).thenReturn(1);
		when(reseñaTres.getPuntaje()).thenReturn(3);
		when(reseñaCuatro.getPuntaje()).thenReturn(2);
		assertEquals(2.75, modulo.puntajeTotal(reseñas));
	}
	
}