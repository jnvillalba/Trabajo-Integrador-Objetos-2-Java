package tiempo;

import java.time.LocalTime;

public class CheckTime {
	private LocalTime horarioCheckIn;
	private LocalTime horarioCheckOut;
	
	
	public CheckTime(LocalTime horarioCheckIn, LocalTime horarioCheckOut) {
		super();
		this.horarioCheckIn = horarioCheckIn;
		this.horarioCheckOut = horarioCheckOut;
	}
	
	public LocalTime getHorarioCheckIn() {
		return horarioCheckIn;
	}
	public LocalTime getHorarioCheckOut() {
		return horarioCheckOut;
	}
	
	public boolean finalizoEstadia() {
		return ((Integer) LocalTime.now().getHour()).equals((Integer)horarioCheckOut.getHour());
	}
}
