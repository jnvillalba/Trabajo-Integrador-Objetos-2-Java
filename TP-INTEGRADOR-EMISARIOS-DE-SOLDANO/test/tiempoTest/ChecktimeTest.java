package tiempoTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tiempo.CheckTime;

class ChecktimeTest {
	
	
	private LocalTime horarioCheckIn;
	private LocalTime horarioCheckOut;
	private CheckTime checkTime;
	private CheckTime checkOut;
	
	@BeforeEach
	void setUp() throws Exception {
		horarioCheckIn = LocalTime.of(12, 00, 00);
		horarioCheckOut = LocalTime.of(22, 00, 00);
		
		checkTime = new CheckTime(horarioCheckIn, horarioCheckOut);
		checkOut = new CheckTime(horarioCheckIn, LocalTime.now());
	}

	@Test
	void getHorarioCheckOutTest() {
		assertEquals(checkTime.getHorarioCheckOut(), horarioCheckOut);
	}
	
	@Test
	void getHorarioCheckInTest() {
		assertEquals(checkTime.getHorarioCheckIn(), horarioCheckIn);
	}
	
	@Test
	void finalizoEstadiaTest() {
		assertTrue(checkOut.finalizoEstadia());
	}
	
	

}
