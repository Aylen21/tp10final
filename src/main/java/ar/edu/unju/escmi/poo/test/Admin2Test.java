package ar.edu.unju.escmi.poo.test;

import org.junit.Test;

import ar.edu.unju.escmi.poo.dao.IAdmiDeRestauranteDao;
import ar.edu.unju.escmi.poo.dominio.Reserva;
import ar.edu.unju.escmi.poo.imp.AdmiDeRestauranteDaoImp;
import junit.framework.TestCase;

public class Admin2Test extends TestCase{
	
	@Override
	protected void setUp() throws Exception {
		System.out.println("inicio de test");
		//super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		System.out.println("fin de test");
		//super.tearDown();
	}
	

	@Test
	   public void testCantidadDeMesas() {
		
		int cant=20;
       IAdmiDeRestauranteDao  contado = new  AdmiDeRestauranteDaoImp();
        assertTrue(contado.obtenerMesasSalon1().size()==cant);
		
	}
	
}
