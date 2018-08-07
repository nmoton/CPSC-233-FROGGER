package frogger;

import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.io.File;


public class Gameplay extends JPanel implements KeyListener, ActionListener {
	
	/**
	* 
	* CHANGE THESE VALUES BELOW TO ENABLE/DISABLE COLLISIONS, WATER DETECTION, AND END-ZONES:
	* 
	*/
	private static boolean TOGGLE_COLLISION = true;
	private static boolean TOGGLE_WATER = true;
	private static boolean TOGGLE_ENDZONE = true;
	private static boolean TOGGLE_FROGBOUNDARY = true;
	
	/**
	 * 
	 * LEAVE THESE SETTINGS DEFAULT:
	 * 
	 */

	private Timer timer;
	private int delay = 10;
	
	private int gameMode = -1;
	
	private File frogHop;
	private File startGame;
	private File carCollision;
	private File fallWater;
	private File newMap;
	
	private Map map = new Map();
	
	public Score score;
	public HighscoreManager hm = new HighscoreManager();

	private LevelOne map1 = new LevelOne();
	private LevelTwo map2 = new LevelTwo();
	private LevelThree map3 = new LevelThree();
	
	public Gameplay() {
		try {
			frogHop = new File("C:\\Users\\Nate\\Desktop\\Frogger Sounds\\sound-frogger-hop.wav\\");
			startGame = new File("C:\\Users\\Nate\\Desktop\\Frogger Sounds\\sound-frogger-coin-in.wav\\");
			carCollision = new File("C:\\Users\\Nate\\Desktop\\Frogger Sounds\\sound-frogger-plunk.wav\\");
			fallWater = new File("C:\\Users\\Nate\\Desktop\\Frogger Sounds\\sound-frogger-squash.wav\\");
			newMap = new File("C:\\Users\\Nate\\Desktop\\Frogger Sounds\\sound-frogger-extra.wav\\");
		}
		
		catch (Exception e){
			
		}
		
		map.graphicsEngine.getGameMode(this.gameMode);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
	}
	
	public void paintComponent(Graphics g) {
		//Forces the graphics engine to paint components:
		map.graphicsEngine.paintComponent(g);
	}

	public void actionPerformed(ActionEvent e) {
		
		switch(this.gameMode) {
			case -1: //Main Menu
				map.graphicsEngine.getGameMode(-1);
				break;
			case 0: //Point Table
				playSound(startGame);
				map.graphicsEngine.getGameMode(0);
				break;
			case 1: //First Level
				map = map1;
				map.graphicsEngine.getGameMode(1);
				break;
			case 2: //Second Level
				map = map2;
				map.graphicsEngine.getGameMode(2);
				break;
			case 3: //Third Level
				map = map3;
				map.graphicsEngine.getGameMode(3);
				break;
			case 4: //Game End - Lose
				map.graphicsEngine.getGameMode(4);
				break;
			case 5: //Game End - Win
				map.graphicsEngine.getGameMode(5);
				break;
			case 6: //Show score board
				map.graphicsEngine.getGameMode(6);
				break;
		}
		
		//Checks to see if user entered the end zone:
		if (TOGGLE_ENDZONE) {
			checkEndZone(map.getEndZoneXBoundary1(), map.getEndZoneYBoundary1(), map.getEndZoneXBoundary2(),
					map.getEndZoneYBoundary2(), map.frog.getPlayerPosX(), map.frog.getPlayerPosY());
		}
		
		if (TOGGLE_FROGBOUNDARY) {
			checkFrogInBounds();
		}
		
		//Checks logs, vehicles, and trucks for collisions:
		checkLogs(map.logArray);
		checkVehicles(map.vehicleArray);
		checkTurtles(map.turtleArray);
		
		//Forces the graphics engine to update painted components:
		repaint();
	}
	
	public void checkFrogInBounds(){
	if (map.frog.getPlayerPosX() < 0 || map.frog.getPlayerPosX() + 32 > 640) {
			timer.stop();
			playSound(fallWater);
			this.gameMode = 5;
			map.graphicsEngine.getGameMode(this.gameMode);
			repaint();
		}
	}
	
