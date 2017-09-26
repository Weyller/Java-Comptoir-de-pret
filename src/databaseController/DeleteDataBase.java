package databaseController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteDataBase {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//
			String url = "jdbc:mysql://localhost:3306/";
			Connection connection = DriverManager.getConnection( url, "root", "root");
			//
			System.out.println("==========");
			System.out.println("Delete DataBase");
			System.out.println("URL : " + url);
			System.out.println("Connection : " + connection);
			System.out.println("==========");
			//
			Statement statement;
			statement = connection.createStatement();
			statement.executeUpdate("DROP DATABASE " + RequetesMySQL.DATABASE_NAME);
			//
			System.out.println("DataBase " + RequetesMySQL.DATABASE_NAME + " deleted !");
			System.out.println("==========");
			//
			statement.close();
			connection.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}