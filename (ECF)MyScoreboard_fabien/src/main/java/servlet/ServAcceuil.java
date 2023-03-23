package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoContest;
import dao.DaoGame;
import dao.DaoPlayer;

/**
 * Servlet implementation class ServAcceuil
 */
@WebServlet("/")
public class ServAcceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    /**     
     * @see HttpServlet#HttpServlet()
     */
    public ServAcceuil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**  
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//DaoGame dg = new DaoGame();
		//DaoPlayer dp = new DaoPlayer();
		//DaoContest dc = new DaoContest();
		
		
		request.setAttribute("games", new DaoGame().read());
		request.setAttribute("players", new DaoPlayer().read());
		request.setAttribute("contests", new DaoContest().read());
		request.getRequestDispatcher("view/accueil.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
