package estadosPublicacion;

import publicacion.Publicacion;
import publicacion.Reseña;
import usuarioSAT.UsuarioSAT;

public class EstadoReservado extends EstadoPublicacion{
	
	@Override
	public void aprobarReserva(UsuarioSAT nuevoInquilino, Publicacion publicacion) {
		throw new RuntimeException("No se puede aprobar una reseva ya reservada");
	}

	@Override
	public void cancelarReservar(Publicacion publicacion) {
		if (publicacion.getInquilinosPendientes().isEmpty()) {
			publicacion.setEstado(new EstadoDisponible());
		}else {
			publicacion.removerInquilinoDePendientes(publicacion.getInquilino());
			publicacion.setInquilino(publicacion.getInquilinosPendientes().get(0));
		}
		//notifcar que se desocupo;	
	}
	
	@Override
	public boolean estaReservado() {
		return true;
	}
	
	@Override
	public void reseñarInmuebleAsociado(Publicacion publicacion, Reseña reseña) {
		throw new RuntimeException("No se puede reseñar una publicacion que este disponible");
	}

	@Override
	public void finalizarPublicacion(Publicacion publicacion) {
		if (publicacion.getPeriodoDeAlquiler().finalizoEstadia() && publicacion.getCheckTime().finalizoEstadia()) {
			publicacion.setEstado(new EstadoFinalizado());
		}
	}

}
