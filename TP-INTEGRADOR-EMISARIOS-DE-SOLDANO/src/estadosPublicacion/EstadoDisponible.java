package estadosPublicacion;

import publicacion.Publicacion;
import publicacion.Reseña;
import usuarioSAT.UsuarioSAT;

public class EstadoDisponible extends EstadoPublicacion{
	
	@Override
	public void aprobarReserva(UsuarioSAT nuevoInquilino, Publicacion publicacion){
		publicacion.removerInquilinoDePendientes(nuevoInquilino);
		publicacion.setFormaDePagoInquilino(publicacion.getFormaDePagoDePosibleInquilino().get(nuevoInquilino));
		publicacion.setEstado(new EstadoReservado());
		nuevoInquilino.aprobarReserva(publicacion);
	}

	@Override
	public void cancelarReservar(Publicacion publicacion) {
		throw new RuntimeException("No se puede cancelar una publicacion que no este reservada");
	}

	@Override
	public boolean estaDisponible() {
		return true;
	}

	@Override
	public void reseñarInmuebleAsociado(Publicacion publicacion, Reseña reseña) {
		throw new RuntimeException("No se puede reseñar una publicacion que este disponible");
		
	}

	@Override
	public void finalizarPublicacion(Publicacion publicacion) {
		publicacion.setEstado(new EstadoFinalizado());
	}
}
