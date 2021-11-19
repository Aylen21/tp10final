package ar.edu.unju.escmi.poo.dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Mozos")
public class Mozo extends Persona {

	private long dniM;

	public long getDniM() {
		return dniM;
	}

	public void setDniM(long dniM) {
		this.dniM = dniM;
	}

	public Mozo() {
		
	}

	public Mozo(String nombre, String email, long telefono, long dniM) {
		super(nombre, email, telefono);
		this.dniM = dniM;
	}

	@Override
	public String toString() {
		return "Mozo [dniM=" + dniM + ", getId()=" + getId() + ", getNombre()=" + getNombre() + ", getEmail()="
				+ getEmail() + ", getTelefono()=" + getTelefono() + "]";
	}
	
}
