package cancelacion;
import java.time.LocalDate;

import publicacion.Publicacion;

public class Regular extends Cancelacion {
	@Override
	public long montoACobrar(Publicacion publicacion, LocalDate fechaDeActual) {
		LocalDate fechaDeIngreso = publicacion.getPeriodoDeAlquiler().getFechaDeIngreso();
		if(this.diferenciaDeDiasMayorQue(fechaDeIngreso, fechaDeActual, 10)) {
			return 0;
		}
		
		return publicacion.getPrecioPorDia() * 2;
	}
}
