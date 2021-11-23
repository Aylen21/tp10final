package ar.edu.unju.escmi.poo.imp;

import java.util.ArrayList;
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

		Query query = manager.createQuery("SELECT e FROM Mesa e");
		@SuppressWarnings("unchecked")
		List<Mesa> mesas = (List<Mesa>) query.getResultList();
//		mesas.stream().forEach(System.out::println);
		List<Mesa> mesasOcup = new ArrayList<Mesa>();
		for (int i = 0; i < mesas.size(); i++) {
			// busca todas las mesas ocupadas y las guarda para luego mostrar info
			if (mesas.get(i).getEstado().equals("ocupada")) {
				mesasOcup.add(mesas.get(i));
			}
		}
		int contMesas1 = 0, contMesas2 = 0, comensales1 = 0, comensales2 = 0;
		for (int j = 0; j < mesasOcup.size(); j++) {
			if (mesasOcup.get(j).getSalon().getNroDeSalon() == 1) {
				contMesas1++;
				comensales1 = comensales1 + mesasOcup.get(j).getComensalesSentados();
			}
		}
		for (int k = 0; k < mesasOcup.size(); k++) {
			if (mesasOcup.get(k).getSalon().getNroDeSalon() == 2) {
				contMesas2++;
				comensales2 = comensales2 + mesasOcup.get(k).getComensalesSentados();
			}
		}

		System.out.println(
				" En el salon 1, hay " + contMesas1 + " mesas ocupadas, y " + comensales1 + " comnsales sentados");
		System.out.println(
				" En el salon 2, hay " + contMesas2 + " mesas ocupadas, y " + comensales2 + " comnsales sentados");

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
			return false;
		} else {
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

	@Override
	public void cambiarTotal(int id, double nuevoTotal) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Reserva> reservas = (List<Reserva>) manager.createQuery("SELECT e FROM Reserva e").getResultList();
		for (int i = 0; i < reservas.size(); i++) {
			if (reservas.get(i).getIdR() == id) {
				reservas.get(i).setTotal(nuevoTotal);
				manager.getTransaction().begin();
				manager.merge(reservas.get(i));
				manager.getTransaction().commit();
			}
		}

	}

	@Override
	public void cambiarEstado(Mesa mesa) {
		// TODO Auto-generated method stub

		manager.getTransaction().begin();
		manager.merge(mesa);
		manager.getTransaction().commit();
	}

	@Override
	public void liberarCantMesas(int cant, int numSalon) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Mesa> mesas = (List<Mesa>) manager.createQuery("SELECT e FROM Mesa e").getResultList();
		for (int i = 0; i < mesas.size(); i++) {
			if (mesas.get(i).getSalon().getNroDeSalon() == numSalon) {

				if (mesas.get(i).getEstado().equals("ocupada")) {
					mesas.get(i).setEstado("desocupada");
					manager.getTransaction().begin();
					manager.merge(mesas.get(i));
					manager.getTransaction().commit();
				}

			}
		}

	}
	
	@Override
	public List<Reserva> obtenerReservasDeMozo(Mozo mozo) {
		// TODO Auto-generated method stub
		List<Reserva> reservas = new ArrayList<Reserva>();
		for(Reserva r: obtenerReservas()) {
			if(r.getMozo().equals(mozo)) {
				reservas.add(r);
			}
		}
		return reservas;
	}
	@Override
	public void cambiarMozo(int id) {
			// TODO Auto-generated method stub
			@SuppressWarnings("unchecked") List<Reserva> reservas= (List<Reserva>)
					manager.createQuery("SELECT e FROM Reserva e").getResultList();
			for(int i=0;i<reservas.size();i++) {
				if(reservas.get(i).getIdR()==id) {
					reservas.get(i).setMozo(null);
					manager.getTransaction().begin();
					manager.merge(reservas.get(i));
					manager.getTransaction().commit();
				}
			}
			
		}

}
