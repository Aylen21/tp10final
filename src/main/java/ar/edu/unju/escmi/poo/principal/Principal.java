package ar.edu.unju.escmi.poo.principal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.internal.build.AllowSysOut;

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
//	public static EntityManagerFactory emf;
//	public static EntityManager manager;

	public static void main(String[] args) throws Exception {
		// comentario
		boolean confirmacionSalida = false;
		IPersonaDao persDao = new PersonaDaoImp();
		IMozoDao mozoDao = new MozoDaoImp();
		IAdmiDeRestauranteDao admiDao = new AdmiDeRestauranteDaoImp();
//		emf = Persistence.createEntityManagerFactory("TestPersistence");
//		manager = emf.createEntityManager();

		AdminDeRestaurante administrador = new AdminDeRestaurante("jjuan", "12345");
		Scanner sc = new Scanner(System.in);
		String nombre, contra;
		boolean ingreso = false;

		if (admiDao.salonesMesasCargados() == false) {
			List<Mesa> mesas1 = new ArrayList<Mesa>(); // creando mesas
			List<Mesa> mesas2 = new ArrayList<Mesa>();

//			Salon salon1 = new Salon(1, 20, mesas1);
//			Salon salon2 = new Salon(2, 10, mesas2);
			Salon salon1 = new Salon(1, 20, mesas1);
			Salon salon2 = new Salon(2, 10, mesas2);
			admiDao.guardarSalon(salon2);
			admiDao.guardarSalon(salon1);

			mesas1 = cargarMesas1(salon1);// cargando mesas
			mesas2 = cargarMesas2(salon2);
			admiDao.cargarMesas1(mesas1, salon1);
			admiDao.cargarMesas2(mesas2, salon2);

//		  ClienteP clienteP1 = new ClienteP("Juan","Juarez",123,456);
//		  manager.getTransaction().begin(); 
//		  manager.persist(clienteP1);
//		  manager.getTransaction().commit();
			//
			/*
			 * for (int k=0;k<mesas1.size();k++) { mesas1.get(k).setSalon(salon1);
			 * manager.getTransaction().begin(); manager.merge(mesas1.get(k));
			 * manager.getTransaction().commit(); }
			 * 
			 * for (int j=0;j<mesas2.size();j++) { mesas1.get(j).setSalon(salon2);
			 * manager.getTransaction().begin(); manager.merge(mesas2.get(j));
			 * manager.getTransaction().commit(); }
			 */

		}
		// si la bd no tiene ningún mozo, va a agregar 3 por defecto
		if (mozoDao.revisarMozosEnBd() == false) {
			System.out.println(" Cargando mozos por defecto");
			// Precarga de mozos

			Mozo mozo = new Mozo(2002, "Sebastian", "seba@gmail.com", 12345, null);
			mozoDao.darDeAltaMozo(mozo);
			Mozo mozo2 = new Mozo(2003, "Hector", "tor@gmail.com", 5311, null);
			mozoDao.darDeAltaMozo(mozo2);
			Mozo mozo3 = new Mozo(2004, "Julian", "flo@gmail.com", 82125, null);
			mozoDao.darDeAltaMozo(mozo3);

		}

		// cargando salon en las mesas

		while (ingreso == false) {
			System.out.println("-----Inicio de sesion-----");
			System.out.println("Nombre de usuario:");
			nombre = sc.next();
			System.out.println("Contrasenia:");
			contra = sc.next();
			if (administrador.getUser().equals(nombre)) {
				System.out.println("Usuario encontrado");
				if (administrador.getPassword().equals(contra)) {
					System.out.println("Contraseña correcta");
					ingreso = true;
				} else {
					System.out.println("Contraseña incorrecta");
				}
			} else {
				System.out.println("Usuario no encontrado");
			}
		}
		System.out.println("Listo el pollo");

		/* Menu principal */
		do {
			boolean band;
			band = true;

			System.out.println("" + "1 - Alta de Mozo\r\n" + "2 - Listado de Mozos.\r\n"
					+ "3 - Consultar disponibilidad de mesas según salón.\r\n"
					+ "4 - Consultar mesas ocupadas mostrando la cantidad de comensales.\r\n"
					+ "5 - Alta de una reserva.\r\n"
					+ "6 - Realizar la búsqueda de una reserva para realizar la modificación de total a pagar (significa que finaliza la reserva).\r\n"
					+ "7 - Consultar los datos del cliente ingresando cuil o dni.\r\n"
					+ "8 - Eliminar una reserva ingresando el id.\r\n" + "9 - Listar todas las reservas.\r\n"
					+ "10 - Salir");

			int a = sc.nextInt();

			switch (a) {

			case 1:
				System.out.println("Carga de datos de Mozo:");
				Mozo mozo1 = new Mozo();
				if(mozoDao.obtenerMozos().size()< 6) {
				band = true;
				do {
					System.out.println("Ingrese DNI del mozo");
					String dni = sc.next();
					try {

						mozo1.setDniM(Integer.valueOf(dni));
						band = false;

					} catch (NumberFormatException m) {
						System.out.println("Debe ingresar obligatoriamente dato de tipo numerico.");

					}

				} while (band == true);

				System.out.println("El DNI fue ingresado correctamente, continuemos");

				System.out.println("Ingrse nombre de mozo");
				mozo1.setNombre(sc.next());
				System.out.println("Ingrese email de mozo");
				mozo1.setEmail(sc.next());
				boolean band1;
				band1 = true;
				do {
					System.out.println("Ingrese telefono de mozo");
					String t = sc.next();
					try {
						mozo1.setTelefono(Integer.valueOf(t));
						band1 = false;

					} catch (NumberFormatException ex) {
						System.out.println("Debe ingresar obligatoriamente dato de tipo numerico.");

					}

				} while (band1 == true);
				// enviar esto, para que PersonaDaoImp lo use
				System.out.println("El Telefono fue ingresado correctamente, continuemos");
				mozoDao.darDeAltaMozo(mozo1);
				System.out.println("Mozo cargado exitosamente");
				}
				else {
					System.out.println("Lista llena, no puede cargar mas mozos");
				}
				break;
			case 2:
				System.out.println("=============LISTADO DE MOZOS===================");

				mozoDao.listarMozos();

				break;
			case 3:// caso tres
//
				System.out.println(" Consultar disponibilidad de mesas según salón.");
				System.out.println("Ingrese el numero de  Salon (1) o (2)");
				int numSalon = sc.nextInt();
				String estado = "desocupada";
				int cont = 0;
				if (numSalon == 1) {
					for (int m = 0; m < admiDao.obtenerMesasSalon1().size(); m++) {
						if (admiDao.obtenerMesasSalon1().get(m).getEstado().equals(estado)) {
							cont = cont + 1;

						}
					}
					System.out.println("El numero de mesas desocupadas en el Salon 1 es de" + cont + "/20");

				} else {

					if (numSalon == 2) {
						for (int m = 0; m < admiDao.obtenerMesasSalon2().size(); m++) {
							if (admiDao.obtenerMesasSalon2().get(m).getEstado().equals(estado)) {
								cont = cont + 1;
							}
						}
						System.out.println("El numero de mesas desocupadas en el Salon 2 es de" + cont + "/10");
					}

				}

				// ahora deviulve cuantas mesas tiene disponible el salon

				break;
			//

			case 4:
//				"4 - Consultar mesas ocupadas mostrando la cantidad de comensales.\r
				
				admiDao.consultarMesasOcup();
				
				break;

			case 5:
				/*
				 * Dar de alta reserva, precisa de definir si el cliente ya estaba registrado
				 * con anterioridad
				 */

				System.out.println("El cliente a buscar es de tipo agencia de turismo(A) o  particular:(P)");
				String identificador = sc.next();
				String A = "A";
				String P = "P";
				boolean encontrado = false;
				boolean band3 = true, band4 = true;
				long cuitC = 0, dniC = 0;
				if (identificador.equals(A)) {

					do {
						System.out.println("Ingrese CUIT del cliente Agencia de Turismo");
						String cuitAT = sc.next();
						try {

							cuitC = Long.valueOf(cuitAT);
							band3 = false;

						} catch (NumberFormatException ex) {
							System.out.println("Debe ingresar obligatoriamente dato de tipo numerico.");

						}
					} while (band3 == true);
//				long cuit = sc.nextLong();

					for (int i = 0; i < persDao.obtenerClientesAgenciaDeTurismo().size(); i++) {
						if (cuitC == persDao.obtenerClientesAgenciaDeTurismo().get(i).getCuit()) {
							System.out.println("Cliente Encontrado");
							encontrado = true;
//					reserva1.setCliente(persDao.obtenerClientesAgenciaDeTurismo().get(i)); no use
//   				reserva1.setMozo(mozo1);
//   				reserva1.setMesa(mesas2);//guardar la lista de mesas
							admiDao.darAltaReserva(pedirDatos(persDao.obtenerClientesAgenciaDeTurismo().get(i)));
						}
					}
					if (encontrado == false) {
						System.out.println("No se encontró ClienteAgencia con ese número de cuit");

						System.out.println("Ingrese los datos del cliente para hacer la reserva:");
						ClienteAT clienteA1 = new ClienteAT();
//					System.out.println("Ingrese CUIT del clienteAT"); ya se lo ingresó
						clienteA1.setCuit(cuitC);
						System.out.println("Ingrese nombre de clienteAT");
						clienteA1.setNombre(sc.next());
						System.out.println("Ingrese email de clienteAT");
						clienteA1.setEmail(sc.next());

						do {// intentando guardar número de teléfono
							System.out.println("Ingrese telefono de clienteAT");
							String tel1 = sc.next();
							try {

								clienteA1.setTelefono(Long.valueOf(tel1));
								band4 = false;

							} catch (NumberFormatException ex) {
								System.out.println("Debe ingresar obligatoriamente dato de tipo numerico.");

							}

						} while (band4 == true);

						// enviar el cliente , para que PersonaDaoImp lo guarde:
						persDao.darDeAltaCLiente(clienteA1);
						System.out.println("ClienteAT cargado exitosamente");
						// ahora, creando reserva:

//						reserva1.setCliente(clienteA1);
//				reserva1.setMozo(mozo1);
//				reserva1.setMesa(mesas2);//guardar la lista de mesas
						admiDao.darAltaReserva(pedirDatos(clienteA1));
						//

					}
				} else {

					if (identificador.equals(P)) {
						long dni = 0;
						boolean band5 = true;
						do {// intentando guardar número de teléfono
							System.out.println("Ingrese el dni del cliente particular");
							String tel1 = sc.next();
							try {

								dni = Long.valueOf(tel1);
								band5 = false;

							} catch (NumberFormatException ex) {
								System.out.println("Debe ingresar obligatoriamente dato de tipo numerico.");

							}

						} while (band5 == true);

						for (int i = 0; i < persDao.obtenerClientesParticulares().size(); i++) {
							if (dni == persDao.obtenerClientesParticulares().get(i).getDni()) {

								System.out.println("Cliente Encontrado");
								encontrado = true;
								// creando reserva para el cliente P
//							reserva1.setCliente(persDao.obtenerClientesParticulares().get(i));no use
//           				reserva1.setMozo(mozo1);
//           				reserva1.setMesa(mesas2);//guardar la lista de mesas
								admiDao.darAltaReserva(pedirDatos(persDao.obtenerClientesParticulares().get(i)));

							}
						}
						if (encontrado == false) {

							System.out.println("El cliente particular no existe");
							System.out.println("Ingrese los datos del cliente para hacer la reserva:");
							ClienteP clienteP = new ClienteP();
//					System.out.println("Ingrese DNI del clienteP"); ya ingresado
							clienteP.setDni(dni);
							System.out.println("Ingrse nombre de clienteP");
							clienteP.setNombre(sc.next());
							System.out.println("Ingrese email de clienteP");
							clienteP.setEmail(sc.next());
							band4 = true;
							do {// intentando guardar número de teléfono
								System.out.println("Ingrese telefono de clienteP");
								String tel1 = sc.next();
								try {

									clienteP.setTelefono(Long.valueOf(tel1));
									band4 = false;

								} catch (NumberFormatException ex) {
									System.out.println("Debe ingresar obligatoriamente dato de tipo numerico.");

								}

							} while (band4 == true);

							// enviar clienteP para que PersonaDaoImp lo use
							persDao.darDeAltaCLiente(clienteP);
							System.out.println("ClienteP cargado exitosamente");
							// creando la reserva
							// aquí estaba
							admiDao.darAltaReserva(pedirDatos(clienteP));

						}
					}
				}
				break;
			case 6:				
//				6 - Realizar la búsqueda de una reserva para modificar total a pagar (finaliza la reserva).\r\n"
				boolean idCorrecto=false;
				double totalNuevo;
				do {
			
				
				boolean band9=true;
				int idReserva=0;
				
				do {	System.out.println("Ingrese id de reserva: ");
						String intento=sc.next();	
				try {

						idReserva=Integer.valueOf(intento);
						band9 = false;

					} catch (NumberFormatException ex) {
						System.out.println("Debe ingresar obligatoriamente un numero tipo Entero.");

					}

				} while (band9 == true);
				
				
				
				
				if(admiDao.traerUnaReserva(idReserva)!=null) {
					System.out.println("Reserva encontrada");
					//si la reserva se encuentra en la bd, se procede a cambiar el total:
					
					totalNuevo=0;
					
					boolean band10=true;
					do {System.out.println("Ingrese nuevo total: ");
					String intento2=sc.next();
						try {

							totalNuevo=Double.valueOf(intento2);
							band10 = false;

						} catch (NumberFormatException ex) {
							System.out.println("Debe ingresar obligatoriamente un numero tipo double.");

						}

					} while (band10 == true);
					
					
					admiDao.cambiarTotal(idReserva, totalNuevo);
					int cantidadM=admiDao.traerUnaReserva(idReserva).getMesa().size();
					int numSalon1=admiDao.traerUnaReserva(idReserva).getMesa().get(0).getSalon().getNroDeSalon();
					admiDao.liberarCantMesas(cantidadM, numSalon1);
					idCorrecto=true;
					System.out.println(" Nuevo total asignado con exito");
				}else {
					System.out.println(" id no registrado, intente de nuevo");
				}				
				}while(idCorrecto==false);
				System.out.println(" Proceso finalizado");
				break;
			case 7:
				System.out.println("El cliente a buscar es de tipo agencia de turismo(A) o  particular:(P)");
				String tipoCliente = sc.next();
				String A1 = "A";
				String P1 = "P";
				boolean clienteEncontrado = false;
				/* Recorre la lista de clientes de agencia */
				if (tipoCliente.equals(A1)) {
					System.out.println("Ingrese CUIT del cliente a buscar");
					long iden;
					iden = sc.nextLong();

					for (int i = 0; i < persDao.obtenerClientesAgenciaDeTurismo().size(); i++) {
						if (iden == persDao.obtenerClientesAgenciaDeTurismo().get(i).getCuit()) {
							System.out.println("Cliente Encontrado");
							clienteEncontrado = true;
							System.out.println(persDao.obtenerClienteA(iden));
						}
					}

				}
				/* Recorre la lista de clientes particulares */
				if (tipoCliente.equals(P1)) {
					System.out.println("Ingrese DNI del cliente a buscar");
					long iden;
					iden = sc.nextLong();

					for (int i = 0; i < persDao.obtenerClientesParticulares().size(); i++) {
						if (iden == persDao.obtenerClientesParticulares().get(i).getDni()) {

							System.out.println("Cliente Encontrado");
							clienteEncontrado = true;
							System.out.println(persDao.obtenerClienteP(iden));
						}
					}
				}
				if (clienteEncontrado == false) {
					System.out.println("Cliente no existente en la base de datos");
				}

				break;
			case 8:
				boolean encontrada = false;
				System.out.println("Eliminar una reserva ingresando el id");
				System.out.println("Ingrese el id de la reserva a eliminar");
				int idR = sc.nextInt();
				for (int r = 0; r < admiDao.obtenerReservas().size(); r++) {

					if (idR == admiDao.obtenerReservas().get(r).getIdR()) {
						System.out.println("=======RESERVA ENCONTRADA=========");
						encontrada = true;
						System.out.println("¿Confirma la eliminación? (S/N) :");
						String respuesta = sc.next();
						if (respuesta.equals("S") || respuesta.equals("s")) {
							System.out.println("Eliminando reserva.........");
							admiDao.eliminarReserva(admiDao.obtenerReservas().get(r));
							System.out.println("Reserva eliminada");
						} else {
							if (respuesta.equals("N") || respuesta.equals("n")) {
								System.out.println("Eliminacion cancelada");
							} else {
								System.out.println("Intente de nuevo");
							}

						}
					}

				}
				if (encontrada == false) {
					System.out.println("No se encontro reserva segun el id ingresado");
				}

				break;
			case 9:
				admiDao.listarReservas();
				break;
			case 10:
				// salida
				confirmacionSalida = true;
				System.out.println("Programa finalizado, buenas tardes");
				break;

			}

		} while (confirmacionSalida != true);
		sc.close();
	}

	// este método carga los datos de la reserva en el objeto reserva1, y lo envía a
	// principal, para ser reenviado a AdmiDeRestauranteDao,
	// para ser guardado
	public static Reserva pedirDatos(Persona cliente) {
		Reserva reserva1 = new Reserva();
		Scanner sc = new Scanner(System.in);
		List<Mesa> mesasAux = new ArrayList<Mesa>();
		LocalTime hora, limiteInferior;
		IAdmiDeRestauranteDao admiDao = new AdmiDeRestauranteDaoImp();
		IMozoDao mozoDao = new MozoDaoImp();
		String jlimite = "11:00";
		limiteInferior = FechaUtil.convertirStringLocalTime(jlimite);
		System.out.println(" Creando reserva... ");

		boolean band1 = true, band2 = true, band3 = true, band4 = true, band5 = true;

		boolean conformidad = true;
		boolean band7;
		band7 = true;
		String estado = "desocupada";
		int c = 0;

		do {

			System.out.println(" Ingrese fecha de reserva [dd/MM/yyyy]:");// try catch
			String fecha = sc.next();

			try {
				LocalDate fechaNueva = FechaUtil.convertirStringLocalDate(fecha);
				reserva1.setFechaR(fechaNueva);
				band2 = false;

			} catch (Exception f) {

				System.out.println(f.getMessage());

			}

		} while (band2 == true);

		do {

			System.out.println("Ingrese hora de la reserva, hh:mm (ejemplo: 17:30)");
			try {
				hora = FechaUtil.convertirStringLocalTime(sc.next());

				if (hora.isAfter(limiteInferior)) {
					reserva1.setHoraR(hora);
					band3 = false;
				} else {
					System.out.println("hora incorrecta debe ingresar un horario posterior a " + limiteInferior);

				}

			} catch (Exception e) {
				System.out.println("debe ingresar correctamente la hora, formato: hh:mm ");

			}
		} while (band3 == true);

		reserva1.setCliente(cliente);// si da error revisar this

		do {
//			/bucle del try catch de numero/
			do {
				System.out.println(" Ingrese la cantidad de comensales ");
				c = sc.nextInt();
				try {

					reserva1.setCantidadComensales(Integer.valueOf(c));
					band7 = false;

				} catch (NumberFormatException ex) {
					System.out.println("Debe ingresar obligatoriamente un numero entero.");

				}

			} while (band7 == true);

//		/Metodos para determinar las mesas disponibles por salon/

			int contMesas1 = 0;
			for (int p = 0; p < admiDao.obtenerMesasSalon1().size(); p++) {
				if (admiDao.obtenerMesasSalon1().get(p).getEstado().equals(estado)) {
					contMesas1 = contMesas1 + 1;

				}
			}
			int contMesas2 = 0;
			for (int q = 0; q < admiDao.obtenerMesasSalon2().size(); q++) {
				if (admiDao.obtenerMesasSalon1().get(q).getEstado().equals(estado)) {
					contMesas2 = contMesas2 + 1;

				}

			}
//		/Comparamos cantidades con ambos salones y elegimos/

			int salonSeleccionado = 0;

			if (admiDao.calcularMesasNecesarias(c) <= contMesas1 && admiDao.calcularMesasNecesarias(c) <= contMesas2) {
				System.out.println("Disponibilidad en ambos salones, elija cual prefiere?(1/2)");
				int op1 = sc.nextInt();
				switch (op1) {
				case 1:
					System.out.println("Salon 1 Seleccionado");
					salonSeleccionado = 1;
					System.out.println("Salon seleccionado(c1)= " + salonSeleccionado);
					break;
				case 2:
					System.out.println("Salon 2 Seleccionado");
					salonSeleccionado = 2;
					System.out.println("Salon seleccionado (c2)= " + salonSeleccionado);
					break;
				}
			} else if (admiDao.calcularMesasNecesarias(c) <= contMesas1) {
				System.out.println("Salon 1 unicamente disponible");
				salonSeleccionado = 1;
			} else if (admiDao.calcularMesasNecesarias(c) <= contMesas2) {
				System.out.println("Salon 2 unicamente disponible");
				salonSeleccionado = 2;
			} else {
//		/Cantidad superior se pregunta si quiere rehacer la solicitud o no hacer la reserva/
				System.out.println(
						"Cantidad superior al maximo disponible en ambos salones, ¿Desea volver a intentarlo?(S/N)");
				String op = sc.next();
				switch (op) {
				case "S":
					System.out.println("Recuperando información");
					break;
				case "N":
					System.out.println("Reserva Cancelada");
					conformidad = false;
					break;
				}
			}
//			/Guardado de mozo/
			int pM = -1;
			List<Mozo> mozos = mozoDao.obtenerMozos();
			for (int i = 0; i < mozos.size(); i++) {
				if (admiDao.obtenerReservasDeMozo(mozoDao.obtenerMozos().get(i)) == null) {
					pM = i;
				} else if (admiDao.obtenerReservasDeMozo(mozoDao.obtenerMozos().get(i)).size() < 4) {
					pM = i;
				}
			}
			
			reserva1.setMozo(mozos.get(pM));
			System.out.println("3-Salon seleccionado= " + salonSeleccionado);
			Reserva reserAux = reserva1;
			int contNecesario=0;
			if (salonSeleccionado > 0) {
				if (salonSeleccionado == 1) {
					List<Mesa> mesas = admiDao.obtenerMesasSalon1();
					for (int p = 0; p < admiDao.obtenerMesasSalon1().size(); p++) {
						String e = "ocupada";

						if (admiDao.obtenerMesasSalon1().get(p).getEstado().equals(estado)) {
//							/Recorre y Compara id del de la lista con el de la tabla y cambia el estado/

//			/cambiar estado a ocupado/
							if(admiDao.calcularMesasNecesarias(c)>contNecesario) {
								contNecesario++;
							System.out.println("estado antes: " + mesas.get(p));
							mesas.get(p).setEstado(e);
							System.out.println("estado despues: " + mesas.get(p));

							if (c % 4 == 0) {
//			/cantidadComensales=4/
								mesas.get(p).setComensalesSentados(4);
								System.out.println("1");
							} else {
								if (admiDao.calcularMesasNecesarias(c) - p == 1) {
//			/cantidad comensales=c%4/
									mesas.get(p).setComensalesSentados(c % 4);
									System.out.println("2");
								} else {
//			/cantidadComensales=4/
									mesas.get(p).setComensalesSentados(4);
									System.out.println("3");
								}
							}
							System.out.println("guardando");
//							Mesa mes = new Mesa();
//							mes = mesas.get(p);
							
							admiDao.cambiarEstado(mesas.get(p));
							mesasAux.add(mesas.get(p));
//							admiDao.asignarMozo(reserva1);

//							reserva1.setMozo(mozo1);
//							/cambiar la reserva a la que corresponde/
//							
//							/determinando cantidad comensales por mesa/

						}
						}
					}

					conformidad = false;
				} else if (salonSeleccionado == 2) {
					List<Mesa> mesas = admiDao.obtenerMesasSalon2();
					for (int p = 0; p < admiDao.obtenerMesasSalon2().size(); p++) {
						String e = "ocupada";

						if (admiDao.obtenerMesasSalon2().get(p).getEstado().equals(estado)) {
//							/Recorre y Compara id del de la lista con el de la tabla y cambia el estado/

//			/cambiar estado a ocupado/
							if(admiDao.calcularMesasNecesarias(c)>contNecesario) {
								contNecesario++;
							System.out.println("estado antes: " + mesas.get(p));
							mesas.get(p).setEstado(e);
							System.out.println("estado despues: " + mesas.get(p));

							if (c % 4 == 0) {
//			/cantidadComensales=4/
								mesas.get(p).setComensalesSentados(4);
								System.out.println("1");
							} else {
								if (admiDao.calcularMesasNecesarias(c) - p == 1) {
//			/cantidad comensales=c%4/
									mesas.get(p).setComensalesSentados(c % 4);
									System.out.println("2");
								} else {
//			/cantidadComensales=4/
									mesas.get(p).setComensalesSentados(4);
									System.out.println("3");
								}
							}
							System.out.println("guardando");
//							Mesa mes = new Mesa();
//							mes = mesas.get(p);
							
							admiDao.cambiarEstado(mesas.get(p));
							mesasAux.add(mesas.get(p));
//							admiDao.asignarMozo(reserva1);

//							reserva1.setMozo(mozo1);
//							/cambiar la reserva a la que corresponde/
//							
//							/determinando cantidad comensales por mesa/

						}
						}
					}


					conformidad = false;
				}
			}

		} while (conformidad == true);
		reserva1.setMesa(mesasAux);

		return reserva1;
	}

	public static List<Mesa> cargarMesas1(Salon salon1) {
		IAdmiDeRestauranteDao admiDao = new AdmiDeRestauranteDaoImp();
		List<Mesa> mesas1 = new ArrayList<Mesa>();

		for (int i = 0; i < 20; i++) {// agregando 20 mesas a la lista
			Mesa mesa = new Mesa(0, "desocupada", salon1, null);// creando una mesa
//			mesa.setEstado("desocupada");
//			mesa.setSalon(salon1);
//			mesa.setReserva(null);
//			mesa.setComensalesSentados(0);
			mesas1.add(mesa);// agregando la mesa

			admiDao.cargarMesa(mesa);

		}
		return mesas1;
	}

	public static List<Mesa> cargarMesas2(Salon salon2) {
		IAdmiDeRestauranteDao admiDao = new AdmiDeRestauranteDaoImp();
		List<Mesa> mesas2 = new ArrayList<Mesa>();

		for (int i = 0; i < 10; i++) {// agregando 10 mesas a la lista
			Mesa mesa = new Mesa(0, "desocupada", salon2, null);// creando una mesa
//			mesa.setEstado("desocupada");
//			mesa.setSalon(salon2);
//			mesa.setReserva(null);
//			mesa.setComensalesSentados(0);
			mesas2.add(mesa);// agregando la mesa
			admiDao.cargarMesa(mesa);

		}
		return mesas2;
	}

}