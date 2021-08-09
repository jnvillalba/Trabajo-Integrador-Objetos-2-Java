package notificaciones;
import publicacion.Publicacion;

public class ObserverCancelacion extends Observer implements PopUpWindow  {
	
	public ObserverCancelacion() {
		super(Interes.CANCELACION);
	}
	
	@Override
	public void update(Publicacion publicacion) {
		this.popUp("La publicacion" + publicacion + "se ha liberado! Corre a reservarlo!", "Rojo" , 5);
	}
	
	@Override
	public void popUp(String message, String color, int fontSize) {
		/// Muestra una ventana emergente en el dispositivo movil
	}
}
