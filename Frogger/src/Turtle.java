package frogger;

public class Turtle {
	
	private double turtlePosX;
	private int turtlePosY;
	private double turtleAccelerationX;
	
	public Turtle(double setTurtlePosX, int setTurtlePosY, double setTurtleAccelerationX) {
		this.turtlePosX = setTurtlePosX;
		this.turtlePosY = setTurtlePosY;
		this.turtleAccelerationX = setTurtleAccelerationX;
	}
	
	public double getLogPosX() {
		return this.turtlePosX;
	}
	
	public double getLogPosY() {
		return this.turtlePosY;
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
