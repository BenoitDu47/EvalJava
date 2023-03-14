package fr.fms.entities;

/**
 * This class represents a user.
 * 
 * @author ThouryB
 *
 */
public class User {

	private int id;
	private String login;
	private String passWord;
	private boolean admin;

	/**
	 * Constructs a new user with the specified information.
	 * 
	 * @param login    The login user
	 * @param passWord The passWord user
	 * @param admin    The admin or not
	 */
	public User(int id, String login, String passWord, boolean admin) {
		super();
		this.id = id;
		this.login = login;
		this.passWord = passWord;
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "User [login=" + login + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
