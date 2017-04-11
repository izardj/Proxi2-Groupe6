package metier;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Client extends Personne {
	private int idClient;
	private boolean entreprise = false;
	private String nomEntreprise;
	private Collection<Compte> comptes = new ArrayList<Compte>();
	private Collection<Placement> placements = new ArrayList<Placement>();
	private Conseiller conseiller;

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public boolean isEntreprise() {
		return entreprise;
	}

	public void setEntreprise(boolean entreprise) {
		this.entreprise = entreprise;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	public Collection<Placement> getPlacements() {
		return placements;
	}

	public void setPlacements(Collection<Placement> placements) {
		this.placements = placements;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	

	@Override
	protected String getNom() {
		// TODO Auto-generated method stub
		return super.getNom();
	}

	@Override
	protected void setNom(String nom) {
		// TODO Auto-generated method stub
		super.setNom(nom);
	}

	@Override
	protected String getPrenom() {
		// TODO Auto-generated method stub
		return super.getPrenom();
	}

	@Override
	protected void setPrenom(String prenom) {
		// TODO Auto-generated method stub
		super.setPrenom(prenom);
	}

	@Override
	protected String getAdresse() {
		// TODO Auto-generated method stub
		return super.getAdresse();
	}

	@Override
	protected void setAdresse(String adresse) {
		// TODO Auto-generated method stub
		super.setAdresse(adresse);
	}

	@Override
	protected String getCodePostal() {
		// TODO Auto-generated method stub
		return super.getCodePostal();
	}

	@Override
	protected void setCodePostal(String codePostal) {
		// TODO Auto-generated method stub
		super.setCodePostal(codePostal);
	}

	@Override
	protected String getVille() {
		// TODO Auto-generated method stub
		return super.getVille();
	}

	@Override
	protected void setVille(String ville) {
		// TODO Auto-generated method stub
		super.setVille(ville);
	}

	@Override
	protected String getTelephone() {
		// TODO Auto-generated method stub
		return super.getTelephone();
	}

	@Override
	protected void setTelephone(String telephone) {
		// TODO Auto-generated method stub
		super.setTelephone(telephone);
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "Client [entreprise=" + entreprise + ", nomEntreprise=" + nomEntreprise + ", comptes=" + comptes
				+ ", placements=" + placements + ", conseiller=" + conseiller + "]";
	}

}
