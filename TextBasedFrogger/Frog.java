/**
 * @author T:01 Team 3
 * The Frog class keeps track of the frog's X and Y position and moves it according to
 * user input.
 * It has 2 instance variables, frogX, and frogY of type int. They keep track of the
 * frog's X and Y position relating to the "grid".
 * The class has 4 methods including a default constructor a getter for frogX and frogY,
 * and moveFrog.
 */

import java.util.Scanner;

public class Frog{
    //Instance Variables
    private int frogX = 6;
    private int frogY = 9;

    /**
     * Default constructor for Frog, a constructor that takes no arguments.
     */
    public Frog(){

    }

    /**
     * Getter method for frogX.
     * @return frogX of type int, the frog's X position.
     */
    public int getFrogX(){
        return frogX;
    }

    /**
     * Getter method for frogY.
     * @return frogY of type int, the frog's Y position.
     */
    public int getFrogY(){
        return frogY;
    }

    /**
     * Method that asks the user for w, a, s, and d and adjusts the frog's X and Y.
     */
    public void moveFrog(){
        Scanner keyboard = new Scanner(System.in);
        boolean validInput = false;
        while (validInput == false) {
            System.out.print("Enter your action by typing  w for up, s for down, \n" +
                    "a for left, or d for right.\n Move Frog: ");
            String userInput = keyboard.nextLine();
            String trimmedInput = userInput.trim();
            String lowerCaseInput = trimmedInput.toLowerCase();

            if(lowerCaseInput.equals("w")){
                validInput = true;
                frogY--;
            }
            else if(lowerCaseInput.equals("s")){
                validInput = true;
                frogY++;
            }
            else if(lowerCaseInput.equals("a")){
                frogX--;
                validInput = true;
            }
            else if(lowerCaseInput.equals("d")){
                frogX++;
                validInput = true;
            }
            else{
                System.out.println("That is not a valid Input.");
            }



        }

    }
}