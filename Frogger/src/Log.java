package frogger;

public class Log {

    private double logPosX;
    private double logPosY;
    private double logAccelerationX;
    private int logLength;
    private boolean logRightBound;

    /**
     * Constructor for Log
     * @param setLogPosX, log X position.
     * @param setLogPosY, log Y position.
     * @param setLogAccelerationX, log speed.
     * @param setLogLength, log length.
     * @param setDirection, log direction.
     */
    public Log(double setLogPosX, double setLogPosY, double setLogAccelerationX, int setLogLength, boolean setDirection) {
        this.logPosX = setLogPosX;
        this.logPosY = setLogPosY;
        this.logAccelerationX = setLogAccelerationX;
        this.logLength = setLogLength;
        this.logRightBound = setDirection;
    }

    /**
     * Getter method for X position.
     * @return logPosX, the log's X position.
     */
    public double getLogPosX() {
        return this.logPosX;
    }

    /**
     * Getter method for Y position.
     * @return logPosY, the log's Y position.
     */
    public double getLogPosY() {
        return this.logPosY;
    }

    /**
     * Getter method for logLength
     * @return logLength, length of the log.
     */
    public int getLogLength() {
        return this.logLength;
    }

    /**
     * Check if log is right bound.
     * @return
     */
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

}
