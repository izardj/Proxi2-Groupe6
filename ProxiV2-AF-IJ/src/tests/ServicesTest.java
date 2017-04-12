package tests;

import java.util.ArrayList;
import java.util.Collection;

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
	
	// creation 
	Compte compteCourant1 = new CompteCourant(1, 1000, "10/09/90", null, null, 1000);
	Compte compteCourant2 = new CompteCourant(2, 2000, "30/03/1985", null, null, 2000);
	
	Client client1 = new Client(Izard, Jerome, rue toto, 38 420, domaine, 066666666,
			1, true, econocome, comptes1,
			placements1, conseiller1)

	@Test
	public void testmodifierClient() {
		IConseillerService test = new Services();
		Client client = new Client();
		Conseiller conseiller = new Conseiller();
		conseiller = test.
		client= test.afficherClient(conseiller, id)
		
	}

}
