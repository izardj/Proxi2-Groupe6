package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import metier.Client;
import metier.Compte;
import metier.Conseiller;

public class Dao implements IDao {

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

	@Override
	public int creerConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifierConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Conseiller verificationLogin(String login, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int supprimerConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int creerCompte(Compte compte) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifierCompte(Compte compte) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Compte getCompteParId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int supprimerCompte(Compte compte) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int creerClient(Client client) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifierClient(Client client) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int supprimerClient(Client client) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Client retourneClientParId(int IdClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Client> listerClientsParConseiller(int idConseiller) {
		// TODO Auto-generated method stub
		return null;
	}

}
