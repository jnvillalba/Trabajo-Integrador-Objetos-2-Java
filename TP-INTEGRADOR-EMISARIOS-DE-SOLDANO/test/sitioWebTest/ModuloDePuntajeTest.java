package sitioWebTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicacion.Inmueble;
import publicacion.Rese�a;
import sistemaSAT.ModuloDePuntaje;
import usuarioSAT.UsuarioSAT;

class ModuloDePuntajeTest {
	private ModuloDePuntaje modulo;
	private Rese�a rese�aUno;
	private Rese�a rese�aDos;
	private Rese�a rese�aTres;
	private Rese�a rese�aCuatro;
	private Inmueble inmueblePrueba;
	private UsuarioSAT usarioPrueba;
	
	@BeforeEach
	void setUp() {
		modulo = new ModuloDePuntaje();
		rese�aUno =  mock(Rese�a.class);
		rese�aDos =  mock(Rese�a.class);
		rese�aTres =  mock(Rese�a.class);
		rese�aCuatro =  mock(Rese�a.class);
		inmueblePrueba = mock(Inmueble.class);
		usarioPrueba = mock(UsuarioSAT.class);
	}

	@Test
	void categoriasConPromedioDePuntajesTest() {
		ArrayList<Rese�a> rese�as = new ArrayList<Rese�a>();
		rese�as.add(rese�aUno);
		rese�as.add(rese�aDos);
		rese�as.add(rese�aTres);
		rese�as.add(rese�aCuatro);
		HashSet<String> categorias = new HashSet<String>();
		categorias.add("Limpio");
		categorias.add("Ordenado");
		when(rese�aUno.getPuntaje()).thenReturn(5);
		when(rese�aDos.getPuntaje()).thenReturn(1);
		when(rese�aTres.getPuntaje()).thenReturn(3);
		when(rese�aCuatro.getPuntaje()).thenReturn(2);
		when(rese�aUno.getNombreCategoria()).thenReturn("Limpio");
		when(rese�aDos.getNombreCategoria()).thenReturn("Ordenado");
		when(rese�aTres.getNombreCategoria()).thenReturn("Limpio");
		when(rese�aCuatro.getNombreCategoria()).thenReturn("Ordenado");
		HashMap<String, Double> categoriasPromediadas = new HashMap<String, Double>();
		categoriasPromediadas.put("Limpio", (double) 4.0);
		categoriasPromediadas.put("Ordenado", (double) 1.5);
		assertEquals(categoriasPromediadas, modulo.categoriasConPromedioDePuntajes(rese�as, categorias));
	}
	
	@Test
	void puntajeTotalInmuebleTest() {
		ArrayList<Rese�a> rese�as = new ArrayList<Rese�a>();
		rese�as.add(rese�aUno);
		rese�as.add(rese�aDos);
		rese�as.add(rese�aTres);
		rese�as.add(rese�aCuatro);
		when(rese�aUno.getPuntaje()).thenReturn(5);
		when(rese�aDos.getPuntaje()).thenReturn(1);
		when(rese�aTres.getPuntaje()).thenReturn(3);
		when(rese�aCuatro.getPuntaje()).thenReturn(2);
		when(inmueblePrueba.getRese�as()).thenReturn(rese�as);
		assertEquals(2.75, modulo.puntajeTotalInmueble(inmueblePrueba));
	}
	
	@Test
	void puntajeTotalPropietarioTest() {
		ArrayList<Rese�a> rese�as = new ArrayList<Rese�a>();
		rese�as.add(rese�aUno);
		rese�as.add(rese�aDos);
		rese�as.add(rese�aTres);
		rese�as.add(rese�aCuatro);
		when(rese�aUno.getPuntaje()).thenReturn(5);
		when(rese�aDos.getPuntaje()).thenReturn(1);
		when(rese�aTres.getPuntaje()).thenReturn(3);
		when(rese�aCuatro.getPuntaje()).thenReturn(2);
		when(usarioPrueba.getRese�asComoPropietario()).thenReturn(rese�as);
		assertEquals(2.75, modulo.puntajeTotalPropietario(usarioPrueba));
	}
}