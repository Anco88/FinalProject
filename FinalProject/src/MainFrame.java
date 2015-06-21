import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

/**
 * @author Anco Gietema (s2614154) & Dekel Viner (s2612925)
 *
 */

public class MainFrame extends JFrame {
	KeyAction key = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container contentPane;
	private World world;
	
	public MainFrame(World world) {
		setTitle("Zombie Game - Main menu");
		this.world = world;
		setSize(1000,700);
		setVisible(true);
		setFocusable(true);

		key = new KeyAction();
		addKeyListener(key);
		this.init();
	}

	private void init() {
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		setPanel(new MainPanel(this, world));	
	}

	public void setPanel(EditPanel editPanel) {
		setTitle("Zombie Game - Edit Maze");
		contentPane.removeAll();
		contentPane.add(editPanel);
		setVisible(true);
	}
	
	public void setPanel(MainPanel main) {
		contentPane.removeAll();
		contentPane.add(main);
		setTitle("Zombie Game - Main menu");
		setVisible(true);
	}

	public void setPanel(PlayPanel playPanel) {
		setTitle("Zombie Game - Play");
		contentPane.removeAll();
		contentPane.add(playPanel);
		setVisible(true);
	}

	public KeyAction getKeyAction() {
		return key;
	}

}
