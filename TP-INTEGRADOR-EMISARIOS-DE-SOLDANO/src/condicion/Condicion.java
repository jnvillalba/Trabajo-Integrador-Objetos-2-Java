package condicion;
import java.util.List;

import publicacion.Publicacion;

public abstract interface Condicion {
	public abstract List<Publicacion> filtar(List<Publicacion> publicaciones);
	public abstract void agregar(Condicion condicion);
	public abstract void eliminar(Condicion condicion);
	public abstract Condicion obtenerHijo(int numero);
}
