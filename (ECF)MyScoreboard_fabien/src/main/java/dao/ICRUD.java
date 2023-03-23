package dao;

import java.util.ArrayList;

public interface ICRUD <T>{
	
	public Boolean create(T objet);
	
	public ArrayList <T> read();
	
}
