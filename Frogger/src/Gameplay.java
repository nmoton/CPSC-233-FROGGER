package frogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

	private int width = 0;
	private int height = 0;
	private Timer timer;
	private int delay = 10;
	
	//Frog for testing.
	private Frog frog = new Frog();
	
	public Gameplay(int contentWidth, int contentHeight) {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
		
		this.width = contentWidth;
		this.height = contentHeight;
		//Testing for content pane resolution.
		System.out.println("Width:" + this.width);
		System.out.println("Height:" + this.height);
	}
	
	public void paintComponent(Graphics g) {
		//Code for development grid.
		for (int x = 0; x < width; x += 32)
		{
			for (int y = 0; y < height; y+= 32)
			{
				g.drawRect(x, y, 32, 32);
			}
		}
		
		//Frog for testing.
		g.setColor(Color.green);
		g.drawRect(frog.getPlayerPosX(), frog.getPlayerPosY(), 32, 32);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			if (frog.getPlayerPosY() <= 0) {
				 frog.setPosY(0);
			}
			else {
				frog.moveUp();
			}
		}
			
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			if (frog.getPlayerPosY() >= 480) {
				frog.setPosY(480);
			}
			else {
				frog.moveDown();
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			if (frog.getPlayerPosX() >= 640) {
				frog.setPosY(640);
			}
			else {
				frog.moveRight();
			}
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			if (frog.getPlayerPosX() <= 0) {
				frog.setPosX(0);
			}
			else {
				frog.moveLeft();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	

