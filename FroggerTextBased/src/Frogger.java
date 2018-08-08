/**
 * @author T:01 Team 3
 * Frogger is the class that is run and incorporates the other classes in a game format.
 *
 * The boolean variable running helps loop the game until the user enters quit in the
 * main menu.
 *
 */
public class Frogger{

    public static void main(String[] args){
        //Instance Variables/ Variables
        boolean running = true;
        Menus menu = new Menus();
        Game game = new Game();

        while (running){
            menu.displayMenu();
            if (menu.getMenuAction() == 1){
                game.runGame();
            }
            else if(menu.getMenuAction() == 2){
                menu.showInstructions();

            }
            else if(menu.getMenuAction() == 3){
                System.out.println("Thanks for Playing");
                running = false;
            }
        }

    }
}