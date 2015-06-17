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
	private JButton start;

	public MainPanel() {
		super();
		start = new JButton("Start game");
		editor = new JButton("Edit maze");
		add(start);
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
		start.addActionListener(
				new ActionListener(){
					public void actionPerformed (ActionEvent e){
						System.out.println("start playpanel");
						System.out.println("frame: " + frame);
						frame.setPanel(new PlayPanel(frame, world));
						System.out.println("Start game");
					}
				}
		);

		editor.addActionListener(
				new ActionListener(){
					public void actionPerformed (ActionEvent e){
						frame.setPanel(new EditPanel(frame, world));
						System.out.println("go to edit screen");
					}
				}
		);
		this.setVisible(true);
	}
	
}