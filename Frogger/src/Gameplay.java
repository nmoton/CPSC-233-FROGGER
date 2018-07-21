package frogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

	private Timer timer;
	private int delay = 10;
	
	private Map map = new Map();
	
	public Gameplay(int contentWidth, int contentHeight) {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		map.paintComponent(g);
	}

	public void actionPerformed(ActionEvent e) {
		checkLogs(map.logArray);
		repaint();
	}
	
	public void checkLogs(Log[][] logArray) {
		for (int i = 0; i < logArray.length; i++) {
			for (int j = 0; j < logArray[i].length; j++) {
				
				if (logArray[i][j].isLogRightBound() == true) {
					logBoundaryRightBound(logArray[i]);
					
					if (logArray[i][j].getlogLength() == 3) {
						userOnLog3R(logArray[i]);
				
					} 
					else if (logArray[i][j].getlogLength() == 5) {
						userOnLog5R(logArray[i]);
						
					} 
					else {
						userOnLog7R(logArray[i]);
					}
				}
				
				else if (logArray[i][j].isLogRightBound() == false) {
					logBoundaryLeftBound(logArray[i]);
					
					if (logArray[i][j].getlogLength() == 3) {
						userOnLog3L(logArray[i]);
					
					} 
					else if (logArray[i][j].getlogLength() == 5) {
						userOnLog5L(logArray[i]);
						
					} 
					else {
						userOnLog7L(logArray[i]);
					}
				}
			}
		}
	}

	public void checkVehicles(Vehicle[][] vehicleArray) {
		for (int i = 0; i < vehicleArray.length; i++) {
			for (int j = 0; j < vehicleArray[i].length; j++) {
				
				if (vehicleArray[i][j].isVehicleRightBound() == true) {
					vehicleBoundaryRightBound(vehicleArray[i]);
					vehicleCollisionRightBound(vehicleArray[i]);
				}
				else if (vehicleArray[i][j].isVehicleRightBound() == false) {
					vehicleBoundaryLeftBound(vehicleArray[i]);
					vehicleCollisionLeftBound(vehicleArray[i]);
				}
			}
		}
	}
	
	public void checkTurtles(Turtle[][] turtleArray) {
		for (int i = 0; i < turtleArray.length; i++) {
			for (int j = 0; j < turtleArray[i].length; j++) {
				turtleBoundaryLeftBound(turtleArray[i]);
				
				if (turtleArray[i][j].getTurtleLength() == 2) {
					userOnTurtle2L(turtleArray[i]);
				}
				else if (turtleArray[i][j].getTurtleLength() == 3) {
					userOnTurtle3L(turtleArray[i]);
				}
			}
		}
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			if (map.frog.getPlayerPosY() <= 0) {
				 map.frog.setPosY(0);
			}
			else {
				map.frog.moveUp();
			}
		}
			
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			if (map.frog.getPlayerPosY() >= 448) {
				map.frog.setPosY(448);
			}
			else {
				map.frog.moveDown();
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			if (map.frog.getPlayerPosX() >= 608) {
				map.frog.setPosX(608);
			}
			else {
				map.frog.moveRight();
			}
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			if (map.frog.getPlayerPosX() <= 0) {
				map.frog.setPosX(0);
			}
			else {
				map.frog.moveLeft();
			}
		}
	}
	
	public void vehicleBoundaryRightBound(Vehicle[] vehicleArray) {
		for (int i = 0; i < vehicleArray.length; i++) {
			if (vehicleArray[i].getVehiclePosX() >= 640.0) {
			vehicleArray[i].setVehiclePosX(-30.0);
			}
		}
	}
	
	public void vehicleBoundaryLeftBound(Vehicle[] vehicleArray) {
		for (int i = 0; i < vehicleArray.length; i++) {
			if (vehicleArray[i].getVehiclePosX() <= 0.0) {
				vehicleArray[i].setVehiclePosX(670.0);
			}
		}
	}

	public void vehicleCollisionRightBound(Vehicle[] vehicleArray) {
		for (int i = 0; i < vehicleArray.length; i++) {
			if (map.frog.getPlayerPosX() - vehicleArray[i].getVehiclePosX() < 32 && map.frog.getPlayerPosX() - vehicleArray[i].getVehiclePosX() > -32 &&
					vehicleArray[i].getVehiclePosY() == map.frog.getPlayerPosY()) {
				//System.exit(0); //Will close program on collision.
			}
		}
	}
	
	public void vehicleCollisionLeftBound (Vehicle[] vehicleArray) {
		for (int i = 0; i < vehicleArray.length; i++) {
			if (map.frog.getPlayerPosX() - vehicleArray[i].getVehiclePosX() > -32 && map.frog.getPlayerPosX() - vehicleArray[i].getVehiclePosX() < 32 &&
					vehicleArray[i].getVehiclePosY() == map.frog.getPlayerPosY()){
				//System.exit(0); //Will close program on collision.
			}
		}
	}
	
	public void logBoundaryRightBound (Log[] logArray) {
		for (int i = 0; i < logArray.length; i++) {
			if(logArray[i].getLogPosX() >= 640.0) {
				logArray[i].setLogPosX(-30.0);
			}
		}
	}
	
	public void logBoundaryLeftBound (Log[] logArray) {
		for (int i = 0; i < logArray.length; i++) {
			if (logArray[i].getLogPosX() <= -256.0) {
				logArray[i].setLogPosX(640);
			}
		}
	}
	
	public void turtleBoundaryLeftBound (Turtle[] turtleArray) {
		for (int i = 0; i < turtleArray.length; i++) {
			if (turtleArray[i].getLogPosX() <= -64.0) {
				turtleArray[i].setLogPosX(640);
			}
		}
	}
	
	public void userOnTurtle2L (Turtle[] turtleArray) { //For Left-Bound Turtles
		for (int i = 0; i < turtleArray.length; i++) {
			if (turtleArray[i].getLogPosX() - map.frog.getPlayerPosX() < -16 && turtleArray[i].getLogPosX() - map.frog.getPlayerPosX() > -48 && 
					turtleArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(turtleArray[i].getLogPosX() + 32);
			}
			
			else if (turtleArray[i].getLogPosX() - map.frog.getPlayerPosX() < 16 && turtleArray[i].getLogPosX() - map.frog.getPlayerPosX() > -16 && 
					turtleArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(turtleArray[i].getLogPosX());
			}

		}
	}
	
	public void userOnTurtle3L (Turtle[] turtleArray) { //for Left-Bound Turtles
		for (int i = 0; i < turtleArray.length; i++) {
			if (turtleArray[i].getLogPosX() - map.frog.getPlayerPosX() < -48 && turtleArray[i].getLogPosX() - map.frog.getPlayerPosX() > -64 && 
					turtleArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(turtleArray[i].getLogPosX() + 64);
			}
			
			if (turtleArray[i].getLogPosX() - map.frog.getPlayerPosX() < -16 && turtleArray[i].getLogPosX() - map.frog.getPlayerPosX() > -48 && 
					turtleArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(turtleArray[i].getLogPosX() + 32);
			}
			
			if (turtleArray[i].getLogPosX() - map.frog.getPlayerPosX() < 16 && turtleArray[i].getLogPosX() - map.frog.getPlayerPosX() > -16 && 
					turtleArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(turtleArray[i].getLogPosX());
			}
		}
	}
	
	public void userOnLog3R (Log[] logArray) {
		for (int i = 0; i < logArray.length; i++) {
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -48 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -96 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 64);
			}
			
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -16 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -48 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 32);
			}
			
			//8 is REQUIRED in order to allow the log to move to a maximum speed of 8 pixels/period.
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < 8 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -16 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX());
			}
		}
	}
		
	public void userOnLog5R (Log[] logArray) {
		for (int i = 0; i < logArray.length; i++) {
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -112 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -180 &&
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 128);
			}
			
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -80 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -112 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 96);
			}
			
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -48 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -80 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 64);
			}
			
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -16 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -48 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 32);
			}
			
			//8 is REQUIRED in order to allow the log to move to a maximum speed of 8 pixels/period.
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < 8 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -16 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX());
			}
		}
	}
	
	public boolean userOnLog7R (Log[] logArray) {
		for (int i = 0; i < logArray.length; i++) {
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -176 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -240 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 192);
				return true;
			}
			
			else if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -144 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -176 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 160);
				return true;
			}
			
			else if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -112 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -144 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 128);
				return true;
			}
			
			else if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -80 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -112 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 96);
				return true;
			}
			
			else if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -48 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -80 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 64);
				return true;
			}
			
			else if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -16 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -48 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 32);
				return true;
			}
			
			//8 is REQUIRED in order to allow the log to move to a maximum speed of 8 pixels/period.
			else if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < 8 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -16 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX());
				return true;
			}
		}
		return false;
	}
	
	public void userOnLog3L (Log[] logArray) { //For Left-Bound Logs
		for (int i = 0; i < logArray.length; i++) {
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -48 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -64 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 64);
			}
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -16 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -48 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 32);
			}
			
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < 16 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -16 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX());
			}
		}
	}
	
	public void userOnLog5L (Log[] logArray) {
		for (int i = 0; i < logArray.length; i++) {
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -112 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -144 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 128);
			}
			
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -80 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -112 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 96);
			}
			
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -48 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -80 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 64);
			}
			
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -16 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -48 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 32);
			}
	
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < 16 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -16 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX());
			}
		}
	}
	
	public void userOnLog7L (Log[] logArray) {
		for (int i = 0; i < logArray.length; i++) {
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -176 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -208 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 192);
			}
		
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -144 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -176 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 160);
			}
			
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -112 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -144 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 128);
			}
		
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -80 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -112 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 96);
			}
		
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -48 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -80 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 64);
			}
		
			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < -16 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -48 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX() + 32);
			}

			if (logArray[i].getLogPosX() - map.frog.getPlayerPosX() < 16 && logArray[i].getLogPosX() - map.frog.getPlayerPosX() > -16 && 
					logArray[i].getLogPosY() == map.frog.getPlayerPosY()) {
				map.frog.setPosX(logArray[i].getLogPosX());
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	

