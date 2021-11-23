package ar.edu.unju.escmi.poo.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.internal.build.AllowSysOut;

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

		// @SuppressWarnings("unchecked")
		// List<Mesa> empleados = (List<Mesa>) manager.createQuery("SELECT e FROM
		// Empleado e").getResultList();
		return 0;

	}

	@Override
	public void consultarMesasOcup() {
		// TODO Auto-generated method stub

	}

	@Override
	public void darAltaReserva(Reserva reserva) {
		System.out.println("Haciendo alta mmmmmmmmmmm");
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
		List<Reserva> reservas = (List<Reserva>) query.getResultList();
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
		// con este metodo reviso si la base de datos ya se encuantra cargada, para no
		// intnetar recargar los salones y mesas
		@SuppressWarnings("unchecked")
		List<Salon> salones = (List<Salon>) manager.createQuery("SELECT e FROM Salon e").getResultList();

		if (salones.size() == 0) {
			System.out.println(" bd  vacia");
			return false;
		} else {
			System.out.println("bd con datos");
			return true;
		}

	}

	@Override
	public Reserva traerUnaReserva(int id) {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT e FROM Reserva e");
		@SuppressWarnings("unchecked")
		List<Reserva> reservas = (List<Reserva>) query.getResultList();
		for (int i = 0; i < reservas.size(); i++) {
			if (reservas.get(i).getIdR() == id) {
				return reservas.get(i);
			}
		}

		return null;
	}

	@Override
	public List<Mesa> obtenerMesasSalon1() {
		@SuppressWarnings("unchecked")
		List<Mesa> mesasDeS1 = (List<Mesa>) manager.createQuery("SELECT e FROM Mesa e WHERE nrodesalon like '1'")
				.getResultList();

		return mesasDeS1;
	}

	@Override
	public List<Mesa> obtenerMesasSalon2() {
		@SuppressWarnings("unchecked")
		List<Mesa> mesasDeS2 = (List<Mesa>) manager.createQuery("SELECT e FROM Mesa e WHERE nrodesalon like '2'")
				.getResultList();
		return mesasDeS2;
	}

	@Override
	public int calcularMesasNecesarias(int cantRequerida) {
		int mesasParaReserv = 0;
		int extra = 0;
		if ((cantRequerida % 4) > 0) {
			extra = 1;
		}
		mesasParaReserv = (cantRequerida / 4) + extra;

		return mesasParaReserv;
	}

	@Override
	public void cambiarEstado(Mesa mesa) {
		// TODO Auto-generated method stub
		
				manager.getTransaction().begin();
				manager.merge(mesa);
				manager.getTransaction().commit();
			}
		

	

//	@Override
//	public void asignarMozo(Reserva reserva) {
//		// TODO Auto-generated method stub
//		int pM = 0;
//		System.out.println("asignando un mozo");
//		/*
//		 * @SuppressWarnings("unchecked") List<Mozo> mozos= (List<Mozo>)
//		 * manager.createQuery("SELECT e FROM Mozo e").getResultList();
//		 */
//		@SuppressWarnings("unchecked")
//		List<Mozo> mozos = (List<Mozo>) manager.createQuery("SELECT e FROM Mozo e").getResultList();
//		// Query query = manager.createQuery("SELECT e FROM Mozo e");
//
//		// List<Mozo> mozos = (List<Mozo>)query.getResultList();
//		for (int i = 0; i < mozos.size(); i++) {
//			if (mozos.get(i).getReservas().size() < 4) {
//				pM = i;
//			}
//		}
//
//		reserva.setMozo(mozos.get(pM));
//		
//
//	}

	@Override
	public void guardarSalon(Salon salon) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
//		salon1.setMesas(mesas1);
		manager.persist(salon);
		manager.getTransaction().commit();
	}

	@Override
	public void cargarMesas1(List<Mesa> mesas, Salon salon) {
		// TODO Auto-generated method stub
		salon.setMesas(mesas);
		manager.getTransaction().begin();
		manager.persist(salon);
		manager.getTransaction().commit();
	}

	@Override
	public void cargarMesa(Mesa mesa) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(mesa);
		manager.getTransaction().commit();
	}

	@Override
	public void cargarMesas2(List<Mesa> mesas, Salon salon) {
		// TODO Auto-generated method stub
		salon.setMesas(mesas);
		manager.getTransaction().begin();
		manager.persist(salon);
		manager.getTransaction().commit();
	}

}
