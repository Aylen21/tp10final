package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Mozo;


public interface IMozoDao {

	public void darDeAltaMozo(Mozo mozo);
	public void listarMozos();
	public List<Mozo> obtenerMozos();
	
}
