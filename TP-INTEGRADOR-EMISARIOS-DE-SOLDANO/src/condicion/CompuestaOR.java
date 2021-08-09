package condicion;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import publicacion.Publicacion;

public class CompuestaOR extends Compuesta {

	public CompuestaOR() {
		super();
	}

	@Override
	public List<Publicacion> filtar(List<Publicacion> publicaciones) {
		HashSet<Publicacion> publicacionesSinRepetidos = new HashSet<Publicacion>();
		ArrayList<Publicacion> publicacionesFiltradas = new ArrayList<Publicacion>();
		for(Condicion condicion : this.getCondiciones()) {
			publicacionesSinRepetidos.addAll(condicion.filtar(publicaciones));
		}
		publicacionesFiltradas.addAll(publicacionesSinRepetidos);
		
		return publicacionesFiltradas;
	} 
}
