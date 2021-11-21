package ar.edu.unju.escmi.poo.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FechaUtil {
	public static LocalDate convertirStringLocalDate(String fecha) throws Exception {
		DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaLocalDate;
		try {
			fechaLocalDate = LocalDate.parse(fecha,formato);
		}catch(DateTimeParseException dtpe) {
			throw new Exception("La fecha ingresada no tiene formato de fecha");
		}
		return fechaLocalDate;
		
		}
		public static String convertirLocalDateString(LocalDate fechaLocalDate) {
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String fechaString = formato.format(fechaLocalDate);
			return fechaString;
			
		}
        public static LocalTime convertirStringLocalTime(String h) {
			
			LocalTime t = LocalTime.parse( h ) ;
			
			
			return t;
		}
}
