package cancelacion;
import static java.time.temporal.ChronoUnit.DAYS;
import java.time.LocalDate;

import publicacion.Publicacion;

public abstract class Cancelacion {
	
	public abstract long montoACobrar(Publicacion publicacion, LocalDate fechaDeActual);
	
	protected boolean diferenciaDeDiasMayorQue(LocalDate fechaDeIngreso, LocalDate fechaDeActual, int cantidadDeDias) {
		return Math.abs(DAYS.between(fechaDeIngreso, fechaDeActual)) > cantidadDeDias;
	}
	
	protected boolean diferenciaDeDiasMenorQue(LocalDate fechaDeIngreso, LocalDate fechaDeActual, int cantidadDeDias) {
		return Math.abs(DAYS.between(fechaDeIngreso, fechaDeActual)) < cantidadDeDias;
	}
}
