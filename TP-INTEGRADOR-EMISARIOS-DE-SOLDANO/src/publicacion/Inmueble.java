package publicacion;

import java.util.ArrayList;
import java.util.List;

public class Inmueble {
	private String tipoDeInmueble;
	private int superficie;
	private String pais;
	private String ciudad;
	private String direccion;
	private int capacidadDeHabitantes;
	private List<String> servicios;
	private List<String> fotos;
	private List<Rese�a> rese�as;
	
	public Inmueble(String tipoDeInmueble, int superficie, String pais, String ciudad, String direccion,
			List<String> servicios, int capacidadDeHabitantes, List<String> fotos) {
		super();
		this.tipoDeInmueble = tipoDeInmueble;
		this.superficie = superficie;
		this.pais = pais;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.capacidadDeHabitantes = capacidadDeHabitantes;
		this.servicios = servicios;
		this.fotos = fotos;
		this.rese�as = new ArrayList<Rese�a>();
	}

	public String getTipoDeInmueble() {
		return tipoDeInmueble;
	}
	
	public int getSuperficie() {
		return superficie;
	}
	
	public String getPais() {
		return pais;
	}
	
	
	public String getCiudad() {
		return ciudad;
	}
	
	
	public String getDireccion() {
		return direccion;
	}
	
	public int getCapacidadDeHabitantes() {
		return capacidadDeHabitantes;
	}
	
	public List<String> getServicios() {
		return servicios;
	}
	
	public List<String> getFotos() {
		return fotos;
	}

	public List<Rese�a> getRese�as() {
		return rese�as;
	}
	
	public void agregarRese�aInmueble(Rese�a nuevaRese�a) {
		this.getRese�as().add(nuevaRese�a);
	}


}
