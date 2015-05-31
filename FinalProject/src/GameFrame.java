import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameFrame extends JFrame {
	JPanel buttonPanel;
	public GamePanel gamePanel;
	Container content;

	GameFrame(){
		gamePanel = new GamePanel();
		content = getContentPane();
		
		content.add(gamePanel, BorderLayout.SOUTH);
		
		this.setSize(1000,1000);
		this.setVisible(true);
		//this.init();

	}
	
	
	
	
}
