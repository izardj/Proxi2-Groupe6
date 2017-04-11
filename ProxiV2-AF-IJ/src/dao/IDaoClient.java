package dao;

import java.util.Collection;

import metier.Client;
import metier.Conseiller;

public interface IDaoClient {
	
	public Collection<Client> listerClientParConseiller(id_conseiller);
}
