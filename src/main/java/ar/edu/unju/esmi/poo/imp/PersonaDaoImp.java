package ar.edu.unju.esmi.poo.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IPersonaDao;
import ar.edu.unju.escmi.poo.dominio.AdminDeRestaurante;
import ar.edu.unju.escmi.poo.dominio.Persona;

public class PersonaDaoImp implements IPersonaDao {

	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

	@Override
	public void darDeAltaMozo(Persona mozo) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(mozo);
		manager.getTransaction().commit();
		
	}

	@Override
	public void darDeAltaCLiente(Persona cliente) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();
	}

	@Override
	public void listarMozos() {
		// TODO Auto-generated method stub

	}

	@Override
	public void consultarDatosCliente() {
		// TODO Auto-generated method stub

	}

	@Override
	public int obtenerPersonas() {
		// TODO Auto-generated method stub
        Query query = manager.createQuery("SELECT p FROM Persona p ");
		List<Persona> personas = query.getResultList();
		if(personas.isEmpty()==false) {
			return 1;
		}else {
			return 0;			
		}


	}

	

}
