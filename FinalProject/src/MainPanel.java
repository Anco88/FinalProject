import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Anco Gietema (s2614154) & Dekel Viner (s2612925)
 *
 * Panel to show the options to change and buttons to go to other panels
 */

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private MainFrame frame;
	private JPanel topPanel;
	private SettingsPanel settingsPanel;
	private JButton editor;
	private World world;
	private JButton start;

	public MainPanel() {
		super();
		start = new JButton("Start game");
		editor = new JButton("Edit maze");
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
		this.setLayout(new BorderLayout());
		settingsPanel = new SettingsPanel(world);
		topPanel = new JPanel();
		topPanel.add(start);
		topPanel.add(editor);
		add(topPanel, BorderLayout.NORTH);
		add(settingsPanel, BorderLayout.CENTER);			
	}
	
	// adds methods to buttons
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
