package databaseController;
import java.sql.*;

import databaseConnection.DBConnection;

public class CreateTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			// adresse du serveur
			//String url = RequetesMySQL.DATABASE_ADRESSE + RequetesMySQL.DATABASE_NAME;
			Connection connection = DBConnection.getDBConnection();
			//
			System.out.println("==========");
			System.out.println("Creating tables...");
			System.out.println("Connection: " + connection);
			//
			Statement statement;
			statement = connection.createStatement();
			connection.setAutoCommit(false);

			// ================================== TYPE_UTILISATEUR ==============================================
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS type_utilisateur"
					+ " ( "
					+ "id_type INT PRIMARY KEY NOT NULL AUTO_INCREMENT, "
					+ "nom TEXT NOT NULL"
					+ ")"
					);
			//
			System.out.println("Table TYPE_UTILISATEUR created !");
			
			// ================================== UTILISATEUR ==============================================
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS utilisateur"
					+ " ( "
					+ "id_utilisateur INT PRIMARY KEY NOT NULL AUTO_INCREMENT, "
					+ "id_type INT NOT NULL, "
					+ "prenom TEXT NOT NULL, "
					+ "nom TEXT NOT NULL, "
					+ "email TEXT NOT NULL, "
					+ "FOREIGN KEY ( id_type ) REFERENCES type_utilisateur ( id_type )"
					+ " )"
					);
			//
			System.out.println("Table UTILISATEUR created !");
			
			// ================================== LOGIN ==============================================
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS login"
					+ " ("
					+ "id_utilisateur INT PRIMARY KEY NOT NULL, "
					+ "mot_passe TEXT NOT NULL, "
					+ "FOREIGN KEY ( id_utilisateur ) REFERENCES utilisateur ( id_utilisateur )"
					+ ")"
					);
			//
			System.out.println("Table LOGIN created !");
			
			// ================================= MATIERE ==============================================
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS  matiere"
					+ " ("
					+ "id_matiere INT PRIMARY KEY NOT NULL AUTO_INCREMENT, "
					+ "nom TEXT NOT NULL"
					+ ")"
					);
			//
			System.out.println("Table MATIERE created !");
			
			// ================================= PROGRAMME ==============================================
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS programme"
					+ " ("
					+ "id_programme INT PRIMARY KEY NOT NULL AUTO_INCREMENT, "
					+ "nom TEXT NOT NULL"
					+ ")"
					);
			//
			System.out.println("Table PROGRAMME created !");
			
			// ================================= PROGRAMME_MATIERE ==============================================
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS programme_matiere"
					+ " ("
					+ "id_matiere INT NOT NULL, "
					+ "id_programme INT NOT NULL, "
					+ "PRIMARY KEY (id_matiere, id_programme), " 
					+ "FOREIGN KEY (id_matiere) REFERENCES matiere(id_matiere), "
					+ "FOREIGN KEY (id_programme) REFERENCES programme(id_programme)"
					+ ")"
					);
			//
			System.out.println("Table PROGRAMME_MATIERE created !");
			
			// ================================= CATEGORIE ==============================================
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS categorie"
					+ " ("
					+ "id_categorie INT PRIMARY KEY NOT NULL AUTO_INCREMENT, "
					+ "nom TEXT NOT NULL"
					+ ")"
					);
			//
			System.out.println("Table CATEGORIE created !");
			
			// =============================== ARTICLE ==================================================
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS article" 
					+ "("
					+ "id_article INT PRIMARY KEY NOT NULL AUTO_INCREMENT, "
					+ "id_categorie INT NOT NULL, "
					+ "nom TEXT NOT NULL, "
					+ "quantite INT NOT NULL, "
					+ "special BOOL NOT NULL, "
					+ "FOREIGN KEY (id_categorie) REFERENCES categorie(id_categorie)"
					+ ")"
					);
			//
			System.out.println("Table ARTICLE created !");
			
			// ================================= RESERVATION ==========================================
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS reservation"
					+ "("
					+ "id_pret INT PRIMARY KEY NOT NULL AUTO_INCREMENT, " 
					+ "id_utilisateur INT NOT NULL, " 
					+ "id_professeur_utilisateur INT NOT NULL, " 
					+ "prenom TEXT NOT NULL, "
					+ "nom TEXT NOT NULL, "
					+ "email TEXT NOT NULL, "
					+ "id_matiere INT NOT NULL, "
					+ "date_reservation DATE, " //default NOW
					+ "date_pret DATE, "
					+ "commentaire TEXT, "
					+ "valider_professeur BOOL, "
					+ "valider_administrateur BOOL, "
					+ "FOREIGN KEY (id_utilisateur) REFERENCES utilisateur (id_utilisateur), " 
					+ "FOREIGN KEY (id_professeur_utilisateur) REFERENCES utilisateur (id_utilisateur), "
					+ "FOREIGN KEY (id_matiere) REFERENCES matiere (id_matiere)"
					+ ")"
					);
			//
			System.out.println("Table RESERVATION created !");
			
			// =============================== RESERVATION_ARTICLE ==================================================
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS reservation_article" 
					+ "("
					+ "id_pret INT NOT NULL, " 
					+ "id_article INT NOT NULL, "
					+ "quantite INT, " //default 1
					+ "PRIMARY KEY (id_pret, id_article), " 
					+ "FOREIGN KEY (id_pret) REFERENCES reservation(id_pret), "
					+ "FOREIGN KEY (id_article) REFERENCES article(id_article)"
					+ ")"
					);
			//
			System.out.println("Table RESERVATION_ARTICLE created !");
			
			// =============================== PRET ===================================================
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS pret"
					+"("
					+ "id_pret INT PRIMARY KEY NOT NULL, "
					+ "date_debut DATE NOT NULL, "
					+ "date_fin DATE NOT NULL, "
					+ "pret_termine BOOL, " //default false
					+ "commentaire TEXT, "
					+ "FOREIGN KEY (id_pret) REFERENCES reservation (id_pret)"
					+ ")"
					);
			//
			System.out.println("Table PRET created !");
			
			// ===========================================================================================
			connection.commit();
			statement.close();
			connection.close();
			System.out.println("End of Create Tables");
			System.out.println("==========");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}

