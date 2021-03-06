package sistemaSAT;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import publicacion.Inmueble;
import publicacion.Reseņa;
import usuarioSAT.UsuarioSAT;

public class ModuloDePuntaje {
	
	public ModuloDePuntaje() {
		super();
	}
	
	/* Metodos Publicos */
	public Double puntajeTotalInmueble(Inmueble inmueble) {
		return this.puntajeTotal(inmueble.getReseņas());
	}
	
	public Double puntajeTotalPropietario(UsuarioSAT propietario) {
		return this.puntajeTotal(propietario.getReseņasComoPropietario());
	}
	
	public HashMap<String, Double> categoriasConPromedioDePuntajes(List<Reseņa> reseņas, HashSet<String> categorias) {
		HashMap<String, List<Integer>> categoriasConListaDePuntajes = this.categoriasConListaDePuntajes(reseņas, categorias);
		HashMap<String, Double> categoriasPromediadas = new HashMap<String, Double>();
		
		for(String categoria : categoriasConListaDePuntajes.keySet()) {
			List<Integer> puntajes = categoriasConListaDePuntajes.get(categoria);
			categoriasPromediadas.put(categoria, this.promedioDePuntaje(puntajes));
		}
		
		return categoriasPromediadas;	
	}
	
	/* Metodos Privados */
	private Double puntajeTotal(List<Reseņa> reseņasComoPropietario) {
		Integer contador = 0;
		for(Reseņa reseņa : reseņasComoPropietario) {
			contador = contador + reseņa.getPuntaje();
		}
		
		return ((double) contador) / reseņasComoPropietario.size();
	}
	
	private HashMap<String, List<Integer>> categoriasConListaDePuntajes(List<Reseņa> reseņas, HashSet<String> categorias) {
		HashMap<String, List<Integer>> categoriasConAcumulacion = this.categoriasParaPuntaje(categorias);
		
		for(Reseņa reseņa : reseņas) {
			List<Integer> valorCategoriaActual = categoriasConAcumulacion.get(reseņa.getNombreCategoria());
			valorCategoriaActual.add(reseņa.getPuntaje());
			categoriasConAcumulacion.replace(reseņa.getNombreCategoria(), valorCategoriaActual);
		}
		
		return categoriasConAcumulacion;
	}
	
	private HashMap<String, List<Integer>> categoriasParaPuntaje(HashSet<String> categorias) {
		HashMap<String, List<Integer>> categoriasConAcumulacion = new HashMap<String, List<Integer>>();
		
		for(String categoria : categorias) {
			categoriasConAcumulacion.put(categoria, new ArrayList<Integer>());
		}
		
		return categoriasConAcumulacion;
	}
	
	private Double promedioDePuntaje(List<Integer> puntajes) {
		return ((double) sumatoriaTotalDePuntajes(puntajes)) / puntajes.size();
	}
	
	private int sumatoriaTotalDePuntajes(List<Integer> valorCategoriaActual) {
		int puntajeTotal = 0;
		
		for(int puntaje :  valorCategoriaActual) {
			puntajeTotal = puntajeTotal + puntaje;
		}
		return puntajeTotal;
	}
}
