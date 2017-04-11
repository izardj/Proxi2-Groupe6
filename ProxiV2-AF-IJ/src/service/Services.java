package service;

import java.util.Collection;

import dao.IDaoClient;
import dao.IDaoLogin;
import metier.Client;
import metier.Compte;
import metier.Conseiller;

public class Services implements IConseillerService, ILoginService {
	
	
	private IDaoClient iDaoClient = new daoClient();

	@Override
	public Conseiller verificationLogin(String login, String pwd) {
		IDaoLogin iDaoLogin = new daoLogin();
		return iDaoLogin.verificationLogin(login,pwd);
	}

	@Override
	public Collection<Client> listerClients(Conseiller conseiller) {
		return iDaoClient.listerClientParConseiller(conseiller.getIdConseiller());
	}

	@Override
	public void modifierClient(Conseiller conseiller, Client client, String nom, String prenom, String email,
			String adresse, String codePostal, String ville, String telephone) {
		if (client.getConseiller().equals(conseiller)){
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
		if (client.getConseiller().equals(conseiller)){
			return iDaoClient.returnClientParId(client.getIdClient());
			
		}
		
	}

	@Override
	public boolean effectuerVirement(Conseiller conseiller, Client client, Compte compteCred, Compte comptedeb,
			double montant) {
		// TODO Auto-generated method stub
		return false;
	}

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
