import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;


public class EditPanel extends JPanel {
	int mode = 0;
	MouseAction mouse;
	GamePanel panel;
	JPanel buttonPanel;
	JToggleButton makeWall = new JToggleButton("Wall");
	JToggleButton makePath = new JToggleButton("Path");
	JButton save = new JButton("Save");
	JButton load = new JButton("Load");
	ButtonGroup btnGroup = new ButtonGroup();
	
	
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
		btnGroup.add(makeWall);
		btnGroup.add(makePath);
		makePath.doClick();
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
