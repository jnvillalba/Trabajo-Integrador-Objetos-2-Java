package modoDeFiltrado;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import publicacion.Publicacion;

public abstract class ModoDeFiltrado {

	public List<Publicacion> filtrar(List<Publicacion> historialDeReservas) {
		List<Publicacion> listaFiltrada = new ArrayList<>();
		listaFiltrada = historialDeReservas.stream().filter(reserva -> cumpleConCondicion(reserva)).collect(Collectors.toList());
		
		return listaFiltrada;
	}

	protected abstract Boolean cumpleConCondicion(Publicacion reserva);

}
