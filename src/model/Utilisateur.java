package model;

public class Utilisateur {

	// ========== Attributs ==========
	private int id;
	private String type;
	private String prenom;
	private String nom;
	private String email;
	// ========== Constru4555ctors ==========
	public Utilisateur() {
	}
	//
	public Utilisateur(int id, String type, String prenom, String nom, String email) {
		this.id = id;
		this.type = type;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
	}
	// ========== getters & setters ==========
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	// ========== toString ==========
	@Override
	public String toString() {
		return "=======================\n" + prenom + " " + nom + "  -  id : " + id + " - " + type
				 + "\nEmail : " + email + "\n=======================\n";
		}

	
	}//fin classe
