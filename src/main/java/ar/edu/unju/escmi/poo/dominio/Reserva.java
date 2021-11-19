package ar.edu.unju.escmi.poo.dominio;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Reservas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idR;
	@ManyToOne
	@JoinColumn(name = "id")
	private Persona cliente;
	@ManyToOne
	@JoinColumn(name = "dniM")
	private Mozo mozo;
	@OneToMany(mappedBy = "reserva")
	private List<Mesa> mesa;
	private int cantidadComensales;
	private LocalDate fechaR;
	private LocalDate horaR;
	private double total;

	public Long getIdR() {
		return idR;
	}

	public void setIdR(Long idR) {
		this.idR = idR;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	public List<Mesa> getMesa() {
		return mesa;
	}

	public void setMesa(List<Mesa> mesa) {
		this.mesa = mesa;
	}

	public int getCantidadComensales() {
		return cantidadComensales;
	}

	public void setCantidadComensales(int cantidadComensales) {
		this.cantidadComensales = cantidadComensales;
	}

	public LocalDate getFechaR() {
		return fechaR;
	}

	public void setFechaR(LocalDate fechaR) {
		this.fechaR = fechaR;
	}

	public LocalDate getHoraR() {
		return horaR;
	}

	public void setHoraR(LocalDate horaR) {
		this.horaR = horaR;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Reserva [idR=" + idR + ", cliente=" + cliente + ", mozo=" + mozo + ", mesa=" + mesa
				+ ", cantidadComensales=" + cantidadComensales + ", fechaR=" + fechaR + ", horaR=" + horaR + ", total="
				+ total + "]";
	}

	public Reserva(Long idR, Persona cliente, Mozo mozo, List<Mesa> mesa, int cantidadComensales, LocalDate fechaR,
			LocalDate horaR, double total) {
		super();
		this.idR = idR;
		this.cliente = cliente;
		this.mozo = mozo;
		this.mesa = mesa;
		this.cantidadComensales = cantidadComensales;
		this.fechaR = fechaR;
		this.horaR = horaR;
		this.total = total;
	}

	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}

}
