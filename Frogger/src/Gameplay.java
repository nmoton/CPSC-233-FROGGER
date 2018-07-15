package frogger;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

	private int width = 0;
	private int height = 0;
	
	public Gameplay(int contentWidth, int contentHeight) {
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
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
