package notificaciones;
import java.util.ArrayList;
import java.util.List;

import publicacion.Publicacion;

public abstract class Observer {
	protected List<Publicacion> publicacionesALasQueSeSuscribio;
	protected Interes interesAsociado;
	
	public Observer(Interes interesAsociado) {
		super();
		this.publicacionesALasQueSeSuscribio = new ArrayList<Publicacion>();
		this.interesAsociado = interesAsociado;
	}

	public abstract void update(Publicacion publicacion);
	
	public boolean tieneElMismoInteresAsociado(Interes interes) {
		return interesAsociado.esElInteresBuscado(interes);
	}
}
