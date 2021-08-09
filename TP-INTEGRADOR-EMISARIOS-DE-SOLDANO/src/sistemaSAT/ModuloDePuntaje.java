package sistemaSAT;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import publicacion.Inmueble;
import publicacion.Rese�a;
import usuarioSAT.UsuarioSAT;

public class ModuloDePuntaje {
	
	public ModuloDePuntaje() {
		super();
	}
	
	/* Metodos Publicos */
	public Double puntajeTotalInmueble(Inmueble inmueble) {
		return this.puntajeTotal(inmueble.getRese�as());
	}
	
	public Double puntajeTotalPropietario(UsuarioSAT propietario) {
		return this.puntajeTotal(propietario.getRese�asComoPropietario());
	}
	
	public HashMap<String, Double> categoriasConPromedioDePuntajes(List<Rese�a> rese�as, HashSet<String> categorias) {
		HashMap<String, List<Integer>> categoriasConListaDePuntajes = this.categoriasConListaDePuntajes(rese�as, categorias);
		HashMap<String, Double> categoriasPromediadas = new HashMap<String, Double>();
		
		for(String categoria : categoriasConListaDePuntajes.keySet()) {
			List<Integer> puntajes = categoriasConListaDePuntajes.get(categoria);
			categoriasPromediadas.put(categoria, this.promedioDePuntaje(puntajes));
		}
		
		return categoriasPromediadas;	
	}
	
	/* Metodos Privados */
	private Double puntajeTotal(List<Rese�a> rese�asComoPropietario) {
		Integer contador = 0;
		for(Rese�a rese�a : rese�asComoPropietario) {
			contador = contador + rese�a.getPuntaje();
		}
		
		return ((double) contador) / rese�asComoPropietario.size();
	}
	
	private HashMap<String, List<Integer>> categoriasConListaDePuntajes(List<Rese�a> rese�as, HashSet<String> categorias) {
		HashMap<String, List<Integer>> categoriasConAcumulacion = this.categoriasParaPuntaje(categorias);
		
		for(Rese�a rese�a : rese�as) {
			List<Integer> valorCategoriaActual = categoriasConAcumulacion.get(rese�a.getNombreCategoria());
			valorCategoriaActual.add(rese�a.getPuntaje());
			categoriasConAcumulacion.replace(rese�a.getNombreCategoria(), valorCategoriaActual);
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
