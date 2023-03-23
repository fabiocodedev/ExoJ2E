package bean;

import java.util.Date;

public class Contest {
	private int id;
	private Game game_id;
	private Date start_date;
	private Player winner_id;
	// CONSTRUCTEURS
	public Contest(int id, Game game_id, Date start_date, Player winner_id) {
		this.id = id;
		this.game_id = game_id;
		this.start_date = start_date;
		this.winner_id = winner_id;
	}
	public Contest(Game game_id, Date start_date, Player winner_id) {
		this.game_id = game_id;
		this.start_date = start_date;
		this.winner_id = winner_id;
	}
	public Contest() {
	}
	// ACCESSEURS ET MUTATEURS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Game getGame_id() {
		return game_id;
	}
	public void setGame_id(Game game_id) {
		this.game_id = game_id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Player getWinner_id() {
		return winner_id;
	}
	public void setPlayer_id(Player winner_id) {
		this.winner_id = winner_id;
	}
}