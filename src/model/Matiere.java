package model;

public class Matiere {
	private int id;
	private String nom;
	// ========== Constructors ==========
	public Matiere() {
	}
	public Matiere(int id, String nom) {
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

}//end of class matiere 
