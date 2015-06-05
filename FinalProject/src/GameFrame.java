import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameFrame extends JFrame {
	Maze maze;
	World world;
	JPanel buttonPanel;
	public GamePanel gamePanel;
	Container content;

	JButton makeWall = new JButton("Wall");
	
	GameFrame(){
		
	}
	
	GameFrame(World world){
		this.world = world;
		buttonPanel = new JPanel();
		gamePanel = new GamePanel(world);
		content = getContentPane();
		
	
		buttonPanel.add(makeWall);
		
		content.add(gamePanel, BorderLayout.CENTER);
		content.add(buttonPanel, BorderLayout.SOUTH);
		

		
		this.setSize(1000,1000);
		this.setVisible(true);
		this.init();

	}
	
	public void init(){
		makeWall.addActionListener(
				new ActionListener(){
					public void actionPerformed (ActionEvent e){
						System.out.println("Remove vertex");
					}
				}
		);
	}
	
	
	
	
}
