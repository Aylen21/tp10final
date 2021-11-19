package ar.edu.unju.escmi.poo.dao;

public interface IAdmiDeRestauranteDao {

	public void consultarMesas();

	public void consultarMesasOcup();

	public void darAltaReserva();

	public void buscarActualizarReserva();

	public void listarReservas();

	public void eliminarReserva();
//	public void limpiarReservas();//no sería necesario, ya existe eliminarReserva()
}
