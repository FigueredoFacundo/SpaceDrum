package model;

public class Player extends Aircraft {

	private String name;
	private int score;
	
	public Player(String name) {
		super(Constants.PLAYER_SPAWN_X, Constants.PLAYER_SPAWN_Y, Constants.PLAYER_SPEED_X, Constants.PLAYER_SPEED_Y);
		this.name = name;
		this.score = 0;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
	
}
