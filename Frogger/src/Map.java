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
	 * Setter method for logArray, that takes an integer.
	 * @param level, the level associated with array of Logs.
	 */
	public void setLogs(int level) {
		if (level == 1) {
			logArray = level1LogArray;
		}
		else if(level == 2) {
			logArray = level2LogArray;
		}
		else {
			logArray = level3LogArray;
		}
	}
	
	/**
	 * Setter method for vehicleArray, that takes an integer.
	 * @param level, the level associated with array of Vehicles.
	 */
	public void setVehicles(int level) {
		if (level == 1) {
			vehicleArray = level1VehicleArray;
		}
		else if(level == 2) {
			vehicleArray = level2VehicleArray;
		}
		else {
			vehicleArray = level3VehicleArray;
		}
	}
	
	/**
	 * Setter method for turtleArray, that takes an integer.
	 * @param level, the level associated with array of Turtles.
	 */
	public void setTurtles(int level) {
		if (level == 1) {
			turtleArray = level1TurtleArray;
		}
		else if(level == 2) {
			turtleArray = level2TurtleArray;
		}
		else {
			turtleArray = level3TurtleArray;
		}
	}
	
	
/**
 * !! YOU MUST HAVE ONE OF EACH ARRAY IN ORDER FOR THE GRAPHICS ENGINE TO FUNCTION CORRECTLY!! If you want no objects of that type, make the array EMPTY.	
 * CHANGE THESE VALUES BELOW TO ADD LOGS, VEHICLES, AND TURTLES INTO THE MAP:
 */
	/**
	 * Level 1 Object Arrays: Logs, Vehicles, Turtles.
	 */
	private Log[][] level1LogArray = {
		//Right-bound log @ y = 96.0, traveling at speed of 1.0, gaps of 224.0, and length of 5:
		{new Log (0.0, 96.0, 1.5, 5, true), new Log (224.0, 96.0, 1.5, 5, true), new Log (448.0, 96.0, 1.5, 5, true),
			new Log (672.0, 96.0, 1.5, 5, true)}, 
		
		//Right-bound log @ y = 160, traveling at speed of 1.25, gaps of 228.0, and various lengths of 7:
		{new Log (0.0, 160, 1.25, 7, true), new Log (416.0, 160.0, 1.25, 7, true)},
		
		//Right-bound log @ y = 192, traveling at speed of 0.75, gaps of 160.0, and length of 3:
		{new Log (0.0, 192, 0.75, 3, true), new Log (160, 192, 0.75, 3, true), new Log (320, 192, 0.75, 3, true), 
			new Log (680, 192, 0.75, 3, true)}
	};
	
	private Vehicle[][] level1VehicleArray = {
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
	
	private Turtle[][] level1TurtleArray = {
		//Left-bound turtle @ y = 128.0, traveling at speed of 0.5, various gaps, and length of 2:
		{new Turtle (640.0, 128.0, 0.5, 2), new Turtle (512.0, 128.0, 0.5, 2), new Turtle (384.0, 128.0, 0.5, 2),
			new Turtle (256.0, 128.0, 0.5, 2), new Turtle (128.0, 128.0, 0.5, 2)},
		
		//Left-bound turtle @ y = 224.0, traveling at speed of 1.5, various gaps, and length of 3:
		{new Turtle (640.0, 224.0, 1.5, 3), new Turtle (320.0, 224.0, 1.5, 2), new Turtle (128.0, 224.0, 1.5, 2),}
	};
	private Log[][] level2LogArray = {
		//Right-bound logs @ y = 96.0, traveling at speed of 1.5, varying gaps, and length of 5:
		{new Log (0.0, 96.0, 1.5, 5, true), new Log (224.0, 96.0, 1.5, 5, true), new Log (448.0, 96.0, 1.5, 5, true),
			new Log (672.0, 96.0, 1.5, 5, true)}, 
		
		//Left-bound logs @ y = 128.0, traveling at speed of 1.5, varying gaps, and length of 5:
		{new Log (0.0, 128.0, 1.5, 5, false), new Log (224.0, 128.0, 1.5, 5, false), new Log (448.0, 128.0, 1.5, 5, false),
				new Log (672.0, 128.0, 1.5, 5, false)}, 
		
		//Right-bound logs @ y = 160, traveling at speed of 1.25, varying gaps, and various lengths of 7:
		{new Log (0.0, 160, 1.25, 7, true), new Log (416.0, 160.0, 1.25, 7, true)},
		
		//Right-bound logs @ y = 192, traveling at speed of 0.75, varying, and length of 3:
		{new Log (0.0, 192, 0.75, 3, true), new Log (160, 192, 0.75, 3, true), new Log (320, 192, 0.75, 3, true), 
			new Log (680, 192, 0.75, 3, true)},
		
		//Left-bound logs @ y = 224, traveling at speed of 1.25, varying, and various lengths of 7:
		{new Log (0.0, 224.0, 1.25, 7, false), new Log (416.0, 224.0, 1.25, 7, false)},
		
		//Right-bound logs @ y = 288, traveling at speed of 1.50, varying, and length of 3:
		{new Log (0.0, 288.0, 1.5, 3, true), new Log (160, 288.0, 1.50, 3, true), new Log (320, 288.0, 1.50, 3, true), 
			new Log (680, 288.0, 1.50, 3, true)},
		
		//Left-bound logs @ y = 320, traveling at speed of 0.5, varying, and various lengths of 7:
		{new Log (0.0, 320.0, 0.5, 7, false), new Log (416.0, 320.0, 0.5, 7, false)},
		
		//Left-bound logs @ y = 352, traveling at speed of 1.50, varying, and length of 3:
		{new Log (0.0, 352.0, 1.5, 3, false), new Log (160, 352.0, 1.50, 3, false), new Log (320, 352.0, 1.50, 3, false), 
			new Log (500, 352.0, 1.50, 3, false)},
		
		//Left-bound logs @ y = 384.0, traveling at speed of 1.5, varying gaps, and length of 5:
		{new Log (0.0, 384.0, 1.5, 5, false), new Log (224.0, 384.0, 1.5, 5, false), new Log (448.0, 384.0, 1.5, 5, false),
			new Log (672.0, 384.0, 1.5, 5, false)}, 
		
		//Left-bound logs @ y = 320, traveling at speed of 1.25, varying, and various lengths of 7:
		{new Log (0.0, 416.0, 0.5, 7, false), new Log (416.0, 416.0, 0.5, 7, false)}
		
	};
	//Empty Array as Level 2 has no Vehicles.
	private Vehicle[][] level2VehicleArray = {
	};
	//Empty Array as Level 2 has no Turtles.
	private Turtle[][] level2TurtleArray = {	
	};
	
	/**
	 * Level 3 Object Arrays: Logs, Vehicles, Turtles
	 */
	private Log[][] level3LogArray = {
		//Right-bound log @ y = 96.0, traveling at speed of 1.0, gaps of 224.0, and length of 5:
		{new Log (0.0, 96.0, 1.5, 5, true), new Log (224.0, 96.0, 1.5, 5, true), new Log (448.0, 96.0, 1.5, 5, true),
			new Log (672.0, 96.0, 1.5, 5, true)}, 
			
		//Right-bound log @ y = 160, traveling at speed of 1.25, gaps of 228.0, and various lengths of 7:
		{new Log (0.0, 160, 1.25, 7, true), new Log (416.0, 160.0, 1.25, 7, true)},
			
		//Right-bound log @ y = 192, traveling at speed of 0.75, gaps of 160.0, and length of 3:
		{new Log (0.0, 192, 0.75, 3, true), new Log (160, 192, 0.75, 3, true), new Log (320, 192, 0.75, 3, true), 
			new Log (680, 192, 0.75, 3, true)}
	};
	private Vehicle[][] level3VehicleArray = {
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
	private Turtle[][] level3TurtleArray = {
		//Left-bound turtle @ y = 128.0, traveling at speed of 0.5, various gaps, and length of 2:
		{new Turtle (640.0, 128.0, 0.5, 2), new Turtle (512.0, 128.0, 0.5, 2), new Turtle (384.0, 128.0, 0.5, 2),
			new Turtle (256.0, 128.0, 0.5, 2), new Turtle (128.0, 128.0, 0.5, 2)},
		
		//Left-bound turtle @ y = 224.0, traveling at speed of 1.5, various gaps, and length of 3:
		{new Turtle (640.0, 224.0, 1.5, 3), new Turtle (320.0, 224.0, 1.5, 2), new Turtle (128.0, 224.0, 1.5, 2),}
	};
	
	
	
	
/**
 * IGNORE THE FOLLOWING FUNCTIONS BELOW:	
 */
	public Map(int level){
		setLogs(level);
		setVehicles(level);
		setTurtles(level);
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
