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

/**
 * @author Nathan Moton
 * @editors Michael Manila, Justin Flores
 *
 *The gameplay class is a game engine that deals entirely with all features and logic of the game; this includes game logic, 
 * game physics, graphics, sounds, player controls, game modes, collision detection, end zones, and ultimately the game's timer.
 *
 * Last Updated:08/14/2018
 */
public class Gameplay extends JPanel implements KeyListener, ActionListener{
	
	/**
	* 
	* CHANGE THESE VALUES BELOW TO ENABLE/DISABLE COLLISIONS, WATER DETECTION, AND END-ZONES:
	* 
	*/
	private static boolean TOGGLE_COLLISION = true; //Car collisions
	private static boolean TOGGLE_WATER = true; //Water tiles
	private static boolean TOGGLE_ENDZONE = true; //Clearing maps
	private static boolean TOGGLE_FROGBOUNDARY = true; //Frog exiting the game screen
	
	/**
	 * 
	 * CHANGE THIS VALUE TO CHANGE THE INTERVAL/HOW LONG THE DEATH SCREEN APPEARS FOR
	 * 
	 */
	
	private int deathTime = 2500; //game ticks in milliseconds
	
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
	private LevelOne map1 = new LevelOne();
	private LevelTwo map2 = new LevelTwo();
	private LevelThree map3 = new LevelThree();
	
	public Score score;
	public HighscoreManager hm = new HighscoreManager();
	
	/**
	 *  This constructor:
	 *  	i) Loads and initializes game sounds
	 *  	ii) Creates key listeners for user interaction (checks for valid key presses)
	 * 		iii) Creates a new timer based on the delay (game tick) that will create an action event
	 * 			 after every game tick passes
	 */
	public Gameplay() {
		/**
		 * ENSURE THE FILE DIRECTORIES ARE CORRECT
		 */
		try {
			frogHop = new File("C:\\Users\\Nate\\Desktop\\Frogger Sounds\\sound-frogger-hop.wav\\");
			startGame = new File("C:\\Users\\Nate\\Desktop\\Frogger Sounds\\sound-frogger-coin-in.wav\\");
			carCollision = new File("C:\\Users\\Nate\\Desktop\\Frogger Sounds\\sound-frogger-plunk.wav\\");
			fallWater = new File("C:\\Users\\Nate\\Desktop\\Frogger Sounds\\sound-frogger-squash.wav\\");
			newMap = new File("C:\\Users\\Nate\\Desktop\\Frogger Sounds\\sound-frogger-extra.wav\\");
		}
		
		catch (Exception e){
			System.out.println("Failed to load sounds. No sounds will be played.");
		}
		
		map.graphicsEngine.setGameMode(getGameMode());
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
	}
	
