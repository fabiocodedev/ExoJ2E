package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Contest;
import bean.Game;
import bean.Player;

public class DaoContest implements ICRUD<Contest> {

	Connection MyCo = Connect.getConnect();
	PreparedStatement sql = null;
	ResultSet rs = null;
	
	Game game = null;
	Player winner = null;
	Contest contest = null;
	
	@Override
	public Boolean create(Contest contest) {
		
		try {
			sql = MyCo.prepareStatement("INSERT INTO contest (game_id,start_date,winner_id) VALUES (?,NOW(),?)");
			//sql = MyCo.prepareStatement("INSERT INTO contest (game_id,start_date,winner_id) VALUES (?,?,?)");
			
			sql.setInt(1, contest.getGame_id().getId());
			//sql.setDate(2, contest.getStart_date());
			sql.setInt(3, contest.getWinner_id().getId());
			
			sql.execute();
			System.out.println(contest.getGame_id().getId());
			System.out.println(contest.getWinner_id().getId());
			System.out.println("Ajout contest a la BDD OKAY");
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Pas d'ajout contest a la BDD...");
			return false;
		}
	}


	@Override
	public ArrayList<Contest> read() {
			
			ArrayList<Contest> al = new ArrayList<>();
			
			try {
				//sql = MyCo.prepareStatement("SELECT * FROM contest");
				sql = MyCo.prepareStatement("SELECT *, g.title, p.nickname FROM contest c "
	                    + "INNER JOIN game g on c.game_id = g.id "
	                    + "INNER JOIN player p on c.winner_id=p.id ");

				rs = sql.executeQuery();
				
				while (rs.next()) {
					game = new Game(rs.getInt("id"),rs.getString("title"),rs.getInt("min_players"),rs.getInt("max_players"));
					winner = new Player(rs.getInt("id"),rs.getString("email"),rs.getString("nickname"));
					contest = new Contest(rs.getInt("id"),game,rs.getDate("start_date"),winner);
					al.add(contest);
				}
				
				System.out.println("Tableau des contests recupere !");
				return al;
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("Pas de tableau des contests recupere...");
				return null;
			}
		}
	}