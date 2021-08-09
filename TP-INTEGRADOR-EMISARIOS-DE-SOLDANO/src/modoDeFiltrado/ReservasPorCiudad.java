package modoDeFiltrado;

import publicacion.Publicacion;

public class ReservasPorCiudad extends ModoDeFiltrado {
	private String ciudadBuscada;

	public ReservasPorCiudad(String ciudad) {
		ciudadBuscada = ciudad;
	}

	@Override
	protected Boolean cumpleConCondicion(Publicacion reserva) {
		return reserva.getInmueblePublicado().getCiudad() == ciudadBuscada;
	}
}
