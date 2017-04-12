package tests;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
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
	

	@Test
	public void testmodifierClient() {
		IConseillerService test = new Services();
		Client client = new Client();
		Client clientModif = new Client();
		Conseiller conseiller = new Conseiller();
		conseiller = test.afficherConseiller(1);
		client= test.afficherClient(conseiller, 1);
		clientModif = client;
		test.modifierClient(conseiller, clientModif, "toto", "titi", "email", "adresse", "codePostal"," ville", "telephone");
		clientModif = test.afficherClient(conseiller, 1);
		Assert.assertNotSame(client,clientModif);
		
		
	}

}
