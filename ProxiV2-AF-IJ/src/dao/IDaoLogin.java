package dao;

import metier.Conseiller;

public interface IDaoLogin {
	public Conseiller verificationLogin(String login, String pwd);

}
