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
	public boolean virement(Compte compteCred,Compte compteDeb);
	
}
