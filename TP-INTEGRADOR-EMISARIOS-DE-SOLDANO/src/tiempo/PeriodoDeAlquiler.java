package tiempo;

import java.time.LocalDate;

public class PeriodoDeAlquiler {
	
	private LocalDate fechaDeIngreso;
	private LocalDate fechaDeEgreso;
	
	public PeriodoDeAlquiler(LocalDate fechaDeIngreso, LocalDate fechaDeEgreso) {
		super();
		this.fechaDeIngreso = fechaDeIngreso;
		this.fechaDeEgreso = fechaDeEgreso;
	}

	public LocalDate getFechaDeIngreso() {
		return fechaDeIngreso;
	}
	
	public LocalDate getFechaDeEgreso() {
		return fechaDeEgreso;
	}
	
	public int diasAlquiladosTotales() {
		return fechaDeEgreso.getDayOfMonth() - fechaDeIngreso.getDayOfMonth();
		
	}
	
	public boolean finalizoEstadia() {
		return LocalDate.now().equals(fechaDeEgreso);
	}


	
	
	

}
