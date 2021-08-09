package sitioWebTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import publicacion.Rese�a;

public class ModuloDePuntajeCopy {
	
	protected Double puntajeTotal(List<Rese�a> rese�asComoPropietario) {
		Integer contador = 0;
		for(Rese�a rese�a : rese�asComoPropietario) {
			contador = contador + rese�a.getPuntaje();
		}
		
		return ((double) contador) / rese�asComoPropietario.size();
	}
	
	protected HashMap<String, List<Integer>> categoriasConListaDePuntajes(List<Rese�a> rese�as, HashSet<String> categorias) {
		HashMap<String, List<Integer>> categoriasConAcumulacion = this.categoriasParaPuntaje(categorias);
		for(Rese�a rese�a : rese�as) {
			List<Integer> valorCategoriaActual = categoriasConAcumulacion.get(rese�a.getNombreCategoria());
			valorCategoriaActual.add(rese�a.getPuntaje());
			categoriasConAcumulacion.replace(rese�a.getNombreCategoria(), valorCategoriaActual);
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
