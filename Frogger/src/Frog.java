package frogger;

/**
 * @author T:01 Team 3
 * The frog class is representative of the player/frog.
 *
 * The frog has 3 instance variables, playerPosX, playerPosY the player's/frog's X and Y position.
 * Last facing is a character that is used to check the frog's last move which helps for displaying
 * the frog facing different directions appropriately.
 *
 * It has 11 methods, 2 constructors, setters and getters for the frog's position, a getter for
 * the lastFacing, and four move methods, one for each direction: up, dow, left, right.
 */
public class Frog {
	//Instance Variables
	private double playerPosX = 0;
	private double playerPosY = 448;
	private char lastFacing = 'U';
	
	/**
	 * Default Constructor.
	 */
	public Frog(){
	}
	
	/**
	 * Constructor that takes two doubles.
	 * @param setPlayerPosX, the frog's xPosition.
	 * @param setPlayerPosY, the frog's yPosition.
	 */
	public Frog(double setPlayerPosX, double setPlayerPosY) {
		if(setPlayerPosX >= 0 && setPlayerPosX <= 608){
			setPosX(setPlayerPosX);
		}
		if(setPlayerPosY >= 0 && setPlayerPosY <= 448){
			setPosY(setPlayerPosY);
		}
	}
	
	/**
	 * Method that moves the frog Up.
	 */
	public void moveUp() {
		if (this.playerPosY < 32){
			setPosY(0);
		}
		else{
			this.playerPosY -= 32;
		}
		this.lastFacing = 'U';
	}
	
	/**
	 * Method that moves the frog Down.
	 */
	public void moveDown() {
		if (this.playerPosY >= 448){
			setPosY(448);
		}
		else{
			this.playerPosY += 32;
		}
		this.lastFacing = 'D';
	}
	
	/**
	 * Method that moves the frog Left.
	 */
	public void moveLeft() {
		if (this.playerPosX < 32){
			setPosX(0);
		}
		else{
			this.playerPosX -= 32;
		}
		this.lastFacing = 'L';
	}
	
	/**
	 * Method that moves the frog Right.
	 */
	public void moveRight() {
		if (this.playerPosX > 576){
			setPosX(608);
		}
		else{
			this.playerPosX += 32;
		}
		this.lastFacing = 'R';
	}
	
	/**
	 * Setter method for the xPosition.
	 * @param posX, a double that frog's xPosition is to be set to.
	 */
	public void setPosX(double posX) {
		this.playerPosX = posX;
	}
	
	/**
	 * Setter method for the yPosition.
	 * @param posY, a double that frog's yPosition is to be set to.
	 */
	public void setPosY(double posY) {
		this.playerPosY = posY;
	}
	
	/**
	 * Getter method for getPlayerPosX
	 * @return playerPosX, a double for the frog's X position 
	 */
	public double getPlayerPosX() {
		return playerPosX;
	}
	
	/**
	 * Getter method for getPlayerPosY
	 * @return playerPosY, a double for the frog's Y position 
	 */
	public double getPlayerPosY() {
		return playerPosY;
	}
	
	/**
	 * Getter method for lastFacing
	 * @return lastFacing, a character that represent the player's last move.
	 */
	public char getLastFacing() {
		return this.lastFacing;
	}
}
