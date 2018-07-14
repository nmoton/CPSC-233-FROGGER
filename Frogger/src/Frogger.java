import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Frogger {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable( ) {
			public void run() {
				JFrame frame = new JFrame("Frogger");
				frame.setBounds(10,  10, 700, 600);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
