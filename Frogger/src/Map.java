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
	public Frog frog = new Frog();
	public Vehicle vehicle = new Vehicle(0, 256, 0.5);
	
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
		for (int x = 0; x < 640; x += 32)
		{
			for (int y = 0; y < 480; y+= 32)
			{
				g2.drawRect(x, y, 32, 32);
			}
		}
	
		//Frog for testing.
		g2.setColor(Color.green);
		g2.drawRect(frog.getPlayerPosX(), frog.getPlayerPosY(), 32, 32);
	
		//Vehicle for testing.
		g2.setColor(Color.red);
		vehicle.moveVehicleX();
		Rectangle2D rect = new Rectangle2D.Double(vehicle.getVehiclePosX(), vehicle.getVehiclePosY(), 32, 32);
		g2.fill(rect); 
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		repaint();
	}
}
