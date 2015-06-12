import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author anco
 *
 */
public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainFrame frame;
	JButton editor;
	private World world;

	public MainPanel() {
		super();
		editor = new JButton("Edit maze");
		add(editor);
		this.setPreferredSize(new Dimension(400,400));
		init();
	}
	
	public MainPanel(MainFrame frame){
		this();
		this.frame = frame;
	}
	
	public MainPanel(MainFrame frame, World world){
		this();
		this.frame = frame;
		this.world = world;
	}
	
	private void init(){
		editor.addActionListener(
				new ActionListener(){
					public void actionPerformed (ActionEvent e){
						frame.setPanel(new EditPanel(world));
						System.out.println("go to edit screen");
					}
				}
		);
		this.setVisible(true);
	}
	
}
