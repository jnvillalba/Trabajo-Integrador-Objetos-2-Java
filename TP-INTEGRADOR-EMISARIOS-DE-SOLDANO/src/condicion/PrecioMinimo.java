package condicion;

import publicacion.Publicacion;

public class PrecioMinimo extends Base {
	private Integer valorBuscado;

	public PrecioMinimo(Integer valorBuscado) {
		super();
		this.valorBuscado = valorBuscado;
	}

	@Override
	protected boolean cumpleConCondicion(Publicacion publicacion) {
		return publicacion.getMontoTotal() >= this.getValorBuscado();
	}

	private Integer getValorBuscado() {
		return valorBuscado;
	}
}
