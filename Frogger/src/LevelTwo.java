package frogger;

public class LevelTwo extends Map {
	
	public LevelTwo() {
		super.logArray = level2LogArray;
		super.vehicleArray = level2VehicleArray;
		super.turtleArray = level2TurtleArray;
		MapGraphics();
	}
		
	
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
		
}