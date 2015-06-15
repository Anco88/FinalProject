import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;


public class PlayPanel extends JPanel {
	GamePanel panel;
	JPanel buttonPanel;
	JPanel topButtons;
	JButton backMainMenu = new JButton("Back to main menu");
	KeyAction key;
	
	private World world;
	private MainFrame frame;

	public PlayPanel(World world) {
		this.world = world;
		panel = new GamePanel(world);
		
		buttonPanel = new JPanel();
		topButtons = new JPanel();
		topButtons.add(backMainMenu);
		
		this.add(topButtons);
		this.add(panel);
		this.add(buttonPanel);
		setFocusable(true);
		grabFocus();
		requestFocusInWindow();
		//this.setPreferredSize(new Dimension(400,400));
		this.setVisible(true);
		
		key = new KeyAction();
		this.addKeyListener(key);
		init();
		initWorld();
	}
	
	public PlayPanel(World world, MainFrame frame) {
		this(world);
		//this.frame = frame;
		//key = new KeyAction();
		//frame.addKeyListener(key);
		
	}

	private void initWorld() {

		Random rand = new Random();
		Maze maze = world.getMaze();
		ArrayList<Point> pathPoints = new ArrayList<Point>();
		for(int i = 0; i < maze.getHEIGHT();i++){
			for(int j = 0; j < maze.getWIDTH(); j++){
				if(maze.getMazeAt(i, j).getType() == 0){
					pathPoints.add(new Point(i, j));
				}
			}
		}	
		for(int i = 0; i < world.getSettings().getNumberOfPlayers(); i++){
			world.getCharacters().clear();
			Character c;
			int index = rand.nextInt(pathPoints.size());
			System.out.println(index);
			System.out.println();
			Point p = pathPoints.get(index);
			pathPoints.remove(index);
			int x = (int) (p.getX() * maze.getSIZE() + 0.5 * maze.getSIZE());
			int y = (int) (p.getY() * maze.getSIZE() + 0.5 * maze.getSIZE());
			c = new Character(x, y);
			world.getCharacters().add(c);
		}
		System.out.println(pathPoints);
		System.out.println(world.getCharacters());
		System.out.println(world.getCharacters().get(0).getLocation());
	}

	public PlayPanel(MainFrame mainFrame, World world) {
		this(world);
		this.frame = mainFrame;
	}

	public void init(){
		backMainMenu.addActionListener(
				new ActionListener(){
					public void actionPerformed (ActionEvent e){
						frame.setPanel(new MainPanel(frame, world));
					}
				}
		);
		
	}

}
