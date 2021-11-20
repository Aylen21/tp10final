package ar.edu.unju.escmi.poo.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ar.edu.unju.escmi.poo.dao.IAdmiDeRestauranteDao;
import ar.edu.unju.escmi.poo.dao.IPersonaDao;
import ar.edu.unju.escmi.poo.dominio.AdminDeRestaurante;
import ar.edu.unju.escmi.poo.dominio.ClienteP;
import ar.edu.unju.escmi.poo.dominio.Mesa;
import ar.edu.unju.escmi.poo.dominio.Mozo;
import ar.edu.unju.escmi.poo.dominio.Salon;
import ar.edu.unju.escmi.poo.imp.AdmiDeRestauranteDaoImp;
import ar.edu.unju.escmi.poo.imp.PersonaDaoImp;

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
		
		//cargamos mesas y salones
		Mesa mesa=new Mesa();
		List<Mesa> mesas1=new ArrayList<Mesa>(); //creando mesas
		List<Mesa> mesas2=new ArrayList<Mesa>();
		
		Salon salon1 = new Salon(1,20,mesas1);
		Salon salon2 = new Salon(2,10,mesas2);
		
		
		manager.getTransaction().begin();
//		salon1.setMesas(mesas1);
		manager.persist(salon1);
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
//		salon2.setMesas(mesas2);
		manager.persist(salon2);
		manager.getTransaction().commit();
		
		mesas1=cargarMesas1(salon1);//cargando mesas
		mesas2=cargarMesas2(salon2);
		
	    

	
		
		
		
		
		//cargando salon en las mesas
	/*for (int k=0;k<mesas1.size();k++) {
		mesas1.get(k).setSalon(salon1);
		manager.getTransaction().begin();
		manager.persist(mesas1.get(k));
		manager.getTransaction().commit();
	}
	for (int j=0;j<mesas2.size();j++) {
		mesas1.get(j).setSalon(salon2);
		manager.getTransaction().begin();
		manager.persist(mesas2.get(j));
		manager.getTransaction().commit();
	}
		*/
	
	 
	//
		
		
		
		


		
		//
		
		
		
		
		
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
			System.out.println("Carga de datos de Mozo:");
			Mozo mozo1 = new Mozo();
			System.out.println("Ingrese DNI del mozo");
			mozo1.setDniM(sc.nextLong());
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
			IAdmiDeRestauranteDao admiDao= new AdmiDeRestauranteDaoImp();
			System.out.println("Ingrese numero de salon");
			int numSalon=sc.nextInt();//debe ser 1 o 2
			admiDao.consultarMesas(numSalon);
			
			//ahora deviulve cuantas mesas tiene disponible el salon
			
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
	
	
	
	public static List<Mesa> cargarMesas1(Salon salon1) {
	
		List<Mesa> mesas1=new ArrayList<Mesa>();
		
		for(int i=0;i<20;i++) {//agregando 20 mesas a la lista
			Mesa mesa=new Mesa();//creando una mesa
			mesa.setEstado("desocupada");
			mesa.setSalon(salon1);
			mesas1.add(mesa);//agregando la mesa
			manager.getTransaction().begin();
			manager.persist(mesa);
			manager.getTransaction().commit();

		}
		return mesas1;
	}
	public static List<Mesa> cargarMesas2(Salon salon2){
		
		List<Mesa> mesas2=new ArrayList<Mesa>();
		
		for(int i=0;i<10;i++) {//agregando 10 mesas a la lista
			Mesa mesa=new Mesa();//creando una mesa
			mesa.setEstado("desocupada");
			mesa.setSalon(salon2);
			mesas2.add(mesa);//agregando la mesa
			manager.getTransaction().begin();
			manager.persist(mesa);
			manager.getTransaction().commit();

		}
		return mesas2;
	}

}
