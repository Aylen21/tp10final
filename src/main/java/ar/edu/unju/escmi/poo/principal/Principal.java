package ar.edu.unju.escmi.poo.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ar.edu.unju.escmi.poo.dao.IAdmiDeRestauranteDao;
import ar.edu.unju.escmi.poo.dao.IMozoDao;
import ar.edu.unju.escmi.poo.dao.IPersonaDao;
import ar.edu.unju.escmi.poo.dominio.AdminDeRestaurante;
import ar.edu.unju.escmi.poo.dominio.ClienteAT;
import ar.edu.unju.escmi.poo.dominio.ClienteP;
import ar.edu.unju.escmi.poo.dominio.Mesa;
import ar.edu.unju.escmi.poo.dominio.Mozo;
import ar.edu.unju.escmi.poo.dominio.Persona;
import ar.edu.unju.escmi.poo.dominio.Reserva;
import ar.edu.unju.escmi.poo.dominio.Salon;
import ar.edu.unju.escmi.poo.imp.AdmiDeRestauranteDaoImp;
import ar.edu.unju.escmi.poo.imp.MozoDaoImp;
import ar.edu.unju.escmi.poo.imp.PersonaDaoImp;
import ar.edu.unju.escmi.poo.util.FechaUtil;





public class Principal {
	public static EntityManagerFactory emf;
	public static EntityManager manager;
	
