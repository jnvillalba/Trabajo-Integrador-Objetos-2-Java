package publicacion;

import usuarioSAT.UsuarioSAT;

public class Reseña {
	
	private String nombreCategoria;
	//El max puntaje es 5 y el menor 1
	private int puntaje;
	private String comentario;
	private UsuarioSAT usuarioGenerador;
	
	public Reseña(String nombreCategoria, int puntaje, String comentario, UsuarioSAT usuarioGenerador) {
		super();
		this.nombreCategoria = nombreCategoria;
		this.puntaje = puntaje;
		this.comentario = comentario;
		this.usuarioGenerador = usuarioGenerador;
	}
	
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public String getComentario() {
		return comentario;
	}
	public UsuarioSAT getUsuarioGenerador() {
		return usuarioGenerador;
	}
	
}
