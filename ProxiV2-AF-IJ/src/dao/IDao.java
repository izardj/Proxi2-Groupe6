package dao;

import java.util.Collection;

import metier.Client;
import metier.Compte;
import metier.Conseiller;

public interface IDao {

	public int modifierCompte(Compte compte);

	public int creerConseiller(Conseiller conseiller);

	public int modifierConseiller(Conseiller conseiller);

	public Conseiller verificationLogin(String login, String pwd);

	public int supprimerConseiller(Conseiller conseiller);

	public int creerCompte(Compte compte);

	public Compte getCompteParId(int id);

	public int supprimerCompte(Compte compte);

	public int creerClient(Client client);

	public int modifierClient(Client client);

	public int supprimerClient(Client client);

	public Client retourneClientParId(int idClient);

	public Collection<Client> listerClientsParConseiller(int idConseiller);
	
	/**
	 * Récupère tous les comptes de l'agence
	 * @return une collection de compte
	 */
	public Collection<Compte> listerComptes();

}
