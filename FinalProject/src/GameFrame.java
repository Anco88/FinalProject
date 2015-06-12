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
	int mode = 0;

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	JButton makeWall = new JButton("Wall");
	JButton makePath = new JButton("Path");
	JButton save = new JButton("Save");
	JButton load = new JButton("Load");
	
	GameFrame(){
		
	}
	
	GameFrame(World world){
		this.world = world;
		buttonPanel = new JPanel();
		gamePanel = new GamePanel(world);
		content = getContentPane();
		
	
		buttonPanel.add(makeWall);
		buttonPanel.add(makePath);

		buttonPanel.add(save);
		buttonPanel.add(load);
		
		content.add(gamePanel, BorderLayout.CENTER);
		content.add(buttonPanel, BorderLayout.SOUTH);
		

		
		this.setSize(700,700);
		this.setVisible(true);
		this.init();

	}
	
	public void init(){
		makeWall.addActionListener(
				new ActionListener(){
					public void actionPerformed (ActionEvent e){
						setMode(1);
						System.out.println("Create wall mode");
					}
				}
		);
		makePath.addActionListener(
				new ActionListener(){
					public void actionPerformed (ActionEvent e){
						setMode(0);
						System.out.println("Create path mode");
					}
				}
		);
		save.addActionListener(
				new ActionListener(){
					public void actionPerformed (ActionEvent e){
						world.getMaze().save("maze.txt");
						System.out.println("save maze");
					}
				}
		);
		load.addActionListener(
				new ActionListener(){
					public void actionPerformed (ActionEvent e){
						world.getMaze().load("maze.txt");
						System.out.println("load maze");
					}
				}
		);
	}
	
	
	
	
}
