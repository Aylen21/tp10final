package ar.edu.unju.escmi.poo.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="Salones")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Salon {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	private int capacidadMesas;
    private int nroDeSalon;
	
	
	public int getCapacidadMesas() {
		return capacidadMesas;
	}

	public void setCapacidadMesas(int capacidadMesas) {
		this.capacidadMesas = capacidadMesas;
	}


	public Long getId() {
		return id;
	}

	public void setIdS(Long id) {
		this.id = id;
	}


	public int getNroDeSalon() {
		return nroDeSalon;
	}

	public void setNroDeSalon(int nroDeSalon) {
		this.nroDeSalon = nroDeSalon;
	}

	public Salon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Salon(Long id, int capacidadMesas, int nroDeSalon) {
		super();
		this.id = id;
		this.capacidadMesas = capacidadMesas;
		this.nroDeSalon = nroDeSalon;
	}

	@Override
	public String toString() {
		return "Salon [id=" + id + ", capacidadMesas=" + capacidadMesas + ", nroDeSalon=" + nroDeSalon + "]";
	}

	
	
	
}
