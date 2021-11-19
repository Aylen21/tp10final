package ar.edu.unju.escmi.poo.dominio;


public class AdminDeRestaurante {

	  
	private String user;
	private String password;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AdminDeRestaurante() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminDeRestaurante(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminDeRestaurante [user=" + user + ", password=" + password + "]";
	}


}
