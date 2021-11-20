package ar.edu.unju.escmi.poo.imp;

import javax.persistence.EntityManager;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IMozoDao;
import ar.edu.unju.escmi.poo.dominio.Mozo;

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
		// TODO Auto-generated method stub
		
	}

	
	
	
}
