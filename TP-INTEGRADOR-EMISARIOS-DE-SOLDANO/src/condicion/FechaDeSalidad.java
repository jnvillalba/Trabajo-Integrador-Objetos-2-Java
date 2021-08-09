package condicion;

import java.time.LocalDate;

import publicacion.Publicacion;

public class FechaDeSalidad extends Base {
	private LocalDate fechaBuscada;
	
	public FechaDeSalidad(LocalDate fechaBuscada) {
		super();
		this.fechaBuscada = fechaBuscada;
	}

	@Override
	protected boolean cumpleConCondicion(Publicacion publicacion) {
		return publicacion.getPeriodoDeAlquiler().getFechaDeEgreso().isBefore(this.getFechaBuscada());
	}

	private LocalDate getFechaBuscada() {
		return fechaBuscada;
	}
}
