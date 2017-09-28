package databaseController;

import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import model.Article;
import model.Categorie;
import model.Matiere;
import model.Programme;
import model.Utilisateur;

public class RequetesMySQL  {
	
	
	
	

	// Nom de la base de donnees
	static public final String DATABASE_NAME = "ig_pret";
	static public final String DATABASE_ADRESSE = "jdbc:mysql://localhost:3306/";

	// *********************** TYPE_UTILISATEUR *************************************
	// Nom de la table TYPE_UTILISATEUR
	static public final String TABLE_TYPE_UTILISATEUR = "type_utilisateur";
	// Nom des attributs TYPE_UTILISATEUR
	static public final String ID_TYPE = "type_utilisateur.id_type";
	static public final String NOM_TYPE = "type_utilisateur.nom";	

	// ************************* UTILISATEUR ***********************************
	// Nom de la table UTILISATEUR
	static public final String TABLE_UTILISATEUR = "utilisateur";
	// Nom des attributs UTILISATEUR
	static public final String ID_UTILISATEUR = "utilisateur.id_utilisateur";
	static public final String ID_TYPE_UTILISATEUR = "utilisateur.id_type";
	static public final String PRENOM_UTILISATEUR = "utilisateur.prenom";
	static public final String NOM_UTILISATEUR = "utilisateur.nom";
	static public final String EMAIL_UTILISATEUR = "utilisateur.email";

	// ************************* LOGIN ***********************************
	// Nom de la table LOGIN
	static public final String TABLE_LOGIN = "login";
	// Nom des attributs LOGIN
	static public final String ID_UTILISATEUR_LOGIN = "login.id_utilisateur";
	static public final String MOT_PASSE = "login.mot_passe";

	// *********************** MATIERE ************
	// Nom de la table MATIERE
	static public final String TABLE_MATIERE = "matiere";
	// Nom des attributs MATIERE
	static public final String ID_MATIERE = "matiere.id_matiere";
	static public final String NOM_MATIERE= "matiere.nom";

	// *********************** PROGRAMME ************
	// Nom de la table PROGRAMME
	static public final String TABLE_PROGRAMME = "programme";
	// Nom des attributs PROGRAMME
	static public final String ID_PROGRAMME = "programme.id_programme";
	static public final String NOM_PROGRAMME= "programme.nom";

	// *********************** PROGRAMME_MATIERE ************
	// Nom de la table PROGRAMME_MATIERE
	static public final String TABLE_PROGRAMME_MATIERE = "programme_matiere";
	// Nom des attributs PROGRAMME_MATIERE
	static public final String ID_MATIERE_PROGRAMME_MATIERE = "programme_matiere.id_matiere";
	static public final String ID_PROGRAMME_PROGRAMME_MATIERE= "programme_matiere.id_programme";

	// *********************** CATEGORIE **************************************
	// Nom de la table CATEGORIE
	static public final String TABLE_CATEGORIE= "categorie";
	// Nom des attributs CATEGORIE
	static public final String ID_CATEGORIE = "categorie.id_categorie";
	static public final String NOM_CATEGORIE = "categorie.nom";

	// *********************** ARTICLE *****************************************
	// Nom de la table ARTICLE
	static public final String TABLE_ARTICLE = "article";
	// Nom des attributs ARTICLE
	static public final String ID_ARTICLE = "article.id_article";
	static public final String ID_CATEGORIE_ARTICLE = "article.id_categorie";
	static public final String NOM_ARTICLE = "article.nom";
	static public final String SPECIAL_ARTICLE = "article.special";
	static public final String QUANTITE_ARTICLE = "article.quantite";

	// *********************** RESERVATION ************
	// Nom de la table RESERVATION
	static public final String TABLE_RESERVATION = "reservation";
	// Nom des attributs RESERVATION
	static public final String ID_PRET_RESERVATION = "reservation.id_pret";
	static public final String ID_UTILISATEUR_RESERVATION = "reservation.id_utilisateur";
	static public final String ID_PROFESSEUR_UTILISATEUR_RESERVATION = "reservation.id_professeur_utilisateur";
	static public final String PRENOM_UTILISATEUR_RESERVATION = "reservation.prenom";
	static public final String NOM_UTILISATEUR_RESERVATION = "reservation.nom";
	static public final String EMAIL_UTILISATEUR_RESERVATION = "reservation.email";
	static public final String ID_MATIERE_PRESERVATION = "reservation.id_matiere";
	static public final String DATE_RESERVATION_RESERVATION = "reservation.date_reservation";
	static public final String DATE_PRET_RESERVATION = "reservation.date_pret";	
	static public final String VALIDER_PROFESSEUR_RESERVATION = "reservation.valider_professeur";
	static public final String VALIDER_ADMINISTRATEUR_RESERVATION = "reservation.valider_administrateur";
	static public final String COMMENTAIRE_RESERVATION = "reservation.commentaire";

	// *********************** RESERVATION_ARTICLE *************
	// Nom de la table RESERVATION_ARTICLE
	static public final String TABLE_RESERVATION_ARTICLE = "reservation_article";
	// Nom des attributs RESERVATION_ARTICLE
	static public final String ID_PRET_RESERVATION_ARTICLE = "reservation_article.id_pret";
	static public final String ID_ARTICLE_RESERVATION_ARTICLE = "reservation_article.id_article";
	static public final String QUANTITE_RESERVATION_ARTICLE = "reservation_article.quantite";

