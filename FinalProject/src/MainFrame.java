import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;


public class MainFrame extends JFrame {
	KeyAction key = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container contentPane;
	private World world;
	
	public MainFrame(World world) {
		setTitle("Game - Main menu");
		this.world = world;
		this.setSize(700,700);
		this.setVisible(true);
		setFocusable(true);

		key = new KeyAction();
		addKeyListener(key);
		this.init();
	}

	private void init() {
		contentPane = getContentPane();
		//contentPane.setLayout(BorderLayout);
		setPanel(new MainPanel(this, world));
		
	}
	
	

	public GameFrame getGameFrame() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPanel(EditPanel editPanel) {
		System.out.println("test");
		contentPane.removeAll();
		contentPane.add(editPanel);
		this.setVisible(true);
	}
	
	public void setPanel(MainPanel main) {
		System.out.println("Going back to main panel");
		contentPane.removeAll();
		contentPane.add(main);
		this.setVisible(true);
	}

	public void setPanel(PlayPanel playPanel) {
		System.out.println("Going to playpanel");
		contentPane.removeAll();
		contentPane.add(playPanel);
		this.setVisible(true);
		
	}


	public KeyAction getKeyAction() {
		return key;
	}

}
