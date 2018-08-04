package frogger;

import java.util.*;

/**
 * @author Justin Flores
 *
 */
public class Score {
	
	private int score;
	private String username;
	private double highestPosY;
	private static Scanner keyboard = new Scanner(System.in);
	
	Score(double posY){
		score = 0;
		username = "";
		setHighestPosY(posY);
	}
	
	public int getScore() {
		return score;
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
			}
		}
	}
	
	public void updateScore(double playerPosY) {
		if(playerPosY < highestPosY) {
			score += 10;
			highestPosY = playerPosY;
		}
		System.out.println("Score: " + score + " Y: " + playerPosY);
		
		
	}

}