	/**
	 * This method passes the Graphics object "g" to the active graphicsEngine object. In theory, this forces
	 * the graphics engine to deal with painting the sprites and other graphical data onto the game window, ultimately
	 * splitting the tasks between both engines and reducing the code for the game engine.
	 * 
	 * @param g, Graphics object that deals with all drawing to the game window
	 * 	(https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html)
	 */
	public void paintComponent(Graphics g) {
		map.graphicsEngine.paintComponent(g);
	}
	
	
	/**
	 * Method that is called after an ActionEvent object is created (either by user interaction or game ticks).
	 * This method:
	 * 		i) Uses a switch statement to load data based on the game mode; this ultimately changes what appears on the game window.
	 * 		ii) Checks to see if user has cleared the map or died (via collisions, water tiles, and exiting the game window).
	 * 		iii) Updates all graphical components in the game window.
	 */
	public void actionPerformed(ActionEvent e) {
		
		switch(this.gameMode) {
			case -1: //Main Menu
				map.graphicsEngine.setGameMode(getGameMode());
				break;
			case 0: //Point Table
				playSound(startGame);
				map.graphicsEngine.setGameMode(getGameMode());
				break;
			case 1: //First Level
				map = map1;
				map.graphicsEngine.setBestScores(hm.getHighscoreString());
				map.graphicsEngine.setGameMode(getGameMode());
				break;
			case 2: //Second Level
				map = map2;
				map.graphicsEngine.setGameMode(getGameMode());
				map.graphicsEngine.setBestScores(hm.getHighscoreString());
				map.graphicsEngine.getGameScore(score.updateScore(map.frog.getPlayerPosY()));
				break;
			case 3: //Third Level
				map = map3;
				map.graphicsEngine.setGameMode(getGameMode());
				map.graphicsEngine.setBestScores(hm.getHighscoreString());
				map.graphicsEngine.getGameScore(score.updateScore(map.frog.getPlayerPosY()));
				break;
			case 4: //Game End - Lose
				map.graphicsEngine.setGameMode(getGameMode());
				break;
			case 5: //Game End - Win
				map.graphicsEngine.setGameMode(getGameMode());
				break;
			case 6: //Show score board
				map.graphicsEngine.setGameMode(getGameMode());
				break;
		}
		
		//Checks to see if user entered the end zone:
		if (TOGGLE_ENDZONE) {
			checkFrogEndZoneBoundary();
		}
		
		//Checks to see if user has exited the game window by riding a log/turtle:
		if (TOGGLE_FROGBOUNDARY) {
			checkFrogInBounds();
		}
		
		//Checks logs, vehicles, and trucks for collisions:
		checkLogs(map.logArray);
		checkVehicles(map.vehicleArray);
		checkTurtles(map.turtleArray);
		
		//Forces the graphics engine to update the graphical components on the screen:
		repaint();
	}
	
	/**
	 * Method that checks to see if the frog is within the map's boundaries. If the frog is outside
	 * the map's boundaries, the user will die, the timer stops, and the game will pause for short period to notify the user
	 * they died due to their failure to stay within the boundaries.
	 */
	private void checkFrogInBounds(){
		if (map.frog.getPlayerPosX() < 0 || map.frog.getPlayerPosX() + 32 > 640) {
			timer.stop();
			playSound(fallWater);
			setGameMode(5);
			map.graphicsEngine.setGameMode(getGameMode());
			
			// Pauses the game for a short period to notify the user of how they died:
			try {
				Thread.sleep(this.deathTime);
			} catch (InterruptedException e) {
				
			}
			
			repaint();
		}
	}
	
	/**
	 * Method that checks to see if the frog is within the map's end zone. If the frog is inside
	 * the map's end zone, the user will either move onto the next level or win the game. The game will pause
	 * for a short period to notify the user they won the game and cleared the final map.
	 */
	private void checkFrogEndZoneBoundary() {
		if (map.frog.getPlayerPosY() <= map.getEndZoneYBoundary2() && !checkEndZone(map.getEndZoneXBoundary1(), map.getEndZoneYBoundary1(), map.getEndZoneXBoundary2(),
				map.getEndZoneYBoundary2(), map.frog.getPlayerPosX(), map.frog.getPlayerPosY())) {
			timer.stop();
			playSound(fallWater);
			setGameMode(5);
			map.graphicsEngine.setGameMode(getGameMode());
			
			// Pauses the game for a short period to notify the user that they won the game:
			try {
				Thread.sleep(this.deathTime);
			} catch (InterruptedException e) {
				
			}
			
			repaint();
		}
	}
	
