package publicacionTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicacion.Rese�a;
import usuarioSAT.UsuarioSAT;

class Rese�aTest {
	
	private Rese�a rese�aCopada;
	private UsuarioSAT usuario;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//MOCK
		usuario = mock(UsuarioSAT.class);
		
		//SUT
		rese�aCopada = new Rese�a("Limpieza", 5, "Todo impecable", usuario);
	}

	@Test
	void getNombreCategoriaTest() {
		assertEquals(rese�aCopada.getNombreCategoria(), "Limpieza");
	}
	
	@Test
	void getPuntajeTest() {
		assertEquals(rese�aCopada.getPuntaje(), 5);
	}
	
	@Test
	void getComentarioTest() {
		assertEquals(rese�aCopada.getComentario(), "Todo impecable");
	}
	
	@Test
	void getUsuarioGeneradorTest() {
		assertEquals(rese�aCopada.getUsuarioGenerador(), usuario);
	}
	
}
