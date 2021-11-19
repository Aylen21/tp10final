package ar.edu.unju.escmi.poo.principal;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ar.edu.unju.escmi.poo.dominio.AdminDeRestaurante;
import ar.edu.unju.escmi.poo.dominio.ClienteP;
import ar.edu.unju.escmi.poo.dominio.Salon;

public class Principal {
	public static EntityManagerFactory emf;
	public static EntityManager manager;
	
	public static void main(String[] args) {
		  //comentario
		
		emf=Persistence.createEntityManagerFactory("TestPersistence");
		manager = emf.createEntityManager();
		ClienteP clienteP1 = new ClienteP("Juan","Juarez",123,456);
		manager.getTransaction().begin();
		manager.persist(clienteP1);
		manager.getTransaction().commit();

		AdminDeRestaurante administrador = new AdminDeRestaurante("jjuan","12345");
		Scanner sc = new Scanner(System.in);
		String nombre, contra;
		boolean ingreso=false;
		Salon salon1 = new Salon(1,20);
		Salon salon2 = new Salon(2,10);
		
		
		
		
		
		
		
		/* Registro de el unico usuario administrador */
		while (ingreso == false) {
			System.out.println("-----Inicio de sesion-----");
			System.out.println("Nombre de usuario:");
			nombre = sc.next();
			System.out.println("Contrasenia:");
			contra = sc.next();
			if(administrador.getUser().equals(nombre)) {
				System.out.println("Usuario encontrado");
				if(administrador.getPassword().equals(contra)) {
					System.out.println("Contraseña correcta");
					ingreso=true;
				}
				else {
					System.out.println("Contraseña incorrecta");
				}
			}
			else {
				System.out.println("Usuario no encontrado");
			}
		}
		System.out.println("Listo el pollo");
		/*Menu principal*/
		System.out.println("1 - Alta de Mozo\r\n"
				+"2 - Listado de Mozos.\r\n"
				+"3 - Consultar disponibilidad de mesas según salón.\r\n"
				+ "4 - Consultar mesas ocupadas mostrando la cantidad de comensales.\r\n"
				+ "5 - Alta de una reserva.\r\n"
				+ "6 - Realizar la búsqueda de una reserva para realizar la modificación de total a pagar (significa que finaliza la reserva).\r\n"
				+ "7 - Consultar los datos del cliente ingresando cuil o dni.\r\n"
				+ "8 - Eliminar una reserva ingresando el id.\r\n"
				+ "9 - Listar todas las reservas."
				);

		int a = sc.nextInt();

		switch (a) {
		
		case 1:
			/*Listado de Mozos*/
			
	
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			/*Dar de alta reserva, precisa de definir si el cliente ya estaba registrado con anterioridad*/
			System.out.println("Ingrese el DNI o CUIT del cliente que va a realizar la reserva");
			long identificador;
			identificador= sc.nextLong();
					
			
			
			
			
			break;
		case 6:
			
			break;
		case 7:
			System.out.println("Ingrese el DNI o CUIT del cliente a buscar");
			long iden;
			iden= sc.nextLong();
			break;
		case 8:
			
			break;
		case 9:
			
			break;
			

		
		}
		
		
		
	}

}
