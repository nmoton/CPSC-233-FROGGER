package frogger;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author Nathan Moton
 *
 * The Frogger class creates the game window in Swing and creates the game engine that will essentially run the entire
 * game. The game engine's data is then added to the game window.
 *
 * Last Updated:08/14/2018
 */
public class Frogger {
	
	public static void main(String[] args) throws IOException{
		
		SwingUtilities.invokeLater(new Runnable( ){
			public void run(){
				JFrame gameWindow = new JFrame("Frogger"); //Names the window "Frogger"
				
				gameWindow.getContentPane().setPreferredSize((new Dimension(640, 480))); //Sets content pane to 640x480.
				gameWindow.setResizable(false); //Keeps window at same size.
				gameWindow.setVisible(true); //Makes window visible.
				gameWindow.pack(); //Forces content pane to 640x480.
				gameWindow.setLocationRelativeTo(null); //Forces frame to appear in middle of user's screen.
				gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Terminates entire program upon closing window.
				
				Gameplay frogger = new Gameplay(); //Creates a new game engine that will manage the entire game
				gameWindow.add(frogger); //Adds all the data of the game engine to the game window
			}
		});
	}
}
