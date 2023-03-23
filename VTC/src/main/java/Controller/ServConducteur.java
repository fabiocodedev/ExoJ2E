package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoConducteur;
import Model.Conducteur;

/**
 * Servlet implementation class ServConducteur
 */
@WebServlet("/conducteur")
public class ServConducteur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServConducteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("id") != null && request.getParameter("action").equalsIgnoreCase("edit") ) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("conducteur",new DaoConducteur().findByIdConducteur(id));
		}
		//execute le read et l'envoi a la vue
		request.setAttribute("listeConducteurs",new DaoConducteur().read());
		request.getRequestDispatcher("view/conducteur.jsp").forward(request, response);
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String prenomC = request.getParameter("prenom");
		String nomC = request.getParameter("nom");
		DaoConducteur daoConducteur = new DaoConducteur();
		Conducteur conducteur = new Conducteur(request.getParameter("prenom"),request.getParameter("nom"));

		if (request.getParameter("id") != null && request.getParameter("action").equals("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			conducteur.setId(id);
			daoConducteur.update(conducteur);
			request.setAttribute("message", "Bravo, le conducteur " +prenomC+" "+nomC+" est bien updaté");
		}else {
			if (daoConducteur.create(conducteur)){
				System.out.println("Nouveau conducteur !");
				request.setAttribute("message", "Bravo, le conducteur " +prenomC+" "+nomC+" est bien crée !!!");
			}else {
				System.err.println("Pas de nouveau conducteur !");
			}
		}
		doGet(request, response);
	}
}
