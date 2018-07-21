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
	
	public double getLogPosX() {
		return this.turtlePosX;
	}
	
	public double getLogPosY() {
		return this.turtlePosY;
	}
	
	public double getTurtleLength() {
		return this.turtleLength;
	}
	
	public void moveLogX() {
		this.turtlePosX -= turtleAccelerationX;
	}
	
	public void setLogPosX(double inputLocation) {
		this.turtlePosX = inputLocation;
	}
	
	public void setLogPosY(int inputLocation) {
		this.turtlePosY = inputLocation;
	}
}
