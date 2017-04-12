package service;

import java.util.Collection;

import metier.Client;
import metier.Compte;
import metier.Conseiller;

public interface IConseillerService {

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
	 * Retourne le conseiller corespondant a l'idConseiller
	 * @param idConseiller identifiant du conseiller a retourner
	 * @return
	 */
	public Conseiller afficherConseiller(int idConseiller);

	/**
	 * renvoie la liste de client d'un conseiller
	 * 
	 * @param conseiller
	 *            conseiller dont on veut les clients
	 * @return
	 */
	public Collection<Client> listerClients(Conseiller conseiller);

	/**
	 * Modifie un client spécifique d'un conseiller
	 * 
	 * @param conseiller
	 * @param idClient
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param telephone
	 * @return true si le client a bien été modifié et false en cas contraire
	 */
	public boolean modifierClient(Conseiller conseiller, int idClient, String nom, String prenom, String email,
			String adresse, String codePostal, String ville, String telephone);
/**
 * retourne le client correspondant a l'id si le conseiller qui le demande est sont conseiller
 * @param conseiller conseiller qui demande le client
 * @param id identifiant du client a retourner
 * @return
 */
	public Client afficherClient(Conseiller conseiller, int id);

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
	 * Récupère un compte par son identifiant
	 * 
	 * @param id
	 *            identifiant du compte
	 * @return le Compte récupéré
	 */
	public Compte recupererCompteParId(int id);

	/**
	 * Récupère tous les comptes de l'agence sauf le compte donné en argument
	 * 
	 * @param compte
	 *            Compte à ne pas récupérer
	 * @return La collection de tous les comptes sauf le compte donné
	 */
	public Collection<Compte> recupererAutresComptes(Compte compte);
}
