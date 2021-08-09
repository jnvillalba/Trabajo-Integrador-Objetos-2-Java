package sitioWebTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import publicacion.Reseña;

public class ModuloDePuntajeCopy {
	
	protected Double puntajeTotal(List<Reseña> reseñasComoPropietario) {
		Integer contador = 0;
		for(Reseña reseña : reseñasComoPropietario) {
			contador = contador + reseña.getPuntaje();
		}
		
		return ((double) contador) / reseñasComoPropietario.size();
	}
	
	protected HashMap<String, List<Integer>> categoriasConListaDePuntajes(List<Reseña> reseñas, HashSet<String> categorias) {
		HashMap<String, List<Integer>> categoriasConAcumulacion = this.categoriasParaPuntaje(categorias);
		for(Reseña reseña : reseñas) {
			List<Integer> valorCategoriaActual = categoriasConAcumulacion.get(reseña.getNombreCategoria());
			valorCategoriaActual.add(reseña.getPuntaje());
			categoriasConAcumulacion.replace(reseña.getNombreCategoria(), valorCategoriaActual);
		}
		return categoriasConAcumulacion;
	}
	
	protected HashMap<String, List<Integer>> categoriasParaPuntaje(HashSet<String> categorias) {
		HashMap<String, List<Integer>> categoriasConAcumulacion = new HashMap<String, List<Integer>>();
		for(String categoria : categorias) {
			categoriasConAcumulacion.put(categoria, new ArrayList<Integer>());
		}
		return categoriasConAcumulacion;
	}
	
	protected double promedioDePuntaje(List<Integer> puntajes) {
		return  ((double) sumatoriaTotalDePuntajes(puntajes)) / puntajes.size();
	}
	
	protected int sumatoriaTotalDePuntajes(List<Integer> valorCategoriaActual) {
		int puntajeTotal = 0;
		for(int puntaje :  valorCategoriaActual) {
			puntajeTotal = puntajeTotal + puntaje;
		}
		return puntajeTotal;
	}
}
