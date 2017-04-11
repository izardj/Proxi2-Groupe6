package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import metier.Client;
import metier.Compte;
import metier.Conseiller;

public class Dao implements IDao {

	@Override
	public Conseiller verificationLogin(String login, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Client> listerClientParConseiller(int idConseiller) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifierClient(Client client) {
		// TODO Auto-generated method stub

	}

	@Override
	public Client returnClientParId(int IdClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifierSoldeCompte(Compte compte) {
		int row = 0;
		try {
			// prepare la requete
			PreparedStatement ps = DaoConnexion.getConnexion()
					.prepareStatement("UPDATE Compte SET solde = ?, WHERE id_compte = ?");

			ps.setDouble(1, compte.getSolde());
			ps.setInt(2, compte.getIdCompte());

			// executer la requête pour Coordonnee
			row += ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DaoConnexion.closeConnexion();
		}
		return row;
	}

}
