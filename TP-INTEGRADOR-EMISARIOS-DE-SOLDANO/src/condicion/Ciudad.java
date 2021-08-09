package condicion;
import publicacion.Publicacion;

public class Ciudad extends Base {
	private String ciudadBuscada;

	public Ciudad(String ciudadBuscada) {
		super();
		this.ciudadBuscada = ciudadBuscada;
	}

	@Override
	protected boolean cumpleConCondicion(Publicacion publicacion) {
		return this.getCiudadBuscada().equals(publicacion.getInmueblePublicado().getCiudad());
	}

	private String getCiudadBuscada() {
		return ciudadBuscada;
	}
	
	
	
}
