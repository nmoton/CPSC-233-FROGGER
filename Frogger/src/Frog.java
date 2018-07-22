package frogger;

public class Frog {
	
	private double playerPosX = 0;
	private double playerPosY = 448;
	
	public void moveUp() {
		this.playerPosY -= 32;
	}
	
	public void moveDown() {
		this.playerPosY += 32;
	}
	
	public void moveLeft() {
		this.playerPosX -= 32;
	}
	
	public void moveRight() {
		this.playerPosX += 32;
	}
	
	public void setPosX(double posX) {
		this.playerPosX = posX;
	}
	
	public void setPosY(int posY) {
		this.playerPosY = posY;
	}
	
	public double getPlayerPosX() {
		return playerPosX;
	}
	
	public double getPlayerPosY() {
		return playerPosY;
	}
}
