package databaseController;


import java.sql.*;

public class CreateDataBase {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// adresse du serveur
			String url = RequetesMySQL.DATABASE_ADRESSE;
			Connection connection = DriverManager.getConnection(url, "root", "root");
			//
			System.out.println("==========");
			System.out.println("Create DataBase");
			System.out.println("URL:" + url);
			System.out.println("Connection: " + connection);
			System.out.println("==========");
			//
			Statement statement;
			statement = connection.createStatement();
			statement.executeUpdate("CREATE DATABASE IF NOT EXIST" + RequetesMySQL.DATABASE_NAME);
			//
			System.out.println("DataBase" + RequetesMySQL.DATABASE_NAME + " created !");
			System.out.println("==========");
			//
			statement.close();
			connection.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
