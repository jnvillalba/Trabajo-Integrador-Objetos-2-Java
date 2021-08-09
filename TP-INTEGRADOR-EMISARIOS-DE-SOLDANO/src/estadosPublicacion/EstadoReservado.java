package estadosPublicacion;

import publicacion.Publicacion;
import publicacion.Rese�a;
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
	public void rese�arInmuebleAsociado(Publicacion publicacion, Rese�a rese�a) {
		throw new RuntimeException("No se puede rese�ar una publicacion que este disponible");
	}

	@Override
	public void finalizarPublicacion(Publicacion publicacion) {
		if (publicacion.getPeriodoDeAlquiler().finalizoEstadia() && publicacion.getCheckTime().finalizoEstadia()) {
			publicacion.setEstado(new EstadoFinalizado());
		}
	}

}
