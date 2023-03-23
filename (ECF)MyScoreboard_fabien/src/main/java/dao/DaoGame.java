package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Game;

public class DaoGame implements ICRUD<Game> {

	Connection MyCo = Connect.getConnect();
	PreparedStatement sql = null;
	ResultSet rs = null;
	Game game = null;
	
	@Override
	public Boolean create(Game game) {
		
		try {
			sql = MyCo.prepareStatement("INSERT INTO game (title,min_players,max_players) VALUES (?,?,?) ; ");
			
			sql.setString(1, game.getTitle());
			sql.setInt(2, game.getMin_players());
			sql.setInt(3, game.getMax_players());
			
			sql.execute();
			System.out.println(sql);
			System.out.println("Ajout game a la BDD OKAY");
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Pas d'ajout game a la BDD...");
			return false;
		}
	}


	@Override
	public ArrayList<Game> read() {
			
			ArrayList<Game> al = new ArrayList<>();
			
			try {
				sql = MyCo.prepareStatement("SELECT * FROM game ; ");
				rs = sql.executeQuery();
				
				while (rs.next()) {
					game = new Game(rs.getInt("id"),rs.getString("title"),rs.getInt("min_players"),rs.getInt("max_players"));
					al.add(game);
				}
				
				System.out.println("Tableau des games recupere !");
				return al;
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("Pas de tableau des games recupere...");
				return null;
			}
		}
	
	public Game findById (int id) {
        try {
            PreparedStatement     sql = MyCo.prepareStatement("SELECT * FROM game "
                    + "WHERE id=? ; ");
            sql.setInt(1,id);
            
            rs= sql.executeQuery();
            if(rs.next()) {
                game = new Game(rs.getInt("id"),rs.getString("title"),rs.getInt("min_players"),rs.getInt("max_players"));
                return game;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}