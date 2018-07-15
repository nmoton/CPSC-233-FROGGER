package frogger;

public class Vehicle {
	
	private double vehiclePosX = 0;
	private double vehiclePosY = 256.0;
	
	public double getVehiclePosX() {
		this.vehiclePosX += 0.75; //Strictly for testing how the object moves across the screen.
		return this.vehiclePosX;
	}
	
	public double getVehiclePosY() {
		return this.vehiclePosY;
	}
}
