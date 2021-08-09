package cancelacion;

import java.time.LocalDate;

import publicacion.Publicacion;

public class Extrema extends Cancelacion {
	@Override
	public long montoACobrar(Publicacion publicacion, LocalDate fechaDeActual) {
		return publicacion.getMontoTotal();
	}
}
