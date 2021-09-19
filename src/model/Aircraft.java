package model;

public class Aircraft extends GameComponent {
	
	private boolean isAlive;
	
	public Aircraft(int x, int y, int speedX, int speedY) {
		super(x, y, speedX, speedY);
		isAlive = true;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	@Override
	public void move() {  }
	
	public void takeDamage() {
		if (!isAlive)
			return;
		
		isAlive = false;
	}

}
