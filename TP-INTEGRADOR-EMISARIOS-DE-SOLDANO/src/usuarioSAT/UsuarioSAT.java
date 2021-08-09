package usuarioSAT;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import modoDeFiltrado.ModoDeFiltrado;
import modoDeFiltrado.TodasLasReservas;
import publicacion.Inmueble;
import publicacion.Publicacion;
import publicacion.Reseña;

@SuppressWarnings("unused")
public class UsuarioSAT {
	private String nombreCompleto;
	private String direccionEmail;
	private int telefono;
	private List<Publicacion> publicacionesRealizadas;
	private List<Publicacion> historialDeReservas;
	private List<Reseña> reseñasComoInquilino;
	private List<Reseña> reseñasComoPropietario;
	private List<Inmueble> inmuebles;

	public UsuarioSAT(String nombreCompleto, String direccionEmail, int telefono) {
		this.nombreCompleto = nombreCompleto;
		this.direccionEmail = direccionEmail;
		this.telefono = telefono;
		inmuebles = new ArrayList<>();
		publicacionesRealizadas = new ArrayList<>();
		historialDeReservas = new ArrayList<>();
		reseñasComoInquilino = new ArrayList<>();
		reseñasComoPropietario = new ArrayList<>();
	}
	
	//INMUEBLE//
	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public void darDeAltaInmueble(String tipoDeInmueble, int superficie, String pais, String ciudad, String direccion,
			List<String> servicios, int capacidad, List<String> fotos) {
		
		Inmueble inmueble = new Inmueble(tipoDeInmueble, superficie, pais, ciudad, direccion, servicios, capacidad, fotos);
		inmuebles.add(inmueble);
	}
	
	public HashSet<Inmueble> inmueblesQueAlquilo() {
		HashSet<Inmueble> inmuebles = new HashSet<Inmueble>();
		
		for(Publicacion publicacion : getPublicacionesRealizadas()) {
			inmuebles.add(publicacion.getInmueblePublicado());
		}
		return inmuebles;
	}
	
	//PUBLICACIONES REALIZADAS //
	public List<Publicacion> getPublicacionesRealizadas() {
		return publicacionesRealizadas;
	}

	public void cargarPublicaciones(List<Publicacion> nuevasPublicaciones) {
		publicacionesRealizadas.addAll(nuevasPublicaciones);
	}
	
	public int cantidadDePublicacionesConInmueble(Inmueble inmueble) {
		return getPublicacionesRealizadas().stream().filter(publicacionActual -> publicacionActual.getInmueblePublicado().equals(inmueble)).collect(Collectors.toList()).size();
	}
	
	public int cantidadDeAlquileresRealizados() {
		return getPublicacionesRealizadas().size();
	}
	
	//RESERVAS HECHAS //
	public List<Publicacion> getReservas(ModoDeFiltrado modoDeFiltrado) {
		return modoDeFiltrado.filtrar(historialDeReservas);
	}
	
	public List<String> getCiudadesConReserva(String ciudadBuscada) {
		List<String> listaCiudades = new ArrayList<>();
		
		historialDeReservas.stream().forEach(reserva -> listaCiudades.add(reserva.getInmueblePublicado().getCiudad()));
		listaCiudades.stream().filter(ciudad -> ciudad == ciudadBuscada);
		
		return listaCiudades;
	}
	
	public void aprobarReserva(Publicacion publicacion) {
		historialDeReservas.add(publicacion);
	}

	public void cancelarReservaHecha(Publicacion publicacion) {
		publicacion.cancelarReservar();
		historialDeReservas.remove(publicacion);
	}

	public int cantidadDeReservas() {
		return historialDeReservas.size();
	}
	
	//RESEÑAS//
	public void agregarReseñaInquilino(Reseña reseña) {
		reseñasComoInquilino.add(reseña);
	}
	
	public void agregarReseñaPropietario(Reseña reseña) {
		reseñasComoPropietario.add(reseña);
	}

	public List<Reseña> getReseñasComoInquilino() {
		return reseñasComoInquilino;
	}
	
	public List<Reseña> getReseñasComoPropietario() {
		return reseñasComoPropietario;
	}
	
	//PROPIETARIO//
	public void aprobarInquilino(Publicacion publicacion, UsuarioSAT inquilino) {
		publicacion.aprobarReserva(inquilino);
		inquilino.aprobarReserva(publicacion);
	}
	
}
