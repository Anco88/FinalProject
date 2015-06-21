import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * @author Anco Gietema (s2614154) & Dekel Viner (s2612925)
 *
 */
public class EditPanel extends JPanel {
	private static final long serialVersionUID = -1778575427764855997L;
	private int mode = 0;
	private MouseAction mouse;
	private GamePanel panel;
	private JPanel buttonPanel, topButtons;
	private JButton backMainMenu = new JButton("Back to main menu");
	private JToggleButton makeWall = new JToggleButton("Wall");
	private JToggleButton makePath = new JToggleButton("Path");
	private JButton save = new JButton("Save");
	private JButton load = new JButton("Load");
	private ButtonGroup btnGroup = new ButtonGroup();
	private World world;
	private MainFrame frame;

	public EditPanel(MainFrame mainFrame, World world) {
		this.world = world;
		this.frame = mainFrame;
		
		panel = new GamePanel(world);
		panel.setMode(GamePanel.EDITMODE);
		
		buttonPanel = new JPanel();
		topButtons = new JPanel();
		topButtons.add(backMainMenu);
		buttonPanel.add(makeWall);
		buttonPanel.add(makePath);
		buttonPanel.add(save);
		buttonPanel.add(load);
		btnGroup.add(makeWall);
		btnGroup.add(makePath);
		makePath.doClick();
		
		setLayout(new BorderLayout());
		add(topButtons, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		panel.setPreferredSize(new Dimension(602,602));
		setVisible(true);
		
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
	
	// create actions for the buttons
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
						panel.repaint();
					}
				}
		);
		backMainMenu.addActionListener(
				new ActionListener(){
					public void actionPerformed (ActionEvent e){
						frame.setPanel(new MainPanel(frame, world));
					}
				}
		);
	}
}
