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
	 * Met � jour le solde de compte
	 * @param compte Le compte � modifier
	 * @return 1 en cas de succ�s ou 0 si le compte n'a pas �t� modifi�
	 */
	public int modifierSoldeCompte(Compte compte);
	
}
