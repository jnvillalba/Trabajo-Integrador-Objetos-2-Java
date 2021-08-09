package sistemaSAT;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ModuloAdministracion {
	private HashMap<Entidad, HashSet<String>> categoriasPorEntidad;
	private List<String> serviciosDeInmuebles;
	private List<String> tiposDeInmueble;
	
	public ModuloAdministracion() {
		this.categoriasPorEntidad = this.cargarValoresRequeridos();
		this.serviciosDeInmuebles = new ArrayList<String>();
		this.tiposDeInmueble = new ArrayList<String>();
	}

	public void darDeAltaCategoria(Entidad entidadBuscada, String nombreDeCategoria) {
		HashSet<String> categorias = this.getCategoriasPorEntidad().get(entidadBuscada);
		categorias.add(nombreDeCategoria);
		this.getCategoriasPorEntidad().replace(entidadBuscada, categorias);
	}
	
	public void darDeAltaTipoDeInmueble(String nombreDeTipo) {
		this.getTiposDeInmueble().add(nombreDeTipo);
	}
	
	public void darDeAltaServicio(String nombreDeSerivico) {
		this.getServicios().add(nombreDeSerivico);
	}
	
	public Entidad getEntidad(Entidad entidadBuscada) {
		return this.getCategoriasPorEntidad().keySet().stream().filter(entidad -> entidad.esLaEntidadBuscada(entidadBuscada)).findFirst().get();
	}
	
	public HashMap<Entidad, HashSet<String>> getCategoriasPorEntidad() {
		return categoriasPorEntidad;
	}
	
	public HashSet<String> getCategoriasDeEntidad(Entidad entidad) {
		return categoriasPorEntidad.get(entidad);
	}
	
	public List<String> getServicios() {
		return serviciosDeInmuebles;
	}

	public List<String> getTiposDeInmueble() {
		return tiposDeInmueble;
	}
	
	private HashMap<Entidad, HashSet<String>> cargarValoresRequeridos() {
		HashMap<Entidad, HashSet<String>> categoriasPorEntidad = new HashMap<Entidad, HashSet<String>>();
		categoriasPorEntidad.put(Entidad.INMUEBLE, new HashSet<String>());
		categoriasPorEntidad.put(Entidad.INQUILINO, new HashSet<String>());
		categoriasPorEntidad.put(Entidad.PROPIETARIO, new HashSet<String>());
		return categoriasPorEntidad;
	}
}
