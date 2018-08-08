package frogger;

public class Map{
/**
 * Please refer to documentation on the grid system to design your own maps.
 * 
 * CHANGE THESE VALUES BELOW TO SELECT MAP CHARACTERISTICS:
 */
	
	//Frog's starting position:
	private double frogStartingX = 0;
	private double frogStartingY = 448;
	
	//End zone boundaries:
	private int endZoneXBoundary1 = 256;
	private int endZoneYBoundary1 = 32;
	private int endZoneXBoundary2 = 320;
	private int endZoneYBoundary2 = 64;
	
	//Frog for testing (LEAVE DEFAULT):
	public Frog frog = new Frog(frogStartingX, frogStartingY);
	
	
	public Vehicle[][] vehicleArray;
	public Log[][] logArray; 
	public Turtle[][] turtleArray;
	
	//Graphics engine (LEAVE DEFAULT):
	public GameGraphics graphicsEngine = new GameGraphics();

/**
 * IGNORE THE FOLLOWING FUNCTIONS BELOW:	
 */
	public Map(){
	}
	
	public void MapGraphics(){
		graphicsEngine.getUserFrog(this.frog);
		graphicsEngine.getMapLogs(this.logArray);
		graphicsEngine.getMapVehicles(this.vehicleArray);
		graphicsEngine.getMapTurtles(this.turtleArray);
	}
	
	public int getEndZoneXBoundary1(){
		return this.endZoneXBoundary1;
	}
	
	public int getEndZoneYBoundary1() {
		return this.endZoneYBoundary1;
	}
	
	public int getEndZoneXBoundary2() {
		return this.endZoneXBoundary2;
	}
	
	public int getEndZoneYBoundary2() {
		return this.endZoneYBoundary2;
	}

}