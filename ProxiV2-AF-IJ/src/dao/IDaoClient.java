package dao;

import java.util.Collection;

import metier.Client;

public interface IDaoClient {
	
	public Collection<Client> listerClientParConseiller(int idConseiller);
	public void modifierClient(Client client);
	public Client returnClientParId(int IdClient);
	
}