	/**
	 * Method that checks to see if the frog is actively riding on a log when on water tiles. If a user is on
	 * water tiles but not standing on a log, this method will call the helper method "checkWater"; said method will
	 * verify the player is indeed on a water tile and penalize the player accordingly.
	 * 
	 * This method checks the 2D array of logs based on the current map loaded and compares the user's x and y coordinates
	 * with the x and y coordinates of every log on the current map. If the coordinates line up properly, the user's x
	 * coordinates will line up with the log's x coordinates making the user appear to "ride the log".
	 * 
	 * When comparing x coordinates, this method will effectively "round" a user's x coordinates to the most fitting
	 * x coordinates of the log. This allows users to anticipate and time when they choose to jump on the log.
	 * 
	 * @param logArray, the loaded map's 2D array of logs. This 2D array of logs is loaded via a "memory leak" and contains
	 * the data of all the logs in the map.
	 */
	private void checkLogs(Log[][] logArray) {
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

	/**
	 * Method that utilizes the  helper functions vehicleBoundaryRightBound, vehicleBoundaryLeftBound, vehicleCollisionRightBound, and
	 * vehicleCollisionLeftBound to check if all vehicles in the current map's 2D vehicle array have collided with the user
	 * or left the map's boundaries.
	 * 
	 * @param vehicleArray, the loaded map's 2D array of vehicles. This 2D array of vehicles is loaded via a "memory leak" and contains
	 * the data of all the vehicles in the map.
	 */
	private void checkVehicles(Vehicle[][] vehicleArray) {
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
	
	/**
	 * Method that checks to see if the frog is actively riding on a turtle when on water tiles. If a user is on
	 * water tiles but not standing on a turtle, this method will call the helper method "checkWater"; said method will
	 * verify the player is indeed on a water tile and penalize the player accordingly.
	 * 
	 * This method checks the 2D array of turtle based on the current map loaded and compares the user's x and y coordinates
	 * with the x and y coordinates of every turtle on the current map. If the coordinates line up properly, the user's x
	 * coordinates will line up with the turtle's x coordinates making the user appear to "ride the turtle".
	 * 
	 * When comparing x coordinates, this method will effectively "round" a user's x coordinates to the most fitting
	 * x coordinates of the turtle. This allows users to anticipate and time when they choose to jump on the turtle.
	 * 
	 * @param turtleArray, the loaded map's 2D array of turtles. This 2D array of turtles is loaded via a "memory leak" and contains
	 * the data of all the turtles in the map.
	 */
	private void checkTurtles(Turtle[][] turtleArray) {
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
	
	/**
	 * Method that compare's a user's x and y coordinates with the x and y coordinates of a set of water tiles. If a user is
	 * indeed standing on a water tile, the user will die.
	 * 
	 * @param xBoundary1, the x coordinate of the first vertex of the set of water titles.
	 * @param yBoundary1, the y coordinate of the first vertex of the set of water titles.
	 * @param xBoundary2, the x coordinate of the second vertex of the set of water titles.
	 * @param yBoundary2, the y coordinate of the second vertex of the set of water titles.
	 * @param userPosX, the user's x coordinate.
	 * @param userPosY, the user's y coordinate.
	 */
	private void checkWater(int xBoundary1, double yBoundary1, int xBoundary2, double yBoundary2, double userPosX, double userPosY) {
		if (userPosX >= xBoundary1 && userPosX <= xBoundary2 && userPosY >= yBoundary1 && userPosY <= yBoundary2) {
			playSound(fallWater);
			setGameMode(5);
			map.graphicsEngine.setGameMode(getGameMode());
			
			// Pauses the game for a short period to notify the user of how they died:
			try {
				Thread.sleep(this.deathTime);
			} catch (InterruptedException e) {
				
			}
			
			timer.stop();
			repaint();
		}
	}
	
	/**
	 * Method that compare's a user's x and y coordinates with the x and y coordinates of the loaded map's end zone. If a user is
	 * indeed standing in the end zone, the user will win the game.
	 * 
	 * @param xBoundary1, the x coordinate of the first vertex of the set of end zone titles.
	 * @param yBoundary1, the y coordinate of the first vertex of the set of end zone titles.
	 * @param xBoundary2, the x coordinate of the second vertex of the set of end zone titles.
	 * @param yBoundary2, the y coordinate of the second vertex of the set of end zone titles.
	 * @param userPosX, the user's x coordinate.
	 * @param userPosY, the user's y coordinate.
	 * @return returns whether or not the user is indeed in the end zone.
	 */
	private boolean checkEndZone(int xBoundary1, int yBoundary1, int xBoundary2, int yBoundary2, double userPosX, double userPosY) {
		if (userPosX >= xBoundary1 && userPosX <= xBoundary2 && userPosY >= yBoundary1 && userPosY <= yBoundary2) {
			this.gameMode++;
			score.clearLevelScore();
			score.setHighestPosY(480);
			
			if (this.gameMode == 4) {
				timer.stop();
				map.graphicsEngine.setGameMode(getGameMode());
				repaint();
				return true;
			}
			
			else {
				playSound(newMap);
				return true;
			}
			
		}
		return false;
	}
	
	
	/**
	 * Getter method that returns the current game mode.
	 * 
	 * @return returns the current game mode
	 */
	private int getGameMode() {
		return this.gameMode;
	}
	
	/**
	 * Setter method that sets the current game mode as long as the user chosen game mode is between -1 and 6.
	 */
	private void setGameMode(int gMode){
		if(gMode >= -1 && gMode <= 6){
			this.gameMode = gMode;
		}
	}
	
	/**
	 * Method that will play the appropriate sound effect.
	 * 
	 * @param Sound, the sound required to be played.
	 */
	private void playSound(File Sound) {
		try {
			Clip soundEffect = AudioSystem.getClip();
			soundEffect.open(AudioSystem.getAudioInputStream(Sound));
			soundEffect.start();
		}
		catch (Exception e) {
			System.out.println("Failed to play: " + Sound);
		}
	}

	/**
	 * Method that will call helper functions when a KeyEvent object is created (when a user presses a key).
	 * 
	 * @param e, a KeyEvent object that is automatically created by the KeyListener when a key is pressed.
	 */
	public void keyPressed(KeyEvent e) {
		
		if (this.gameMode < 1 || this.gameMode > 3) {
			/**
			 * MAIN MENU:
			 * If user presses a key:
			 * 		i) Start game sound effect is played
			 * 		ii) Score system activates
			 * 		iii) Game mode changes to mode 0 (instructions)
			 */
			if (gameMode == -1) {
				playSound(startGame);
				this.gameMode++;
				score = new Score(480.0);
				hm.saveScore(score);
				map.graphicsEngine.setGameMode(getGameMode());
				repaint();
			}
			
			/**
			 * INSTRUCTIONS:
			 * If user presses a key:
			 * 		i) Game timer starts
			 * 		ii) New map sound effect is played
			 * 		iii) Game mode changes to mode 1 (first map)
			 */
			else if (this.gameMode == 0) {
				timer.start();
				this.gameMode++;
				map.graphicsEngine.setGameMode(getGameMode());
				playSound(newMap);
			}

			/**
			 * GAME OVER/YOU WIN SCREEN:
			 * If user presses a key:
			 * 		i) Score is saved
			 * 		ii) All maps are re-loaded
			 * 		iii) Game timer stops
			 * 		iv) Game mode changes to mode 6 (first map)
			 * 		v) Score display data is updated
			 */
			else if (this.gameMode == 4 || this.gameMode == 5){
				hm.saveScore(score);
				map1 = new LevelOne();
				map2 = new LevelTwo();
				map3 = new LevelThree();
				timer.stop();
				setGameMode(6);
				map.graphicsEngine.setGameMode(getGameMode());
				map.graphicsEngine.setBestScores(hm.getHighscoreString());
				repaint();
			}
			
			/**
			 * HIGH SCORE LIST:
			 * If user presses a key:
			 * 		i) Game mode is reset to the main menu.
			 */
			else if (this.gameMode == 6) {
				setGameMode(-1);
				map.graphicsEngine.setGameMode(getGameMode());
				repaint();
			}
		}
		
		/**
		 * IN-GAME:
		 * If user presses a key:
		 * 		i) Frog moves in the proper direction based on key presses
		 * 		ii) Score updates accordingly
		 * 		iii) Frog hop sound effect plays
		 */
		else {
			//Up arrow key or W key
			if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
				playSound(frogHop);
				map.graphicsEngine.getGameScore(score.updateScore(map.frog.getPlayerPosY()));
				map.frog.moveUp();
				map.graphicsEngine.setBestScores(hm.getHighscoreString());
			}
			
			//Down arrow key or S key
			else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
				playSound(frogHop);
				map.frog.moveDown();
			}
			
			//Right arrow key or D key
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
				playSound(frogHop);
				map.frog.moveRight();			
			}
			
			//Left arrow key or A key
			else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
				playSound(frogHop);
				map.frog.moveLeft();
			}
		}
	}
	
	
	/**
	 * Method that will check and place right bound vehicles outside of the map's boundaries back to the left part of the screen. 
	 * This ultimately lets the program re-use vehicles.
	 * 
	 * @param vehicle, the right bound vehicle that is being checked
	 */
	private void vehicleBoundaryRightBound(Vehicle vehicle) {
		if (vehicle.getVehiclePosX() >= 640.0 + (vehicle.getVehicleLength() * 32)) {
			vehicle.setVehiclePosX(-30.0 - (vehicle.getVehicleLength() * 32));
		}
	}
	
	/**
	 * Method that will check and place left bound vehicles outside of the map's boundaries back to the right part of the screen. 
	 * This ultimately lets the program re-use vehicles.
	 * 
	 * @param vehicle, the left bound vehicle that is being checked
	 */
	private void vehicleBoundaryLeftBound(Vehicle vehicle) {
		if (vehicle.getVehiclePosX() <= - (vehicle.getVehicleLength() * 32)) {
			vehicle.setVehiclePosX(670.0 + (vehicle.getVehicleLength() * 32));
		}
	}
	
	/**
	 * Method that compares a right bound vehicle's x and y coordinates and the user's x and y coordinate's. If the pairs of coordinates
	 * line up, it is determined the vehicle has collided with the user and the game will end. The game will pause
	 * for a short period to notify the user they died due to a collision.
	 * 
	 * This method also checks to see if the user has collided with the middle or rear of the vehicle preventing no-clipping.
	 * 
	 * @param vehicle, the right bound vehicle being checked/compared with
	 */
	private void vehicleCollisionRightBound(Vehicle vehicle) {
		if (map.frog.getPlayerPosX() - vehicle.getVehiclePosX() < 32 && map.frog.getPlayerPosX() - vehicle.getVehiclePosX() > -20 &&
					vehicle.getVehiclePosY() == map.frog.getPlayerPosY()) {
				timer.stop();
				setGameMode(5);
				playSound(carCollision);
				map.graphicsEngine.setGameMode(getGameMode());
				
				try {
					Thread.sleep(this.deathTime);
				} catch (InterruptedException e) {
					
				}
				
				repaint();
				}
		}
	
	/**
	 * Method that compares a left bound vehicle's x and y coordinates and the user's x and y coordinate's. If the pairs of coordinates
	 * line up, it is determined the vehicle has collided with the user and the game will end. The game will pause
	 * for a short period to notify the user they died due to a collision.
	 * 
	 * This method also checks to see if the user has collided with the middle or rear of the vehicle preventing no-clipping.
	 * 
	 * @param vehicle, the left bound vehicle being checked/compared with
	 */
	private void vehicleCollisionLeftBound (Vehicle vehicle) {
		//Checks for vehicles of length 2 (trucks)
		if (vehicle.getVehicleLength() == 2) {
			if (map.frog.getPlayerPosX() - vehicle.getVehiclePosX() > -32 && map.frog.getPlayerPosX() - vehicle.getVehiclePosX() < 48 &&
						vehicle.getVehiclePosY() == map.frog.getPlayerPosY()) {
					timer.stop();
					setGameMode(5);
					playSound(carCollision);
					map.graphicsEngine.setGameMode(getGameMode());
					
					try {
						Thread.sleep(this.deathTime);
					} catch (InterruptedException e) {
						
					}
					
					repaint();
					}
		}
		
		//Checks for vehicles of length 1 (cars)
		else {
			if (map.frog.getPlayerPosX() - vehicle.getVehiclePosX() > -32 && map.frog.getPlayerPosX() - vehicle.getVehiclePosX() < 20 &&
					vehicle.getVehiclePosY() == map.frog.getPlayerPosY()){
				timer.stop();
				setGameMode(5);
				playSound(carCollision);
				map.graphicsEngine.setGameMode(getGameMode());
				
				try {
					Thread.sleep(this.deathTime);
				} catch (InterruptedException e) {
					
				}
				
				repaint();
			}
		}
	}
	
	/**
	 * Method that will check and place right bound logs outside of the map's boundaries back to the left part of the screen. 
	 * This ultimately lets the program re-use logs.
	 * 
	 * @param log, the right bound log that is being checked
	 */
	private void logBoundaryRightBound (Log log) {
		if (log.getLogPosX() >= 640 + (log.getLogLength() * 32)) {
			log.setLogPosX(-30.0 - (log.getLogLength() * 32));
		}
	}
	
	/**
	 * Method that will check and place left bound logs outside of the map's boundaries back to the right part of the screen. 
	 * This ultimately lets the program re-use logs.
	 * 
	 * @param log, the left bound log that is being checked
	 */
	private void logBoundaryLeftBound (Log log) {
		if (log.getLogPosX() <= -(log.getLogLength() * 32)) {
			log.setLogPosX(670);
		}
	}
	
	/**
	 * Method that will check and place left bound turtles outside of the map's boundaries back to the right part of the screen. 
	 * This ultimately lets the program re-use vehicles.
	 * 
	 * @param vehicle, the left bound vehicle that is being checked
	 */
	private void turtleBoundaryLeftBound (Turtle turtle) {
		if (turtle.getTurtlePosX() <= -(turtle.getTurtleLength() * 32)) {
			turtle.setTurtlePosX(670);
		}
	}
	
	/**
	 * Helper methods that check to see if the frog is actively riding on a turtle when on water tiles.
	 * 
	 * These methods check an individual turtle based on the current map loaded and the checkTurtles function and 
	 * compares the user's x and y coordinates with the x and y coordinates of said turtle. 
	 * If the coordinates line up properly, the user's x coordinates will line up with the turtle's x coordinates 
	 * making the user appear to "ride the turtle".
	 * 
	 * When comparing x coordinates, this method will effectively "round" a user's x coordinates to the most fitting
	 * x coordinates of the turtle. This allows users to anticipate and time when they choose to jump on the turtle.
	 * 
	 * @param turtle, the individual turtle being checked/compared coordinates with based on the checkTurtles function.
	 * @return returns whether or not the user is indeed on a turtle or not
	 */
	private boolean userOnTurtle2L (Turtle turtle) { //For Left-Bound Turtles of length 2
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
	
	private boolean userOnTurtle3L (Turtle turtle) { //for Left-Bound Turtles of length 3
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
	
	/**
	 * Helper methods that check to see if the frog is actively riding on a log when on water tiles.
	 * 
	 * These methods check an individual turtle based on the current map loaded and the checkLogs function and 
	 * compares the user's x and y coordinates with the x and y coordinates of said log 
	 * If the coordinates line up properly, the user's x coordinates will line up with the log's x coordinates 
	 * making the user appear to "ride the log".
	 * 
	 * When comparing x coordinates, this method will effectively "round" a user's x coordinates to the most fitting
	 * x coordinates of the log. This allows users to anticipate and time when they choose to jump on the log.
	 * 
	 * @param log, the individual log being checked/compared coordinates with based on the checkLogs function.
	 * @return returns whether or not the user is indeed on a log or not
	 */
	private boolean userOnLog3R (Log log) { //for Right-Bound Logs of length 3
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
		
	private boolean userOnLog5R (Log log) { //for Right-Bound Logs of length 5
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
	
	private boolean userOnLog7R (Log log) { //for Right-Bound Logs of length 7
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
	
	private boolean userOnLog3L (Log log) { //for Left-Bound Logs of length 3
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
	
	private boolean userOnLog5L (Log log) { //for Left-Bound Logs of length 5
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
	
	private boolean userOnLog7L (Log log) { //for Left-Bound Logs of length 7
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

	
	/**
	 * UNUSED REQUIRED METHODS
	 */
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	

