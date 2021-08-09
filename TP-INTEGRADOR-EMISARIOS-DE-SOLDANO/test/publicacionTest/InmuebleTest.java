package publicacionTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicacion.Inmueble;
import publicacion.Reseña;

class InmuebleTest {
	private List<String> servicios; 
	private List<String> fotos;
	private Inmueble casaPionera;
	private ArrayList<Reseña> listaVacia;
	private Reseña reseña;
	
	@BeforeEach
	void setUp() throws Exception {
		//SUT
		servicios = Arrays.asList("Cocina", "Wifi", "Estacionamiento","TV");
		fotos = Arrays.asList("fotoComedor.jpg", "fotoDormitorio.jpg", "fotoBaño.jpg", "fotoCocina.jpg","fotoPatio.jpg");
		listaVacia = new ArrayList<>();
		
		casaPionera = new Inmueble("casa", 20, "Argentina", "Buenos Aires", "Zapata", servicios, 2, fotos);
		//MOCK
		reseña = mock(Reseña.class);
	
	}
	
	
	@Test
	void testGetTipoDeInmueble() {
		assertEquals(casaPionera.getTipoDeInmueble(), "casa" );
	}
	
	@Test
	void testGetSuperficie() {
		assertEquals(casaPionera.getSuperficie(), 20 );
	}
	
	@Test
	void testGetPais() {
		assertEquals(casaPionera.getPais(), "Argentina");
	}
	
	@Test
	void testGetCiudad() {
		assertEquals(casaPionera.getCiudad(), "Buenos Aires");
	}
	
	@Test
	void testGetDir() {
		assertEquals(casaPionera.getDireccion(), "Zapata");
	}
	
	@Test
	void testGetServicios() {
		assertEquals(casaPionera.getServicios(), servicios);
	}
	
	@Test
	void testGetFotos() {
		assertEquals(casaPionera.getFotos(), fotos);
	}
	
	@Test
	void testGetCapacidadDeHabitantes() {
		assertEquals(casaPionera.getCapacidadDeHabitantes(), 2);
	}
	
	@Test
	void testGetReseñas() {
		assertEquals(casaPionera.getReseñas(), listaVacia );
	}
	
	@Test
	void testAgregarReseñas() {
		casaPionera.agregarReseñaInmueble(reseña);
		assertEquals(1, casaPionera.getReseñas().size());
	}
	
	

}
