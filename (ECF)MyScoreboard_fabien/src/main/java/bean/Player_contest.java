package bean;

import java.util.ArrayList;

public class Player_contest {
	private int id;
	private ArrayList<Player> players;
	private Contest contest_id;
	// CONSTRUCTEURS
	public Player_contest(int id, ArrayList<Player> players, Contest contest_id) {
		super();
		this.id = id;
		this.players = players;
		this.contest_id = contest_id;
	}
	public Player_contest(ArrayList<Player> players, Contest contest_id) {
		super();
		this.players = players;
		this.contest_id = contest_id;
	}
	// ACCESSEURS ET MUTATEURS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	public Contest getContest_id() {
		return contest_id;
	}
	public void setContest_id(Contest contest_id) {
		this.contest_id = contest_id;
	}
	
}
