package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoVehicule;
import Model.Vehicule;

/**
 * Servlet implementation class ServVehucule
 */
@WebServlet("/vehicule")
public class ServVehicule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServVehicule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("id") != null && request.getParameter("action").equalsIgnoreCase("edit") ) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("vehicule",new DaoVehicule().findByIdVehicule(id));
			System.out.println(new DaoVehicule().findByIdVehicule(id));
		}
		//execute le read et l'envoi a la vue
		request.setAttribute("listeVehicules",new DaoVehicule().read());
		request.getRequestDispatcher("view/vehicule.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String marqueV = request.getParameter("marque");
		String modeleV = request.getParameter("modele");
		DaoVehicule daoVehicule = new DaoVehicule();
		Vehicule vehicule = new Vehicule(request.getParameter("marque"),request.getParameter("modele")
				,request.getParameter("couleur"),request.getParameter("immatriculation"));
		
		if (request.getParameter("id") != null && request.getParameter("action").equals("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			vehicule.setId(id);
			daoVehicule.update(vehicule);
			request.setAttribute("message", "Bravo, le vehicule " +marqueV+" "+modeleV+" est bien updaté");
		}else {
			if (daoVehicule.create(vehicule)){
				System.out.println("Nouveau vehicule !");
				request.setAttribute("message", "Bravo, le vehicule " +marqueV+" "+modeleV+" est bien crée");
			}else {
				System.err.println("Pas de nouveau vehicule !");
			}
		}
		doGet(request, response);
	}
}
