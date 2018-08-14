/**
 * @author T:01 Team 3
 * The log class is representative of the logs that user rides to help get accross.
 *
 * The log has 5 instance variables, logPosX, logPosY the log's X and Y position, logAccelerationX the speed which the
 * log travels, logLength, the size of the log, logRightBound a boolean, if true then the log travels left to right.
 *
 * It has 10 methods, a constructor, setters and getters for the log's position and logRightBound, a getter for
 * logLength, and two move methods, one for each direction: left or right.
 */
public class Log {
	//Instance Variables
	private double logPosX;
	private double logPosY;
	private double logAccelerationX;
	private int logLength;
	private boolean logRightBound;

	/**
	 * Constructor that takes 3 doubles, an int, and a boolean.
	 * @param setLogPosX, the log's xPostion.
	 * @param setLogPosY, the log's yPostion.
	 * @param setLogAccelerationX, the log's speed.
	 * @param setLogLength, the log's length.
	 * @param setDirection, a bolean stating if log is to travel right.
	 */
	public Log(double setLogPosX, double setLogPosY, double setLogAccelerationX, int setLogLength, boolean setDirection) {
		setLogPosX(setLogPosX);
		setLogPosY(setLogPosY);
		this.logAccelerationX = setLogAccelerationX;
		this.logLength = setLogLength;
		setLogDirection(setDirection);
	}

	/**
	 * Getter method for logPosX.
	 * @return logPosX, the log's xPosition.
	 */
	public double getLogPosX() {
		return this.logPosX;
	}

	/**
	 * Getter method for logPosY.
	 * @return logPosY, the log's yPosition.
	 */
	public double getLogPosY() {
		return this.logPosY;
	}

	/**
	 * Getter method for logLength.
	 * @return logLength, the log's length.
	 */
	public int getLogLength() {
		return this.logLength;
	}

	/**
	 * Getter method for logRightBound.
	 * @return logRightBound, a bolean stating if log is to travel right.
	 */
	public boolean isLogRightBound() {
		return this.logRightBound;
	}

	/**
	 * Method that moves the log left.
	 */
	public void moveLogLeftX() {
		this.logPosX -= this.logAccelerationX;
	}

	/**
	 * Method that moves the log Right.
	 */
	public void moveLogRightX() {
		this.logPosX += this.logAccelerationX;
	}

	/**
	 * Setter for logPosX.
	 * @param inputLocation, log's x position.
	 */
	public void setLogPosX(double inputLocation) {
		this.logPosX = inputLocation;
	}

	/**
	 * Setter for logPosY.
	 * @param inputLocation, log's y position.
	 */
	public void setLogPosY(double inputLocation) {
		this.logPosY = inputLocation;
	}

	/**
	 * Setter for logRightBound.
	 * @param setDirection, a bolean stating if log is to travel right.
	 */
	public void setLogDirection(boolean setDirection) {
		this.logRightBound = setDirection;
	}
}
