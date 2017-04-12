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

	public Client afficherClient(Conseiller conseiller, int id);

	/**
	 * Methode qui permet de realiser des virement de compte a compte
	 * 
	 * @param conseiller
	 *            conseiller qui realise le virement
	 * @param client
	 *            client a qui appartient le compte � d�biter
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
	 *            client a cr�er
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
	
	/**
	 * R�cup�re un compte par son identifiant
	 * @param id identifiant du compte
	 * @return le Compte r�cup�r�
	 */
	public Compte recupererCompteParId(int id);
	
	/**
	 * R�cup�re tous les comptes de l'agence sauf le compte donn� en argument
	 * @param compte Compte � ne pas r�cup�rer
	 * @return La collection de tous les comptes sauf le compte donn�
	 */
	public Collection<Compte> recupererAutresComptes(Compte compte);

}
