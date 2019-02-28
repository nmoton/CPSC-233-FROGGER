package frogger;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author Nathan Moton
 * @editors Michael Manila
 *
 * The GameGraphics class is a graphics engine that deals entirely with all graphical features of the game. This includes
 * drawing the frog, logs, vehicles, and turtles to the map; loading the menus, and drawing the score onto the screen. 
 *
 * Last Updated:08/14/2018
 */
public class GameGraphics extends JPanel {
	
	private int gameMode;
	private String gameScore = "0";
	private Frog userFrog;
	private Log[][] logArray;
	private Turtle[][] turtleArray;
	private Vehicle[][] vehicleArray;
	private String best = "0";
	private String secondBest = "0";
	private String thirdBest = "0";
	private String fourthBest = "0";
	private String fifthBest = "0";
	private String highestScore = "0";

	
	private Font highscoreFont;
	private Font customFont;
	private BufferedImage mainMenu;
	private BufferedImage pointTable;
	private BufferedImage gameOver;
	private BufferedImage youWin;
	private BufferedImage scoreBoard;
	private BufferedImage map1;
	private BufferedImage map2;
	private BufferedImage map3;
	private BufferedImage background;
	private BufferedImage upFrog;
	private BufferedImage downFrog;
	private BufferedImage leftFrog;
	private BufferedImage rightFrog;
	private BufferedImage log3L;
	private BufferedImage log5L;
	private BufferedImage log7L;
	private BufferedImage truck;
	private BufferedImage pinkCar;
	private BufferedImage yellowCar;
	private BufferedImage bulldozer;
	private BufferedImage racecar;
	private BufferedImage turtle2L;
	private BufferedImage turtle3L;
	
	/**
	 * 
	 * ENSURE THE FILE DIRECTORIES ARE CORRECT
	 * 
	 * Default constructor that loads all required game images, fonts, and sprites.
	 */
	public GameGraphics(){
		//Loading all images and sprites
		try {
			mainMenu = ImageIO.read(new File(".\\resources\\mainMenu.png"));
			pointTable = ImageIO.read(new File(".\\resources\\pointTable.png"));
			gameOver = ImageIO.read(new File(".\\resources\\gameOver.png"));
			youWin = ImageIO.read(new File(".\\resources\\youWin.png"));
			scoreBoard = ImageIO.read(new File(".\\resources\\scoreBoard.png"));
			map1 = ImageIO.read(new File(".\\resources\\map1.png"));
			map2 = ImageIO.read(new File(".\\resources\\map2.png"));
			map3 = ImageIO.read(new File(".\\resources\\map3.png"));
			upFrog = ImageIO.read(new File(".\\resources\\upFrog.png"));
			downFrog = ImageIO.read(new File(".\\resources\\downFrog.png"));
			leftFrog = ImageIO.read(new File(".\\resources\\leftFrog.png"));
			rightFrog = ImageIO.read(new File(".\\resources\\rightFrog.png"));
			log3L = ImageIO.read(new File(".\\resources\\log3L.png"));
			log5L = ImageIO.read(new File(".\\resources\\log5L.png"));
			log7L = ImageIO.read(new File(".\\resources\\log7L.png"));
			truck = ImageIO.read(new File(".\\resources\\truck.png"));
			pinkCar = ImageIO.read(new File(".\\resources\\pinkCar.png"));
			yellowCar = ImageIO.read(new File(".\\resources\\yellowCar.png"));
			bulldozer = ImageIO.read(new File(".\\resources\\bulldozer.png"));
			racecar = ImageIO.read(new File(".\\resources\\racecar.png"));
			turtle2L = ImageIO.read(new File(".\\resources\\turtle2L.png"));
			turtle3L = ImageIO.read(new File(".\\resources\\turtle3L.png"));
			
		} catch (IOException e) {
			
		}
		
		//Loading all fonts
		try {
			this.customFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Nate\\Desktop\\Frogger Graphics\\Pixeled.ttf")).deriveFont(12f);
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\\\Users\\\\Nate\\\\Desktop\\\\Frogger Graphics\\\\Pixeled.ttf")));
		
			this.highscoreFont = customFont.deriveFont(16f);
			
		} catch (IOException|FontFormatException e) {
			
		}
	}
	
