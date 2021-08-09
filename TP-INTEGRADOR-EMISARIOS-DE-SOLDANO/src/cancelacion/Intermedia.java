package cancelacion;
import java.time.LocalDate;

import publicacion.Publicacion;

public class Intermedia extends Cancelacion {
	@Override
	public long montoACobrar(Publicacion publicacion, LocalDate fechaDeActual) {
		LocalDate fechaDeIngreso = publicacion.getPeriodoDeAlquiler().getFechaDeIngreso(); 
		if(this.diferenciaDeDiasMayorQue(fechaDeIngreso, fechaDeActual, 20)) {
			return 0;
		} else if(this.diferenciaDeDiasMenorQue(fechaDeIngreso, fechaDeActual, 10)) {
			return publicacion.getMontoTotal();
		}
		
		return publicacion.getMontoTotal() / 2;
	}
}
