package condicion;
import java.util.ArrayList;
import java.util.List;

import publicacion.Publicacion;

public class CompuestaAND extends Compuesta {
	
	public CompuestaAND() {
		super();
	}
 
	@Override
	public List<Publicacion> filtar(List<Publicacion> publicaciones) {
		List<Publicacion> publicacionesActuales = publicaciones;
		for(Condicion condicion : this.getCondiciones()) {
			publicacionesActuales = condicion.filtar(publicacionesActuales);
		}
		return this.resultadoSegunCantidadDeCondiciones(publicacionesActuales);
	}
	
	private List<Publicacion> resultadoSegunCantidadDeCondiciones(List<Publicacion> publicaciones) {
		if(this.getCondiciones().isEmpty()) {
			return new ArrayList<Publicacion>();
		} else {
			return publicaciones;
		}
	}
}