	public static void main(String[] args) throws Exception {
		  //comentario
		boolean confirmacionSalida=false;
		IPersonaDao persDao = new PersonaDaoImp();
		IMozoDao mozoDao = new MozoDaoImp();
		IAdmiDeRestauranteDao admiDao= new AdmiDeRestauranteDaoImp();
		emf=Persistence.createEntityManagerFactory("TestPersistence");
		manager = emf.createEntityManager();
		
		

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
		
		
	/*	Descomentar solo cuando se crea bd
	 * manager.getTransaction().begin();
//		salon1.setMesas(mesas1);
		manager.persist(salon1);
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
//		salon2.setMesas(mesas2);
		manager.persist(salon2);
		manager.getTransaction().commit();
		
		mesas1=cargarMesas1(salon1);//cargando mesas
		mesas2=cargarMesas2(salon2);
		
		*
		*ClienteP clienteP1 = new ClienteP("Juan","Juarez",123,456);
		manager.getTransaction().begin();
		manager.persist(clienteP1);
		manager.getTransaction().commit();
		*/ //no descomentar cuando se actualiza bd
	    

	
		
		
		
		
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
		do {
		System.out.println("1 - Alta de Mozo\r\n"
				+"2 - Listado de Mozos.\r\n"
				+"3 - Consultar disponibilidad de mesas según salón.\r\n"
				+ "4 - Consultar mesas ocupadas mostrando la cantidad de comensales.\r\n"
				+ "5 - Alta de una reserva.\r\n"
				+ "6 - Realizar la búsqueda de una reserva para realizar la modificación de total a pagar (significa que finaliza la reserva).\r\n"
				+ "7 - Consultar los datos del cliente ingresando cuil o dni.\r\n"
				+ "8 - Eliminar una reserva ingresando el id.\r\n"
				+ "9 - Listar todas las reservas.\r\n"
				+"10 - Salir"
				);

		int a = sc.nextInt();

		switch (a) {
		
		case 1:
			System.out.println("Carga de datos de Mozo:");
			Mozo mozo1 = new Mozo();
			System.out.println("Ingrese DNI del mozo");
			mozo1.setDniM(sc.nextLong());
			System.out.println("Ingrese nombre de mozo");
			mozo1.setNombre(sc.next());
			System.out.println("Ingrese email de mozo");
			mozo1.setEmail(sc.next());
			System.out.println("Ingrese telefono de mozo");
			mozo1.setTelefono(sc.nextLong());
			// enviar esto, para que PersonaDaoImp lo use
			
			mozoDao.darDeAltaMozo(mozo1);
			System.out.println("Mozo cargado exitosamente");
			
	
			break;
		case 2:
			/*Busca los mozos mediante for each en una lista y muestra todos los existentes*/
			mozoDao.listarMozos();
			break;
		case 3:
			
			System.out.println("Ingrese numero de salon");
			int numSalon=sc.nextInt();//debe ser 1 o 2
			admiDao.consultarMesas(numSalon);
			
			//ahora devuelve cuantas mesas tiene disponible el salon
			
			break;
		case 4:
			
			break;
		case 5:
			/*Dar de alta reserva, precisa de definir si el cliente ya estaba registrado con anterioridad*/
			
			System.out.println("El cliente a buscar es de tipo agencia de turismo(A) o  particular:(P)");
			String identificador = sc.next();
			String A = "A";
			String P = "P";
			boolean encontrado=false;
			if(identificador.equals(A)) {
				System.out.println("Ingrese el cuit del cliente agencia de turismo");
				long cuit = sc.nextLong();
			    
				for(int i = 0; i < persDao.obtenerClientesAgenciaDeTurismo().size(); i++) {
				   if(cuit == persDao.obtenerClientesAgenciaDeTurismo().get(i).getCuit()) {
					   System.out.println("Cliente Encontrado");
                       encontrado=true;
                       Reserva reserva1 = new Reserva();
   					System.out.println(" Creando reserva... ");

   					System.out.println(" Ingrese la cantidad de comensales ");
   					reserva1.setCantidadComensales(sc.nextInt());
   					System.out.println(" Ingrese fecha de reserva");// try catch
   					String fecha = sc.next();
   					reserva1.setFechaR(FechaUtil.convertirStringLocalDate(fecha));
   					System.out.println(" Ingrese hora: [HH:MM] (ejemplo: 17:30)");
   					String hora = sc.next();
   					reserva1.setHoraR(FechaUtil.convertirStringLocalTime(hora));// try catch

   				reserva1.setCliente(persDao.obtenerClientesAgenciaDeTurismo().get(i));
//   				reserva1.setMozo(mozo1);
//   				reserva1.setMesa(mesas2);//guardar la lista de mesas
   					admiDao.darAltaReserva(reserva1);
				   }
				}
                 if (encontrado == false) {
					System.out.println("No se encontró ClienteAgencia con ese número de cuit");

					System.out.println("Ingrese los datos del cliente para hacer la reserva:");
					ClienteAT clienteA1 = new ClienteAT();
					System.out.println("Ingrese CUIT del clienteAT");
					clienteA1.setCuit(sc.nextLong());
					System.out.println("Ingrse nombre de clienteAT");
					clienteA1.setNombre(sc.next());
					System.out.println("Ingrese email de clienteAT");
					clienteA1.setEmail(sc.next());
					System.out.println("Ingrese telefono de clienteAT");
					clienteA1.setTelefono(sc.nextLong());
					// enviar esto, para que PersonaDaoImp lo use
					
				    persDao.darDeAltaCLiente(clienteA1);
					System.out.println("ClienteAT cargado exitosamente");
					Reserva reserva1 = new Reserva();
					System.out.println(" Creando reserva... ");

					System.out.println(" Ingrese la cantidad de comensales ");
					reserva1.setCantidadComensales(sc.nextInt());
					System.out.println(" Ingrese fecha de reserva");// try catch
					String fecha = sc.next();
					reserva1.setFechaR(FechaUtil.convertirStringLocalDate(fecha));
					System.out.println(" Ingrese hora: [HH:MM] (ejemplo: 17:30)");
					String hora = sc.next();
					reserva1.setHoraR(FechaUtil.convertirStringLocalTime(hora));// try catch

				reserva1.setCliente(clienteA1);
//				reserva1.setMozo(mozo1);
//				reserva1.setMesa(mesas2);//guardar la lista de mesas
					admiDao.darAltaReserva(reserva1);
	//
					
				
				}
			}
			else  
			{
				
				if(identificador.equals(P)) {
					
					System.out.println("Ingrese el dni del cliente particular");
					long dni = sc.nextLong();
					for(int i = 0; i < persDao.obtenerClientesParticulares().size(); i++) {
						   if(dni == persDao.obtenerClientesParticulares().get(i).getDni())
						   {
							   
							   System.out.println("Cliente Encontrado");
                               encontrado = true;		
                               //creando reserva para el cliente P
                               Reserva reserva1 = new Reserva();
           					System.out.println(" Creando reserva... ");

           					System.out.println(" Ingrese la cantidad de comensales ");
           					reserva1.setCantidadComensales(sc.nextInt());
           					System.out.println(" Ingrese fecha de reserva");// try catch
           					String fecha = sc.next();
           					reserva1.setFechaR(FechaUtil.convertirStringLocalDate(fecha));
           					System.out.println(" Ingrese hora: [HH:MM] (ejemplo: 17:30)");
           					String hora = sc.next();
           					reserva1.setHoraR(FechaUtil.convertirStringLocalTime(hora));// try catch

           				reserva1.setCliente(persDao.obtenerClientesParticulares().get(i));
//           				reserva1.setMozo(mozo1);
//           				reserva1.setMesa(mesas2);//guardar la lista de mesas
           					admiDao.darAltaReserva(reserva1);
                               
					}
					}
					if (encontrado == false) {

					System.out.println("El cliente particular no existe");
					System.out.println("Ingrese los datos del cliente para hacer la reserva:");
					ClienteP clienteP = new ClienteP();
					System.out.println("Ingrese DNI del clienteP");
					clienteP.setDni(sc.nextLong());
					System.out.println("Ingrse nombre de clienteP");
					clienteP.setNombre(sc.next());
					System.out.println("Ingrese email de clienteP");
					clienteP.setEmail(sc.next());
					System.out.println("Ingrese telefono de clienteP");
					clienteP.setTelefono(sc.nextLong());
					// enviar esto, para que PersonaDaoImp lo use
					
				    persDao.darDeAltaCLiente(clienteP);
					System.out.println("ClienteP cargado exitosamente");
					Reserva reserva1 = new Reserva();
					System.out.println(" Creando reserva... ");

					System.out.println(" Ingrese la cantidad de comensales ");
					reserva1.setCantidadComensales(sc.nextInt());
					System.out.println(" Ingrese fecha de reserva");// try catch
					String fecha = sc.next();
					reserva1.setFechaR(FechaUtil.convertirStringLocalDate(fecha));
					System.out.println(" Ingrese hora: [HH:MM] (ejemplo: 17:30)");
					String hora = sc.next();
					reserva1.setHoraR(FechaUtil.convertirStringLocalTime(hora));// try catch

				reserva1.setCliente(clienteP);//si da error revisar this
//				reserva1.setMozo(mozo1);
//				reserva1.setMesa(mesas2);//guardar la lista de mesas
					admiDao.darAltaReserva(reserva1);
	//
				
				}
			}
			}
			break;
		case 6:
			
			break;
		case 7:
			System.out.println("El cliente a buscar es de tipo agencia de turismo(A) o  particular:(P)");
			String tipoCliente = sc.next();
			String A1 = "A";
			String P1 = "P";
			boolean clienteEncontrado=false;
			/*Recorre la lista de clientes de agencia*/
			if(tipoCliente.equals(A1)) {
			System.out.println("Ingrese CUIT del cliente a buscar");
			long iden;
			iden= sc.nextLong();
			
			for(int i = 0; i < persDao.obtenerClientesAgenciaDeTurismo().size(); i++) {
				   if(iden == persDao.obtenerClientesAgenciaDeTurismo().get(i).getCuit()) {
					   System.out.println("Cliente Encontrado");
                    clienteEncontrado=true;
                    System.out.println( persDao.obtenerClienteA(iden));
				   }
			}
			
			}
			/*Recorre la lista de clientes particulares*/
			if(tipoCliente.equals(P1)) {
				System.out.println("Ingrese DNI del cliente a buscar");
				long iden;
				iden= sc.nextLong();
				
				for(int i = 0; i < persDao.obtenerClientesParticulares().size(); i++) {
					   if(iden == persDao.obtenerClientesParticulares().get(i).getDni())
					   {
						   
						   System.out.println("Cliente Encontrado");
                        clienteEncontrado = true;	
                        System.out.println(persDao.obtenerClienteP(iden));
				}
				}
			}
			if(clienteEncontrado==false) {
				 System.out.println("Cliente no existente en la base de datos");
			}
			
			break;
		case 8:
			System.out.println("Ingrese el id de la reserva a eliminar");
			long idBuscado;
			idBuscado= sc.nextLong();
			break;
		case 9:
			admiDao.listarReservas();
			break;
		case 10:
			confirmacionSalida=true;
			break;
			

		}
		}while (confirmacionSalida!=true);
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
