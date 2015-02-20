package serverMainPackage;

public class Game {

	private StringBuffer name;
	private StringBuffer players;
	private boolean symetric;
	
	public Game (StringBuffer name, StringBuffer players, boolean symetric)
	{
		this.name = name;
		this.players = players;
		this.symetric = symetric;
	}
	
	public StringBuffer getName() {
		return name;
	}
	public void setName(StringBuffer name) {
		this.name = name;
	}
	public StringBuffer getPlayers() {
		return players;
	}
	public void setPlayers(StringBuffer players) {
		this.players = players;
	}
	public boolean isSymetric() {
		return symetric;
	}
	public void setSymetric(boolean symetric) {
		this.symetric = symetric;
	}
}
