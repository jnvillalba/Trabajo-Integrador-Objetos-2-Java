package sitioWebTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicacion.Rese�a;

class ModuloDePuntajeCopyTest {
	private ModuloDePuntajeCopy modulo;
	private Rese�a rese�aUno;
	private Rese�a rese�aDos;
	private Rese�a rese�aTres;
	private Rese�a rese�aCuatro;
	
	@BeforeEach
	void setUp() {
		modulo = new ModuloDePuntajeCopy();
		rese�aUno =  mock(Rese�a.class);
		rese�aDos =  mock(Rese�a.class);
		rese�aTres =  mock(Rese�a.class);
		rese�aCuatro =  mock(Rese�a.class);
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
		ArrayList<Rese�a> rese�as = new ArrayList<Rese�a>();
		rese�as.add(rese�aUno);
		rese�as.add(rese�aDos);
		rese�as.add(rese�aTres);
		rese�as.add(rese�aCuatro);
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
		when(rese�aUno.getPuntaje()).thenReturn(5);
		when(rese�aDos.getPuntaje()).thenReturn(2);
		when(rese�aTres.getPuntaje()).thenReturn(3);
		when(rese�aCuatro.getPuntaje()).thenReturn(4);
		when(rese�aUno.getNombreCategoria()).thenReturn("Limpio");
		when(rese�aDos.getNombreCategoria()).thenReturn("Ordenado");
		when(rese�aTres.getNombreCategoria()).thenReturn("Limpio");
		when(rese�aCuatro.getNombreCategoria()).thenReturn("Ordenado");
		assertEquals(categoriasConAcumulacion , modulo.categoriasConListaDePuntajes(rese�as, categorias));
	}
	
	@Test
	void puntajeTotalTest() {		
		ArrayList<Rese�a> rese�as = new ArrayList<Rese�a>();
		rese�as.add(rese�aUno);
		rese�as.add(rese�aDos);
		rese�as.add(rese�aTres);
		rese�as.add(rese�aCuatro);
		when(rese�aUno.getPuntaje()).thenReturn(5);
		when(rese�aDos.getPuntaje()).thenReturn(1);
		when(rese�aTres.getPuntaje()).thenReturn(3);
		when(rese�aCuatro.getPuntaje()).thenReturn(2);
		assertEquals(2.75, modulo.puntajeTotal(rese�as));
	}
	
}