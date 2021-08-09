package condicion;
import java.time.LocalDate;

import publicacion.Publicacion;

public class FechaDeEntrada extends Base {
	private LocalDate fechaBuscada;
	
	public FechaDeEntrada(LocalDate fechaBuscada) {
		super();
		this.fechaBuscada = fechaBuscada;
	}

	@Override
	protected boolean cumpleConCondicion(Publicacion publicacion) {
		return publicacion.getPeriodoDeAlquiler().getFechaDeIngreso().isAfter(this.getFechaBuscada());
	}

	private LocalDate getFechaBuscada() {
		return fechaBuscada;
	}
}
