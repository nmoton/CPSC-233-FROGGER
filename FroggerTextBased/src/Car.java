/**
 * @author T:01 Team 3
 * The car class keeps track of the cars' X and Y positions and moves it using moveCarLeft
 * and moveCarRight.
 *
 * It has 2 instance variables, carX, and carY of type int. They keep track of the
 * cars' X and Y position relating to the "grid".
 * The class has 5 methods including a constructor that takes 2 ints a getter for carX,
 * carY, moveCarLeft, and moveCarRight.
 *
 */
public class Car{
    private int carX;
    private int carY;

    /**
     * Constructor that takes 2 integers.
     * @param x, the car's initial X position.
     * @param y, the car's initial Y position.
     */
    public Car(int x, int y) {
        carX = x;
        carY = y;
    }

    /**
     * Method that moves the car right 1 position, until they reach the boundary,
     * to which then they will be brought to the left side so they can continue to move right.
     */
    public void moveCarRight(){
        if(carX + 1 == 10){
            carX = 0;
        }
        else{
            carX++;
        }
    }
    /**
     * Method that moves the car right 1 position, until they reach the boundary,
     * to which then they will be brought to the left side so they can continue to move right.
     */
    public void moveCarLeft(){
        if(carX - 1 == -1){
            carX = 9;
        }
        else{
            carX--;
        }
    }

    /**
     * Getter method fot carX.
     * @return carX, the car's X position.
     */
    public int getCarX(){
        return carX;
    }

    /**
     * Getter method for carY.
     * @return carY, the car's Y postion.
     */
    public int getCarY(){
        return carY;
    }

}