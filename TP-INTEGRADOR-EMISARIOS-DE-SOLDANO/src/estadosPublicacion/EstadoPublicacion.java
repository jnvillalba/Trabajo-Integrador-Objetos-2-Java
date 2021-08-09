package estadosPublicacion;

import notificaciones.Interes;
import notificaciones.Observer;
import publicacion.Publicacion;
import publicacion.Reseña;
import usuarioSAT.UsuarioSAT;

public abstract class EstadoPublicacion {
	
	public void reservar(UsuarioSAT nuevoInquilino, Publicacion publicacion ) {
		publicacion.agregarAInquilinosPendientes(nuevoInquilino);
	}
	
	public abstract void aprobarReserva(UsuarioSAT nuevoInquilino, Publicacion publicacion);
	public abstract void reseñarInmuebleAsociado(Publicacion publicacion, Reseña reseña);
	public abstract void finalizarPublicacion(Publicacion publicacion);
	public abstract void cancelarReservar(Publicacion publicacion);

	public boolean estaDisponible() {
		return false;
	}

	public boolean estaReservado() {
		return false;
	}

	public boolean estaFinalizado() {
		return false;
	}

	public void suscribir(Publicacion publicacion, Observer observer) {
		publicacion.getObserversInteresados().add(observer);
	}

	public void quitar(Publicacion publicacion, Observer observer) {
		publicacion.getObserversInteresados().remove(observer);		
	}

	public void notificar(Publicacion publicacion, Interes interes) {
		for(Observer observer : publicacion.getObserversInteresados()) {
			if(observer.tieneElMismoInteresAsociado(interes)) {
				observer.update(publicacion);
			}
		}
	}
}