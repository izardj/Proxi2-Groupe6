package tests;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import dao.Dao;
import dao.IDao;
import metier.Compte;
import metier.CompteCourant;

public class DaoTest {

	@Ignore
	@Test
	public void testModifierSolde(){
		IDao dao = new Dao();
		
		Compte c = new CompteCourant();
		c.setSolde(100);
		
		Assert.assertEquals(1, dao.modifierSoldeCompte(c));

	}

}

