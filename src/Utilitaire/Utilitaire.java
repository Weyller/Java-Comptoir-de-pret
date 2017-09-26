package Utilitaire;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilitaire {

	//===========================================================================================
		 public static String dateActuelle()
		    {
		        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		        LocalDateTime localDate = LocalDateTime.now();
		        return dateFormat.format(localDate);
		    }
	
	
}
