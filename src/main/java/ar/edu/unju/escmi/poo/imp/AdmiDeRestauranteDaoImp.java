package ar.edu.unju.escmi.poo.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IAdmiDeRestauranteDao;
import ar.edu.unju.escmi.poo.dominio.Mesa;
import ar.edu.unju.escmi.poo.dominio.Mozo;
import ar.edu.unju.escmi.poo.dominio.Reserva;
import ar.edu.unju.escmi.poo.dominio.Salon;



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
		
		Query query = manager.createQuery("SELECT e FROM Reserva e");
		@SuppressWarnings("unchecked")
		List<Reserva> reservas = (List<Reserva>)query.getResultList();
		reservas.stream().forEach(System.out::println);
		
	}

	@Override
	public void eliminarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.remove(reserva);
		manager.getTransaction().commit();	
	}
	@Override
	public List<Reserva> obtenerReservas() {
		@SuppressWarnings("unchecked")
		List<Reserva> reservas = (List<Reserva>) manager.createQuery("SELECT e FROM Reserva e").getResultList();
		return reservas;
	}
	@Override
	public boolean salonesMesasCargados() {
		// TODO Auto-generated method stub
		//con este metodo reviso si la base de datos ya se encuantra cargada, para no intnetar recargar los salones y mesas
		@SuppressWarnings("unchecked")
		List<Salon> salones = (List<Salon>) manager.createQuery("SELECT e FROM Salon e").getResultList();

		if(salones.size()==0) {
			System.out.println(" bd  vacia");
			return false;
		}
		else {
			System.out.println("bd con datos");
			return true;
		}
		
		
			
	}

}
