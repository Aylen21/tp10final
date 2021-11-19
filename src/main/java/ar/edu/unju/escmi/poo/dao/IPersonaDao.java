package ar.edu.unju.escmi.poo.dao;

import ar.edu.unju.escmi.poo.dominio.Persona;

public interface IPersonaDao {
	public void darDeAltaMozo(Persona mozo);
	public void darDeAltaCLiente(Persona cliente);
	public void listarMozos();
}
