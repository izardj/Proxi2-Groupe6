package metier;

public abstract class Personne {
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;
	private String email;

	protected String getNom() {
		return nom;
	}

	protected void setNom(String nom) {
		this.nom = nom;
	}

	protected String getPrenom() {
		return prenom;
	}

	protected void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	protected String getAdresse() {
		return adresse;
	}

	protected void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	protected String getCodePostal() {
		return codePostal;
	}

	protected void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	protected String getVille() {
		return ville;
	}

	protected void setVille(String ville) {
		this.ville = ville;
	}

	protected String getTelephone() {
		return telephone;
	}

	protected void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Personne() {
		super();
	}

	public Personne(String nom, String prenom, String adresse, String codePostal, String ville, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}
}
