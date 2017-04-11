package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Client;
import metier.Conseiller;
import service.ILoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// md�fini l'encodage des param�tres en UTF-8
		request.setCharacterEncoding("UTF-8");

		// 1- R�cup�ration les param�tres
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");

		// 2- Traitement avec la couche service
		// TODO utiliser la couche service pour identifier client plutot qu'en dur
		//ILoginService ls = new Service();
		//Conseiller conseiller = ls.verificationLogin(login, pwd);
		
		// verifie si le conseiller existe
		// conseiller.getId() == null
		if (login.equals("toto") && pwd.equals("titi")) {
			// 4 Envoi vers la JSP qui liste les clients
			request.getRequestDispatcher("/listerClients.jsp").forward(request, response);
		} else {
			// 3- Pr�paration de l'envoi
			request.setAttribute("erreur", "Echec identification conseiller, veuillez r�essayer.");
			// 4 Envoi vers la JSP d'identification
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}