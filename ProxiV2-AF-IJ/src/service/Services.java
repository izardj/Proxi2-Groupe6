package service;

import java.util.Collection;

import dao.IDaoClient;
import dao.IDaoLogin;
import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.Conseiller;

public class Services implements IConseillerService, ILoginService {

	private IDaoClient iDaoClient = new daoClient();

	@Override
	public Conseiller verificationLogin(String login, String pwd) {
		IDaoLogin iDaoLogin = new daoLogin();
		return iDaoLogin.verificationLogin(login, pwd);
	}

	@Override
	public Collection<Client> listerClients(Conseiller conseiller) {
		return iDaoClient.listerClientParConseiller(conseiller.getIdConseiller());
	}

	@Override
	public void modifierClient(Conseiller conseiller, Client client, String nom, String prenom, String email,
			String adresse, String codePostal, String ville, String telephone) {
		if (client.getConseiller().equals(conseiller)) {
			client.setNom(nom);
			client.setPrenom(prenom);
			client.setEmail(email);
			client.setAdresse(adresse);
			client.setCodePostal(codePostal);
			client.setVille(ville);
			client.setTelephone(telephone);
			iDaoClient.modifierClient(client);
		}

	}

	@Override
	public Client afficherClient(Conseiller conseiller, Client client) {
		if (client.getConseiller().equals(conseiller)) {
			return iDaoClient.returnClientParId(client.getIdClient());

		}

	}
	/**
	 * Methode permettant de crediter un compte
	 * 
	 * @param c
	 *            Compte a crediter
	 * @param montant
	 *            Montant a Crediter sur le compte
	 * @return retourne le compte crédité
	 */
	public Compte crediterCompte(Compte c, double montant) {
		if (montant >= 0) {
			double solde = c.getSolde();
			solde = solde + montant;
			c.setSolde(solde);

		}
		return c;
	}

	/**
	 * Methode permetant de debiter un compte
	 * 
	 * @param c
	 *            Compte a debiter
	 * @param montant
	 *            Montant a debiter
	 * @return retourne le compte
	 */
	public Compte debiterCompte(Compte c, double montant) {
		
		
// si compte Courant (avec decouvert)
		if (c instanceof CompteCourant) {
			double solde = c.getSolde();
			double decouvert = ((CompteCourant) c).getDecouvert();
			if (montant >= 0) {
				if (solde + decouvert >= montant) {
					solde = solde - montant;
					c.setSolde(solde); //debite le comptecourant
				}

			}
			return c;

		}
// si compte Epargne (Sans decouvert)
		if (c instanceof CompteEpargne) {
			double solde = c.getSolde();
			if (montant >= 0) {
				if (solde >= montant) {
					solde = solde - montant;  
					c.setSolde(solde); //debite le compte Epargne
				}

			}
			return c;
		}

		return c;
	}

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
	 * @param comptedeb
	 *            Compte a debiter
	 */
	@Override
	public boolean effectuerVirement(Conseiller conseiller, Client client, Compte compteCred, Compte comptedeb,
			double montant) {
		if (client.getConseiller().equals(conseiller)) {
			double s = comptedeb.getSolde();
			debiterCompte(comptedeb, montant); // debite un compte
			// verification que le debit a eu lieu
			if (s!=comptedeb.getSolde())
			{
			crediterCompte(compteCred, montant); // credite un compte
		}

		return false;
	}
	}
		
		// pas prioritaire

	@Override
	public boolean creerClient(Conseiller conseiller, Client client) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void supprimerClient(Conseiller conseiller, Client client) {
		// TODO Auto-generated method stub

	}

}
