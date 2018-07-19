package frogger;

public class Log {
	
	private double logPosX;
	private int logPosY;
	private double logAccelerationX;
	
	public Log(double setLogPosX, int setLogPosY, double setLogAccelerationX) {
		this.logPosX = setLogPosX;
		this.logPosY = setLogPosY;
		this.logAccelerationX = setLogAccelerationX;
	}
	
	public double getLogPosX() {
		return this.logPosX;
	}
	
	public double getLogPosY() {
		return this.logPosY;
	}
	
	public void moveLogX() {
		this.logPosX -= logAccelerationX;
	}
	
	public void setLogPosX(double inputLocation) {
		this.logPosX = inputLocation;
	}
	
	public void setLogPosY(int inputLocation) {
		this.logPosY = inputLocation;
	}
}
