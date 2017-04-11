package service;

import java.util.Collection;

import metier.Client;
import metier.Compte;
import metier.Conseiller;

public interface IConseillerService {

	/**
	 * renvoie la liste de client d'un conseiller
	 * 
	 * @param conseiller
	 *            conseiller dont on veut les clients
	 * @return
	 */
	public Collection<Client> listerClients(Conseiller conseiller);

	/**
	 * Modifie le client d'un conseiller
	 * 
	 * @param conseiller
	 *            conseiller qui modifie sont client
	 * @param client
	 *            client a modifier
	 * @param nom
	 *            nouveau nom
	 * @param prenom
	 *            nouveau prenom
	 * @param email
	 *            nouveau email
	 * @param adresse
	 *            nouvelle adresse
	 * @param codePostal
	 *            nouveau code postal
	 * @param ville
	 *            nouvelle ville
	 * @param telephone
	 *            nouveau numeros de telephone
	 */
	public void modifierClient(Conseiller conseiller, Client client, String nom, String prenom, String email,
			String adresse, String codePostal, String ville, String telephone);

	/**
	 * methode qui retourne un client pour l'afficher
	 * 
	 * @param conseiller
	 *            conseiller qui demande
	 * @param client
	 *            client a afficher
	 * @return
	 */
	public Client afficherClient(Conseiller conseiller, Client client);

	/**
	 * Methode qui permet de realiser des virement de compte a compte
	 * 
	 * @param conseiller
	 *            conseiller qui realise le virement
	 * @param client
	 *            client a qui appartient le compte à débiter
	 * @param compteCred
	 *            Montant du virement
	 * @param comptedeb
	 *            Compte a crediter
	 * @param montant
	 *            Compte a debiter
	 * @return
	 */
	public boolean effectuerVirement(Conseiller conseiller, Client client, Compte compteCred, Compte comptedeb,
			double montant);

	// pas prioritaire
	/**
	 * creer un nouveau client
	 * 
	 * @param conseiller
	 *            conseiller qui creer le client
	 * @param client
	 *            client a créer
	 * @return
	 */
	public boolean creerClient(Conseiller conseiller, Client client);

	/**
	 * supprime un client
	 * 
	 * @param conseiller
	 *            conseiller qui supprime le client
	 * @param client
	 *            client a supprimer
	 */
	public void supprimerClient(Conseiller conseiller, Client client);

}
