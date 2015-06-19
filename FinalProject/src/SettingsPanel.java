import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author anco
 *
 */
public class SettingsPanel extends JPanel {
	private World w;
	private JLabel pLabel, zLabel;
	private JTextField pText, zText;
	private JButton pButton, zButton;
	
	SettingsPanel(World world){
		this.w = world;
		System.out.println(world);
		zLabel = new JLabel("Number of zombies: ");
		zText = new JTextField(Integer.toString(w.getSettings().getNumberOfZombies()));
		zButton = new JButton("Update");
		this.add(zLabel, BorderLayout.NORTH);
		this.add(zText, BorderLayout.NORTH);
		this.add(zButton, BorderLayout.NORTH);
		
		zButton.addActionListener(
				new ActionListener(){
					public void actionPerformed (ActionEvent e){
						w.getSettings().setNumberOfZombies(zText.getText());
						zText.setText(Integer.toString(w.getSettings().getNumberOfZombies()));
					}
				}
		);
		this.setVisible(true);
	}
}
