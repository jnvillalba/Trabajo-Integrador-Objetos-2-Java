package publicacionTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicacion.Reseña;
import usuarioSAT.UsuarioSAT;

class ReseñaTest {
	
	private Reseña reseñaCopada;
	private UsuarioSAT usuario;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//MOCK
		usuario = mock(UsuarioSAT.class);
		
		//SUT
		reseñaCopada = new Reseña("Limpieza", 5, "Todo impecable", usuario);
	}

	@Test
	void getNombreCategoriaTest() {
		assertEquals(reseñaCopada.getNombreCategoria(), "Limpieza");
	}
	
	@Test
	void getPuntajeTest() {
		assertEquals(reseñaCopada.getPuntaje(), 5);
	}
	
	@Test
	void getComentarioTest() {
		assertEquals(reseñaCopada.getComentario(), "Todo impecable");
	}
	
	@Test
	void getUsuarioGeneradorTest() {
		assertEquals(reseñaCopada.getUsuarioGenerador(), usuario);
	}
	
}
