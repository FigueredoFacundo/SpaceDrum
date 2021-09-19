package model;

public abstract class GameComponent {
	
	protected int x;
	protected int y;
	protected int speedX;
	protected int speedY;
	
	public GameComponent(int x, int y, int speedX, int speedY) {
		//super();
		this.x = x;
		this.y = y;
		this.speedX = speedX;
		this.speedY = speedY;
	}

	public abstract void move();

}