	// *********************** PRET *************
	// Nom de la table PRET
	static public final String TABLE_PRET = "pret";
	// Nom des attributs PRET
	static public final String ID_PRET = "pret.id_pret";
	static public final String DATE_DEBUT_PRET = "pret.date_debut";
	static public final String DATE_FIN_PRET = "pret.date_fin";	
	static public final String PRET_TERMINE_PRET = "pret.pret_termine";
	static public final String COMMENTAIRE_PRET = "pret.commentaire";

	static String url = DATABASE_ADRESSE + DATABASE_NAME;
	static Connection connection;
	static java.sql.Statement statement;
	static ResultSet resultSet;

	public RequetesMySQL() throws SQLException, ClassNotFoundException  {
		super();
		// TODO Auto-generated constructor stub
	}

	//************** ETABLIR CONNEXION **********
	public static void etablirConnexion () throws SQLException, ClassNotFoundException  {
	
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(url, "root", "root");
		statement = connection.createStatement();	
	}

	//************** FERME CONNEXION **********
	public static void fermerConnexion () throws SQLException{
		resultSet.close();
		statement.close();
		connection.close();	
	}


	//-----------------------------------------------------------------------------------

	//************** REQUETE SQL POUR SUPPRIMER AVEC ID **********
	/**
	 * Batie une requete de suppression d'element à
	 * en fonction des parametres envoyes
	 * 
	 * @param nomTable - nom de la table de l'element a supprimer 
	 * @param nomID - nom de l'attribut (ID de la table)
	 * @param id - numero de l'id a supprimer
	 * @return requete - string de la requete
	 */
	public String requeteSupprimerElementTable(String nomTable, String nomID, int id) {
		String requete = "DELETE FROM " + nomTable +
				" WHERE " + nomID + " = " + id;  
		return requete;
	}//end of RequeteSupprimer

	//************** REQUETE SQL POUR RECUPERER ID A PARTIR D'UN NOM *************************
	/**
	 * Requete qui permet de recuperer un id a partir du nom d'element
	 * @param nomTable - nom de la table
	 * @param nomID - nom d'attribut ID
	 * @param nomElement - nom d'attribut element
	 * @param nom - nom d'element
	 * @return
	 */
	public String requeteRecupererId (String nomTable, String nomID, String nomElement, String nom) {
		String selectQuery = "SELECT " + nomID +
				" FROM " + nomTable + 
				" WHERE " + nomElement  + " = '" + nom + "' ";
		return selectQuery;
	}

	//************** REQUETE SQL POUR RECHERCHER UTILISATEUR **********
	public String requeteRechercherUtilisateurs(String nom, String prenom, String id) {

		String selectQuery = "SELECT DISTINCT " +
				ID_UTILISATEUR + ", " +
				NOM_UTILISATEUR + ", " + 
				PRENOM_UTILISATEUR + ", " +
				ID_TYPE  + ", " +
				NOM_TYPE  + ", " + 
				EMAIL_UTILISATEUR +
				" FROM " + TABLE_UTILISATEUR + ", " + TABLE_TYPE_UTILISATEUR +
				" WHERE " + ID_TYPE  + " = " + ID_TYPE_UTILISATEUR;
		// ==============================    
		if (!nom.isEmpty()) {
			selectQuery += " AND " + NOM_UTILISATEUR + " LIKE '%" + nom + "%'";
		}
		if (!prenom.isEmpty()) {
			selectQuery += " AND " + PRENOM_UTILISATEUR + " LIKE '%" + prenom + "%'";
		}
		if (!id.isEmpty()) {
			selectQuery += " AND " + ID_UTILISATEUR + " = " + Integer.parseInt(id);
		} 
		return selectQuery;
	}

	//************** REQUETE SQL POUR RECHERCHER ARTICLE **********
	public String requeteRechercherArticles(String nom, String categorie, String id) {

		String selectQuery = "SELECT DISTINCT " +
				ID_ARTICLE + ", " +
				NOM_ARTICLE + ", " + 
				ID_CATEGORIE_ARTICLE + ", " +
				NOM_CATEGORIE  + ", " + 
				QUANTITE_ARTICLE  + ", " + 
				SPECIAL_ARTICLE +
				" FROM " + TABLE_ARTICLE + ", " + TABLE_CATEGORIE +
				" WHERE " + ID_CATEGORIE  + " = " + ID_CATEGORIE_ARTICLE;
		// ==============================    
		if (!nom.isEmpty()) {
			selectQuery += " AND " + NOM_ARTICLE + " LIKE '%" + nom + "%'";
		}
		if (!categorie.isEmpty()) {
			selectQuery += " AND " + NOM_CATEGORIE + " LIKE '%" + categorie + "%'";
		}
		if (!id.isEmpty()) {
			selectQuery += " AND " + ID_ARTICLE + " = " + Integer.parseInt(id);
		} 
		return selectQuery;
	}

