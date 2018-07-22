package frogger;

public class Log {
	
	private double logPosX;
	private double logPosY;
	private double logAccelerationX;
	private int logLength;
	private boolean logRightBound;
	
	public Log(double setLogPosX, double setLogPosY, double setLogAccelerationX, int setLogLength, boolean setDirection) {
		this.logPosX = setLogPosX;
		this.logPosY = setLogPosY;
		this.logAccelerationX = setLogAccelerationX;
		this.logLength = setLogLength;
		this.logRightBound = setDirection;
	}
	
	public double getLogPosX() {
		return this.logPosX;
	}
	
	public double getLogPosY() {
		return this.logPosY;
	}
	
	public int getLogLength() {
		return this.logLength;
	}
	
	public boolean isLogRightBound() {
		return this.logRightBound;
	}
	
	public void moveLogLeftX() {
		this.logPosX -= this.logAccelerationX;
	}
	
	public void moveLogRightX() {
		this.logPosX += this.logAccelerationX;
	}
	
	public void setLogPosX(double inputLocation) {
		this.logPosX = inputLocation;
	}
	
	public void setLogPosY(int inputLocation) {
		this.logPosY = inputLocation;
	}
	
	public void setLogDirection(boolean setDirection) {
		this.logRightBound = setDirection;
	}
}
