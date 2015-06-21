import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Anco Gietema (s2614154) & Dekel Viner (s2612925)
 *
 */
public class SettingsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private World w;
	private JLabel zLabel;
	private JTextField zText;
	private JButton zButton;
	
	SettingsPanel(World world) {
		this.w = world;
		System.out.println(world);
		zLabel = new JLabel("Number of zombies: ");
		zText = new JTextField(Integer.toString(w.getSettings().getNumberOfZombies()));
		zButton = new JButton("Update");
		add(zLabel, BorderLayout.NORTH);
		add(zText, BorderLayout.NORTH);
		add(zButton, BorderLayout.NORTH);
		
		zButton.addActionListener(
				new ActionListener() {
					public void actionPerformed (ActionEvent e){
						w.getSettings().setNumberOfZombies(zText.getText());
						zText.setText(Integer.toString(w.getSettings().getNumberOfZombies()));
					}
				}
		);
		this.setVisible(true);
	}
}
