package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Contest;
import bean.Game;
import bean.Player;
import bean.Player_contest;


public class DaoPlayer_contest implements ICRUD<Player_contest> {

	Connection MyCo = Connect.getConnect();
	PreparedStatement sql = null;
	ResultSet rs = null;

	Game game = null;
	ArrayList<Player> player = null;
	Contest contest = null;
	Player_contest player_contest = null;

	@Override
	public Boolean create(Player_contest player_contest) {

		try {
			sql = MyCo.prepareStatement("INSERT INTO player_contest (player_id,contest_id) VALUES (?,?)");

			sql.setInt(1, contest.getWinner_id().getId());
			sql.setInt(2, contest.getId());

			sql.execute();
			System.out.println(sql);
			System.out.println("Ajout player_contest a la BDD OKAY");

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Pas d'ajout player_contest a la BDD...");
			return false;
		}
	}


	@Override
	public ArrayList<Player_contest> read() {

		ArrayList<Player_contest> al = new ArrayList<>();

		try {
			sql = MyCo.prepareStatement("SELECT * FROM player_contest");
			rs = sql.executeQuery();

			while (rs.next()) {
				player_contest = new Player_contest(rs.getInt("id"),player,contest);
				al.add(player_contest);
			}

			System.out.println("Tableau des player_contests recupere !");
			return al;

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Pas de tableau des player_contests recupere...");
			return null;
		}
	}

}