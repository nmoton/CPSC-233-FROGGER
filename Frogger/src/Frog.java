package frogger;

public class Frog {
	
	private double playerPosX;
	private double playerPosY;
	private char lastFacing = 'U';

	
	public Frog(double setPlayerPosX, double setPlayerPosY) {
		setPosX(setPlayerPosX);
		setPosY(setPlayerPosY);
	}
	
	public void moveUp() {
		this.playerPosY -= 32;
		this.lastFacing = 'U';
	}
	
	public void moveDown() {
		this.playerPosY += 32;
		this.lastFacing = 'D';
	}
	
	public void moveLeft() {
		this.playerPosX -= 32;
		this.lastFacing = 'L';
	}
	
	public void moveRight() {
		this.playerPosX += 32;
		this.lastFacing = 'R';
	}
	
	public void setPosX(double posX) {
		this.playerPosX = posX;
	}
	
	public void setPosY(double posY) {
		this.playerPosY = posY;
	}
	
	public double getPlayerPosX() {
		return playerPosX;
	}
	
	public double getPlayerPosY() {
		return playerPosY;
	}
	
	public char getLastFacing() {
		return this.lastFacing;
	}
}
