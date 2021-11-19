package ar.edu.unju.escmi.poo.dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Particular")
public class ClienteP extends Persona{

	  private long dni;

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public ClienteP(String nombre, String email, long telefono, long dni) {
		super(nombre, email, telefono);
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "ClienteP [dni=" + dni + ", getId()=" + getId() + ", getNombre()=" + getNombre() + ", getEmail()="
				+ getEmail() + ", getTelefono()=" + getTelefono() + "]";
	}

	
	


	
	  
	
}
