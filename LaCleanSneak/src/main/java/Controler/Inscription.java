package Controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCrypt;

import Dao.UserDao;
import Model.User;


/**
 * Servlet implementation class AddUser
 */
@WebServlet("/inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("view/user/inscription.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("adresse"));
		
		// TODO Auto-generated method stub
		
//				 VERSION 1 AVEC MDP CRIPTER PAR SQL ----------------
//		         User user = new User(request.getParameter("nom"),request.getParameter("prenom"),
//               request.getParameter("adresse"),
//				 request.getParameter("telephone"),request.getParameter("email"),request.getParameter("mdp"));
//		
//				 User user = new User(); 
//		
//				 user.setNom(request.getParameter("nom"));
//				 user.setPrenom(request.getParameter("prenom"));
//				 user.setEmail(request.getParameter("email"));
//				 user.setMdp(request.getParameter("mdp"));
		
		
//		        CRYPTAGE DU MDP AVEC BCRYPT ----------------------------------
		
				String mdpCrypt = BCrypt.hashpw(request.getParameter("mdp"), BCrypt.gensalt());
				
				User user = new User(request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("adresse"),
					request.getParameter("telephone"),request.getParameter("email"),mdpCrypt);
				
				UserDao userDao = new UserDao();
				
				if (userDao.create(user)) {
					System.out.println("bravo, compte crée !");
					response.sendRedirect("/LaCleanSneak/");
					// !!! le dispacht appel la vue en .jsp directement, le traitement des serverlet correspondant ne sont pas effectuer... 
					//request.getRequestDispatcher("vue/index.jsp").forward(request, response);
				} else {
					System.out.println("Echec de la création du compte...");
					doGet(request, response);
				}
		
	}
}