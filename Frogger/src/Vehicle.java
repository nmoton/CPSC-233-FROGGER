package frogger;

public class Vehicle {

	private double vehiclePosX;
	private double vehiclePosY;
	private double vehicleAccelerationX;
	private int vehicleLength;
	private boolean vehicleRightBound;
	/**
	 * Constructor for Vehicle
	 * @param setVehiclePosX, vehicle X position.
	 * @param setVehiclePosY, vehicle Y position.
	 * @param setVehicleAccelerationX, vehicle speed.
	 * @param setVehicleLength, vehicle length.
	 * @param setDirection, vehicle direction.
	 */
	public Vehicle(double setVehiclePosX, double setVehiclePosY, double setVehicleAccelerationX, int setVehicleLength, boolean setDirection) {
		this.vehiclePosX = setVehiclePosX;
		this.vehiclePosY = setVehiclePosY;
		this.vehicleAccelerationX = setVehicleAccelerationX;
		this.vehicleLength = setVehicleLength;
		this.vehicleRightBound = setDirection;
	}
	/**
	 * Getter method for Vehicle X Position
	 * @return vehiclePosX, X position of vehicle
	 */
	public double getVehiclePosX() {
		return this.vehiclePosX;
	}

	/**
	 * Getter method for Vehicle Y Position
	 * @return vehiclePosY, Y position of vehicle
	 */
	public double getVehiclePosY() {
		return this.vehiclePosY;
	}

	/**
	 * Getter method for length of vehicle
	 * @return vehicleLength, the length of the vehicle.
	 */
	public int getVehicleLength() {
		return this.vehicleLength;
	}

	/**
	 * Getter method for vehicle Acceleration/Speed
	 * @return vehicleAccerationX, acceleration/speed of vehicle.
	 */
	public double getVehicleAcceleration() {
		return this.vehicleAccelerationX;
	}

	/**
	 * Method that checks if vehicle is in right bound
	 * @return vehicleRightBount, boolean or whether vehicle is in right boundary.
	 */
	public boolean isVehicleRightBound() {
		return this.vehicleRightBound;
	}

	/**
	 * Method that moves the vehicle left.
	 */
	public void moveVehicleLeftX() {
		vehiclePosX -= this.vehicleAccelerationX;
	}

	/**
	 * Method that moves vehicle right.
	 */
	public void moveVehicleRightX() {
		vehiclePosX += this.vehicleAccelerationX;
	}

	/**
	 * Setter method for vehicle X Position
	 * @param inputLocation, X coordinate
	 */
	public void setVehiclePosX(double inputLocation) {
		this.vehiclePosX = inputLocation;
	}

	/**
	 * Setter method for vehivle Y position
	 * @param inputLocation, Y coordinate.
	 */
	public void setVehiclePosY(int inputLocation) {
		this.vehiclePosY = inputLocation;
	}
}
