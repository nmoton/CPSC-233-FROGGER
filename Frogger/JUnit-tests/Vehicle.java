public class Vehicle {
	
	private double vehiclePosX;
	private double vehiclePosY;
	private double vehicleAccelerationX;
	private int vehicleLength;
	private boolean vehicleRightBound;
	
	public Vehicle(double setVehiclePosX, double setVehiclePosY, double setVehicleAccelerationX, int setVehicleLength, boolean setDirection) {
		this.vehiclePosX = setVehiclePosX;
		this.vehiclePosY = setVehiclePosY;
		this.vehicleAccelerationX = setVehicleAccelerationX;
		this.vehicleLength = setVehicleLength;
		this.vehicleRightBound = setDirection;
	}
	
	public double getVehiclePosX() {
		return this.vehiclePosX;
	}
	
	public double getVehiclePosY() {
		return this.vehiclePosY;
	}
	
	public int getVehicleLength() {
		return this.vehicleLength;
	}
	
	public double getVehicleAcceleration() {
		return this.vehicleAccelerationX;
	}
	
	public boolean isVehicleRightBound() {
		return this.vehicleRightBound;
	}
	
	public void moveVehicleLeftX() {
		vehiclePosX -= this.vehicleAccelerationX;
	}
	
	public void moveVehicleRightX() {
		vehiclePosX += this.vehicleAccelerationX;
	}
	
	
	public void setVehiclePosX(double inputLocation) {
		this.vehiclePosX = inputLocation;
	}
	
	public void setVehiclePosY(int inputLocation) {
		this.vehiclePosY = inputLocation;
	}
}
