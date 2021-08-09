package publicacion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cancelacion.Cancelacion;
import enumerativos.FormasDePago;
import estadosPublicacion.EstadoDisponible;
import estadosPublicacion.EstadoPublicacion;
import notificaciones.Interes;
import notificaciones.Observer;
import tiempo.CheckTime;
import tiempo.PeriodoDeAlquiler;
import usuarioSAT.UsuarioSAT;

public class Publicacion {
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
	private List<Observer> observersInteresados;
	private HashMap<UsuarioSAT, FormasDePago> formaDePagoDePosibleInquilino;
	
	public Publicacion(int precioPorDia, UsuarioSAT propietario, Inmueble inmueblePublicado, List<FormasDePago> formasDePago, 
					   PeriodoDeAlquiler periodoDeAlquiler, CheckTime checkTime, Cancelacion tipoDeCancelacion) {
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
		this.observersInteresados = new ArrayList<Observer>();
		this.formaDePagoDePosibleInquilino = new HashMap<UsuarioSAT, FormasDePago>();
	}
	
	public UsuarioSAT getPropietario() {
		return propietario;
	}

	public Inmueble getInmueblePublicado() {
		return inmueblePublicado;
	}
	
	public UsuarioSAT getInquilino() {
		return inquilino;
	}

	public int getPrecioPorDia() {
		return precioPorDia;
	}
	
	public PeriodoDeAlquiler getPeriodoDeAlquiler() {
		return periodoDeAlquiler;
	}

	public CheckTime getCheckTime() {
		return checkTime;
	}
	
	public List<FormasDePago> getFormasDePago() {
		return formasDePago;
	}


	public Cancelacion getTipoDeCancelacion() {
		return tipoDeCancelacion;
	}
	
	public List<Observer> getObserversInteresados() {
		return observersInteresados;
	}
	
	public void setInquilino(UsuarioSAT inquilino) {
		this.inquilino = inquilino;
	}

	public List<UsuarioSAT> getInquilinosPendientes() {
		return inquilinosPendientes;
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
	
	public HashMap<UsuarioSAT, FormasDePago> getFormaDePagoDePosibleInquilino() {
		return formaDePagoDePosibleInquilino;
	}

	public void agregarAInquilinosPendientes(UsuarioSAT nuevoInquilino) {
		this.getInquilinosPendientes().add(nuevoInquilino);
	}
	
	public void removerInquilinoDePendientes(UsuarioSAT nuevoInquilino) {
		this.getInquilinosPendientes().remove(nuevoInquilino);
	}
	
	public int getMontoTotal() {
		return precioPorDia * periodoDeAlquiler.diasAlquiladosTotales();
	}

	public void reservar(UsuarioSAT nuevoInquilino, FormasDePago formaDePago) {
		estado.reservar(nuevoInquilino, this);
		formaDePagoDePosibleInquilino.put(nuevoInquilino, formaDePago);
	}
	
	public void aprobarReserva(UsuarioSAT nuevoInquilino) {
		estado.aprobarReserva(nuevoInquilino,this);
	}
	
	public void cancelarReservar() {
		estado.cancelarReservar(this);
		this.notificar(Interes.CANCELACION);
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
	
	public void cargarReseñarInmuebleAsociado(Reseña reseña) {
		estado.reseñarInmuebleAsociado(this, reseña);
	}
	
	public void finalizarPublicacion() {
		estado.finalizarPublicacion(this);
	}

	public void suscribir(Observer observer) {
		estado.suscribir(this, observer);
	}
		
	public void quitar(Observer observer) {
		estado.quitar(this, observer);
	}
	
	public void notificar(Interes interes) {
		estado.notificar(this, interes);
	}
}
