package usuarioSATTest;

import java.util.ArrayList;
import java.util.List;

import modoDeFiltrado.ModoDeFiltrado;
import publicacion.Publicacion;

public class UsuarioSATCopia {
	public String nombreCompleto;
	public String direccionEmail;
	public int telefono;
	public List<Publicacion> historialDeReservas;

	public UsuarioSATCopia(String nombreCompleto, String direccionEmail, int telefono) {
		this.nombreCompleto = nombreCompleto;
		this.direccionEmail = direccionEmail;
		this.telefono = telefono;
		historialDeReservas = new ArrayList<>();
	}

	public List<Publicacion> getReservas(ModoDeFiltrado metodoDeFiltrado) {
		return metodoDeFiltrado.filtrar(historialDeReservas);
	}
	
	public List<String> getCiudadesConReserva(String ciudadBuscada) {
		List<String> listaCiudades = new ArrayList<>();
		
		historialDeReservas.stream().forEach(reserva -> listaCiudades.add(reserva.getInmueblePublicado().getCiudad()));
		listaCiudades.stream().filter(ciudad -> ciudad == ciudadBuscada);
		
		return listaCiudades;
	}

}
