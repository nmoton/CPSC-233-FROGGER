package frogger;

/**
 * @author Nathan Moton
 * @editors Michael Manila
 *
 * The map class is a boilerplate that deals entirely with all the characteristics of maps. This includes the frog's starting position,
 * the end zone boundaries, and initializes the graphics engine that deals with drawing the objects based on the characteristics of the map.
 *
 * Last Updated:08/14/2018
 */
public class Map{
/**
 * 
 * CHANGE THESE VALUES BELOW TO SELECT MAP CHARACTERISTICS:
 * 
 */
	
	//Frog's starting position:
	private double frogStartingX = 0;
	private double frogStartingY = 448;
	
	//End zone boundaries:
	private int endZoneXBoundary1 = 262;
	private int endZoneYBoundary1 = 32;
	private int endZoneXBoundary2 = 346;
	private int endZoneYBoundary2 = 64;
	
	//Frog's initial location:
	public Frog frog = new Frog(frogStartingX, frogStartingY);
	
	//Vehicle, log, and turtle arrays (LEAVE DEFAULT):
	public Vehicle[][] vehicleArray;
	public Log[][] logArray; 
	public Turtle[][] turtleArray;
	
	//Graphics engine (LEAVE DEFAULT):
	public GameGraphics graphicsEngine = new GameGraphics();

/**
 * IGNORE THE FOLLOWING METHODS BELOW:	
 */
	//Unused default constructor
	public Map(){
	}
	
	/**
	 * Method that utilizes memory leaks to provide the graphics engine with the required data for the frog,
	 * logs, vehicles, and turtles. This allows the graphics engine to read data from the same objects and arrays
	 * updated by the game engine every game tick.
	 */
	public void MapGraphics(){
		graphicsEngine.getUserFrog(this.frog);
		graphicsEngine.getMapLogs(this.logArray);
		graphicsEngine.getMapVehicles(this.vehicleArray);
		graphicsEngine.getMapTurtles(this.turtleArray);
	}
	
	/**
	 * Getter method that returns the x coordinate of the first vertex of the end zone.
	 * @return, returns the x coordinate of the first vertex of the end zone.
	 */
	public int getEndZoneXBoundary1(){
		return this.endZoneXBoundary1;
	}
	
	/**
	 * Getter method that returns the y coordinate of the first vertex of the end zone.
	 * @return, returns the y coordinate of the first vertex of the end zone.
	 */
	public int getEndZoneYBoundary1() {
		return this.endZoneYBoundary1;
	}
	
	/**
	 * Getter method that returns the x coordinate of the second vertex of the end zone.
	 * @return, returns the x coordinate of the second vertex of the end zone.
	 */
	public int getEndZoneXBoundary2() {
		return this.endZoneXBoundary2;
	}
	
	/**
	 * Getter method that returns the y coordinate of the second vertex of the end zone.
	 * @return, returns the y coordinate of the second vertex of the end zone.
	 */
	public int getEndZoneYBoundary2() {
		return this.endZoneYBoundary2;
	}

}
