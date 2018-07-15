package frogger;

public class Frog {
	
	private int playerPosX = 0;
	private int playerPosY = 0;
	
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
	
	public void setPosX(int posX) {
		this.playerPosX = posX;
	}
	
	public void setPosY(int posY) {
		this.playerPosY = posY;
	}
	
	public int getPlayerPosX() {
		return playerPosX;
	}
	
	public int getPlayerPosY() {
		return playerPosY;
	}
}
