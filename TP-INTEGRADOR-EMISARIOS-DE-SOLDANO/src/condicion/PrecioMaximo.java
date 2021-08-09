package condicion;

import publicacion.Publicacion;

public class PrecioMaximo extends Base {
	private Integer valorBuscado;

	public PrecioMaximo(Integer valorBuscado) {
		super();
		this.valorBuscado = valorBuscado;
	}

	@Override
	protected boolean cumpleConCondicion(Publicacion publicacion) {
		return publicacion.getMontoTotal() <= this.getValorBuscado();
	}

	private Integer getValorBuscado() {
		return valorBuscado;
	}
}
