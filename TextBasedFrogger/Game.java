/**
 * @author T:01 Team 3
 * Game is the class which operates the main gameplay. It creates a 10 by 10 grid via print statements
 * and prints the frog as an F and the cars as arrows.
 *
 * The class has a boolean called playing, which keeps track if the user is still playing (has not died or
 * reached the top).
 *
 * The class has one method play runGame, which like the name implies runs the main game.
 */
public class Game{
    private boolean playing = true;
    private Frog frog;
    private Car car1;
    private Car car2;
    private Car car3;
    private Car car4;
    private Car car5;
    private Car car6;

    /**
     * Method that runs the main text based frogger game.
     */
    public void runGame(){
        /**
         * Place frogs and cars in starting positions everytime you start running the game.
         * Reset hit boolean variables.
         */
        playing = true;
        frog = new Frog();
        car1 = new Car(2,4);
        car2 = new Car(7,4);
        car3 = new Car(3,6);
        car4 = new Car(9,6);
        car5 = new Car(1,1);
        car6 = new Car(6,2);
        boolean hit = false;
        boolean hit2 = false;

        /**
         * Loop the game until user reaches the top or until the user dies.
         */
        while(playing) {

            /**
             * Prints a grid, representing the frog as an F, the cars as arrows and filling the
             * rest of the grid with " ".
             */
            for (int column = 0; column < 10; column++) {
                System.out.print("|"); //Print used to help user keep track of left boundary.
                for (int row = 0; row < 10; row++) {
                    if (row == frog.getFrogX() && column == frog.getFrogY()) {
                        System.out.print("F");
                    }
                    else if(row == car1.getCarX() && column == car1.getCarY() ||
                            row == car2.getCarX() && column == car2.getCarY() ||
                            row == car5.getCarX() && column == car5.getCarY()){
                        System.out.print(">");
                    }

                    else if(row == car3.getCarX() && column == car3.getCarY() ||
                            row == car4.getCarX() && column == car4.getCarY() ||
                            row == car6.getCarX() && column == car6.getCarY()) {
                        System.out.print("<");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
                System.out.println("|"); //Print used to help user keep track of right boundary.
            }

            /**
             * Stop the game loop if user reaches the top level of the game.
             */
            if (frog.getFrogY() == 0) {
                System.out.println("Congrats. You Made It Across!\n");
                playing = false;
            }
            /**
             * Update the position of the frog, and cars.
             * Check for collisions two times, so that user dies if they jump onto a car or in the immediate path of
             * one of the moving cars.
             */
            else{
                frog.moveFrog();
                hit = collisionDetection(); // hit checks if you jumped onto a moving car.
                if(hit == true) {
                    System.out.println("\nYOU DIED\n");
                    playing = false;
                }
                //Update the cars moving Right
                car1.moveCarRight();
                car2.moveCarRight();
                car5.moveCarRight();

                //Update the cars moving Left
                car3.moveCarLeft();
                car4.moveCarLeft();
                car6.moveCarLeft();
                hit2 = collisionDetection(); //hit2 checks if you jumped in front of a moving car.
                if(hit2 == true){
                    System.out.println("\nYOU DIED\n");
                    playing = false;
                }
            }
        }
    }

    /***
     * Checks for collision by looing at the X and Y positions of frog and car.
     * If frog coordinates matches a car's coordinates, then collision occurs
     *
     * @return hit of type boolean, returns true if hit occurs
     */
    public boolean collisionDetection() {
        boolean hit = false;
        if(frog.getFrogX() == car1.getCarX() && frog.getFrogY() == car1.getCarY()) {
            hit = true;
        }if(frog.getFrogX() == car2.getCarX() && frog.getFrogY() == car2.getCarY()) {
            hit = true;
        }if(frog.getFrogX() == car3.getCarX() && frog.getFrogY() == car3.getCarY()) {
            hit = true;
        }if(frog.getFrogX() == car4.getCarX() && frog.getFrogY() == car4.getCarY()) {
            hit = true;
        }if(frog.getFrogX() == car5.getCarX() && frog.getFrogY() == car5.getCarY()) {
            hit = true;
        }if(frog.getFrogX() == car6.getCarX() && frog.getFrogY() == car6.getCarY()) {
            hit = true;
        }
        return hit;

    }
}