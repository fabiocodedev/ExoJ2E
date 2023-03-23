package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Contest;
import bean.Game;
import bean.Player;
import dao.DaoContest;
import dao.DaoGame;
import dao.DaoPlayer;

/**
 * Servlet implementation class ServContest
 */
@WebServlet("/serv_contest")
public class ServContest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServContest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("view/addContest.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DaoContest dc = new DaoContest();
		DaoGame dg = new DaoGame();
		DaoPlayer dp = new DaoPlayer();
		
		int id_game = Integer.parseInt(request.getParameter("game_id"));
		int id_winner = Integer.parseInt(request.getParameter("winner_id"));
		Game game = dg.findById(id_game);
		Player winner = dp.findById(id_winner);
		
		//PARSE LA DATE EN STRING...
		String date_start = request.getParameter("game_id");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try { 
			date = (Date) dateFormat.parse(date_start);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		
		Contest contest = new Contest(game,date,winner);
		System.err.println(contest);
		
		if (dc.create(contest)){
			System.out.println("Nouveau player !");
			request.setAttribute("message", "Bravo, le contest est bien crée !!!");
		}else {
			System.err.println("Pas de nouveau contest...");
		}
		doGet(request, response);
	}
}
