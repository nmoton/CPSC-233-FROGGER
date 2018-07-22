package frogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class GameGraphics extends JPanel {
	
	private Frog userFrog;
	private Log[][] logArray;
	private Turtle[][] turtleArray;
	private Vehicle[][] vehicleArray;
	
	public GameGraphics(){
	}
	

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		//Drawing background:
		g2.setColor(Color.black);
		g2.fillRect(0, 0, 640, 480);
		
		//Drawing Logs:
		g2.setColor(Color.cyan);
		for (int i = 0; i < logArray.length; i++) {
			for (int j = 0; j < logArray[i].length; j++) {
				if (logArray[i][j].isLogRightBound() == true) {
					logArray[i][j].moveLogRightX();
					Rectangle2D logRight = new Rectangle2D.Double(logArray[i][j].getLogPosX(), logArray[i][j].getLogPosY(), (logArray[i][j].getLogLength() * 32), 32);
					g2.fill(logRight);
				}
					
				else if (logArray[i][j].isLogRightBound() == false) {
					logArray[i][j].moveLogLeftX();
					Rectangle2D logLeft = new Rectangle2D.Double(logArray[i][j].getLogPosX(), logArray[i][j].getLogPosY(), (logArray[i][j].getLogLength() * 32), 32);
					g2.fill(logLeft);
				}
			}
		}
		//Drawing Vehicles:
		g2.setColor(Color.red);
		for (int i = 0; i < vehicleArray.length; i++) {
			for (int j = 0; j < vehicleArray[i].length; j++) {
				if (vehicleArray[i][j].isVehicleRightBound() == true) {
					vehicleArray[i][j].moveVehicleRightX();
					Rectangle2D vehicleRight = new Rectangle2D.Double(vehicleArray[i][j].getVehiclePosX(), vehicleArray[i][j].getVehiclePosY(), (vehicleArray[i][j].getVehicleLength() * 32), 32);
					g2.fill(vehicleRight);
				}
					
				if (vehicleArray[i][j].isVehicleRightBound() == false) {
					vehicleArray[i][j].moveVehicleLeftX();
					Rectangle2D vehicleLeft = new Rectangle2D.Double(vehicleArray[i][j].getVehiclePosX(), vehicleArray[i][j].getVehiclePosY(), (vehicleArray[i][j].getVehicleLength() * 32), 32);
					g2.fill(vehicleLeft);
				}
			}
		}
		
		//Drawing Turtles:
		g2.setColor(Color.yellow);
		for (int i = 0; i < turtleArray.length; i++) {
			for (int j = 0; j < turtleArray[i].length; j++) {
				turtleArray[i][j].moveTurtleX();
				Rectangle2D turtleLeft = new Rectangle2D.Double(turtleArray[i][j].getTurtlePosX(), turtleArray[i][j].getTurtlePosY(), (turtleArray[i][j].getTurtleLength() * 32), 32);
				g2.fill(turtleLeft);
			}
		}
		
		//Drawing Frog:
		g2.setColor(Color.green);
		Rectangle2D frogRect = new Rectangle2D.Double(userFrog.getPlayerPosX(), userFrog.getPlayerPosY(), 32, 32);
		g2.fill(frogRect);
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
}
