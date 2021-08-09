package publicacionTest;

import java.util.ArrayList;
import java.util.List;

import cancelacion.Cancelacion;
import enumerativos.FormasDePago;
import estadosPublicacion.EstadoDisponible;
import estadosPublicacion.EstadoFinalizado;
import estadosPublicacion.EstadoPublicacion;
import publicacion.Inmueble;
import publicacion.Publicacion;
import publicacion.Reseña;
import tiempo.CheckTime;
import tiempo.PeriodoDeAlquiler;
import usuarioSAT.UsuarioSAT;

public class PublicacionCopia {
	
private EstadoPublicacion estado;
	

	private int precioPorDia;
	private UsuarioSAT inquilino;
	private UsuarioSAT propietario;
	private List<UsuarioSAT> inquilinosPendientes;
	private Inmueble inmueblePublicado;
	private List<FormasDePago> formasDePago;
	private FormasDePago formaDePagoInquilino;
	private PeriodoDeAlquiler periodoDeAlquiler;
	private CheckTime checkTime;
	private Cancelacion tipoDeCancelacion;
	
	
	public PublicacionCopia(int precioPorDia, UsuarioSAT propietario, Inmueble inmueblePublicado,
			List<FormasDePago> formasDePago, PeriodoDeAlquiler periodoDeAlquiler, CheckTime checkTime,
			Cancelacion tipoDeCancelacion) {
		super();
		this.estado = new EstadoDisponible();
		this.precioPorDia = precioPorDia;
		this.propietario = propietario;
		this.inmueblePublicado = inmueblePublicado;
		this.formasDePago = formasDePago;
		this.periodoDeAlquiler = periodoDeAlquiler;
		this.checkTime = checkTime;
		this.tipoDeCancelacion = tipoDeCancelacion;
		this.inquilinosPendientes = new ArrayList<UsuarioSAT>();
	}
	
	
	public UsuarioSAT getPropietario() {
		return propietario;
	}

	public Inmueble getInmueblePublicado() {
		return inmueblePublicado;
	}


	public PeriodoDeAlquiler getPeriodoDeAlquiler() {
		return periodoDeAlquiler;
	}

	public CheckTime getCheckTime() {
		return checkTime;
	}
	
	public int getPrecioPorDia() {
		return precioPorDia;
	}
	
	public UsuarioSAT getInquilino() {
		return inquilino;
	}
	
	public void setInquilino(UsuarioSAT inquilino) {
		this.inquilino = inquilino;
	}

	public List<UsuarioSAT> getInquilinosPendientes() {
		return inquilinosPendientes;
	}
	
	public List<FormasDePago> getFormasDePago() {
		return formasDePago;
	}


	public Cancelacion getTipoDeCancelacion() {
		return tipoDeCancelacion;
	}


	public FormasDePago getFormaDePagoInquilino() {
		return formaDePagoInquilino;
	}

	public void setEstado(EstadoPublicacion estado) {
		this.estado = estado;
	}

	public void setFormaDePagoInquilino(FormasDePago formaDePago) {
		this.formaDePagoInquilino = formaDePago;
	}

	public int getMontoTotal() {
		return precioPorDia * periodoDeAlquiler.diasAlquiladosTotales();
	}
	
	public void aprobarReserva(UsuarioSAT nuevoInquilino , Publicacion publicacion) {
		estado.aprobarReserva(nuevoInquilino,publicacion);
	}
	
	public void cancelarReservar(Publicacion publicacion) {
		estado.cancelarReservar(publicacion);
	}

	
	public void agregarAInquilinosPendientes(UsuarioSAT nuevoInquilino) {
		this.getInquilinosPendientes().add(nuevoInquilino);
	}
	
	public void removerAInquilinosPendientes(UsuarioSAT nuevoInquilino) {
		this.getInquilinosPendientes().remove(nuevoInquilino);
	}
	
	public boolean estaDisponible() {
		return estado.estaDisponible();
	}
	
	public boolean estaReservado() {
		return estado.estaReservado();
	}
	
	public boolean estaFinalizado() {
		return estado.estaFinalizado();
	}
	
	public void generarReseña(Reseña reseña) {
		if (this.estaFinalizado()) {
			inmueblePublicado.agregarReseñaInmueble(reseña);
		}else {
			throw new RuntimeException("Debe finalizar la estadia parar reseñar");
		}
		
	}
	
	public void finalizarPublicacion() {
		if (periodoDeAlquiler.finalizoEstadia() && checkTime.finalizoEstadia()) {
			this.setEstado(new EstadoFinalizado());
		}
		
	}

}
