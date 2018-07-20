package frogger;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Frogger {
	
	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable( ){
			public void run(){
				JFrame gameWindow = new JFrame("Frogger");
				
				gameWindow.getContentPane().setPreferredSize((new Dimension(640, 480))); //Sets content pane to 640x480.
				gameWindow.setResizable(false); //Keeps window at same size.
				gameWindow.setVisible(true); //Makes window visible.
				gameWindow.pack(); //Forces content pane to 640x480.
				gameWindow.setLocationRelativeTo(null); //Forces frame to appear in middle of user's screen.
				gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Terminates entire program upon closing window.
				
				Gameplay frogger = new Gameplay(gameWindow.getContentPane().getWidth(), gameWindow.getContentPane().getHeight());
				gameWindow.add(frogger);
			}
		});
	}
}
