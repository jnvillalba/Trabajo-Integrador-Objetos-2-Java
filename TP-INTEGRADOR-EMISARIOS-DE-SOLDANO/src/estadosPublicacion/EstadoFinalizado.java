package estadosPublicacion;
import notificaciones.Interes;
import notificaciones.Observer;
import publicacion.Publicacion;
import publicacion.Rese�a;
import usuarioSAT.UsuarioSAT;

public class EstadoFinalizado extends EstadoPublicacion {
	
	@Override
	public void reservar(UsuarioSAT nuevoInquilino, Publicacion publicacion) {
		throw new RuntimeException("La publicacion Finalizo");
	}
	
	@Override
	public void aprobarReserva(UsuarioSAT nuevoInquilino, Publicacion publicacion) {
		throw new RuntimeException("La publicacion Finalizo");
	}

	@Override
	public void cancelarReservar(Publicacion publicacion) {
		throw new RuntimeException("La publicacion Finalizo");
	}

	@Override
	public boolean estaFinalizado() {
		return true;
	}
	
	@Override
	public void rese�arInmuebleAsociado(Publicacion publicacion, Rese�a rese�a) {
		publicacion.getInmueblePublicado().agregarRese�aInmueble(rese�a);
		
	}

	@Override
	public void finalizarPublicacion(Publicacion publicacion) {
		throw new RuntimeException("La publicacion ya esta finalizada");
	}
	
	public void suscribir(Publicacion publicacion, Observer observer) {
		throw new RuntimeException("La publicacion ya esta finalizada, no puedes suscribirte");
	}

	public void quitar(Publicacion publicacion, Observer observer) {
		publicacion.getObserversInteresados().remove(observer);		
	}

	public void notificar(Publicacion publicacion, Interes interes) {
		throw new RuntimeException("La publicacion ya esta finalizada, no se puede notificar");
	}
}
