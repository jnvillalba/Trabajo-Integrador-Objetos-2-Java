package notificaciones;

public enum Interes {
	BAJADEPRECIO, CANCELACION, RESERVA;
	
	public boolean esElInteresBuscado(Interes interesado) {
		return this.equals(interesado);
	}	
}