	//********** REQUETE SQL POUR RECUPERER LES ATTRIBUTS ********
	/**
	 * Requete qui retourne tous les ID et les noms (select *) d'une table (Categorie, Programme et Matiere)
	 * @param nomID
	 * @param nomAttribut
	 * @param nomTable
	 * @return
	 */
	public String requeteRecupererLesAttributs(String nomID, String nomAttribut, String nomTable) {

		String selectQuery = "SELECT DISTINCT " +
				nomID + ", " +
				nomAttribut + 			
				" FROM " + nomTable ;
		// ==============================    
		return selectQuery;
	}//end of requeteRechercherCategorie


	//-----------------------------------------------------------------------------------

	//************** RECUPERER ID A PARTIR D'UN NOM *************************
	public int recupererId(String nomTable, String nomID, String nomElement, String nom) throws SQLException, ClassNotFoundException {

		etablirConnexion();
		resultSet =  statement.executeQuery(requeteRecupererId(nomTable, nomID, nomElement, nom));
		int idResult = 0;
		//
		while (resultSet.next() ){
			idResult = resultSet.getInt(nomID);
			System.out.println("ID = " + idResult);
		}
		fermerConnexion();
		return idResult;
	}

	//************** SUPPRIMER ***************************
	public void supprimmerElementTable(String nomTable, String nomID, int id) throws SQLException, ClassNotFoundException {
		etablirConnexion();
		statement.executeUpdate(requeteSupprimerElementTable(nomTable, nomID, id));
		fermerConnexion();		
	}//end of suppression d'element

	//-----------------------------------------------------------------------------------


	//************** RECHERCHER UTILISATEUR ********************
	public ArrayList<Utilisateur> rechercherUtilisateurs(String nom, String prenom, String id)
			throws SQLException, ClassNotFoundException {

		ArrayList<Utilisateur> utilisateurs = new ArrayList<>();

		etablirConnexion(); // Lance la connexion au serveur

		resultSet =  statement.executeQuery(requeteRechercherUtilisateurs(nom, prenom, id));
		//
		while (resultSet.next() ){
			int idResult = resultSet.getInt(ID_UTILISATEUR);
			String nomResult = resultSet.getString(NOM_UTILISATEUR);
			String prenomResult = resultSet.getString(PRENOM_UTILISATEUR);
			String emailResult = resultSet.getString(EMAIL_UTILISATEUR);
			String typeResult = resultSet.getString(NOM_TYPE);

			// Creation de l'utilisateur
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setId(idResult);
			utilisateur.setType(typeResult);
			utilisateur.setNom(nomResult);
			utilisateur.setPrenom(prenomResult);
			utilisateur.setEmail(emailResult);

			// Ajout de l'utilisateur dans la Liste
			utilisateurs.add(utilisateur);
		}
		//
		fermerConnexion (); // Ferme la connexion au serveur
		return utilisateurs;
	} // end of rechercherUtilisateurs

	//************** RECHERCHER ARTICLE ********************
	public ArrayList<Article> rechercherArticles(String nom, String prenom, String id)
			throws SQLException, ClassNotFoundException {

		ArrayList<Article> articles = new ArrayList<>();

		etablirConnexion(); // Lance la connexion au serveur
		resultSet =  statement.executeQuery(requeteRechercherUtilisateurs(nom, prenom, id));
		//
		while (resultSet.next() ){
			int idResult = resultSet.getInt(ID_ARTICLE);
			String nomResult = resultSet.getString(NOM_ARTICLE);
			String categorieResult = resultSet.getString(NOM_CATEGORIE);
			int quantiteResult = resultSet.getInt(QUANTITE_ARTICLE);
			Boolean specialResult = resultSet.getBoolean(SPECIAL_ARTICLE);

			// Creation de l'article
			Article article = new Article();
			article.setId(idResult);
			article.setCategorie(categorieResult);;
			article.setNom(nomResult);
			article.setQuantite(quantiteResult);;
			article.setSpecial(specialResult);

			// Ajout de l'article dans la liste
			articles.add(article);
		}
		//
		fermerConnexion (); // Ferme la connexion au serveur
		return articles;
	} // end of rechercherArticle

	//**************  RECHERCHER CATEGORIE ****************************
	public ArrayList<Categorie> recupererCategories(String nomID, String nomAttribut, String nomTable) 
			throws SQLException, ClassNotFoundException {

		ArrayList<Categorie> categories = new ArrayList<>();

		etablirConnexion(); // Lance la connexion au serveur
		//
		resultSet =  statement.executeQuery(requeteRecupererLesAttributs(nomID, nomAttribut, nomTable));
		//
		while (resultSet.next() ){
			int idResult = resultSet.getInt(ID_CATEGORIE);
			String nomResult = resultSet.getString(NOM_CATEGORIE);

			// Creation de la categorie
			Categorie categorie = new Categorie();
			categorie.setId(idResult);
			categorie.setNom(nomResult);

			// Ajout de la categorie dans la Liste
			categories.add(categorie);
		}
		//
		fermerConnexion (); // Ferme la connexion au serveur
		return categories;
	} // end of recupererCategorie

