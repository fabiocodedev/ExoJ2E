package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Conducteur;

public class DaoConducteur implements ICRUD<Conducteur> {
	
	Connection MyCo = Connector.getConnect();
	PreparedStatement sql = null;
	ResultSet rs = null;
	Conducteur conducteur = null;
	

	@Override
	public Boolean create(Conducteur conducteur) {
		
		try {
			sql = MyCo.prepareStatement("INSERT INTO conducteur (prenom,nom) VALUES (?,?)");
			
			sql.setString(1, conducteur.getPrenom());
			sql.setString(2, conducteur.getNom() );
			
			sql.execute();
			System.out.println(sql);
			System.out.println("Ajout conducteur a la BDD OKAY");
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Pas d'ajout conducteur a la BDD...");
			return false;
		}
	}

	@Override
	public ArrayList<Conducteur> read() {
		
		ArrayList<Conducteur> al = new ArrayList<>();
		
		try {
			sql = MyCo.prepareStatement("SELECT * FROM conducteur");
			
			rs = sql.executeQuery();
			
			while (rs.next()) {
				conducteur = new Conducteur(rs.getInt("id"),rs.getString("prenom"),rs.getString("nom"));
				al.add(conducteur);
			}
			System.out.println("Tableau des conducteurs recuperer !");
			return al;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Pas de tableau des conducteurs recuperer...");
			return null;
		}
	}

	@Override
	public boolean update(Conducteur conducteur) {
		
		try {
			sql = MyCo.prepareStatement("UPDATE conducteur SET prenom=?, nom=? WHERE id=?");
			
			sql.setString(1, conducteur.getPrenom());
			sql.setString(2, conducteur.getNom());
			sql.setInt(3, conducteur.getId());
			
			sql.execute();
			
			System.out.println(sql);
			System.out.println("Conducteur modifier !");
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Pas de conducteur modifier...");
			return false;
		}
	}

	@Override
	public void delete(Conducteur conducteur) {
		// TODO Auto-generated method stub
		
	}
	
	public Conducteur findByIdConducteur(int id) {
		
		try {
			sql = MyCo.prepareStatement("SELECT * FROM conducteur WHERE id=?");
			sql.setInt(1,id);
			rs = sql.executeQuery();
			
			if (rs.next()) {
				conducteur = new Conducteur(rs.getInt("id"),rs.getString("prenom"),rs.getString("nom"));
				System.out.println("findByIdConducteur = "+conducteur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conducteur;
	}
}