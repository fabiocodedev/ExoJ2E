package Dao;

import java.sql.Connection;
import java.util.ArrayList;

public class DaoVehicule implements ICRUD {

	Connection MyCo = Connector.getConnect();
		
	@Override
	public Boolean create(Object objet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Object> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object objet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object objet) {
		// TODO Auto-generated method stub
		
	}

}
