package modoDeFiltrado;

import publicacion.Publicacion;

public class TodasLasReservas extends ModoDeFiltrado {

	@Override
	protected Boolean cumpleConCondicion(Publicacion reserva) {
		return true;
	}

}
