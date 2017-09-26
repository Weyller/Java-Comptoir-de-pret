package databaseController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import databaseConnection.DBConnection;

public class InsertAll {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//Class.forName("com.mysql.jdbc.Driver");
			// adresse du serveur
			//String url = RequetesMySQL.DATABASE_ADRESSE + RequetesMySQL.DATABASE_NAME;
			Connection connection = DBConnection.getDBConnection();
			//
			System.out.println("==========");
			System.out.println("Inserting.... All");
			System.out.println("Connection: " + connection);
			
			connection.setAutoCommit(false);
			Statement statement;
			statement = connection.createStatement();
			
			
			// ============== INSERER TYPE_UTILISATEUR =========================
			statement.executeUpdate(
					"INSERT INTO type_utilisateur"
							+ " (NOM) "
							+ " VALUES "
							+ "('ADMINISTRATEUR'), "
							+ " ('PROFESSEUR')"
					);			
			System.out.println("TYPE_UTILISATEUR Done !");

			// ============== INSERER UTILISATEUR =========================
			statement.executeUpdate(
					"INSERT INTO utilisateur"
							+ " (ID_TYPE, PRENOM, NOM, EMAIL) "
							+ " VALUES "
							+ "(1,'ALEXANDRA', 'THIBEAULT', 'ALEXANDRA@GMAIL.COM'), "
							+ "(1,'NICOLAS', 'GARREAU', 'NGARREAU@GRASSET.QC.CA'), "
							+ "(2,'RAMIRO', 'GUERREIRO', 'RAMIRO.GUERREIRO@GMAIL.COM'), "
							+ "(2,'REBECCA', 'LAPOINTE', 'REBECCA.LAPOINTE@GMAIL.COM') "
					);

			System.out.println("UTILISATEUR Done !");
			
			/*

			// ============== INSERER MATIERE =========================
			statement.executeUpdate(
					"INSERT INTO matiere"
							+ " (NOM) "
							+ " VALUES ('') "
							+ " VALUES ('') "
					);

			System.out.println("MATIERE Done !");
			// ============== INSERER PROGRAMME =========================
			statement.executeUpdate(
					"INSERT INTO programme"
							+ " (NOM) "
							+ " VALUES ('') "
							+ " VALUES ('') "
					);

			System.out.println("PROGRAMME Done !");
			
			*/

			// ============== INSERER CATEGORIE =========================
			statement.executeUpdate(
					"INSERT INTO CATEGORIE"
							+ " (ID_CATEGORIE, NOM) "
							+ " VALUES "
							+ "(1, 'DIVERS'), "
							+ "(2, 'LECTEUR DE CARTE MEMOIRE'), "
							+ "(3, 'OBJECTIF'), "
							+ "(4, 'MONITEUR'), "
							+ "(5, 'TREPIED'), "
							+ "(6, 'MONOPIED'), "
							+ "(7, 'KIT ECLAIRAGE'), "
							+ "(8, 'EXTENSION'), "
							+ "(9, 'ROULEAU'), "
							+ "(10, 'POSMETRE'), "
							+ "(11, 'BOITES DE POMME'), "
							+ "(12, 'CLAMP'), "
							+ "(13, 'MICRO'), "
							+ "(14, 'GRAVEUR'), "
							+ "(15, 'MIXETTE'), "
							+ "(16, 'ECRAN VERT'), "
							+ "(17, 'FOND DE SCENE'), "
							+ "(18, 'KIT'), "
							+ "(19, 'KIT CAMERA')"
					);

			System.out.println("CATEGORIE Done !");

			// ============== End of INSERER =========================
			System.out.println("\nAll Done !");

			statement.close();
			connection.commit();
			connection.close();		
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}//end class
