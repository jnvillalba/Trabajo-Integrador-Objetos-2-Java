package sistemaSAT;

public enum Entidad {
	
	INQUILINO,PROPIETARIO,INMUEBLE;
	
	public boolean esLaEntidadBuscada(Entidad entidadBuscada) {
		return this.equals(entidadBuscada);
	}	
}
