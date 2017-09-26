package model;

public class Article {

	private int id;
	private String nom;
	private String categorie;
	private int quantite;
	private Boolean special;
	
	// ========== Constructors ==========
	public Article() {
		
	}
	//
	public Article(int id, String nom, String categorie, int quantite, Boolean special) {
		super();
		this.id = id;
		this.nom = nom;
		this.categorie = categorie;
		this.quantite = quantite;
		this.special = special;
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

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Boolean getSpecial() {
		return special;
	}

	public void setSpecial(Boolean special) {
		this.special = special;
	}

	// ========== toString ==========
	@Override
	public String toString() { 
		return "=======================" 
				+ "\nNom : " + nom 
				+ "\nCategorie : " + categorie 
				+ "\nid : " + id 
				+ "\nQuantite : " + quantite
				+ "\nSpecial : " + special;
	}
}//fin classe
