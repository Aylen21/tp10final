package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Mesa;
import ar.edu.unju.escmi.poo.dominio.Mozo;
import ar.edu.unju.escmi.poo.dominio.Reserva;
import ar.edu.unju.escmi.poo.dominio.Salon;

public interface IAdmiDeRestauranteDao {
	public int consultarMesas(int numSalon);

	public void consultarMesasOcup();

	public void darAltaReserva(Reserva reserva);

	public void buscarActualizarReserva();
	public void guardarSalon(Salon salon);
	public void cargarMesas1(List<Mesa> mesas, Salon salon);
	public void cargarMesas2(List<Mesa> mesas,Salon salon);
	public void cargarMesa(Mesa mesa);

	public void listarReservas();

	public void eliminarReserva(Reserva reserva);
	
	public List<Reserva> obtenerReservas();
	
	public boolean salonesMesasCargados();
	
	public Reserva traerUnaReserva(int id);
	public List<Mesa> obtenerMesasSalon1() ;
	public List<Mesa> obtenerMesasSalon2() ;
	public int calcularMesasNecesarias(int cantRequerida);

	public void cambiarEstado(Mesa mesa);
	public void cambiarTotal(int id, double nuevoTotal);
	public void liberarCantMesas(int cant, int numSalon);
//	public void asignarMozo(Reserva reserva);
	public List<Reserva> obtenerReservasDeMozo(Mozo mozo);
	public void cambiarMozo(int id);
//	public void limpiarReservas();//no sería necesario, ya existe eliminarReserva()

	
}
