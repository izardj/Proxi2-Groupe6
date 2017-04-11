package dao;

import java.util.Collection;

import metier.Client;
import metier.Compte;
import metier.Conseiller;

public interface IDao {
	
	public Conseiller verificationLogin(String login, String pwd);
	public Collection<Client> listerClientParConseiller(int idConseiller);
	public void modifierClient(Client client);
	public Client returnClientParId(int IdClient);
	/**
	 * Met à jour un Compte
	 * @param compte Le compte à modifier
	 * @return true si la modification à eu lieu
	 */
	public boolean modifierCompte(Compte compte);
	
}
