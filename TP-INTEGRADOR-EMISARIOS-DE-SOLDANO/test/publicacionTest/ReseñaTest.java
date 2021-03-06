package publicacionTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicacion.Reseņa;
import usuarioSAT.UsuarioSAT;

class ReseņaTest {
	
	private Reseņa reseņaCopada;
	private UsuarioSAT usuario;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//MOCK
		usuario = mock(UsuarioSAT.class);
		
		//SUT
		reseņaCopada = new Reseņa("Limpieza", 5, "Todo impecable", usuario);
	}

	@Test
	void getNombreCategoriaTest() {
		assertEquals(reseņaCopada.getNombreCategoria(), "Limpieza");
	}
	
	@Test
	void getPuntajeTest() {
		assertEquals(reseņaCopada.getPuntaje(), 5);
	}
	
	@Test
	void getComentarioTest() {
		assertEquals(reseņaCopada.getComentario(), "Todo impecable");
	}
	
	@Test
	void getUsuarioGeneradorTest() {
		assertEquals(reseņaCopada.getUsuarioGenerador(), usuario);
	}
	
}
