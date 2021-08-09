package condicion;
import java.util.List;
import java.util.stream.Collectors;

import publicacion.Publicacion;

public abstract class Base implements Condicion {

	public List<Publicacion> filtar(List<Publicacion> publicacionesResultantes) {
		return publicacionesResultantes.stream().filter(publicacion -> this.cumpleConCondicion(publicacion)).collect(Collectors.toList());
	}

	protected abstract boolean cumpleConCondicion(Publicacion publicacion);
	
	@Override
	public void agregar(Condicion condicion) {
		throw new RuntimeException("Una Condicion Base no puede ejecutar esta operacion");
		
	}

	@Override
	public void eliminar(Condicion condicion) {
		throw new RuntimeException("Una Condicion Base no puede ejecutar esta operacion");
		
	}

	@Override
	public Condicion obtenerHijo(int numero) {
		throw new RuntimeException("Una Condicion Base no puede ejecutar esta operacion");
	}

}
