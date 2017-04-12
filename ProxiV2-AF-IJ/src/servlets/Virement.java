package servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Compte;
import service.IConseillerService;
import service.Services;

/**
 * Servlet implementation class Virement
 */
@WebServlet("/Virement")
public class Virement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IConseillerService service = new Services();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Virement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// d�fini l'encodage des param�tres en UTF-8
		request.setCharacterEncoding("UTF-8");
		
		// verifier session
		if(request.isRequestedSessionIdValid()){			
			int id = Integer.parseInt(request.getParameter("id"));
			
			Compte compteDebiteur = service.recupererCompteParId(id);
			Collection<Compte> autresComptes = service.recupererAutresComptes(compteDebiteur);
			
			request.setAttribute("compteDebiteur", compteDebiteur);
			request.setAttribute("autresComptes", autresComptes);
			
			request.getRequestDispatcher("/virement.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}