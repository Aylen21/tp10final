package ar.edu.unju.escmi.poo.dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Agencia")
public class ClienteAT extends Persona{

	private long cuit;

	public long getCuit() {
		return cuit;
	}

	public void setCuit(long cuit) {
		this.cuit = cuit;
	}

	public ClienteAT() {
		
	}


	public ClienteAT(String nombre, String email, long telefono, long cuit) {
		super(nombre, email, telefono);
		this.cuit = cuit;
	}

	@Override
	public String toString() {
		return "ClienteAT [cuit=" + cuit + ", getId()=" + getId() + ", getNombre()=" + getNombre() + ", getEmail()="
				+ getEmail() + ", getTelefono()=" + getTelefono() + "]";
	}

	

	
	
	
	
}
