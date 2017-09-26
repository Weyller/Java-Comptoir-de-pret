package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import databaseController.RequetesMySQL;

public class DBConnection {
	
	
	static String usager = "root";
	static String password = "root";
	static Connection connection = null;

	public static Connection getConnection() {
		
		String url = RequetesMySQL.DATABASE_ADRESSE;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// adresse du serveur
			
			connection = DriverManager.getConnection(url, usager, password);
			//
			System.out.println("==========");
			System.out.println("Create DataBase");
			System.out.println("URL:" + url);
			System.out.println("Connection: " + connection);
			System.out.println("==========");
			//
			Statement statement;
			statement = connection.createStatement();
			statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + RequetesMySQL.DATABASE_NAME);
			//
			System.out.println("DataBase " + RequetesMySQL.DATABASE_NAME + " created !");
			System.out.println("==========");
			//
			statement.close();
			//connection.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return connection;
	}

	//============================================================
	
	
	public static Connection getDBConnection() {
		
		String url = RequetesMySQL.DATABASE_ADRESSE + RequetesMySQL.DATABASE_NAME;
	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// adresse du serveur
			
			connection = DriverManager.getConnection(url, usager, password);
			//
			System.out.println("==========");
			 
			System.out.println("URL:" + url);
			System.out.println("Connection: " + connection);
			System.out.println("==========");
			//
			Statement statement;
			statement = connection.createStatement();
			statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + RequetesMySQL.DATABASE_NAME);
			//
			System.out.println("Connceted to " + RequetesMySQL.DATABASE_NAME );
			System.out.println("==========");
			//
			statement.close();
			//connection.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return connection;
	}
}
