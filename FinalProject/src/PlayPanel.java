import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PlayPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private GamePanel panel;
	private JPanel buttonPanel, panelP1, panelP2, topButtons;
	private PlayerController p1, p2;
	private JButton backMainMenu = new JButton("Back to main menu");
	private JButton restart = new JButton("Restart");
	private KeyAction key;
	private Update u = null;
	private World world;
	private MainFrame frame;
	private Timer timer;

	public PlayPanel(MainFrame frame, World world) {
		this.world = world;
		this.frame = frame;
		setLayout(new BorderLayout());
		panel = new GamePanel(world);
		
		buttonPanel = new JPanel();
		topButtons = new JPanel();
		topButtons.add(backMainMenu);
		topButtons.add(restart);
		u = new Update(panel, this);
		
		add(topButtons, BorderLayout.PAGE_START);
		add(panel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.PAGE_END);

		setFocusable(true);
		grabFocus();
		requestFocusInWindow();
		//this.setPreferredSize(new Dimension(400,400));
				
		key = new KeyAction();
		addKeyListener(key);
		init();
		initWorld();
		panelP1 = new PlayerInfo((Player) world.getCharacter(0));
		panelP2 = new PlayerInfo((Player) world.getCharacter(1));

		add(panelP1, BorderLayout.LINE_START);
		add(panelP2, BorderLayout.LINE_END);
		setVisible(true);
	}
		
	public KeyAction getKeyAction(){
		return key;
	}

	private void initWorld() {
		Player c = new Player(0, 0, world, "player");
		Zombie z = new Zombie(0, 0, world);
		Random rand = new Random();
		Maze maze = world.getMaze();
		ArrayList<Point> pathPoints = new ArrayList<Point>();
		for(int i = 0; i < maze.getHeigt();i++){
			for(int j = 0; j < maze.getWidth(); j++){
				if(maze.getMazeAt(i, j).getType() == 0){
					pathPoints.add(new Point(i, j));
				}
			}
		}	
		world.getCharacters().clear();
		for(int i = 0; i < world.getSettings().getNumberOfPlayers(); i++){
			int index = rand.nextInt(pathPoints.size());
			System.out.println(index);
			System.out.println();
			Point p = pathPoints.get(index);
			pathPoints.remove(index);
			int x = (int) (p.getX() * maze.getSize() + 0.5 * maze.getSize());
			int y = (int) (p.getY() * maze.getSize() + 0.5 * maze.getSize());
			c = new Player(x, y, world, "player " + (i+1));
			world.getCharacters().add(c);	
		}
		
		System.out.println(world.getCharacters());
		System.out.println(world.getCharacters().get(0).getLocation());
		p1 = new PlayerController(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_P, KeyEvent.VK_O, frame.getKeyAction().getPressedKeys(), (Player) world.getCharacter(0), this);
		world.getCharacter(0).setColor(Color.GREEN);
		p2 = new PlayerController(KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D,KeyEvent.VK_T, KeyEvent.VK_R, frame.getKeyAction().getPressedKeys(), (Player) world.getCharacter(1), this);
		world.getCharacter(1).setColor(Color.BLUE);
		
		for(int i = 0; i < world.getSettings().getNumberOfZombies(); i++){
			int index = rand.nextInt(pathPoints.size());
			System.out.println(index);
			System.out.println();
			Point p = pathPoints.get(index);
			pathPoints.remove(index);
			int x = (int) (p.getX() * maze.getSize() + 0.5 * maze.getSize());
			int y = (int) (p.getY() * maze.getSize() + 0.5 * maze.getSize());
			z = new Zombie(x, y, world);
			world.getCharacters().add(z);
			z.setColor(Color.RED);
			u.getControllers().add(new ZombieController(z, world));	
		}
		
		panel.repaint();
		playLoop();
	}
	
	private void playLoop() {
		p1.setLastCheck(System.nanoTime());
		p2.setLastCheck(System.nanoTime());
		u.getControllers().add(p1);
		u.getControllers().add(p2);
		panel.repaint();
		timer = new Timer(true);
		timer.schedule(u, 0, 10);
	}
	
	public Timer getTimer(){
		return timer;
	}
	
	public void stopTimer(){
		timer.cancel();
		u.cancel();
	}

	// add methods to buttons
	public void init(){
		backMainMenu.addActionListener(
				new ActionListener(){
					public void actionPerformed (ActionEvent e){
						stopTimer();
						frame.setPanel(new MainPanel(frame, world));
					}
				}
		);
		restart.addActionListener(
				new ActionListener(){
					public void actionPerformed (ActionEvent e){
						stopTimer();
						frame.setPanel(new PlayPanel(frame, world));
					}
				}
		);
	}
	
}
