package modoDeFiltrado;

import java.time.LocalDate;

import publicacion.Publicacion;

public class ReservasFuturas extends ModoDeFiltrado {

	@Override
	protected Boolean cumpleConCondicion(Publicacion reserva) {
		LocalDate fechaActual = LocalDate.now();
		return fechaActual.isBefore(reserva.getPeriodoDeAlquiler().getFechaDeIngreso());
	}

}
