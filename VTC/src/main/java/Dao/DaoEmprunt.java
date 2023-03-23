package Dao;

import java.sql.Connection;
import java.util.ArrayList;

import Model.Emprunt;

public class DaoEmprunt implements ICRUD<Emprunt> {

	Connection MyCo = Connector.getConnect();
	
	@Override
	public Boolean create(Emprunt emprunt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Emprunt> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Emprunt emprunt) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Emprunt emprunt) {
		// TODO Auto-generated method stub
		
	}

}