	/**
	 * Method that will draw the proper graphical components to the screen depending on the game mode (set by the game engine).
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		//The main menu
		if (gameMode == -1) {
			g.drawImage(mainMenu, 0, 0, null);
		}
		
		//The instructions/point table
		else if (gameMode == 0) {
			g.drawImage(pointTable, 0, 0, null);
		}
		
		//The maps that are loaded in-game
		else if (gameMode > 0 && gameMode < 6) {
			
			if (gameMode == 3) {
				this.background = map3;
			}
			
			else if (gameMode == 2) {
				this.background = map2;
			}
			
			else {
				this.background = map1;
			}
			
			
			
			//Drawing background:
			g.drawImage(background, 0, 0, null);
			
			//Drawing Score:
			g.setColor(Color.red);
			g.setFont(this.customFont);
			g.drawString(this.gameScore, 126, 36);
			g.drawString(this.highestScore, 450, 36);
		
			//Drawing Logs:
			for (int i = 0; i < logArray.length; i++) {
				for (int j = 0; j < logArray[i].length; j++) {
					if (logArray[i][j].isLogRightBound() == true) {
						logArray[i][j].moveLogRightX();
					
						AffineTransform logPosXY = new AffineTransform();
						logPosXY.translate(logArray[i][j].getLogPosX(), logArray[i][j].getLogPosY());
					
						if (logArray[i][j].getLogLength() == 3) {
							g2.drawImage(log3L, logPosXY, null);
						}
						
						else if (logArray[i][j].getLogLength() == 5) {
							g2.drawImage(log5L, logPosXY, null);
						}
						
						else {
							g2.drawImage(log7L, logPosXY, null);
						}
					
					}
					
					else if (logArray[i][j].isLogRightBound() == false) {
						logArray[i][j].moveLogLeftX();
					
						AffineTransform logPosXY = new AffineTransform();
						logPosXY.translate(logArray[i][j].getLogPosX(), logArray[i][j].getLogPosY());
					
						if (logArray[i][j].getLogLength() == 3) {
							g2.drawImage(log3L, logPosXY, null);
						}
						
						else if (logArray[i][j].getLogLength() == 5) {
							g2.drawImage(log5L, logPosXY, null);
							
						}
						
						else {
						g2.drawImage(log7L, logPosXY, null);
						}
					
					}
				}
			}
			
			//Drawing Vehicles:
			g2.setColor(Color.red);
			for (int i = 0; i < vehicleArray.length; i++) {
				for (int j = 0; j < vehicleArray[i].length; j++) {
					if (vehicleArray[i][j].isVehicleRightBound() == true) {
						vehicleArray[i][j].moveVehicleRightX();
						AffineTransform vehiclePosXY = new AffineTransform();
						vehiclePosXY.translate(vehicleArray[i][j].getVehiclePosX(), vehicleArray[i][j].getVehiclePosY());
					
						if (vehicleArray[i][j].getVehicleAcceleration() >= 0.75) {
							g2.drawImage(racecar, vehiclePosXY, null);
						}
						
						else {
							g2.drawImage(bulldozer, vehiclePosXY, null);
						}
					}

					
					if (vehicleArray[i][j].isVehicleRightBound() == false) {
						vehicleArray[i][j].moveVehicleLeftX();
						AffineTransform vehiclePosXY = new AffineTransform();
						vehiclePosXY.translate(vehicleArray[i][j].getVehiclePosX(), vehicleArray[i][j].getVehiclePosY());
					
						if (vehicleArray[i][j].getVehicleLength() == 2) {
							g2.drawImage(truck, vehiclePosXY, null);
						}
						
						else if (vehicleArray[i][j].getVehicleLength() == 1) {
							if (vehicleArray[i][j].getVehicleAcceleration() <= 0.65) {
								g2.drawImage(pinkCar, vehiclePosXY, null);
							}
						
							else {
								g2.drawImage(yellowCar, vehiclePosXY, null);
							}
							
						}
					}
				}
			}
		
			//Drawing Turtles:
			g2.setColor(Color.yellow);
			for (int i = 0; i < turtleArray.length; i++) {
				for (int j = 0; j < turtleArray[i].length; j++) {
					turtleArray[i][j].moveTurtleX();
					AffineTransform turtlePosXY = new AffineTransform();
					turtlePosXY.translate(turtleArray[i][j].getTurtlePosX(), turtleArray[i][j].getTurtlePosY());
				
					if (turtleArray[i][j].getTurtleLength() == 2) {
						g2.drawImage(turtle2L, turtlePosXY, null);
					}
				
					else {
						g2.drawImage(turtle3L, turtlePosXY, null);
					}
				}
			}
			
			//Drawing Frog:
			AffineTransform frogPosXY = new AffineTransform();
			frogPosXY.translate(userFrog.getPlayerPosX(), userFrog.getPlayerPosY());
			if (userFrog.getLastFacing() == 'U') {
				g2.drawImage(upFrog, frogPosXY, null);
			}
		
			else if (userFrog.getLastFacing() == 'D') {
				g2.drawImage(downFrog, frogPosXY, null);
			}
		
			else if (userFrog.getLastFacing() == 'L') {
				g2.drawImage(leftFrog, frogPosXY, null);
			}
		
			else {
				g2.drawImage(rightFrog, frogPosXY, null);
			}
			
			
			if (gameMode == 4) {
				g.drawImage(youWin, 0, 0, null);
			}
			
			else if (gameMode == 5) {
				g.drawImage(gameOver, 0, 0, null);
			}
		}
			
		//Drawing the score board
		else {
			g.drawImage(scoreBoard, 0, 0, null);
			g.setColor(Color.white);
			g.setFont(this.highscoreFont);
			g.drawString(best, 390, 274);
			g.drawString(secondBest, 390, 305);
			g.drawString(thirdBest, 390, 336);
			g.drawString(fourthBest, 390, 367);
			g.drawString(fifthBest, 390, 393);
		}
	}

	/**
	 * Setter method that gets the frog from the loaded map. This utilizes memory leaks, as
	 * now the map, game engine, and now graphics engine will all utilize the same frog.
	 * 
	 * @param mapFrog, frog set and used by the loaded map.
	 */
	public void getUserFrog(Frog mapFrog) {
		this.userFrog = mapFrog;
	}
	
