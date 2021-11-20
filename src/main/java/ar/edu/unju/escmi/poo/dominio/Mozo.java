package ar.edu.unju.escmi.poo.dominio;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name = "Mozos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Mozo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private long dniM;
	private String nombre;
	private String email;
	private long telefono;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getDniM() {
		return dniM;
	}
	public void setDniM(long dniM) {
		this.dniM = dniM;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public Mozo() {
		
	}
	public Mozo(long dniM, String nombre, String email, long telefono) {
		super();
		this.dniM = dniM;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Mozo [id=" + id + ", dniM=" + dniM + ", nombre=" + nombre + ", email=" + email + ", telefono="
				+ telefono + "]";
	}
	
	
	
}
