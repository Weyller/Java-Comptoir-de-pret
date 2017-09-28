package TestRequetes_UI;

import java.util.List;

import databaseController.RequetesMySQL;
import model.Categorie;

public class TestMain {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		List<Categorie> listCategorie = RequetesMySQL.recupererCategories() ;

		
		//String[] categories =listCategorie.toArray(new String[listCategorie.size()]);
		
		
		
		
		System.out.println(listCategorie);
		
	}

}
