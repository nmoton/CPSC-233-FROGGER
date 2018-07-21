package frogger;

public class Vehicle {
	
	private double vehiclePosX;
	private double vehiclePosY;
	private double vehicleAccelerationX;
	private int logLength;
	private boolean logRightBound;
	
	public Vehicle(double setVehiclePosX, int setVehiclePosY, double setVehicleAccelerationX, int setLogLength, boolean setDirection) {
		this.vehiclePosX = setVehiclePosX;
		this.vehiclePosY = setVehiclePosY;
		this.vehicleAccelerationX = setVehicleAccelerationX;
		this.logLength = setLogLength;
		this.logRightBound = setDirection;
	}
	
	public double getVehiclePosX() {
		return this.vehiclePosX;
	}
	
	public double getVehiclePosY() {
		return this.vehiclePosY;
	}
	
	public int getLogLength() {
		return this.logLength;
	}
	
	public boolean isVehicleRightBound() {
		return this.logRightBound;
	}
	
	public void moveVehicleX() {
		vehiclePosX += this.vehicleAccelerationX;
	}
	
	public void setVehiclePosX(double inputLocation) {
		this.vehiclePosX = inputLocation;
	}
	
	public void setVehiclePosY(int inputLocation) {
		this.vehiclePosY = inputLocation;
	}
}
