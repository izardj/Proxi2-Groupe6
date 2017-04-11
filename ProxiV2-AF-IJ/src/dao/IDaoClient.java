package dao;

import java.util.Collection;

import metier.Client;

public interface IDaoClient {
	
	public Collection<Client> listerClientParConseiller(idConseiller);
	public void modifierClient(Client client);
	public Client returnClientParId(client.getIdClient());
	
}
