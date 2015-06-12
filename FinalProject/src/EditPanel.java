import java.awt.Dimension;

import javax.swing.JPanel;


public class EditPanel extends JPanel {

	
	private World world;

	public EditPanel(World world) {
		this.world = world;
		this.add(new GamePanel(world));
		//this.setPreferredSize(new Dimension(400,400));
		this.setVisible(true);
	}

}
