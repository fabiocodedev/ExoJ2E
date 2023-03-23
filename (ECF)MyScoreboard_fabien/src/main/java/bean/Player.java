package bean;

public class Player {
	private int id;
	private String email;
	private String nickname;
	// CONSTRUCTEURS
	public Player(int id, String email, String nickname) {
		this.id = id;
		this.email = email;
		this.nickname = nickname;
	}
	public Player(String email, String nickname) {
		this.email = email;
		this.nickname = nickname;
	}
	public Player() {
	}
	// ACCESSEURS ET MUTATEURS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}