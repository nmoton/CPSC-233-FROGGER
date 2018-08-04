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
	
	//Graphics engine (LEAVE DEFAULT):
	public GameGraphics graphicsEngine = new GameGraphics();
	
	
/**
 * !! YOU MUST HAVE ONE OF EACH ARRAY IN ORDER FOR THE GRAPHICS ENGINE TO FUNCTION CORRECTLY !!	
 * 
 * CHANGE THESE VALUES BELOW TO ADD LOGS, VEHICLES, AND TURTLES INTO THE MAP:
 */
	//Log array:
	public Log[][] logArray = {
			//Right-bound log @ y = 96.0, traveling at speed of 1.0, gaps of 224.0, and length of 5:
			{new Log (0.0, 96.0, 1.5, 5, true), new Log (224.0, 96.0, 1.5, 5, true), new Log (448.0, 96.0, 1.5, 5, true),
				new Log (672.0, 96.0, 1.5, 7, true)}, 
			
			//Right-bound log @ y = 160, traveling at speed of 1.25, gaps of 228.0, and various lengths of 7:
			{new Log (0.0, 160, 1.25, 7, true), new Log (416.0, 160.0, 1.25, 7, true)},
			
			//Right-bound log @ y = 192, traveling at speed of 0.75, gaps of 160.0, and length of 3:
			{new Log (0.0, 192, 0.75, 3, true), new Log (160, 192, 0.75, 3, true), new Log (320, 192, 0.75, 3, true), 
				new Log (680, 192, 0.75, 3, true)}
				
			//
	};
	
	//Vehicle array:
	public Vehicle[][] vehicleArray = {
			//Left-bound vehicle @ y = 416.0, traveling at speed of 0.75, gaps of 128.0, and length of 1:
			{new Vehicle (640.0, 416.0, 0.75, 1, false), new Vehicle (512.0, 416.0, 0.75, 1, false), new Vehicle (384.0, 416.0, 0.75, 1, false),
				new Vehicle (256.0, 416.0, 0.75, 1, false), new Vehicle (128.0, 416.0, 0.75, 1, false)},
			
			//Right-bound vehicle @ y = 384.0, traveling at speed of 0.5, gaps of 128, and length of 1:
			{new Vehicle (640.0, 384.0, 0.5, 1, true), new Vehicle (512.0, 384.0, 0.5, 1, true), new Vehicle (384.0, 384.0, 0.5, 1, true),
				new Vehicle (256.0, 384.0, 0.5, 1, true), new Vehicle (128.0, 384.0, 0.5, 1, true)},
				
			//Left-bound vehicle @ y = 352.0, traveling at speed of 0.75, gaps of 128, and length of 1:
			{new Vehicle (640.0, 352.0, 0.5, 1, false), new Vehicle (512.0, 352.0, 0.5, 1, false), new Vehicle (384.0, 352.0, 0.5, 1, false),
				new Vehicle (256.0, 352.0, 0.5, 1, false), new Vehicle (128.0, 352.0, 0.5, 1, false)},
			
			//Right-bound vehicle @ y = 320.0, traveling at speed of 2.5, gaps of 64, and length of 1:
			{new Vehicle (640.0, 320.0, 2.5, 1, true), new Vehicle (576.0, 320.0, 2.5, 1, true)},
				
			//Left-bound vehicle @ y = 	288.0, traveling at speed of 0.65, gaps of 160, and length of 2:
			{new Vehicle (640.0, 288.0, 0.75, 2, false), new Vehicle (480, 288.0, 0.75, 2, false), new Vehicle (320, 288.0, 0.75, 2, false),
				new Vehicle (160, 288.0, 0.75, 2, false)}
	};
	
	//Turtle array:
	public Turtle[][] turtleArray = {
			//Left-bound turtle @ y = 128.0, traveling at speed of 0.5, various gaps, and length of 2:
			{new Turtle (640.0, 128.0, 0.5, 2), new Turtle (512.0, 128.0, 0.5, 2), new Turtle (384.0, 128.0, 0.5, 2),
				new Turtle (256.0, 128.0, 0.5, 2), new Turtle (128.0, 128.0, 0.5, 2)},
			
			//Left-bound turtle @ y = 224.0, traveling at speed of 1.5, various gaps, and length of 3:
			{new Turtle (640.0, 224.0, 1.5, 3), new Turtle (320.0, 224.0, 1.5, 2), new Turtle (128.0, 224.0, 1.5, 2),}
	};
	
/**
 * IGNORE THE FOLLOWING FUNCTIONS BELOW:	
 */
	public Map(){
		//Links arrays to the graphics engine.
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
