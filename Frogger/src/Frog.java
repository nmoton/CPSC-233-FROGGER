package frogger;

public class Frog {
	
	private double playerPosX = 0;
	private double playerPosY = 448;
	private char lastFacing = 'U';
	
	public Frog(){
	}
	
	public Frog(double setPlayerPosX, double setPlayerPosY) {
		if(setPlayerPosX >= 0 && setPlayerPosX <= 608){
			setPosX(setPlayerPosX);
		}
		if(setPlayerPosY >= 0 && setPlayerPosY <= 448){
			setPosY(setPlayerPosY);
		}
	}
	
	public void moveUp() {
		if (this.playerPosY < 32){
			setPosY(0);
		}
		else{
			this.playerPosY -= 32;
		}
		this.lastFacing = 'U';
	}
	
	public void moveDown() {
		if (this.playerPosY >= 448){
			setPosY(448);
		}
		else{
			this.playerPosY += 32;
		}
		this.lastFacing = 'D';
	}
	
	public void moveLeft() {
		if (this.playerPosX < 32){
			setPosX(0);
		}
		else{
			this.playerPosX -= 32;
		}
		this.lastFacing = 'L';
	}
	
	public void moveRight() {
		if (this.playerPosX > 576){
			setPosX(608);
		}
		else{
			this.playerPosX += 32;
		}
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
