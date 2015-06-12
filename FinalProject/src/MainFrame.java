import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;


public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame(World world) {
		setTitle("Game - Main menu");  
		this.setSize(700,700);
		this.setVisible(true);
		this.init();
	}

	private void init() {
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new MainPanel());
		

	}

	public GameFrame getGameFrame() {
		// TODO Auto-generated method stub
		return null;
	}

}
