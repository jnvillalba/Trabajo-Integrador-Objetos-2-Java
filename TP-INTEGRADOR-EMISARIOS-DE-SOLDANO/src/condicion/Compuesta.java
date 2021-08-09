package condicion;

import java.util.ArrayList;
import java.util.List;

import publicacion.Publicacion;

public abstract class Compuesta implements Condicion {
	protected List<Condicion> condiciones;

	public Compuesta() {
		super();
		this.condiciones = new ArrayList<Condicion>();
	}

	@Override
	public abstract List<Publicacion> filtar(List<Publicacion> publicaciones);

	@Override
	public void agregar(Condicion condicion) {
		this.getCondiciones().add(condicion);
	}

	@Override
	public void eliminar(Condicion condicion) {
		this.getCondiciones().remove(condicion);
	}

	@Override
	public Condicion obtenerHijo(int numero) {
		return this.getCondiciones().get(numero);
	}
	
	protected List<Condicion> getCondiciones() {
		return condiciones;
	}
}
