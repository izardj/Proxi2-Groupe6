package tests;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import metier.CarteBancaire;
import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.Conseiller;
import metier.Placement;
import service.IConseillerService;
import service.Services;

public class ServicesTest {
	
	@Ignore
	@Test
	public void testModifierClient() {
		IConseillerService test = new Services();
		Client client = new Client();
		Client clientModif = new Client();
		Conseiller conseiller = new Conseiller();
		conseiller = test.afficherConseiller(1);
		client = test.afficherClient(conseiller, 1);
		clientModif = client;
		//test.modifierClient(conseiller, clientModif, "toto", "titi", "email", "adresse", "codePostal", " ville",
			//	"telephone");
		clientModif = test.afficherClient(conseiller, 1);
		Assert.assertNotSame(client, clientModif);

	}

	
	@Ignore
	@Test
	public void afficherClient() {
		IConseillerService test = new Services();
		Client client = new Client();
		Client clientTest = new Client();
		Client clientRef = new Client();
		Conseiller conseiller = new Conseiller();
		conseiller = test.afficherConseiller(1);
		client.setIdClient(7);
		test.modifierClient(conseiller,client, "Ayraud", "Florent", "fayraud@email.com",
				"gabriel péri", "69100", "Villerubane", "98754121");
		client = test.afficherClient(conseiller, 7);
		clientTest.setNom(client.getNom());
		clientTest.setPrenom(client.getPrenom());
		clientTest.setAdresse(client.getAdresse());
		clientTest.setCodePostal(client.getCodePostal());
		clientTest.setVille(client.getVille());
		clientTest.setTelephone(client.getTelephone());
		clientTest.setEmail(client.getEmail());


		Assert.assertSame("69100", clientTest.getCodePostal());

	}
	
	
	
	


}
