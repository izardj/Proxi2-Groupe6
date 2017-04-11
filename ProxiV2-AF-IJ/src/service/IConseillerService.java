package service;

import java.util.Collection;

import metier.Client;
import metier.Compte;
import metier.Conseiller;

public interface IConseillerService {

	public Collection<Client> listerClients(Conseiller conseiller);

	public void modifierClient(Conseiller conseiller, Client client, String nom, String prenom, String email,
			String adresse, String codePostal, String ville, String telephone);

	public Client afficherClient(Conseiller conseiller, Client client);
	
	
	/**
	 * Methode qui permet de realiser des virement de compte a compte
	 * @param conseiller conseiller qui realise le virement
	 * 
	 * @param client client a qui appartient le compte à débiter
	 * 
	 * @param montant
	 *            Montant du virement
	 * @param compteCred
	 *            Compte a crediter
	 * @param compteDeb
	 *            Compte a debiter
	 */
	public boolean effectuerVirement(Conseiller conseiller, Client client, Compte compteCred, Compte comptedeb,
			double montant);

	// pas prioritaire
	public boolean creerClient(Conseiller conseiller, Client client);

	public void supprimerClient(Conseiller conseiller, Client client);

}