	public void playSound(File Sound) {
		try {
			Clip soundEffect = AudioSystem.getClip();
			soundEffect.open(AudioSystem.getAudioInputStream(Sound));
			soundEffect.start();
		}
		catch (Exception e) {
			
		}
	}

	
	public void checkLogs(Log[][] logArray) {
		for (int i = 0; i < logArray.length; i++) {
			int countFalse = 0; //Keep track of how many logs the user is not stepping on
		
			for (int j = 0; j < logArray[i].length; j++) {
				
				if (logArray[i][j].isLogRightBound() == true) {
					logBoundaryRightBound(logArray[i][j]);
					
					if (logArray[i][j].getLogLength() == 3) {
						if (userOnLog3R(logArray[i][j]) == false) {
							countFalse++;
						}
						
						if (countFalse == logArray[i].length && TOGGLE_WATER) {
							checkWater(0, logArray[i][j].getLogPosY(), 640, logArray[i][j].getLogPosY() + 31, 
									map.frog.getPlayerPosX(), map.frog.getPlayerPosY());
							}
						}
	
					else if (logArray[i][j].getLogLength() == 5) {
						if (userOnLog5R(logArray[i][j]) == false) {
							countFalse++;
						}
						if (countFalse == logArray[i].length && TOGGLE_WATER) {
							checkWater(0, logArray[i][j].getLogPosY(), 640, logArray[i][j].getLogPosY() + 31, 
									map.frog.getPlayerPosX(), map.frog.getPlayerPosY());
						}
					} 
					else {
						if (userOnLog7R(logArray[i][j]) == false) {
							countFalse++;
						}
						if (countFalse == logArray[i].length && TOGGLE_WATER) {
							checkWater(0, logArray[i][j].getLogPosY(), 640, logArray[i][j].getLogPosY() + 31, 
									map.frog.getPlayerPosX(), map.frog.getPlayerPosY());
						}
					}
				}
	
				
				else if (logArray[i][j].isLogRightBound() == false) {
					logBoundaryLeftBound(logArray[i][j]);
					
					if (logArray[i][j].getLogLength() == 3) {
						if (userOnLog3L(logArray[i][j]) == false) {
							countFalse++;
						}
						if (countFalse == logArray[i].length && TOGGLE_WATER) {
							checkWater(0, logArray[i][j].getLogPosY(), 640, logArray[i][j].getLogPosY() + 31, 
									map.frog.getPlayerPosX(), map.frog.getPlayerPosY());
						}
					} 
					else if (logArray[i][j].getLogLength() == 5) {
						if (userOnLog5L(logArray[i][j]) == false) {
							countFalse++;
						}
						if (countFalse == logArray[i].length && TOGGLE_WATER) {
							checkWater(0, logArray[i][j].getLogPosY(), 640, logArray[i][j].getLogPosY() + 31, 
									map.frog.getPlayerPosX(), map.frog.getPlayerPosY());
						}
					} 
					else {
						if (userOnLog7L(logArray[i][j]) == false) {
							countFalse++;
						}
						if (countFalse == logArray[i].length && TOGGLE_WATER) {
							checkWater(0, logArray[i][j].getLogPosY(), 640, logArray[i][j].getLogPosY() + 31, 
									map.frog.getPlayerPosX(), map.frog.getPlayerPosY());
						}
					}
				}
			}
		}
	}

	public void checkVehicles(Vehicle[][] vehicleArray) {
		for (int i = 0; i < vehicleArray.length; i++) {
			for (int j = 0; j < vehicleArray[i].length; j++) {
				
				if (vehicleArray[i][j].isVehicleRightBound() == true) {
					vehicleBoundaryRightBound(vehicleArray[i][j]);
					
					if (TOGGLE_COLLISION) {
					vehicleCollisionRightBound(vehicleArray[i][j]);
					}
				}
				else if (vehicleArray[i][j].isVehicleRightBound() == false) {
					vehicleBoundaryLeftBound(vehicleArray[i][j]);
					
					if (TOGGLE_COLLISION) {
					vehicleCollisionLeftBound(vehicleArray[i][j]);
					}
				}
			}
		}
	}
	
