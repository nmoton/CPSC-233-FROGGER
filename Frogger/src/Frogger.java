import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Frogger{
	
	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable( ){
			public void run(){
				JFrame gameWindow = new JFrame("Frogger");
				Gameplay gameContent = new Gameplay();
				
				gameWindow.setBounds(50, 50, 640, 480);
				gameWindow.setResizable(false);
				gameWindow.setVisible(true);
				gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameWindow.add(gameContent);
			}
		});
	}

}
