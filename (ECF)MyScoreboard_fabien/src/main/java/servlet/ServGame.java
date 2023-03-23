package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Game;
import dao.DaoGame;

/**
 * Servlet implementation class ServGame
 */
@WebServlet("/serv_game")
public class ServGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServGame() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("view/addGame.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DaoGame dg = new DaoGame();
		int players_min = Integer.parseInt(request.getParameter("min_players"));
		int players_max = Integer.parseInt(request.getParameter("max_players"));
		Game game = new Game(request.getParameter("title"),players_min,players_max);
		
		if (dg.create(game)){
			System.out.println("Nouveau player !");
			request.setAttribute("message", "Bravo, le jeu est bien crée !!!");
		}else {
			System.err.println("Pas de nouveau jeu...");
		}
		
		doGet(request, response);
	}

}
