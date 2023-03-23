package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Contest;
import bean.Player;
import bean.Player_contest;
import dao.DaoPlayer_contest;

/**
 * Servlet implementation class ServMatch
 */
@WebServlet("/serv_match")
public class ServMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServMatch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("view/addMatch.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DaoPlayer_contest dpc = new DaoPlayer_contest();
		ArrayList<Player> player = new ArrayList<Player>();
		Contest contest = new Contest();
		Player_contest player_contest = new Player_contest(player,contest);
		
		
		if (dpc.create(player_contest)){
			System.out.println("Nouveau match !");
			request.setAttribute("message", "Bravo, le match est bien crée !!!");
		}else {
			System.err.println("Pas de nouveau match...");
		}
		
		doGet(request, response);
	}

}
