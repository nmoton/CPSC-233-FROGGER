package frogger;

public class LevelThree extends Map{

	
	public LevelThree() {
		super.logArray = level3LogArray;
		super.vehicleArray = level3VehicleArray;
		super.turtleArray = level3TurtleArray;
		MapGraphics();
	}
	
	/**
	 * Level 3 Object Arrays: Logs, Vehicles, Turtles
	 */
	private Log[][] level3LogArray = {
		//Left-bound log @ y = 416.0, traveling at speed of 1.0, gaps of 224.0, and length of 5:
		{new Log (0.0, 416.0, 1.5, 5, true), new Log (224.0, 416.0, 1.5, 5, true), new Log (448.0, 416.0, 1.5, 5, true),
			new Log (672.0, 416.0, 1.5, 5, true)}, 
			
		//Left-bound log @ y = 384, traveling at speed of 1.25, gaps of 228.0, and various lengths of 7:
		{new Log (0.0, 384.0, 1.25, 7, false), new Log (416.0, 384.0, 1.25, 7, false)},
			
		//Right-bound log @ y = 192, traveling at speed of 0.75, gaps of 160.0, and length of 3:
		{new Log (0.0, 192.0, 0.75, 3, true), new Log (160, 192.0, 0.75, 3, true), new Log (320, 192.0, 0.75, 3, true), 
			new Log (680, 192.0, 0.75, 3, true)}
		
	};
	private Vehicle[][] level3VehicleArray = {
		//Left-bound vehicle @ y = 96.0, traveling at speed of 1.75, gaps of 128.0, and length of 1:
		{new Vehicle (640.0, 96.0, 1.75, 1, false), new Vehicle (512.0, 96.0, 1.75, 1, false), new Vehicle (384.0, 96.0, 1.75, 1, false),
			new Vehicle (256.0, 96.0, 1.75, 1, false), new Vehicle (128.0, 96.0, 1.75, 1, false)},
			
		//Right-bound vehicle @ y = 128.0, traveling at speed of 1.5, gaps of 128, and length of 2:
		{new Vehicle (640.0, 128.0, 1.5, 2, true), new Vehicle (512.0, 128.0, 1.5, 2, true), new Vehicle (384.0, 128.0, 1.5, 2, true),
			new Vehicle (256.0, 128.0, 1.5, 2, true), new Vehicle (128.0, 128.0, 1.5, 2, true)},
				
		//Left-bound vehicle @ y = 160.0, traveling at speed of 2.0, gaps of 128, and length of 1:
		{new Vehicle (640.0, 160.0, 0.5, 2, false), new Vehicle (512.0, 160.0, 0.5, 2, false), new Vehicle (384.0, 160.0, 0.5, 2, false),
			new Vehicle (256.0, 160.0, 0.5, 2, false), new Vehicle (128.0, 160.0, 0.5, 2, false)},
			
		//Right-bound vehicle @ y = 288.0, traveling at speed of 2.5, gaps of 64, and length of 1:
		{new Vehicle (640.0, 288.0, 2.5, 1, true), new Vehicle (576.0, 288.0, 2.5, 1, true)},
			
	};
	public Turtle[][] level3TurtleArray = {
		//Left-bound turtle @ y = 320.0, traveling at speed of 0.5, various gaps, and length of 3:
		{new Turtle (640.0, 320.0, 2.0, 3), new Turtle (512.0, 320.0, 2.0, 2), new Turtle (384.0, 320.0, 2.0, 3),
			new Turtle (256.0, 320.0, 2.0, 3), new Turtle (128.0, 320.0, 2.0, 3)},
		
		//Left-bound turtle @ y = 224.0, traveling at speed of 1.5, various gaps, and length of 2:
		{new Turtle (640.0, 224.0, 1.5, 3), new Turtle (320.0, 224.0, 1.5, 2), new Turtle (128.0, 224.0, 1.5, 2)},
		
		//Left-bound turtle @ y = 352.0, traveling at speed of 1.0, various gaps, and length of 2:
		{new Turtle (640.0, 352.0, 1.0, 2), new Turtle (320.0, 352.0, 1.0, 2), new Turtle (128.0, 352.0, 1.0, 2)},
			
	};
	
	
}