	public void checkTurtles(Turtle[][] turtleArray) {
		for (int i = 0; i < turtleArray.length; i++) {
			int countFalse = 0; //Keep track of how many turtles the user is not stepping on
			
			for (int j = 0; j < turtleArray[i].length; j++) {
				turtleBoundaryLeftBound(turtleArray[i][j]);
				
				if (turtleArray[i][j].getTurtleLength() == 2) {
					if (userOnTurtle2L(turtleArray[i][j]) == false){
						countFalse++;
					}
					
					if (countFalse == turtleArray[i].length && TOGGLE_WATER) {
						checkWater(0, turtleArray[i][j].getTurtlePosY(), 640, turtleArray[i][j].getTurtlePosY() + 31, 
								map.frog.getPlayerPosX(), map.frog.getPlayerPosY());
					}
				}
				else if (turtleArray[i][j].getTurtleLength() == 3) {
					if (userOnTurtle3L(turtleArray[i][j]) == false) {
						countFalse++;
					}
					if (countFalse == turtleArray[i].length && TOGGLE_WATER) {
						checkWater(0, turtleArray[i][j].getTurtlePosY(), 640, turtleArray[i][j].getTurtlePosY() + 31, 
								map.frog.getPlayerPosX(), map.frog.getPlayerPosY());
					}
				}
				
			}
		}
	}
	
	public void checkWater(int xBoundary1, double yBoundary1, int xBoundary2, double yBoundary2, double userPosX, double userPosY) {
		if (userPosX >= xBoundary1 && userPosX <= xBoundary2 && userPosY >= yBoundary1 && userPosY <= yBoundary2) {
			playSound(fallWater);
			this.gameMode = 5;
			timer.stop();
			map.graphicsEngine.getGameMode(this.gameMode);
			repaint();
		}
	}
	
	public void checkEndZone(int xBoundary1, int yBoundary1, int xBoundary2, int yBoundary2, double userPosX, double userPosY) {
		if (userPosX >= xBoundary1 && userPosX <= xBoundary2 && userPosY >= yBoundary1 && userPosY <= yBoundary2) {
			this.gameMode++;
			score.clearLevelScore();
			
			
			if (this.gameMode == 4) {
				timer.stop();
				map.graphicsEngine.getGameMode(this.gameMode);
				repaint();
			}
			
			else {
				playSound(newMap);
			}
		}
	}
	
	public int getGameMode() {
		return this.gameMode;
	}
	

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		if (this.gameMode < 1 || this.gameMode > 3) {
			if (gameMode == -1) {
				System.out.println(hm.getHighscoreString());
				playSound(startGame);
				this.gameMode++;
				score = new Score(480);
				map.graphicsEngine.getGameMode(this.gameMode);
				repaint();
			}
			
			else if (this.gameMode == 0) {
				timer.start();
				this.gameMode++;
				map.graphicsEngine.getGameMode(this.gameMode);
				playSound(newMap);
			}

			else if (this.gameMode == 4 || this.gameMode == 5){
				score.setUsername();
				hm.addScore(score);
				map1 = new LevelOne();
				map2 = new LevelTwo();
				map3 = new LevelThree();
				timer.stop();
				this.gameMode = 6;
				map.graphicsEngine.getGameMode(this.gameMode);
				repaint();
			}
			
			else if (this.gameMode == 6) {
				this.gameMode = -1;
				map.graphicsEngine.getGameMode(this.gameMode);
				repaint();
			}
		}
		
		else {
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			if (map.frog.getPlayerPosY() <= 0) {
				 map.frog.setPosY(0);
			}
			else {
				playSound(frogHop);
				score.updateScore(map.frog.getPlayerPosY());
				map.frog.moveUp();
			}
		}
			
