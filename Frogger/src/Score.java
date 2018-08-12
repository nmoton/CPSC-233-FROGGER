package frogger;

import java.io.Serializable;
import java.util.*;

/**
 * @author Justin Flores
 *
 *An object that holds the score and name of player. It can also update the score
 *of the player.
 *
 * Last Updated:07/08/2018
 */
public class Score implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int score = 0;
	private double highestPosY;
	
	/**
	 * Initializes the name, score, and highest y-position that
	 * the player has achieved
	 * @param posY - starting y position of the player
	 */
	Score(double posY){
		score = 0;
		setHighestPosY(posY);
	}
	
	//Only used for JUnit Testing
	Score(int s){
		score = s;
		setHighestPosY(480);
	}
	
	/**
	 * A copy constructor, which copies the name and score of a Score object
	 * @param toCopy - that object that is being copied
	 */
	Score(Score toCopy){
		this.score = toCopy.getScore();
	}
	
	/**
	 * Description: returns score of the player
	 * @return - score that the player got in
	 * one run
	 */
	public int getScore() {
		return score;
	}
	
	public String getScoreString() {
		return new String(Integer.toString(this.score));
	}
	
	/**
	 * Sets the highest y-position that the player reached, which is used to
	 * update the score of the player It can also be used to reset the highest 
	 * y-position when going to a new level
	 * @param posY - the highest y- position that the player reached
	 */
	public void setHighestPosY(double posY) {
		highestPosY = posY;
	}
	
	/**
	 * Increases the players position if it reaches a y position higher than its
	 * highestPosY, and updates the highestPosY to the new highest y position reached.
	 * @param playerPosY
	 */
	public String updateScore(double playerPosY) {
		if(playerPosY < highestPosY) {
			score += 10;
			highestPosY = playerPosY;
		}
		
		System.out.println("Score: " + score + " Y: " + playerPosY + " highestY: " + highestPosY);
		return new String (Integer.toString(this.score));
	}
	
	/**
	 * Increases the score if the player clears a level
	 */
	public void clearLevelScore() {
		score += 1000;
		System.out.println(score);
	}
}
