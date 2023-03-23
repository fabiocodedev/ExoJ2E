package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Vehicule;

public class DaoVehicule implements ICRUD<Vehicule> {

	Connection MyCo = Connector.getConnect();
	PreparedStatement sql = null;
	ResultSet rs = null;
	Vehicule vehicule = null;

	@Override
	public Boolean create(Vehicule vehicule) {

		try {
			sql = MyCo.prepareStatement("INSERT INTO vehicule (marque,modele,couleur,immatriculation)"
					+ " VALUES (?,?,?,?)");

			sql.setString(1, vehicule.getMarque());
			sql.setString(2, vehicule.getModele() );
			sql.setString(3, vehicule.getCouleur() );
			sql.setString(4, vehicule.getImmatriculation() );

			sql.execute();
			System.out.println(sql);
			System.out.println("Ajout vehicule a la BDD OKAY");

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Pas d'ajout vehicule a la BDD...");
			return false;
		}
	}

	@Override
	public ArrayList<Vehicule> read() {

		ArrayList<Vehicule> al = new ArrayList<>();

		try {
			sql = MyCo.prepareStatement("SELECT * FROM vehicule");

			rs = sql.executeQuery();

			while (rs.next()) {
				Vehicule vehicule = new Vehicule(rs.getInt("id"),rs.getString("marque"),rs.getString("modele"),
						rs.getString("couleur"),rs.getString("immatriculation"));
				al.add(vehicule);
			}
			System.out.println("Tableau des vehicule recuperer !");
			return al;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Pas de tableau des vehicule recuperer...");
			return null;
		}
	}

	@Override
	public boolean update(Vehicule vehicule) {
		
		try {
			sql = MyCo.prepareStatement("UPDATE vehicule SET (marque,modele,couleur,immatriculation) WHERE id=?");
			sql.setInt(1, vehicule.getId());
			sql.execute();
			
			System.out.println(sql);
			System.out.println("vehicule modifier !");
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Pas de vehicule modifier...");
		}
		return false;
	}

	@Override
	public void delete(Vehicule vehicule) {
		// TODO Auto-generated method stub

	}
	
	public Vehicule findByIdVehicule(int id) {
		
		try {
			sql = MyCo.prepareStatement("SELECT * FROM vehicule WHERE id=?");
			sql.setInt(1, id);
			rs = sql.executeQuery();
			
			if (rs.next()) {
				vehicule = new Vehicule(rs.getInt("id"),rs.getString("marque"),rs.getString("modele"),
						rs.getString("couleur"),rs.getString("immatriculation"));
				System.out.println("findByIdVehicule = "+vehicule);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicule;
	}
}
