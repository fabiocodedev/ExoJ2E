package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.User;

public class UserDao {

	Connection coBDD = Connect.getConnect();
	
	public Boolean create(User user) {
		try {
			PreparedStatement sql = coBDD.prepareStatement("INSERT INTO user (nom,prenom,adresse,telephone,email,mdp) "
					+ "VALUES (?,?,?,?,?,PASSWORD(?))");
			
			sql.setString(1, user.getNom());
			sql.setString(2, user.getPrenom());
			sql.setString(3, user.getAdresse());
			sql.setString(4, user.getTelephone());
			sql.setString(5, user.getEmail());
			sql.setString(6, user.getMdp());
			
			sql.execute();
			System.out.println(sql);
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
	}
}