	/**
	 * Setter method that gets the 2D log array from the loaded map. This utilizes memory leaks, as
	 * now the map, game engine, and now graphics engine will all utilize the same 2D log array.
	 * 
	 * @param mapLogArray, 2D log array set and used by the loaded map.
	 */
	public void getMapLogs(Log[][] mapLogArray) {
		this.logArray = mapLogArray;
	}
	
	/**
	 * Setter method that gets the 2D turtle array from the loaded map. This utilizes memory leaks, as
	 * now the map, game engine, and now graphics engine will all utilize the same 2D turtle array.
	 * 
	 * @param mapLogArray, 2D turtle array set and used by the loaded map.
	 */
	public void getMapTurtles(Turtle[][] mapTurtleArray) {
		this.turtleArray = mapTurtleArray;
	}
	
	/**
	 * Setter method that gets the 2D vehicle array from the loaded map. This utilizes memory leaks, as
	 * now the map, game engine, and now graphics engine will all utilize the same 2D vehicle array.
	 * 
	 * @param mapVehicleArray, 2D vehicle array set and used by the loaded map.
	 */
	public void getMapVehicles(Vehicle[][] mapVehicleArray) {
		this.vehicleArray = mapVehicleArray;
	}
	
	/**
	 * Setter method that sets the gameMode used by the graphics engine. This value is taken from the game engine.
	 * 
	 * @param gameMode, game mode set by the game engine.
	 */
	public void setGameMode(int gameMode) {
		this.gameMode = gameMode;
	}
	
	/**
	 * Setter method that gets the game score set by the game engine and scoring manager.
	 * 
	 * @param gameScore, user's score set by the game engine and scoring manager.
	 */
	public void getGameScore(String gameScore) {
		this.gameScore = new String (gameScore);
	}
	
	/**
	 * Setter method that gets the game score set by the scoring manager.
	 * 
	 * @param gameScore, user's score set and used by the scoring manager.
	 */
	public void setBestScores(String highestScores){
		if(highestScores.length() >= 5){
			best = highestScores.substring(0,4);
			if(highestScores.length() >= 10) {
				secondBest = highestScores.substring(5, 9);
				if (highestScores.length() >= 15) {
					thirdBest = highestScores.substring(10, 14);
					if (highestScores.length() >= 20) {
						fourthBest = highestScores.substring(15, 19);
						if (highestScores.length() == 25) {
							fifthBest = highestScores.substring(20, 24);
						}
					}
				}
			}
			int intBest = Integer.parseInt(best.trim());
			int intScore = Integer.parseInt(gameScore.trim());
			if(intBest < intScore){
				highestScore = gameScore;
			}
			else{
				highestScore = best;
			}
		}
	}
}
