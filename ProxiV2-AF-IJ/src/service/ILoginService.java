package service;

import metier.Conseiller;

public interface ILoginService {
	/**
	 * Methode d'authentification par login et PWD		
	 * @param login parametre login	
	 * @param pwd parametr  mots de passe
	 * @return
	 */
	public Conseiller verificationLogin(String login, String pwd);

}
