package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCrypt;

import Model.User;

public class UserDao {

	Connection coBDD = Connect.getConnect();
	PreparedStatement sql = null; 
	ResultSet rs = null;
	
	public Boolean create(User user) {
		try {
			
			//VERSION AVEC PASSWORD() -----------------------------------------------
//			sql = coBDD.prepareStatement("INSERT INTO user (nom,prenom,adresse,telephone,email,mdp) "
//					+ "VALUES (?,?,?,?,?,PASSWORD(?))");
//			
//			sql.setString(1, user.getNom());
//			sql.setString(2, user.getPrenom());
//			sql.setString(3, user.getAdresse());
//			sql.setString(4, user.getTelephone());
//			sql.setString(5, user.getEmail());
//			sql.setString(6, user.getMdp());

			
			
			//VERSION AVEC BCRYPT -----------------------------------------------
			
			sql = coBDD.prepareStatement("INSERT INTO user (nom,prenom,adresse,telephone,email,mdp) "
					+ " VALUES (?,?,?,?,?,?)");
			
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
	
	public User login(String email, String mdp) {
		try {
//           Version avec PASSWORD de MYSQL -------------------------------- 
//           sql = connect.prepareStatement("select * from user where email=? and password = PASSWORD(?)");
//			 sql.setString(1, email);
//	         sql.setString(2, mdp);
            
//			VERSION AVEC BCRYPT ---------------------------------------------
            sql = coBDD.prepareStatement("select * from user where email=?");
            sql.setString(1, email);
            
            rs = sql.executeQuery();
            
            if (rs.next()) {
            	if(BCrypt.checkpw(mdp, rs.getString("mdp"))) {
            		//AVEC MOT DE PASSE
            		//return new User(rs.getString("nom"), rs.getString("prenom"),rs.getString("email"), rs.getString("mdp"));
            		return new User(rs.getString("nom"), rs.getString("prenom"),rs.getString("email"));
            	}
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
}
