package ar.edu.unju.escmi.poo.dao;

import ar.edu.unju.escmi.poo.dominio.Reserva;

public interface IAdmiDeRestauranteDao {
	public int consultarMesas(int numSalon);

	public void consultarMesasOcup();

	public void darAltaReserva(Reserva reserva);

	public void buscarActualizarReserva();

	public void listarReservas();

	public void eliminarReserva();
//	public void limpiarReservas();//no sería necesario, ya existe eliminarReserva()
}
