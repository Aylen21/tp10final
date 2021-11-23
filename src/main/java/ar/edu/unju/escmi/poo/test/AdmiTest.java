package ar.edu.unju.escmi.poo.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ar.edu.unju.escmi.poo.dominio.Reserva;
import junit.framework.TestCase;

public class AdmiTest extends TestCase{
	
	
	@Override
	protected void setUp() throws Exception {
		System.out.println("inicia test");
		//super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		System.out.println("finaliza el test");
		//super.tearDown();
	}
	
	
	@Test
	   public void testValidarListaReserva() {
		
		List<Reserva> reservas =   new ArrayList<Reserva>();
		Reserva reserva = new Reserva();
		reserva.setCantidadComensales(6);
		reservas.add(reserva);
		
		assertNotNull("La lista no esta vacia:",reservas);
	
	 }

}
