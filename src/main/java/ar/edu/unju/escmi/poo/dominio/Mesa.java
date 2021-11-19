package ar.edu.unju.escmi.poo.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Mesas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Mesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMesa;
	private static final int CAPACIDAD_PERSONAS = 4;
	private String Estado;
	@ManyToOne
	@JoinColumn(name = "nroDeSalon")
	private Salon salon;
	@ManyToOne
	@JoinColumn(name = "idR")
	private Reserva reserva;

	public Long getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(Long idMesa) {
		this.idMesa = idMesa;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public static int getCapacidadPersonas() {
		return CAPACIDAD_PERSONAS;
	}

	@Override
	public String toString() {
		return "Mesa [idMesa=" + idMesa + ", Estado=" + Estado + ", salon=" + salon + ", reserva=" + reserva + "]";
	}

	public Mesa(Long idMesa, String estado, Salon salon, Reserva reserva) {
		super();
		this.idMesa = idMesa;
		Estado = estado;
		this.salon = salon;
		this.reserva = reserva;
	}

	public Mesa() {
		super();
		// TODO Auto-generated constructor stub
	}

}
