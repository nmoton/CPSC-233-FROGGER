package frogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameGraphics extends JPanel {
	
	private int gameMode;
	private Frog userFrog;
	private Log[][] logArray;
	private Turtle[][] turtleArray;
	private Vehicle[][] vehicleArray;
	
	private BufferedImage mainMenu;
	private BufferedImage pointTable;
	private BufferedImage gameOver;
	private BufferedImage youWin;
	private BufferedImage scoreBoard;
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
	
	public GameGraphics(){
		try {
			mainMenu = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\mainMenu.png"));
			pointTable = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\pointTable.png"));
			gameOver = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\gameOver.png"));
			youWin = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\youWin.png"));
			scoreBoard = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\scoreBoard.png"));
			background = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\background.jpg"));
			upFrog = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\upFrog.png"));
			downFrog = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\downFrog.png"));
			leftFrog = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\leftFrog.png"));
			rightFrog = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\rightFrog.png"));
			log3L = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\log3L.png"));
			log5L = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\log5L.png"));
			log7L = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\log7L.png"));
			truck = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\truck.png"));
			pinkCar = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\pinkCar.png"));
			yellowCar = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\yellowCar.png"));
			bulldozer = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\bulldozer.png"));
			racecar = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\racecar.png"));
			turtle2L = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\turtle2L.png"));
			turtle3L = ImageIO.read(new File("C:\\Users\\PheeeG\\OneDrive - University of Calgary\\Frogger\\resources\\turtle3L.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
	

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		if (gameMode == -1) {
			g.drawImage(mainMenu, 0, 0, null);
		}
		
		else if (gameMode == 0) {
			g.drawImage(pointTable, 0, 0, null);
		}
		
		else if (gameMode == 4) {
			g.drawImage(background, 0, 0, null);
			g.drawImage(youWin, 0, 0, null);
		}
		
		else if (gameMode == 5) {
			g.drawImage(background, 0, 0, null);
			g.drawImage(gameOver, 0, 0, null);
		}
		
		else if (gameMode == 6) {
			g.drawImage(scoreBoard, 0, 0, null);
		}
				
		else if (gameMode >= 1 && gameMode <= 3) {
			//Drawing background:
			g.drawImage(background, 0, 0, null);
		
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
		}
	}

	public void getUserFrog(Frog mapFrog) {
		this.userFrog = mapFrog;
	}
	
	public void getMapLogs(Log[][] mapLogArray) {
		this.logArray = mapLogArray;
	}
	
	public void getMapTurtles(Turtle[][] mapTurtleArray) {
		this.turtleArray = mapTurtleArray;
	}
	
	public void getMapVehicles(Vehicle[][] mapVehicleArray) {
		this.vehicleArray = mapVehicleArray;
	}
	
	public void getGameMode(int gameMode) {
		this.gameMode = gameMode;
	}
}
