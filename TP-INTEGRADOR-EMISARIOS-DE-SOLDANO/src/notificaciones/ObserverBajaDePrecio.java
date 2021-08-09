package notificaciones;
import publicacion.Publicacion;

public class ObserverBajaDePrecio extends Observer implements HomePagePublisher {

	public ObserverBajaDePrecio() {
		super(Interes.BAJADEPRECIO);
		// TODO Auto-generated constructor stub
	}

	public void update(Publicacion publicacion) {
		this.publish("No te pierdas esta oferta" + publicacion + "a tan solo" + publicacion.getMontoTotal());
	}
	
	@Override
	public void publish(String message) {
		/// Publicara el mensaje en su pagina
	}
	
	public boolean tieneElMismoInteresAsociado(Interes interes) {
		return interesAsociado.esElInteresBuscado(interes);
	}
}
