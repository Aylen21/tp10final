package ar.edu.unju.escmi.poo.dominio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Mesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMesa;
	private static final int CAPACIDAD_PERSONAS = 4;
	private int comensalesSentados;
	private String Estado;
	@ManyToOne//(cascade = {CascadeType.ALL})
	@JoinColumn(name = "nroDeSalon")//dueño de relación
	private Salon salon;
	
	@ManyToOne//(cascade = {CascadeType.ALL})
	@JoinColumn(name = "idR")
	private Reserva reserva;

	
	public Long getIdMesa() {
		return idMesa;
	}

//	public void setIdMesa(Long idMesa) {
//		this.idMesa = idMesa;
//	}

	public static int getCantidadPersonas() {
		return CAPACIDAD_PERSONAS;
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

	public static int getCapacidadPersonas() {
		return CAPACIDAD_PERSONAS;
	}

	public Mesa() {

	}

	public Mesa(int comensalesSentados, String estado, Salon salon, Reserva reserva) {
		super();
		this.comensalesSentados = comensalesSentados;
		Estado = estado;
		this.salon = salon;
		this.reserva = reserva;
	}

	public int getComensalesSentados() {
		return comensalesSentados;
	}

	public void setComensalesSentados(int comensalesSentados) {
		this.comensalesSentados = comensalesSentados;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	@Override
	public String toString() {
		return "Mesa [idMesa=" + idMesa + ", comensalesSentados=" + comensalesSentados + ", Estado=" + Estado
				+ ", salon=" + salon +  "]";
	}


}
