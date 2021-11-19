package ar.edu.unju.escmi.poo.principal;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ar.edu.unju.escmi.poo.dao.IPersonaDao;
import ar.edu.unju.escmi.poo.dominio.AdminDeRestaurante;
import ar.edu.unju.escmi.poo.dominio.ClienteP;
import ar.edu.unju.escmi.poo.dominio.Mozo;
import ar.edu.unju.escmi.poo.dominio.Persona;
import ar.edu.unju.escmi.poo.dominio.Salon;
import ar.edu.unju.esmi.poo.imp.PersonaDaoImp;

public class Principal {
	public static EntityManagerFactory emf;
	public static EntityManager manager;

	public static void main(String[] args) {
		// comentario

		emf = Persistence.createEntityManagerFactory("TestPersistence");
		manager = emf.createEntityManager();

		/*   */
		//
		Scanner sc = new Scanner(System.in);
		String nombre, contra;
		boolean ingreso = false;
		Salon salon1 = new Salon(1, 20);
		Salon salon2 = new Salon(2, 10);
		//creando administrador
		AdminDeRestaurante administrador = new AdminDeRestaurante("jjuan", "12345");
		
		
		
//		crearPersonas();//por defecto

		
		 /* Registro de el unico usuario administrador*/
		  while (ingreso == false) {
		  System.out.println("-----Inicio de sesion-----");
		  System.out.println("Nombre de usuario:"); nombre = sc.next();
		  System.out.println("Contrasenia:"); contra = sc.next();
		  if(administrador.getUser().equals(nombre)) {
		  System.out.println("Usuario encontrado");
		  if(administrador.getPassword().equals(contra)) {
		  System.out.println("Contraseña correcta"); ingreso=true; } else {
		  System.out.println("Contraseña incorrecta"); } } else {
		  System.out.println("Usuario no encontrado"); } }
		 
		System.out.println("Listo el pollo");
		/* Menu principal */
		System.out.println("- Alta de Mozo\r\n" + "- Listado de Mozos.\r\n"
				+ "- Consultar disponibilidad de mesas según salón.\r\n"
				+ "- Consultar mesas ocupadas mostrando la cantidad de comensales.\r\n" + "- Alta de una reserva.\r\n"
				+ "- Realizar la búsqueda de una reserva para realizar la modificación de total a pagar (significa\r\n"
				+ "que finaliza la reserva). El estado se debe actualizar de forma automática (no se ingresa).\r\n"
				+ "Las mesas deben quedar liberadas para una próxima reserva.\r\n"
				+ "- Consultar los datos del cliente ingresando cuil o dni.\r\n"
				+ "- Eliminar una reserva ingresando el id.\r\n" + "- Listar todas las reservas.");

		int a = sc.nextInt();

		switch (a) {

		case 1:
			System.out.println("Carga de datos de Mozo:");
			Mozo mozo1 = new Mozo();
//			System.out.println("Ingrese DNI del mozo");
//			mozo1.setDniM(sc.nextLong());
			System.out.println("Ingrse nombre de mozo");
			mozo1.setNombre(sc.next());
			System.out.println("Ingrese email de mozo");
			mozo1.setEmail(sc.next());
			System.out.println("Ingrese telefono de mozo");
			mozo1.setTelefono(sc.nextLong());
			// enviar esto, para que PersonaDaoImp lo use
			IPersonaDao personaDao = new PersonaDaoImp();
			personaDao.darDeAltaMozo(mozo1);
			System.out.println("Mozo cargado exitosamente");

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;
		case 6:

			break;
		case 7:

			break;
		case 8:

			break;
		case 9:

			break;

		}

	}

	public static void crearPersonas() {
		IPersonaDao personaDao = new PersonaDaoImp();
//	List<Persona> personas= personaDao.obtenerPersonas();

	
		Persona clienteP1 = new ClienteP("Juan", "Juarez", 123, 456);

		if (personaDao.obtenerPersonas() == 0) {
//		mesaAux.cargarMesas(); mozos, etc

			// creando al usario admin
//			personaDao.cargarAdmin(administrador);
			// cargando cliente
			personaDao.darDeAltaCLiente(clienteP1);

		} else {
			System.out.println("Base de datos cargada anteriormente");
		}
	}

}
