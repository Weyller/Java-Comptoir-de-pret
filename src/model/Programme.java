package model;

public class Programme {

	private int id;
	private String nom;

	// ========== Constructors ==========
	public Programme() {
	}

	public Programme(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	// ========== getters & setters ==========
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// ========== toString ==========
	@Override
	public String toString() { 
		return "=======================" 
				+ "\nNom : " + nom 
				+ "\nid : " + id ;
	}

}//fin de classe
