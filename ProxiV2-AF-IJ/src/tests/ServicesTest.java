package tests;

import org.junit.Assert;
import org.junit.Test;

import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.Conseiller;
import service.IConseillerService;
import service.Services;

public class ServicesTest {

	IConseillerService iService = (IConseillerService) new Services();

	// cas nominal
	@Test
	public void testeffectuerVirementCasNominal() {
		Conseiller conseiller = new Conseiller();
		conseiller.setIdConseiller(1);
		Client client = new Client();
		client.setConseiller(conseiller);
		CompteCourant compte1 = new CompteCourant(1, 1000, "19/02", client, null, 1000);
		CompteEpargne compte2 = new CompteEpargne(2, 100, "30/03", client, null, 0.03);
		boolean b = iService.effectuerVirement(conseiller, client, compte2, compte1, 500);
		Assert.assertEquals(true, b);
	}

	// cas utilisation autorisation decouvert
	@Test
	public void testeffectuerVirementUtilisationDecouvert() {
		Conseiller conseiller = new Conseiller();
		conseiller.setIdConseiller(1);
		Client client = new Client();
		client.setConseiller(conseiller);
		CompteCourant compte1 = new CompteCourant(1, 1000, "19/02", client, null, 1000);
		CompteEpargne compte2 = new CompteEpargne(2, 100, "30/03", client, null, 0.03);
		boolean b = iService.effectuerVirement(conseiller, client, compte2, compte1, 1500);
		Assert.assertEquals(true, b);
	}

	// cas autorisation decouvert insuffisant
	@Test
	public void testeffectuerVirementDecouvertInsuffisant() {
		Conseiller conseiller = new Conseiller();
		conseiller.setIdConseiller(1);
		Client client = new Client();
		client.setConseiller(conseiller);
		CompteCourant compte1 = new CompteCourant(1, 1000, "19/02", client, null, 1000);
		CompteEpargne compte2 = new CompteEpargne(2, 100, "30/03", client, null, 0.03);
		boolean b = iService.effectuerVirement(conseiller, client, compte2, compte1, 2500);
		Assert.assertEquals(false, b);
	}

	// cas compte sans decouvert
	@Test
	public void testeffectuerVirementSansDecouvert() {
		Conseiller conseiller = new Conseiller();
		conseiller.setIdConseiller(1);
		Client client = new Client();
		client.setConseiller(conseiller);
		CompteCourant compte1 = new CompteCourant(1, 1000, "19/02", client, null, 1000);
		CompteEpargne compte2 = new CompteEpargne(2, 100, "30/03", client, null, 0.03);
		boolean b = iService.effectuerVirement(conseiller, client, compte1, compte2, 200);
		Assert.assertEquals(false, b);
	}

	// cas nominal
	@Test
	public void testRecupererCompteParId() {
		Compte c = iService.recupererCompteParId(7);
				Assert.assertTrue(7==c.getIdCompte());
		

	}
	

}