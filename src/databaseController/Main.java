package databaseController;

import java.sql.Connection;

import databaseConnection.DBConnection;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		String prenomUtilisateur = "ADRIANA";
		String nomUtilisateur = "REIS";
		String nomTypeUtilisateur = "ADMINISTRATEUR";
		String nomArticle = "CAMERA_DI";
		
		DBConnection.getConnection();
		

	}

}
