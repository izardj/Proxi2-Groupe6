package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		try {

			// 2- créer la connexion
			Connection conn = DaoConnexion.getConnexion();
			// 3- créer la requête

			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO Conseiller(nom, prenom, adresse, code_postal, ville, telephone,login,pwd) VALUES (?, ?, ?, ?,?,?,?,?)");
			ps.setString(1, conseiller.getNom());
			ps.setString(2, conseiller.getPrenom());
			ps.setString(3, conseiller.getAdresse());
			ps.setString(4, conseiller.getCodePostal());
			ps.setString(5, conseiller.getVille());
			ps.setString(6, conseiller.getTelephone());
			ps.setString(7, conseiller.getLogin());
			ps.setString(8, conseiller.getPwd());

			// 4- executer la requête
			ps.executeUpdate();
			// 5- présenter les résultats

			// 6- fermer la connexion
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// code qui est executé quelque soit les étapes précédentes
		}

	}

	@Override
	public int modifierConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Conseiller verificationLogin(String login, String pwd) {
		Conseiller c = new Conseiller();
		try {
			// creer la connexion
			Connection conn = DaoConnexion.getConnexion();

			// Créer la requête
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Conseiller WHERE login = ? AND pwd = ?");
			ps.setString(1, login);
			ps.setString(2, pwd);

			// Exécuter la requête
			ResultSet rs = ps.executeQuery();

			// Présenter les résultats

			if (rs.next()) {
				c.setIdConseiller(rs.getInt("id_conseiller"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setAdresse(rs.getString("adresse"));
				c.setCodePostal(rs.getString("code_postal"));
				c.setVille(rs.getString("ville"));
				c.setLogin(rs.getString("login"));
				c.setPwd(rs.getString("pwd"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fermer la connexion
			DaoConnexion.closeConnexion();
		}
		return c;
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
