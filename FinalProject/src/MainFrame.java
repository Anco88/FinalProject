import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;


public class MainFrame extends JFrame {

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
		contentPane.add(new EditPanel(this, world));
		this.setVisible(true);
	}
	
	public void setPanel(MainPanel main) {
		System.out.println("Going back to main panel");
		contentPane.removeAll();
		contentPane.add(main);
		this.setVisible(true);
	}

}
