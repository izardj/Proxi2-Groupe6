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
	public String toString() {
		return "Client [entreprise=" + entreprise + ", nomEntreprise=" + nomEntreprise + ", comptes=" + comptes
				+ ", placements=" + placements + ", conseiller=" + conseiller + "]";
	}

}
