package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.ClienteAT;
import ar.edu.unju.escmi.poo.dominio.ClienteP;
import ar.edu.unju.escmi.poo.dominio.Persona;

public interface IPersonaDao {

	
	
	public void darDeAltaCLiente(Persona cliente);
    
	public void consultarDatosCliente();
	public int obtenerPersona();
	public List<ClienteAT> obtenerClientesAgenciaDeTurismo();
	public Persona obtenerClienteP(long dni);
	public List<ClienteP> obtenerClientesParticulares();
	public Persona obtenerClienteA(long cuit);
	/*public void guardarEmpleado(Empleado empleado);
	public void borrarEmpleado(Empleado empleado);
	public List<Empleado> obtenerEmpleados();
	public void modificarEmpleado(Empleado empleado);
	public Empleado obtenerEmpleado(Long dniEmpleado);
	public List<Empleado> obtenerEmpleadosPasantes();
	public List<Empleado> obtenerEmpleadosContratados();*/
	
}
