package tests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import dao.Dao;
import dao.DaoConnexion;
import dao.IDao;
import metier.Compte;
import metier.CompteCourant;

public class DaoTest {

	private IDao dao = new Dao();

	@Test
	public void testListerTousComptes() {

		Connection conn = DaoConnexion.getConnexion();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("SELECT COUNT(id_client) FROM Compte");
			ResultSet rs = ps.executeQuery();
			rs.next();
			int nbLignes = rs.getInt(1);

			Collection<Compte> col = dao.listerComptes();

			Assert.assertEquals(nbLignes, col.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testModifierCompteExistant() {
		// simule le compte 1 qui est un coompte courant et existe en bdd
		Compte c = new CompteCourant();
		c.setIdCompte(1);

		// modifie son solde a 1000
		c.setSolde(1000);

		// appel de la methode
		dao.modifierCompte(c);

		Connection conn = DaoConnexion.getConnexion();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("SELECT solde FROM Compte WHERE id_compte = 1");
			ResultSet rs = ps.executeQuery();
			rs.next();
			Double soldeBdd = rs.getDouble("solde");

			// assertion
			Assert.assertEquals(c.getSolde(), soldeBdd, 0);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
