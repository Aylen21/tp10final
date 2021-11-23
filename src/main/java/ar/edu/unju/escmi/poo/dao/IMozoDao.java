package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Mozo;
import ar.edu.unju.escmi.poo.dominio.Reserva;


public interface IMozoDao {

	public void darDeAltaMozo(Mozo mozo);
	public void listarMozos();
	public List<Mozo> obtenerMozos();
	public boolean revisarMozosEnBd();
	public void asignarReserva(Reserva reserva);
	
}
