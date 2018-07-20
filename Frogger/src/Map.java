package frogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Map extends JPanel implements ActionListener{

	private Timer timer;
	private int delay = 10;
	
	//Frog for testing.
	public Frog frog = new Frog();
	
	//Vehicle array for testing.
	Vehicle[] vehicleRight64 = new Vehicle[] {
			new Vehicle(0.0, 64, 0.75), new Vehicle(-128, 64, 0.75)
	};
	
	Vehicle[] vehicleLeft = new Vehicle[] {
			new Vehicle(0.0, 256, -0.75)
	};
	
	Log[] logLeft = new Log[] {
			new Log(0.0, 320, 0.75)
	};
	
	Log[] logRight = new Log[] {
			new Log(0.0, 352, 1.0)
	};
	
	public Map(){
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		//Required to implement rect that can use doubles.
		Graphics2D g2 = (Graphics2D) g;
	
		//Code for development grid.
		//for (int x = 0; x < 640; x += 32)
		//{
			//for (int y = 0; y < 480; y+= 32)
			//{
				//g2.drawRect(x, y, 32, 32);
			//}
		//}
	
		g2.setColor(Color.black);
		g2.fillRect(0, 0, 640, 480);
		
		g2.setColor(Color.cyan);
		logLeft[0].moveLogX();
		Rectangle2D rect4 = new Rectangle2D.Double(logLeft[0].getLogPosX(), logLeft[0].getLogPosY(), 64, 32);
		g2.fill(rect4);
		
		logRight[0].moveLogX();
		Rectangle2D rect5 = new Rectangle2D.Double(logRight[0].getLogPosX(), logRight[0].getLogPosY(), 96, 32);
		g2.fill(rect5);
		
		g2.setColor(Color.green);
		Rectangle2D frogRect = new Rectangle2D.Double(frog.getPlayerPosX(), frog.getPlayerPosY(), 32, 32);
		g2.fill(frogRect);
		
	
		//Vehicles for testing.
		g2.setColor(Color.red);
		vehicleRight64[0].moveVehicleX();
		Rectangle2D rect = new Rectangle2D.Double(vehicleRight64[0].getVehiclePosX(), vehicleRight64[0].getVehiclePosY(), 32, 32);
		g2.fill(rect); 
		vehicleRight64[1].moveVehicleX();
		Rectangle2D rect2 = new Rectangle2D.Double(vehicleRight64[1].getVehiclePosX(), vehicleRight64[1].getVehiclePosY(), 32, 32);
		g2.fill(rect2);
		vehicleLeft[0].moveVehicleX();
		Rectangle2D rect3 = new Rectangle2D.Double(vehicleLeft[0].getVehiclePosX(), vehicleLeft[0].getVehiclePosY(), 32, 32);
		g2.fill(rect3);
		
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		repaint();
	}
}
