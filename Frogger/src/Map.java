package frogger;

public class Map{
	
	//Frog for testing.
	public Frog frog = new Frog();
	
	public GameGraphics graphicsEngine = new GameGraphics();
	
	//Log array for testing.
	public Log[][] logArray = {
			{new Log (0.0, 32.0, 1.0, 3, false), new Log (192.0, 32.0, 1.0, 3, false), new Log (384.0, 32.0, 1.0, 3, false)
				} //Left-bound log @ y = 64.0
	};
	
	
	public Map(){
		graphicsEngine.getUserFrog(frog);
		graphicsEngine.getMapLogs(logArray);
	}

}
