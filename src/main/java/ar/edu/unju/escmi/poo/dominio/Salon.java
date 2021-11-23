package ar.edu.unju.escmi.poo.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Salones")
public class Salon {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int nroDeSalon;
	private int capacidadMesas;
   @OneToMany(mappedBy = "salon")//
	private List<Mesa> mesas;
	
	
	public int getCapacidadMesas() {
		return capacidadMesas;
	}

	public void setCapacidadMesas(int capacidadMesas) {
		this.capacidadMesas = capacidadMesas;
	}


	

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
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

	@Override
	public String toString() {
		return "Salon [nroDeSalon=" + nroDeSalon + ", capacidadMesas=" + capacidadMesas + ", mesas=" + mesas + "]";
	}

	public Salon(int nroDeSalon, int capacidadMesas, List<Mesa> mesas) {
		super();
		this.nroDeSalon = nroDeSalon;
		this.capacidadMesas = capacidadMesas;
		this.mesas = mesas;
	}


	
	
	
}