	//**************  RECHERCHER PROGRAMME ***************************
	public ArrayList<Programme> recupererProgramme(String nomID, String nomAttribut, String nomTable) 
			throws SQLException, ClassNotFoundException {

		ArrayList<Programme> programmes = new ArrayList<>();

		etablirConnexion(); // Lance la connexion au serveur
		//
		resultSet =  statement.executeQuery(requeteRecupererLesAttributs(nomID, nomAttribut, nomTable));
		//
		while (resultSet.next() ){
			int idResult = resultSet.getInt(ID_PROGRAMME);
			String nomResult = resultSet.getString(NOM_PROGRAMME);

			// Creation du programme
			Programme programme = new Programme();
			programme.setId(idResult);
			programme.setNom(nomResult);

			// Ajout de le programme dans la Liste
			programmes.add(programme);
		}
		//
		fermerConnexion (); // Ferme la connexion au serveur
		return programmes;
	} // end of recupererProgramme

	//**************  RECHERCHER MATIERE *****************************
	public ArrayList<Matiere> recupererMatiere(String nomID, String nomAttribut, String nomTable) 
			throws SQLException, ClassNotFoundException {

		ArrayList<Matiere> matieres = new ArrayList<>();

		etablirConnexion(); // Lance la connexion au serveur
		//
		resultSet =  statement.executeQuery(this.requeteRecupererLesAttributs(nomID, nomAttribut, nomTable));
		//
		while (resultSet.next() ){
			int idResult = resultSet.getInt(ID_MATIERE);
			String nomResult = resultSet.getString(NOM_MATIERE);

			// Cree les metieres
			Matiere matiere = new Matiere();
			matiere.setId(idResult);
			matiere.setNom(nomResult);

			// Ajout de la matiere dans la Liste
			matieres.add(matiere);
		}
		//
		fermerConnexion (); // Ferme la connexion au serveur
		return matieres;
	} // end of recupererMatiere


	
	//-----------------------------------------------------------------------------------

	//************** AJOUTER UTILISATEUR *************************
	void ajouterUtilisateur(String prenom, String nom, String nomType, String email) 
			throws SQLException, ClassNotFoundException {

		etablirConnexion();		
		statement.executeUpdate("INSERT INTO " + TABLE_UTILISATEUR + "( " 
				+ NOM_UTILISATEUR + ", " + PRENOM_UTILISATEUR + ", " + ID_TYPE_UTILISATEUR + ", " + EMAIL_UTILISATEUR
				+ " ) "
				+ "VALUES ( "
				+ " '" + nom + "', "
				+ " '" + prenom + "', "
				+ recupererId(TABLE_TYPE_UTILISATEUR, ID_TYPE, NOM_TYPE, nomType) + ", "
				+ " '" + email + "' ) "
				);
		//
		System.out.println("UTILISATEUR Ajoute !");
		fermerConnexion();
	}//end of ajouterUtilisateur

	//************** AJOUTER ARTICLE *************************
	void ajouterArticle(String nom, String nomCategorie, String quantite, Boolean special) 
			throws SQLException, ClassNotFoundException {

		etablirConnexion();		
		statement.executeUpdate("INSERT INTO " + TABLE_ARTICLE + "( " 
				+ NOM_ARTICLE + ", " + QUANTITE_ARTICLE + ", " + ID_CATEGORIE_ARTICLE + ", " + SPECIAL_ARTICLE
				+ " ) "
				+ "VALUES ( "
				+ " '" + nom + "', "
				+ Integer.parseInt(quantite) + ", "
				+ recupererId(TABLE_CATEGORIE, ID_CATEGORIE, NOM_CATEGORIE, nomCategorie) + ", "
				+ special + " ) "
				);
		//
		System.out.println("ARTICLE Ajoute !");
		fermerConnexion();
	}//end of ajouterArticle

