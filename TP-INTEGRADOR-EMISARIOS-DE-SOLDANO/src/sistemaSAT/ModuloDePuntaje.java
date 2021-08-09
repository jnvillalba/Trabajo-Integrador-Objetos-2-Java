package sistemaSAT;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import publicacion.Inmueble;
import publicacion.Reseña;
import usuarioSAT.UsuarioSAT;

public class ModuloDePuntaje {
	
	public ModuloDePuntaje() {
		super();
	}
	
	/* Metodos Publicos */
	public Double puntajeTotalInmueble(Inmueble inmueble) {
		return this.puntajeTotal(inmueble.getReseñas());
	}
	
	public Double puntajeTotalPropietario(UsuarioSAT propietario) {
		return this.puntajeTotal(propietario.getReseñasComoPropietario());
	}
	
	public HashMap<String, Double> categoriasConPromedioDePuntajes(List<Reseña> reseñas, HashSet<String> categorias) {
		HashMap<String, List<Integer>> categoriasConListaDePuntajes = this.categoriasConListaDePuntajes(reseñas, categorias);
		HashMap<String, Double> categoriasPromediadas = new HashMap<String, Double>();
		
		for(String categoria : categoriasConListaDePuntajes.keySet()) {
			List<Integer> puntajes = categoriasConListaDePuntajes.get(categoria);
			categoriasPromediadas.put(categoria, this.promedioDePuntaje(puntajes));
		}
		
		return categoriasPromediadas;	
	}
	
	/* Metodos Privados */
	private Double puntajeTotal(List<Reseña> reseñasComoPropietario) {
		Integer contador = 0;
		for(Reseña reseña : reseñasComoPropietario) {
			contador = contador + reseña.getPuntaje();
		}
		
		return ((double) contador) / reseñasComoPropietario.size();
	}
	
	private HashMap<String, List<Integer>> categoriasConListaDePuntajes(List<Reseña> reseñas, HashSet<String> categorias) {
		HashMap<String, List<Integer>> categoriasConAcumulacion = this.categoriasParaPuntaje(categorias);
		
		for(Reseña reseña : reseñas) {
			List<Integer> valorCategoriaActual = categoriasConAcumulacion.get(reseña.getNombreCategoria());
			valorCategoriaActual.add(reseña.getPuntaje());
			categoriasConAcumulacion.replace(reseña.getNombreCategoria(), valorCategoriaActual);
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
