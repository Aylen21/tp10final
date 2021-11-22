package ar.edu.unju.escmi.poo.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IMozoDao;
import ar.edu.unju.escmi.poo.dominio.Mozo;
import ar.edu.unju.escmi.poo.dominio.Salon;

public class MozoDaoImp implements IMozoDao{
	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

	@Override
	public void darDeAltaMozo(Mozo mozo) {
		manager.getTransaction().begin();
		manager.persist(mozo);
		manager.getTransaction().commit();
	}

	@Override
	public void listarMozos() {
		Query query = manager.createQuery("SELECT e FROM Mozo e");
		@SuppressWarnings("unchecked")
		List<Mozo> mozos = (List<Mozo>)query.getResultList();
		mozos.stream().forEach(System.out::println);
		
	}

	@Override
	public List<Mozo> obtenerMozos() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Mozo> mozos = (List<Mozo>) manager.createQuery("SELECT e FROM Mozo e").getResultList();
		return mozos;
	}

	@Override
	public boolean mozosEnBd() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Mozo> mozos = (List<Mozo>) manager.createQuery("SELECT e FROM Mozo e").getResultList();

		if(mozos.size()==0) {
			System.out.println(" bd  sin mozos");
			return false;
		}
		else {
			System.out.println("bd con mozos");
			return true;
		}
	}

	
	
	
}
