package serverMainPackage;

public class User {
	String username;
	String password;
	
	public User (String name, String password, boolean readAccess, boolean writeAccess)
	{
		this.username = name;
	}

	public String getUsername () {
		return username;
	}

	public void setUsername (String username) {
		this.username = username;
	}

}
