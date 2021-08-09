package sitioWebTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sistemaSAT.Entidad;
import sistemaSAT.ModuloAdministracion;

class ModuloAdministracionTest {
	private Entidad inmuble;
	private ModuloAdministracion modulo;
	
	@BeforeEach
	void setUp() {
		inmuble = Entidad.INMUEBLE;
		modulo = new ModuloAdministracion();
	}

	@Test
	void darDeAltaCategoriaTest() {
		modulo.darDeAltaCategoria(inmuble, "Cocina limpia");
		assertEquals(1, modulo.getCategoriasPorEntidad().get(inmuble).size());
	}
	
	@Test
	void darDeAltaTipoDeInmuebleTest() {
		modulo.darDeAltaTipoDeInmueble("Cueva");
		assertEquals(1, modulo.getTiposDeInmueble().size());
	}
	
	@Test
	void darDeAltaServicio() {
		modulo.darDeAltaServicio("WIFI-2.0");
		assertEquals(1, modulo.getServicios().size());
	}
	
	@Test
	void getEntidadTest() {
		assertEquals(inmuble, modulo.getEntidad(inmuble));
	}
	
	@Test
	void getEntidadTestException() {
		assertEquals(inmuble, modulo.getEntidad(inmuble));
	}
	
	@Test
	void getCategoriasPorEntidadTest() {
		HashSet<String> categorias = new HashSet<String>();
		categorias.add("Cocina limpia");
		categorias.add("Patio Amplio");
		modulo.darDeAltaCategoria(inmuble, "Cocina limpia");
		modulo.darDeAltaCategoria(inmuble, "Patio Amplio");
		assertEquals(categorias, modulo.getCategoriasDeEntidad(inmuble));
	}
}


