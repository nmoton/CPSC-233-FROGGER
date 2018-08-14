/**
 * @author T:01 Team 3
 * The turtle class is representative of the turtles that user rides to help get accross.
 *
 * The turtle has 4 instance variables, turtlePosX, turtlePosY the turtle's X and Y position, turtleAccelerationX the speed which the
 * turtle travels, and turtleLength, the size of the turtle.
 *
 * It has 7 methods, a constructor, setters and getters for the turtle's x and y position, a getter for
 * turtleLength, and a move method.
 */
public class Turtle {
	//Instance Variable
	private double turtlePosX;
	private double turtlePosY;
	private double turtleAccelerationX;
	private int turtleLength;

	/**
	 * Constructor that takes 3 doubles and an int.
	 * @param setTurtlePosX, turtle's x position.
	 * @param setTurtlePosY, turtle's y position.
	 * @param setTurtleAccelerationX, turtle's speed
	 * @param setTurtleLength, turtle's length
	 */
	public Turtle(double setTurtlePosX, double setTurtlePosY, double setTurtleAccelerationX, int setTurtleLength) {
		setTurtlePosX(setTurtlePosX);
		setTurtlePosY(setTurtlePosY);
		this.turtleAccelerationX = setTurtleAccelerationX;
		this.turtleLength = setTurtleLength;
	}

	/**
	 * Getter method for turtlePosX
	 * @return turtlePosX, turtle's x position.
	 */
	public double getTurtlePosX() {
		return this.turtlePosX;
	}

	/**
	 * Getter method for turtlePosY
	 * @return turtlePosY, turtle's y position.
	 */
	public double getTurtlePosY() {
		return this.turtlePosY;
	}

	/**
	 * Getter method for turtleLength
	 * @return turtleLength, the length of turtles.
	 */
	public int getTurtleLength() {
		return this.turtleLength;
	}

	/**
	 * Move method that moves turtles left.
	 */
	public void moveTurtleX() {
		this.turtlePosX -= this.turtleAccelerationX;
	}

	/**
	 * Setter method for turtlePosX
	 * @param turtlePosX, turtle's x position.
	 */
	public void setTurtlePosX(double inputLocation) {
		this.turtlePosX = inputLocation;
	}

	/**
	 * Setter method for turtlePosY
	 * @param turtlePosY, turtle's y position.
	 */
	public void setTurtlePosY(double inputLocation) {
		this.turtlePosY = inputLocation;
	}
}
