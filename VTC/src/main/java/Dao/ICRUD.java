package Dao;

import java.util.ArrayList;

public interface ICRUD <T> {
	
	public Boolean create(T objet);
	
	public ArrayList <T> read();
	
	public boolean update(T objet);
	
	public void delete(T objet);
	
}
