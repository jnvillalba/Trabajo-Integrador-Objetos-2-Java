package condicion;

import publicacion.Publicacion;

public class CantidadDeHuespedes extends Base {
	private Integer cantidadDeCuposBuscado; 
	
	public CantidadDeHuespedes(Integer cantidadDeCuposBuscado) {
		super();
		this.cantidadDeCuposBuscado = cantidadDeCuposBuscado;
	}

	@Override
	protected boolean cumpleConCondicion(Publicacion publicacion) {
		return publicacion.getInmueblePublicado().getCapacidadDeHabitantes() >= this.getCantidadDeCuposBuscado();
	}

	private Integer getCantidadDeCuposBuscado() {
		return cantidadDeCuposBuscado;
	}
}
