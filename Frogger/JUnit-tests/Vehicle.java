/**
 * @author T:01 Team 3
 * The  class is representative of the vehicles that user rides to help get accross.
 *
 * The vehicle has 5 instance variables, vehiclePosX, vehiclePosY the vehicle's X and Y position, vehicleAccelerationX the speed which the
 * vehicle travels, vehicleLength, the size of the vehicle, vehicleRightBound a boolean, if true then the vehicle travels left to right.
 *
 * It has 10 methods, a constructor, setters and getters for the vehicle's position, a getter for
 * vehicleLength, vehicleAccelerationX, and vehicleRightBound, then two move methods, one for each direction: left or right.
 */
public class Vehicle {
	//Instance Variables
	private double vehiclePosX;
	private double vehiclePosY;
	private double vehicleAccelerationX;
	private int vehicleLength;
	private boolean vehicleRightBound;

	/**
	 * Constructor that takes 3 doubles, an int, and a boolean as arguments.
	 * @param setVehiclePosX, vehicle's x position.
	 * @param setVehiclePosY, vehicle's y position.
	 * @param setVehicleAccelerationX, vehicle's x acceleration/speed.
	 * @param setVehicleLength, vehicle's length.
	 * @param setDirection, a bolean stating if vehicle is to travel right.
	 */
	public Vehicle(double setVehiclePosX, double setVehiclePosY, double setVehicleAccelerationX, int setVehicleLength, boolean setDirection) {
		setVehiclePosX(setVehiclePosX);
		setVehiclePosY(setVehiclePosY);
		this.vehicleAccelerationX = setVehicleAccelerationX;
		this.vehicleLength = setVehicleLength;
		this.vehicleRightBound = setDirection;
	}

	/**
	 * Getter method for vehiclePosX
	 * @return vehiclePosX, vehicle's x position.
	 */
	public double getVehiclePosX() {
		return this.vehiclePosX;
	}

	/**
	 * Getter methof for vehiclePosY
	 * @return vehiclePosY, vehicle's y position.
	 */
	public double getVehiclePosY() {
		return this.vehiclePosY;
	}

	/**
	 * Getter method for vehicleLength
	 * @return vehicleLength, the vehicle's length.
	 */
	public int getVehicleLength() {
		return this.vehicleLength;
	}

	/**
	 * Getter method for vehicleAccelerationX
	 * @return vehicleAcclerationX, the vehicle's X speed.
	 */
	public double getVehicleAcceleration() {
		return this.vehicleAccelerationX;
	}

	/**
	 * Getter method for vehicleRightBound
	 * @return vehicleRightBound, a boolean that states whether or not the vehicle travels right.
	 */
	public boolean isVehicleRightBound() {
		return this.vehicleRightBound;
	}

	/**
	 * Move method that moves the vehicle Left
	 */
	public void moveVehicleLeftX() {
		vehiclePosX -= this.vehicleAccelerationX;
	}

	/**
	 * Move method that moves the vehicle Right
	 */
	public void moveVehicleRightX() {
		vehiclePosX += this.vehicleAccelerationX;
	}

	/**
	 * Setter method for vehiclePosX
	 * @param inputLocation, the vehicle's x position
	 */
	public void setVehiclePosX(double inputLocation) {
		this.vehiclePosX = inputLocation;
	}

	/**
	 * Setter method for vehiclePosY
	 * @param inputLocation, the vehicle's y position
	 */
	public void setVehiclePosY(double inputLocation) {
		this.vehiclePosY = inputLocation;
	}
}