		else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			if (map.frog.getPlayerPosY() >= 448) {
				map.frog.setPosY(448);
			}
			else {
				playSound(frogHop);
				map.frog.moveDown();
			}
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			if (map.frog.getPlayerPosX() >= 608) {
				map.frog.setPosX(608);
			}
			else {
				playSound(frogHop);
				map.frog.moveRight();
			}
			
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			if (map.frog.getPlayerPosX() <= 0) {
				map.frog.setPosX(0);
			}
			else {
				playSound(frogHop);
				map.frog.moveLeft();
			}
		}
		}
	}
	
	public void vehicleBoundaryRightBound(Vehicle vehicle) {
		if (vehicle.getVehiclePosX() >= 640.0 + (vehicle.getVehicleLength() * 32)) {
			vehicle.setVehiclePosX(-30.0 - (vehicle.getVehicleLength() * 32));
		}
	}
	
	public void vehicleBoundaryLeftBound(Vehicle vehicle) {
		if (vehicle.getVehiclePosX() <= - (vehicle.getVehicleLength() * 32)) {
			vehicle.setVehiclePosX(670.0 + (vehicle.getVehicleLength() * 32));
		}
	}

	public void vehicleCollisionRightBound(Vehicle vehicle) {
		if (map.frog.getPlayerPosX() - vehicle.getVehiclePosX() < 32 && map.frog.getPlayerPosX() - vehicle.getVehiclePosX() > -20 &&
					vehicle.getVehiclePosY() == map.frog.getPlayerPosY()) {
				timer.stop();
				this.gameMode = 5;
				playSound(carCollision);
				map.graphicsEngine.getGameMode(this.gameMode);
				repaint();
				}
		}
	
	public void vehicleCollisionLeftBound (Vehicle vehicle) {
		if (vehicle.getVehicleLength() == 2) {
			if (map.frog.getPlayerPosX() - vehicle.getVehiclePosX() > -32 && map.frog.getPlayerPosX() - vehicle.getVehiclePosX() < 48 &&
						vehicle.getVehiclePosY() == map.frog.getPlayerPosY()) {
					timer.stop();
					this.gameMode = 5;
					playSound(carCollision);
					map.graphicsEngine.getGameMode(this.gameMode);
					repaint();
					}
		}
		
		else {
			if (map.frog.getPlayerPosX() - vehicle.getVehiclePosX() > -32 && map.frog.getPlayerPosX() - vehicle.getVehiclePosX() < 20 &&
					vehicle.getVehiclePosY() == map.frog.getPlayerPosY()){
				timer.stop();
				this.gameMode = 5;
				playSound(carCollision);
				map.graphicsEngine.getGameMode(this.gameMode);
				repaint();
			}
		}
	}
	
	public void logBoundaryRightBound (Log log) {
		if (log.getLogPosX() >= 640 + (log.getLogLength() * 32)) {
			log.setLogPosX(-30.0 - (log.getLogLength() * 32));
		}
	}
	
	public void logBoundaryLeftBound (Log log) {
		if (log.getLogPosX() <= -(log.getLogLength() * 32)) {
			log.setLogPosX(670);
		}
	}
	
	public void turtleBoundaryLeftBound (Turtle turtle) {
		if (turtle.getTurtlePosX() <= -(turtle.getTurtleLength() * 32)) {
			turtle.setTurtlePosX(670);
		}
	}
	
	public boolean userOnTurtle2L (Turtle turtle) { //For Left-Bound Turtles
		if (turtle.getTurtlePosX() - map.frog.getPlayerPosX() < -16 && turtle.getTurtlePosX() - map.frog.getPlayerPosX() > -48 && 
				turtle.getTurtlePosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(turtle.getTurtlePosX() + 32);
			return true;
		}
		else if (turtle.getTurtlePosX() - map.frog.getPlayerPosX() < 16 && turtle.getTurtlePosX() - map.frog.getPlayerPosX() > -16 && 
				turtle.getTurtlePosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(turtle.getTurtlePosX());
			return true;
		}
		return false;
	}
	
	public boolean userOnTurtle3L (Turtle turtle) { //for Left-Bound Turtles
		if (turtle.getTurtlePosX() - map.frog.getPlayerPosX() < -48 && turtle.getTurtlePosX() - map.frog.getPlayerPosX() > -80 && 
				turtle.getTurtlePosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(turtle.getTurtlePosX() + 64);
			return true;
		}
		else if (turtle.getTurtlePosX() - map.frog.getPlayerPosX() < -16 && turtle.getTurtlePosX() - map.frog.getPlayerPosX() > -48 && 
				turtle.getTurtlePosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(turtle.getTurtlePosX() + 32);
			return true;
		}
		else if (turtle.getTurtlePosX() - map.frog.getPlayerPosX() < 16 && turtle.getTurtlePosX() - map.frog.getPlayerPosX() > -16 && 
				turtle.getTurtlePosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(turtle.getTurtlePosX());
			return true;
		}
		return false;
	}
	
	public boolean userOnLog3R (Log log) {
		if (log.getLogPosX() - map.frog.getPlayerPosX() < -48 && log.getLogPosX() - map.frog.getPlayerPosX() > -96 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 64);
			return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < -16 && log.getLogPosX() - map.frog.getPlayerPosX() > -48 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 32);
			return true;
		}
		//8 is REQUIRED in order to allow the log to move to a maximum speed of 8 pixels/period.
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < 8 && log.getLogPosX() - map.frog.getPlayerPosX() > -16 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX());
			return true;
		}
		return false;
	}
		
	public boolean userOnLog5R (Log log) {
		if (log.getLogPosX() - map.frog.getPlayerPosX() < -112 && log.getLogPosX() - map.frog.getPlayerPosX() > -180 &&
					log.getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(log.getLogPosX() + 128);
				return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < -80 && log.getLogPosX() - map.frog.getPlayerPosX() > -112 && 
					log.getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(log.getLogPosX() + 96);
				return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < -48 && log.getLogPosX() - map.frog.getPlayerPosX() > -80 && 
					log.getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(log.getLogPosX() + 64);
				return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < -16 && log.getLogPosX() - map.frog.getPlayerPosX() > -48 && 
					log.getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(log.getLogPosX() + 32);
				return true;
		}
			//8 is REQUIRED in order to allow the log to move to a maximum speed of 8 pixels/period.
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < 8 && log.getLogPosX() - map.frog.getPlayerPosX() > -16 && 
					log.getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(log.getLogPosX());
				return true;
		}
		return false;
	}
	
	public boolean userOnLog7R (Log log) {
		if (log.getLogPosX() - map.frog.getPlayerPosX() < -176 && log.getLogPosX() - map.frog.getPlayerPosX() > -240 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 192);
			return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < -144 && log.getLogPosX() - map.frog.getPlayerPosX() > -176 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 160);
			return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < -112 && log.getLogPosX() - map.frog.getPlayerPosX() > -144 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 128);
			return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < -80 && log.getLogPosX() - map.frog.getPlayerPosX() > -112 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 96);
			return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < -48 && log.getLogPosX() - map.frog.getPlayerPosX() > -80 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 64);
			return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < -16 && log.getLogPosX() - map.frog.getPlayerPosX() > -48 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 32);
			return true;
		}
		//8 is REQUIRED in order to allow the log to move to a maximum speed of 8 pixels/period.
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < 8 && log.getLogPosX() - map.frog.getPlayerPosX() > -16 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX());
			return true;
		}
		return false;
	}
	
	public boolean userOnLog3L (Log log) { //For Left-Bound Logs
		if (log.getLogPosX() - map.frog.getPlayerPosX() < -48 && log.getLogPosX() - map.frog.getPlayerPosX() > -80 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 64);
			return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < -16 && log.getLogPosX() - map.frog.getPlayerPosX() > -48 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 32);
			return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < 16 && log.getLogPosX() - map.frog.getPlayerPosX() > -16 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX());
			return true;
		}
		return false;
	}
	
	public boolean userOnLog5L (Log log) {
		if (log.getLogPosX() - map.frog.getPlayerPosX() < -112 && log.getLogPosX() - map.frog.getPlayerPosX() > -144 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 128);
			return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < -80 && log.getLogPosX() - map.frog.getPlayerPosX() > -112 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 96);
			return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < -48 && log.getLogPosX() - map.frog.getPlayerPosX() > -80 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 64);
			return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < -16 && log.getLogPosX() - map.frog.getPlayerPosX() > -48 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 32);
			return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < 16 && log.getLogPosX() - map.frog.getPlayerPosX() > -16 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX());
			return true;
		}
		return false;
	}
	
	public boolean userOnLog7L (Log log) {
		if (log.getLogPosX() - map.frog.getPlayerPosX() < -176 && log.getLogPosX() - map.frog.getPlayerPosX() > -208 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 192);
			return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < -144 && log.getLogPosX() - map.frog.getPlayerPosX() > -176 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 160);
			return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < -112 && log.getLogPosX() - map.frog.getPlayerPosX() > -144 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 128);
			return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < -80 && log.getLogPosX() - map.frog.getPlayerPosX() > -112 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 96);
			return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < -48 && log.getLogPosX() - map.frog.getPlayerPosX() > -80 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 64);
			return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < -16 && log.getLogPosX() - map.frog.getPlayerPosX() > -48 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX() + 32);
			return true;
		}
		else if (log.getLogPosX() - map.frog.getPlayerPosX() < 16 && log.getLogPosX() - map.frog.getPlayerPosX() > -16 && 
				log.getLogPosY() == map.frog.getPlayerPosY()) {
			map.frog.setPosX(log.getLogPosX());
			return true;
		}
		return false;
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	

