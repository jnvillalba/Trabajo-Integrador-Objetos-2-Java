package sistemaSAT;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import condicion.Condicion;
import publicacion.Inmueble;
import publicacion.Publicacion;
import usuarioSAT.UsuarioSAT;

public class SitioWebSAT{
	private ModuloAdministracion moduloAdministracion;
	private ModuloDePuntaje moduloPuntaje;
	private ArrayList<Publicacion> publicacionesRegistradas;
	private ArrayList<UsuarioSAT> usuariosSAT;
	
	public SitioWebSAT(ModuloAdministracion moduloAdministracion, ModuloDePuntaje moduloPuntaje) {
		this.moduloPuntaje = moduloPuntaje;
		this.moduloAdministracion = moduloAdministracion;
		this.publicacionesRegistradas = new ArrayList<Publicacion>();
		this.usuariosSAT = new ArrayList<UsuarioSAT>();
	}

	/* Sector Getters - Setters */
	public ArrayList<Publicacion> getPublicacionesRegistradas() {
		return publicacionesRegistradas;
	}

	public ArrayList<UsuarioSAT> getUsuariosSAT() {
		return usuariosSAT;
	}
	
	private ModuloAdministracion getModuloAdministracion() {
		return moduloAdministracion;
	}

	private ModuloDePuntaje getModuloPuntaje() {
		return moduloPuntaje;
	}
	
	/* Metodos Publicos */
	public void registrarUsuario(UsuarioSAT nuevoUsuario) {
		usuariosSAT.add(nuevoUsuario);
	}
	
	public void registrarPublicaciones(List<Publicacion> nuevasPublicaciones, UsuarioSAT propietario) {
		this.agregarPublicaciones(nuevasPublicaciones);
		propietario.cargarPublicaciones(nuevasPublicaciones);
	}

	public List<Publicacion> buscarPublicaciones(Condicion condicionTotal) {
		return condicionTotal.filtar(this.getPublicacionesRegistradas());
	}
	
	public HashMap<String, Double> getCategoriasConPromedioInmueble(Inmueble inmueble) {
		return this.getModuloPuntaje().categoriasConPromedioDePuntajes(inmueble.getReseñas(), this.getModuloAdministracion().getCategoriasDeEntidad(Entidad.INMUEBLE));
	}
	
	public HashMap<String, Double> getCategoriasConPromedioPropietario(UsuarioSAT propietario) {
		return this.getModuloPuntaje().categoriasConPromedioDePuntajes(propietario.getReseñasComoPropietario(), this.getModuloAdministracion().getCategoriasDeEntidad(Entidad.PROPIETARIO));
	}
	
	public List<Publicacion> obtenerTodasLasPublicacionesSinReserva() {
		return publicacionesRegistradas.stream().filter(publicacion -> publicacion.estaDisponible()).collect(Collectors.toList());
	}
	
	public int obtenerTasaDeOcupacionDelSitio() {
		List<Publicacion> publicacionesReservadas = new ArrayList<>();
		publicacionesReservadas = publicacionesRegistradas.stream().filter(publicacion -> publicacion.estaReservado()).collect(Collectors.toList());
		
		float cantidadPublicacionesReservadas = publicacionesReservadas.size();
		float cantidadDePublicaciones = publicacionesRegistradas.size();
		
		return Math.round((cantidadPublicacionesReservadas / cantidadDePublicaciones) * 100 );
	}
	

	public HashMap<UsuarioSAT, Integer> inquilinosQueMasAlquilaron() {
		HashMap<UsuarioSAT, Integer> topTen = new HashMap<>();
		List<UsuarioSAT> listaOrdenada = new ArrayList<>();
		
		listaOrdenada = ordenarLista(this.getUsuariosSAT()).subList(0, 10);
		
		for(UsuarioSAT usuario : listaOrdenada) {
			topTen.put(usuario, usuario.cantidadDeReservas());
		}
		
		return topTen;
	}
	
	/* Metodos Privados */
	private void agregarPublicaciones(List<Publicacion> nuvasPublicaciones) {
		this.getPublicacionesRegistradas().addAll(nuvasPublicaciones);
	}

	private List<UsuarioSAT> ordenarLista(List<UsuarioSAT> usuariosSAT) {
		Collections.sort(usuariosSAT, new Comparator<UsuarioSAT>() {
			@Override
			public int compare(UsuarioSAT usuarioUno, UsuarioSAT usuarioDos) {
				return ((Integer) (usuarioDos.cantidadDeReservas())).compareTo((Integer)usuarioUno.cantidadDeReservas());
			}
		});
		return usuariosSAT;
	}
}
