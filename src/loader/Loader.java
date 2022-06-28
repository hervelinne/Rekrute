package loader;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class Loader {
	public  Connection connexion() {
		try {
			Class c = Class.forName("com.mysql.cj.jdbc.Driver"); 
			Driver pilote = (Driver)c.newInstance(); 
			DriverManager.registerDriver(pilote);
			String protocole = "jdbc:mysql:"; 
			String ip = "localhost"; 
			String port = "3306"; 
			String nomBase = "Rekrute"; 
			String conString = protocole + "//" + ip + " : " + port + "/" + nomBase; 
			String nomConnexion = "root"; 
			String motDePasse = "" ; 
			// Connection
			Connection con =  DriverManager.getConnection(conString, nomConnexion, motDePasse);
			System.out.println("Connected");
			return con; 
			
			
		}
		catch(Exception e) {
			e.printStackTrace(); 
			System.out.println("erreur offreLoader"); 
			return null; 
		}
	}
	
}
