package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Player;
import dao.DaoPlayer;

/**
 * Servlet implementation class ServPlayer
 */
@WebServlet("/serv_player")
public class ServPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServPlayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("view/addPlayer.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DaoPlayer dp = new DaoPlayer();
		Player player = new Player(request.getParameter("email"),request.getParameter("nickname"));
		String nickname = request.getParameter("nickname");
		
		if (dp.create(player)){
			System.out.println("Nouveau player !");
			request.setAttribute("message", "Bravo, le player " +nickname+" est bien crée !!!");
		}else {
			System.err.println("Pas de nouveau player...");
		}
		doGet(request, response);
	}
}