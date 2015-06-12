import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class EditPanel extends JPanel {
	int mode = 0;
	MouseAction mouse;
	GamePanel panel;
	JPanel buttonPanel;
	JButton makeWall = new JButton("Wall");
	JButton makePath = new JButton("Path");
	JButton save = new JButton("Save");
	JButton load = new JButton("Load");
	
	private World world;

	public EditPanel(World world) {
		this.world = world;
		panel = new GamePanel(world);
		this.add(panel);
		buttonPanel = new JPanel();
		buttonPanel.add(makeWall);
		buttonPanel.add(makePath);
		buttonPanel.add(save);
		buttonPanel.add(load);
		this.add(buttonPanel);
		
		//this.setPreferredSize(new Dimension(400,400));
		this.setVisible(true);
		mouse = new MouseAction(world, this);
		panel.addMouseMotionListener(mouse);
		panel.addMouseListener(mouse);
		init();
	}

	public int getMode() {
		return mode;
	}
	
	public void setMode(int mode) {
		this.mode = mode;
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
