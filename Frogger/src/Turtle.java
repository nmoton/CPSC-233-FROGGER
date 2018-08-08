package frogger;

public class Turtle {
	
	private double turtlePosX;
	private double turtlePosY;
	private double turtleAccelerationX;
	private int turtleLength;
	
	public Turtle(double setTurtlePosX, double setTurtlePosY, double setTurtleAccelerationX, int setTurtleLength) {
		this.turtlePosX = setTurtlePosX;
		this.turtlePosY = setTurtlePosY;
		this.turtleAccelerationX = setTurtleAccelerationX;
		this.turtleLength = setTurtleLength;
	}
	
	public double getTurtlePosX() {
		return this.turtlePosX;
	}
	
	public double getTurtlePosY() {
		return this.turtlePosY;
	}
	
	public int getTurtleLength() {
		return this.turtleLength;
	}
	
	public void moveTurtleX() {
		this.turtlePosX -= this.turtleAccelerationX;
	}
	
	public void setTurtlePosX(double inputLocation) {
		this.turtlePosX = inputLocation;
	}
	
	public void setTurtlePosY(int inputLocation) {
		this.turtlePosY = inputLocation;
	}
}
