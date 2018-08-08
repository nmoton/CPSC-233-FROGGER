import java.util.Scanner;

/**
 * @author T:01 Team 3
 * Menus is a class that displays the text based menus of the game, including the main
 * menu and the instructions of how to play the game. The class also takes in user
 * input regarding whether the user wished to play, see instructions, or close the game.
 *
 * Menus has 1 instance variable, menuAction which corresponds the the action to be
 * preformed based off of the input from the user.
 */
public class Menus{
    // 1 = Play, 2 = Instructions, 3 = Quit
    private int menuAction;

    /**
     * Default constructior for Menus.
     */
    public Menus(){

    }

    /**
     * Method That Displays the main Menu and asks user for an input regarding
     * what they wish to do.
     */
    public void displayMenu() {

        boolean needValidInput = true;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nFrogger Main Menu");
        System.out.println(">Play");
        System.out.println(">Instructions");
        System.out.println(">Quit" + "\n");

        /**
         * Asks the user for input until  they input an input appropriate for the main menu.
         */
        while (needValidInput) {
            System.out.println("Type PLAY to play, INSTRUCTIONS for how to play, or QUIT to stop the game.");
            String menuInput = keyboard.nextLine();
            String trimmedInput = menuInput.trim();
            String lowerCaseInput = trimmedInput.toLowerCase();

            if(lowerCaseInput.equals("play")){
                menuAction = 1;
                needValidInput = false;
            }
            else if(lowerCaseInput.equals("instructions")){
                menuAction = 2;
                needValidInput = false;
            }
            else if(lowerCaseInput.equals("quit")){
                menuAction = 3;
                needValidInput = false;
            }
            else{
                System.out.print("That is not a valid input. ");
            }
        }
    }

    /**
     * Getter method for menuAction.
     * @return menuAction of type int, used by Frogger class to detemine
     * if the user wishes to play, see instructions, or to stop/close the game.
     */
    public int getMenuAction(){
        return menuAction;
    }

    /**
     * Method that displays the Instructions of how to play the game.
     */
    public void showInstructions(){
        System.out.println("\nWelcome to a text based version of the old classic: Fogger!");
        System.out.println("The aim of the game is to make your way across the play area without colliding");
        System.out.println("Input w, a, s, or d followed by the enter key to move your frog.\n");

    }
}