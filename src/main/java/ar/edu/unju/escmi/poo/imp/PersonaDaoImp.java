package ar.edu.unju.escmi.poo.imp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IPersonaDao;
import ar.edu.unju.escmi.poo.dominio.ClienteAT;
import ar.edu.unju.escmi.poo.dominio.ClienteP;
import ar.edu.unju.escmi.poo.dominio.Persona;



public class PersonaDaoImp implements IPersonaDao {

	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

	

	@Override
	public void darDeAltaCLiente(Persona cliente) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();
	}



	@Override
	public void consultarDatosCliente() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public int obtenerPersona() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<ClienteAT> obtenerClientesAgenciaDeTurismo() {
		@SuppressWarnings("unchecked")
		List<ClienteAT> clientesAgencias = (List<ClienteAT>) manager.createQuery("SELECT e FROM Persona e where tipo like 'Agencia'").getResultList();
		return clientesAgencias;
	}



	@Override
	public Persona obtenerClienteP(long dni) {
		Query query = manager.createQuery("SELECT e FROM Persona e " + "WHERE e.dni = :dni");
		query.setParameter("dni", dni);
		Persona cliente = (Persona)query.getSingleResult();
		return cliente;
	}

	@Override
	public Persona obtenerClienteA(long cuit) {
		Query query = manager.createQuery("SELECT e FROM Persona e " + "WHERE e.cuit = :cuit");
		query.setParameter("cuit", cuit);
		Persona cliente = (Persona)query.getSingleResult();
		return cliente;
	}


	@Override
	public List<ClienteP> obtenerClientesParticulares() {
		@SuppressWarnings("unchecked")
		List<ClienteP> clientesParticulares = (List<ClienteP>) manager.createQuery("SELECT e FROM Persona e where tipo like 'Particular'").getResultList();
		return clientesParticulares;

	}
	

	/*@Override
	public int obtenerPersonas() {
		// TODO Auto-generated method stub
        Query query = manager.createQuery("SELECT p FROM Persona p ");
		List<Persona> personas = query.getResultList();
		if(personas.isEmpty()==false) {
			return 1;
		}else {
			return 0;			
		}
	}*/
	
}
