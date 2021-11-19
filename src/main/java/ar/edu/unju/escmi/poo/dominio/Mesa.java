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

	public Long getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(Long idMesa) {
		this.idMesa = idMesa;
	}

	public static int getCantidadPersonas() {
		return CAPACIDAD_PERSONAS;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public Mesa() {

	}

	public Mesa(String estado) {
		super();
		Estado = estado;
	}

	@Override
	public String toString() {
		return "Mesa [idMesa=" + idMesa + ", Estado=" + Estado + "]";
	}

}
