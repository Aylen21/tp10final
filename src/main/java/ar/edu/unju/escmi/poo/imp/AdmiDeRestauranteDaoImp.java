package ar.edu.unju.escmi.poo.imp;

import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IAdmiDeRestauranteDao;
import ar.edu.unju.escmi.poo.dominio.Mesa;
import ar.edu.unju.escmi.poo.dominio.Reserva;



public class AdmiDeRestauranteDaoImp implements IAdmiDeRestauranteDao {

	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
	
	@Override
	public int consultarMesas(int numSalon) {
	// TODO Auto-generated method stub
		
		//@SuppressWarnings("unchecked")
		//List<Mesa> empleados = (List<Mesa>) manager.createQuery("SELECT e FROM Empleado e").getResultList();
		return 0;
	
	}
	@Override
	public void consultarMesasOcup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darAltaReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(reserva);
		manager.getTransaction().commit();	
		
	}

	@Override
	public void buscarActualizarReserva() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarReservas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarReserva() {
		// TODO Auto-generated method stub
		
	}

}
