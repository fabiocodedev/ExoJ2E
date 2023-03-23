package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Player;

public class DaoPlayer implements ICRUD<Player>{

	Connection MyCo = Connect.getConnect();
	PreparedStatement sql = null;
	ResultSet rs = null;
	Player player = null;
	
	@Override
	public Boolean create(Player player) {
		
		try {
			sql = MyCo.prepareStatement("INSERT INTO player (email,nickname) VALUES (?,?)");
			
			sql.setString(1, player.getEmail());
			sql.setString(2, player.getNickname());
			
			sql.execute();
			System.out.println(sql);
			System.out.println("Ajout player a la BDD OKAY");
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Pas d'ajout player a la BDD...");
			return false;
		}
	}


	@Override
	public ArrayList<Player> read() {
			
			ArrayList<Player> al = new ArrayList<>();
			
			try {
				sql = MyCo.prepareStatement("SELECT * FROM player");
				rs = sql.executeQuery();
				
				while (rs.next()) {
					player = new Player(rs.getInt("id"),rs.getString("email"),rs.getString("nickname"));
					al.add(player);
				}
				
				System.out.println("Tableau des players recupere !");
				System.out.println(al);
				return al;
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("Pas de tableau des players recupere...");
				return null;
			}
		}
	
	public Player findById (int id) {
        try {
            PreparedStatement     sql = MyCo.prepareStatement("SELECT * FROM player "
                    + "WHERE id=? ; ");
            sql.setInt(1,id);
            
            rs= sql.executeQuery();
            if(rs.next()) {
            	player = new Player(rs.getInt("id"),rs.getString("email"),rs.getString("nickname"));
                return player;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}