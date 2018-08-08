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
	private String username;
	private double highestPosY;
	private static Scanner keyboard = new Scanner(System.in);
	
	/**
	 * Initializes the name, score, and highest y-position that
	 * the player has achieved
	 * @param posY - starting y position of the player
	 */
	Score(double posY){
		score = 0;
		username = null;
		setHighestPosY(posY);
	}
	
	//Only used for JUnit Testing
	Score(int s, String name){
		score = s;
		username = name;
		setHighestPosY(448);
	}
	
	/**
	 * A copy constructor, which copies the name and score of a Score object
	 * @param toCopy - that object that is being copied
	 */
	Score(Score toCopy){
		this.score = toCopy.score;
		this.username = toCopy.username;
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
	 * Description: returns the username of the player
	 * @return - the username of the player 
	 */
	public String getUsername() {
		return username;
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
	 * Sets the username of the player through keyboard inputs.
	 * Keeps prompting until the user enters a username
	 */
	public void setUsername() {
		Boolean flag = false;
		String userInput = null;
		while(flag == false) {
			System.out.println("Enter your username: ");
			userInput = keyboard.nextLine();
			if(userInput.trim().equals("")) {
				System.out.println("You must enter a username!");
			}else {
				username = userInput;
				flag = true;
			}
		}
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
