package frogger;

public class Vehicle {
	
	private double vehiclePosX;
	private int vehiclePosY;
	private double vehicleAccelerationX;
	
	public Vehicle(double setVehiclePosX, int setVehiclePosY, double setVehicleAccelerationX) {
		this.vehiclePosX = setVehiclePosX;
		this.vehiclePosY = setVehiclePosY;
		this.vehicleAccelerationX = setVehicleAccelerationX;
	}
	
	public double getVehiclePosX() {
		return this.vehiclePosX;
	}
	
	public double getVehiclePosY() {
		return this.vehiclePosY;
	}
	
	public void moveVehicleX() {
		vehiclePosX += this.vehicleAccelerationX;
	}
}