	//************** AJOUTER ELEMENT A UNE TABLE **********************
	/**
	 * Requete qui permet d'ajouter un nouveau nom a une table (Categorie, Programme)
	 * 
	 * @param nomAttribut
	 * @param nomTable
	 * @param nom
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	void ajouterElementTable(String nomAttribut, String nomTable, String nom) 
			throws SQLException, ClassNotFoundException {

		etablirConnexion();		
		statement.executeUpdate("INSERT INTO " + nomTable + "( " 
				+ nomAttribut  
				+ " ) "
				+ "VALUES ( "
				+ " '" + nom + "' ) "
				);
		//
		System.out.println("ELEMENT Ajoute !");
		fermerConnexion();
	}//end of ajouterElementTable

	//************** AJOUTER PROGRAMME-MATIERE **********************
	void ajouterProgrammeMatiere (String nomTable, String nomMatiere, String nomProgramme) 
			throws SQLException, ClassNotFoundException {

		etablirConnexion();	

		statement.executeUpdate("INSERT INTO " + nomTable + "( " 
				+ ID_PROGRAMME_PROGRAMME_MATIERE + ", " + ID_MATIERE_PROGRAMME_MATIERE
				+ " ) "
				+ "VALUES ( " + recupererId(TABLE_MATIERE, ID_MATIERE, NOM_MATIERE, nomMatiere)
				+ ", " + recupererId(TABLE_PROGRAMME, ID_PROGRAMME, NOM_PROGRAMME, nomProgramme) + " ) "
				);
		//
		System.out.println("ELEMENT Ajoute !");
		fermerConnexion();
	}//end of ajouterProgrammeMatiere


	//-----------------------------------------------------------------------------------

	//************** MODIFIER UTILISATEUR *************************
	void modifierUtilisateur(String prenom, String nom, String nomType, String email, String id) 
			throws SQLException, ClassNotFoundException {

		etablirConnexion();		
		statement.executeUpdate("UPDATE " + TABLE_UTILISATEUR
				+ " SET "
				+ NOM_UTILISATEUR + " = '" + nom + "', "
				+ PRENOM_UTILISATEUR + " = '" + prenom + "', "
				+ EMAIL_UTILISATEUR + " = '" + email + "', "
				+ ID_TYPE + " = " + recupererId(TABLE_TYPE_UTILISATEUR, ID_TYPE, NOM_TYPE, nomType)
				+ " WHERE "
				+ ID_UTILISATEUR + " = " + Integer.parseInt(id)
				);				
		//
		System.out.println("UTILISATEUR Modifie !");
		fermerConnexion();
	}//end of ajouterUtilisateur


	//************** MODIFIER ARTICLE *************************
	void modifierArticle(String nom, String nomCategorie, String quantite, Boolean special, String id) 
			throws SQLException, ClassNotFoundException {

		etablirConnexion();		
		statement.executeUpdate("UPDATE " + TABLE_ARTICLE
				+ " SET "
				+ NOM_ARTICLE + " = '" + nom + "', "
				+ QUANTITE_ARTICLE + " = " + Integer.parseInt(quantite) + ", "
				+ ID_CATEGORIE_ARTICLE + " = " + recupererId(TABLE_CATEGORIE, ID_CATEGORIE, NOM_CATEGORIE, nomCategorie) + ", "
				+ SPECIAL_ARTICLE + " = " + special
				+ " WHERE "
				+ ID_ARTICLE + " = " + Integer.parseInt(id)
				);
		//
		System.out.println("ARTICLE Modifie !");
		fermerConnexion();
	}//end of ajouterArticle



	//-----------------------------------------------------------------------------------



	//************** MODIFIER CATEGORIE - PROGRAMME - MATIERE   ******
	/**
	 * Requete qui permet de modifier un element d'une table (Categorie, Programme, matiere)
	 * 
	 * @param nomAttribut
	 * @param nomTable
	 * @param nom
	 * @param nomID
	 * @param id
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	void modifierElementDeTable(String nomAttribut, String nomTable, String nom, String nomID, String id) 
			throws SQLException, ClassNotFoundException {
		etablirConnexion();		
		statement.executeUpdate("UPDATE " + nomTable
				+ " SET "
				+ nomAttribut + " = '" + nom + "' "			
				+ " WHERE "
				+ nomID + " = " + id
				);					
		//
		System.out.println("TABLE Modifie !");
		fermerConnexion();
	}//end of modifierElementDeTable



























	//TODO VERIFIER SI ON PEUT EFFACER LES FONCTIONS


	//********** REQUETE SQL POUR ID_TYPE *************************
	public String requeteIdType (String nomType) {
		String selectQuery = "SELECT " + ID_TYPE +
				" FROM " + TABLE_TYPE_UTILISATEUR + 
				" WHERE " + NOM_TYPE  + " = '" + nomType + "' ";
		return selectQuery;
	}

	//********** RECUPERER ID_TYPE *************************
	public int recupererIdType(String nomType) throws SQLException, ClassNotFoundException {

		etablirConnexion();
		resultSet =  statement.executeQuery(requeteIdType(nomType));
		int idResult = 0;
		//
		while (resultSet.next() ){
			idResult = resultSet.getInt(ID_TYPE);
			System.out.println("ID = " + idResult);
		}
		fermerConnexion();
		return idResult;
	}


	//********** REQUETE SQL POUR ID_CATEGORIE *************************
	public String requeteIdCategorie (String nomCategorie) {
		String selectQuery = "SELECT " + ID_CATEGORIE +
				" FROM " + TABLE_CATEGORIE + 
				" WHERE " + NOM_CATEGORIE  + " = '" + nomCategorie + "' ";
		return selectQuery;
	}

	//********** RECUPERER ID_CATEGORIE *************************
	public int recupererIdCategorie(String nomCategorie) throws SQLException, ClassNotFoundException {

		etablirConnexion();
		resultSet =  statement.executeQuery(requeteIdCategorie(nomCategorie));
		int idResult = 0;
		//
		while (resultSet.next() ){
			idResult = resultSet.getInt(ID_CATEGORIE);
			System.out.println("ID = " + idResult);
		}
		fermerConnexion();
		return idResult;
	}




	
	
	//=====================================================================================================
	//============================= NEW QUERIES  ==============================
	
	//**************  RECHERCHER CATEGORIE ****************************
	public static ArrayList<Categorie> recupererCategories()
			{

		ArrayList<Categorie> categories = new ArrayList<>();

		try {
			etablirConnexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Lance la connexion au serveur
		
		//
		try {
			resultSet =  statement.executeQuery("SELECT * FROM " + TABLE_CATEGORIE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		try {
			while (resultSet.next() ){
				int idResult = resultSet.getInt(ID_CATEGORIE);
				String nomResult = resultSet.getString(NOM_CATEGORIE);

				// Creation de la categorie
				Categorie categorie = new Categorie();
				categorie.setId(idResult);
				categorie.setNom(nomResult);

				// Ajout de la categorie dans la Liste
				categories.add(categorie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		try {
			fermerConnexion ();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Ferme la connexion au serveur
		return categories;
	} // end of recupererCategorie

	
	
	


	// *****************************************************************
	/*
	public ArrayList<Livre> doQueryLivre(String titre, String prenom_auteur, String nom_auteur, String editeur, String genre, String isbn, String id_examplaire) {

		ArrayList<Livre> livres = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = DATABASE_ADRESSE + DATABASE_NAME;
			Connection connection = DriverManager.getConnection(url, "root", "root");
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery(this.getLivres(titre, prenom_auteur, nom_auteur, editeur, genre, isbn, id_examplaire));
			//
			while (resultSet.next() ){
				int idResult = resultSet.getInt(ID_LIVRE);
				String titreResult = resultSet.getString(TITRE_LIVRE);
				int tomeResult = resultSet.getInt(TOME_LIVRE);
				int auteurIdResult = resultSet.getInt(ID_AUTEUR);
				String auteurPrenomResult = resultSet.getString(PRENOM_AUTEUR);
				String auteurNomResult = resultSet.getString(NOM_AUTEUR);
				String genreResult = resultSet.getString(NOM_GENRE);
				String nomEditeurResult = resultSet.getString(NOM_EDITEUR);
				String isbnResult = resultSet.getString(ISBN_LIVRE_EDITION);
				int anneeResult = resultSet.getInt(ANNEE_LIVRE_EDITION);
				boolean specialResult = resultSet.getBoolean(SPECIAL_LIVRE_EDITION);
				int exemplaireResult = resultSet.getInt(ID_EXEMPLAIRE_LIVRE_EXEMPLAIRE);
				String emplacementResult = resultSet.getString(EMPLACEMENT_LIVRE_EXEMPLAIRE);

				// Create Client
				Livre_Exemplaire livre_Exemplaire = new Livre_Exemplaire();
				livre_Exemplaire.setId(idResult);
				livre_Exemplaire.setTitre(titreResult);
				livre_Exemplaire.setTome(tomeResult);
				livre_Exemplaire.setAuteur(auteurIdResult, auteurPrenomResult, auteurNomResult);
				livre_Exemplaire.setGenre(genreResult);
				livre_Exemplaire.setEdition(nomEditeurResult);
				livre_Exemplaire.setIsbn(isbnResult);
				livre_Exemplaire.setAnnee(anneeResult);
				livre_Exemplaire.setSpecial(specialResult);
				livre_Exemplaire.setId_exemplaire(exemplaireResult);
				livre_Exemplaire.setEmplacement(emplacementResult);

				livres.add(livre_Exemplaire);
			}
			//
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return livres;
	} // end of doQueryLivre  
	//******************************************************************
	public ArrayList<Client> doQueryRechercherClient(String nom, String prenom, String telephone, String id_client) {
		ArrayList<Client> clients = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = DATABASE_ADRESSE + DATABASE_NAME;
			Connection connection = DriverManager.getConnection(url, "root", "root");
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery(this.getClients(nom, prenom, telephone, id_client));
			//
			while (resultSet.next() ){
				int idResult = resultSet.getInt(ID_CLIENT);
				String nomResult = resultSet.getString(NOM_CLIENT);
				String prenomResult = resultSet.getString(PRENOM_CLIENT);
				String telephoneResult = resultSet.getString(TELEPHONE_CLIENT);
				String adresseResult = resultSet.getString(NUMERO_CLIENT) + ", " 
						+ resultSet.getString(RUE_CLIENT) + " "
						+ resultSet.getString(COMPLEMENT_ADRESSE_CLIENT) + ", "
						+  resultSet.getString(CODE_POSTALE_CLIENT);
				String emailResult = resultSet.getString(EMAIL_CLIENT);

				// Create Client
				Client client = new Client();
				client.setId(idResult);
				client.setNom(nomResult);
				client.setPrenom(prenomResult);
				client.setTelephone(telephoneResult);
				client.setAdresse(adresseResult);
				client.setEmail(emailResult);

				clients.add(client);
			}
			//
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clients;
	} // end of doQueryClient

	/********** REQUETE SQL POUR LIVRE **********
	public String getLivres(String titre, String prenom_auteur, String nom_auteur, String editeur, String genre, String isbn, String id_exemplaire) {
		String selectQuery = "SELECT DISTINCT " +
				ID_LIVRE + ", " + //0
				ID_EXEMPLAIRE_LIVRE_EXEMPLAIRE + ", " + //1
				TITRE_LIVRE + ", " + //
				ID_AUTEUR  + ", " + //
				PRENOM_AUTEUR + ", " + //
				NOM_AUTEUR  + ", " + //
				ID_EDITEUR  + ", " + //
				NOM_EDITEUR  + ", " + //
				TOME_LIVRE + ", " + //
				ISBN_LIVRE_EDITION + ", " + // 
				ANNEE_LIVRE_EDITION + ", " + // 
				SPECIAL_LIVRE_EDITION +  ", " + // 
				EMPLACEMENT_LIVRE_EXEMPLAIRE +  ", " + //
				ID_EXEMPLAIRE_LIVRE_EXEMPLAIRE +  ", " + //
				NOM_GENRE + // 
				" FROM " + TABLE_LIVRE + ", " + TABLE_AUTEUR + ", " + TABLE_EDITEUR + ", " + TABLE_LIVRE_EDITION +
				", " + TABLE_LIVRE_EXEMPLAIRE + ", " + TABLE_GENRE + ", " + TABLE_LIVREGENRE +
				" WHERE " + ID_AUTEUR + " = " + ID_AUTEUR_LIVRE + 
				" AND " + ID_LIVRE +  " = " + ID_LIVRE_LIVRE_EDITION +
				" AND " + ID_EDITEUR +  " = " + ID_EDITEUR_LIVRE_EDITION +
				" AND " + ID_LIVRE +  " = " + ID_LIVRE_LIVREGENRE + 
				" AND " + ID_GENRE +  " = " + ID_GENRE_LIVREGENRE +
				" AND " + ISBN_LIVRE_EDITION +  " = " + ISBN_LIVRE_EXEMPLAIRE;  

		if(!titre.isEmpty()) {
			selectQuery += " AND " + TITRE_LIVRE + " LIKE '%" + titre + "%'";
		}

		if (!prenom_auteur.isEmpty()) {
			selectQuery += " AND " + PRENOM_AUTEUR + " LIKE '%" + prenom_auteur + "%'";
		}

		if (!nom_auteur.isEmpty()) {
			selectQuery += " AND " + NOM_AUTEUR + " LIKE '%" + nom_auteur + "%'";
		}

		if(!editeur.isEmpty()) {
			selectQuery += " AND " + NOM_EDITEUR + " LIKE '%" + editeur + "%'";
		}

		if(!genre.isEmpty()) {
			selectQuery += " AND " + NOM_GENRE + " LIKE '%" + genre + "%'";
		}

		if(!isbn.isEmpty()) {
			selectQuery += " AND " + ISBN_LIVRE_EDITION + " = '" + isbn + "'";
		}

		if(!id_exemplaire.isEmpty()) {
			selectQuery += " AND " + ID_EXEMPLAIRE_LIVRE_EXEMPLAIRE + " = " + Integer.parseInt(id_exemplaire);
		}

		return selectQuery;
	} // end of getAllLivres   

	//******************************************************************
	public ArrayList<String> getAllResultats(String requete, String nomElement) {
		ArrayList<String> listeResultats = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = DATABASE_ADRESSE + DATABASE_NAME;
			Connection connection = DriverManager.getConnection(url, "root", "root");
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery(requete);
			listeResultats.add("");

			//
			while (resultSet.next() ){
				String chaqueResult = resultSet.getString(nomElement);
				listeResultats.add(chaqueResult);
			}
			//
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeResultats;
	} // end of doQueryClient
	//******************************************************************
	public String requeteIdVille (String ville) {
		String selectQuery = "SELECT " +
				ID_VILLE +
				" FROM " + TABLE_VILLE + 
				" WHERE " + NOM_VILLE  + " = '" + ville + "' ";

		return selectQuery;
	}
	//******************************************************************
	public String idGenre(String genre) {
		String selectQuery = "SELECT "
				+ ID_GENRE
				+ " FROM " + TABLE_GENRE
				+ " WHERE " + NOM_GENRE  + " = '" + genre + "'";
		return selectQuery;
	}
	//******************************************************************
	public String requeteAllVilles () {
		String selectQuery = "SELECT " +
				NOM_VILLE +
				" FROM " + TABLE_VILLE;
		return selectQuery;
	}
	//******************************************************************
	public String requeteAllEditeurs () {
		String selectQuery = "SELECT " +
				NOM_EDITEUR +
				" FROM " + TABLE_EDITEUR;
		return selectQuery;
	}
	//******************************************************************
	public String requeteAllGenres () {
		String selectQuery = "SELECT " +
				NOM_GENRE +
				" FROM " + TABLE_GENRE;
		return selectQuery;
	}
	//******************************************************************
	public String requeteIdAuteur(String prenomAuteur, String nomAuteur) {
		String selectQuery = "SELECT " +
				ID_AUTEUR +
				" FROM " + TABLE_AUTEUR + 
				" WHERE " + NOM_AUTEUR  + " = '" + nomAuteur + "'" +
				" AND " + PRENOM_AUTEUR + " = '" + prenomAuteur + "'";
		return selectQuery;
	}
	//******************************************************************
	public String requeteIdEditeur (String nomEditeur) {
		String selectQuery = "SELECT " +
				ID_EDITEUR +
				" FROM " + TABLE_EDITEUR + 
				" WHERE " + NOM_EDITEUR  + " = '" + nomEditeur + "'";
		return selectQuery;
	}
	//******************************************************************
	public String requeteIDLivre(String titre) {
		String selectQuery = "SELECT "
				+ ID_LIVRE
				+ " FROM " + TABLE_LIVRE
				+ " WHERE " + TITRE_LIVRE  + " = '" + titre + "'";
		return selectQuery;
	}
	//******************************************************************
	public String requeteLivreEmprunte(String isbn, int idExemplaire) {
		String selectQuery = "SELECT COUNT(" +
				ID_PRET +
				") FROM " + TABLE_PRET +
				" WHERE " + ID_EXEMPLAIRE_PRET  + " = " + idExemplaire +
				" AND " + ISBN_PRET  + " = '" + isbn + "'";
		return selectQuery;
	}
	//******************************************************************
	public String requeteLivreEmprunte(int idClient) {
		String selectQuery = "SELECT COUNT(" +
				ID_PRET +
				") FROM " + TABLE_PRET +
				" WHERE " + ID_CLIENT_PRET  + " = " + idClient;
		return selectQuery;
	}
	//******************************************************************
	public String requeteLivreSpecial(String isbn) {
		String selectQuery = "SELECT " +
				SPECIAL_LIVRE_EDITION +
				" FROM " + TABLE_LIVRE_EDITION +
				" WHERE " + ISBN_LIVRE_EDITION + " = '" + isbn + "'";
		return selectQuery;
	}
	//******************************************************************
	public boolean doQueryLivreSpecial(String isbn) {
		boolean specialResult = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = DATABASE_ADRESSE + DATABASE_NAME;
			Connection connection = DriverManager.getConnection(url, "root", "root");
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery(requeteLivreSpecial(isbn));
			//
			while (resultSet.next() ){
				specialResult = resultSet.getBoolean(SPECIAL_LIVRE_EDITION);
			}
			//
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return specialResult;
	}
	//******************************************************************
	public boolean doQueryEmprunterLivre(String isbn, int idExemplaire) {
		int countResult = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = DATABASE_ADRESSE + DATABASE_NAME;
			Connection connection = DriverManager.getConnection(url, "root", "root");
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery(requeteLivreEmprunte(isbn, idExemplaire));
			//
			while (resultSet.next() ){
				countResult = resultSet.getInt(1);
			}
			//
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (countResult == 0) {
			return true;
		} else {
			return false;	
		}
	}
	//******************************************************************
	public int clientAyantLivre(int idClient) {
		int countResult = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = DATABASE_ADRESSE + DATABASE_NAME;
			Connection connection = DriverManager.getConnection(url, "root", "root");
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery(requeteLivreEmprunte(idClient));
			//
			while (resultSet.next() ){
				countResult = resultSet.getInt(1);
			}
			//
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countResult;
	}
	//******************************************************************
	String requeteFinPret(String isbn, int id_exemplaire) {
		return "DELETE FROM " + TABLE_PRET 
				+ " WHERE " + ISBN_PRET + " = '" + isbn + "' AND " 
				+ ID_EXEMPLAIRE_PRET + " = " + id_exemplaire;
	}
	//******************************************************************
	public void doQueryRetourEmprunt(String isbn, int id_exemplaire) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = DATABASE_ADRESSE + DATABASE_NAME;
			Connection connection = DriverManager.getConnection(url, "root", "root");
			Statement statement;
			statement = connection.createStatement();
			statement.executeUpdate(requeteFinPret(isbn, id_exemplaire));
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//******************************************************************
	void addNewAuteur(String nom, String prenom) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = DATABASE_ADRESSE + DATABASE_NAME;
			Connection connection = DriverManager.getConnection(url, "root", "root");
			Statement statement;
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO AUTEUR"
					+ "(PRENOM, NOM) "
					+ "VALUES "
					+ "('" + prenom + "', " + "'" + nom + "')"
					);

			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//******************************************************************
	public String supprimerLivreRequete(int idExemplaire, String isbn) {
		String requete = "DELETE FROM " + TABLE_LIVRE_EXEMPLAIRE +
				" WHERE " + ID_EXEMPLAIRE_LIVRE_EXEMPLAIRE + " = " + idExemplaire + 
				" AND " + ISBN_LIVRE_EXEMPLAIRE +  " = '" + isbn + "'";  
		return requete;
	}
	//******************************************************************
	public void faireSuppressionLivre(int idExemplaire, String isbn) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = DATABASE_ADRESSE + DATABASE_NAME;
			Connection connection = DriverManager.getConnection(url, "root", "root");
			Statement statement;
			statement = connection.createStatement();
			statement.executeUpdate(supprimerLivreRequete(idExemplaire, isbn));
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//******************************************************************
	public String supprimerClientRequete(int idClient) {
		String requete = "DELETE FROM " + TABLE_CLIENT +
				" WHERE " + ID_CLIENT + " = " + idClient;  
		return requete;
	}
	//******************************************************************
	public void faireSuppressionClient(int idClient) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = DATABASE_ADRESSE + DATABASE_NAME;
			Connection connection = DriverManager.getConnection(url, "root", "root");
			Statement statement;
			statement = connection.createStatement();
			statement.executeUpdate(supprimerClientRequete(idClient));
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 */
}//fin de la classe
