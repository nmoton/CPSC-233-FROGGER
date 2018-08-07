package frogger;

import java.io.Serializable;
import java.util.*;

/**
 * @author Justin Flores
 *
 */
public class Score implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int score;
	private String username;
	private double highestPosY;
	private static Scanner keyboard = new Scanner(System.in);
	
	Score(double posY){
		score = 0;
		username = null;
		setHighestPosY(posY);
	}
	
	//Only used for JUnit Testing
	Score(int s, String name){
		score = s;
		username = name;
		setHighestPosY(0);
	}
	
	Score(Score toCopy){
		this.score = toCopy.score;
		this.username = toCopy.username;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setHighestPosY(double posY) {
		highestPosY = posY;
	}
	
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
	
	public void updateScore(double playerPosY) {
		if(playerPosY < highestPosY) {
			score += 10;
			highestPosY = playerPosY;
		}
		System.out.println("Score: " + score + " Y: " + playerPosY + " highestY: " + highestPosY);	
	}
	
	public void clearLevelScore() {
		score += 1000;
		System.out.println(score);
	}

	

}
