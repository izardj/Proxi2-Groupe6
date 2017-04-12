package service;

import java.util.ArrayList;
import java.util.Collection;

import dao.Dao;
import dao.IDao;
import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.Conseiller;

public class Services implements IConseillerService, ILoginService {

	private IDao iDao = new Dao();

	@Override
	public Compte recupererCompteParId(int id) {
		return iDao.getCompteParId(id);
	}

	@Override
	public Collection<Compte> recupererAutresComptes(Compte compte) {
		Collection<Compte> comptes = iDao.listerComptes();
		comptes.remove(compte);
		return comptes;
	}

	@Override
	public Conseiller verificationLogin(String login, String pwd) {

		return iDao.verificationLogin(login, pwd);
	}

	@Override
	public Collection<Client> listerClients(Conseiller conseiller) {
		return iDao.listerClientsParConseiller(conseiller.getIdConseiller());
	}

	@Override
	public void modifierClient(Conseiller conseiller, Client client, String nom, String prenom, String email,
			String adresse, String codePostal, String ville, String telephone) {
			Collection <Client> clients= iDao.listerClientsParConseiller(conseiller.getIdConseiller());
			for (Client c : clients) {
			if(client.getIdClient() == c.getIdClient()){
			client.setConseiller(conseiller);
			client.setNom(nom);
			client.setPrenom(prenom);
			client.setEmail(email);
			client.setAdresse(adresse);
			client.setCodePostal(codePostal);
			client.setVille(ville);
			client.setTelephone(telephone);
			iDao.modifierClient(client);
		}

	}
	}

	@Override
	public Client afficherClient(Conseiller conseiller, int id) {
		Client c = iDao.retourneClientParId(id);
		Collection<Client> clients = iDao.listerClientsParConseiller(conseiller.getIdConseiller());
		for (Client client : clients) {
			if (client.getIdClient() == c.getIdClient()) {
				c.setConseiller(conseiller);
				return c;
			}
		}
		return new Client();
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
					c.setSolde(solde); // debite le comptecourant
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
					c.setSolde(solde); // debite le compte Epargne
				}

			}
			return c;
		}

		return c;
	}

	@Override
	public boolean effectuerVirement(Conseiller conseiller, Client client, Compte compteCred, Compte compteDeb,
			double montant) {
		if (client.getConseiller().equals(conseiller)) {

			compteDeb.setSolde(debiterCompte(compteDeb, montant).getSolde());
			// debite un compte et verification que le debit a eu lieu
			if (iDao.modifierCompte(compteDeb) == 1) {
				compteCred.setSolde(crediterCompte(compteCred, montant).getSolde());
				// credite un compte
				if (iDao.modifierCompte(compteCred) == 1) {
					return true;
				} else {
					return false;
				}

			}
		}
		return false;
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

	@Override
	public Conseiller afficherConseiller(int idConseiller) {
		return iDao.afficherConseiller(idConseiller);
	}

}
