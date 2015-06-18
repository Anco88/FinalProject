import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PlayerInfo extends JPanel implements Observer {
	Player p;
	JLabel label, item, numPick, numWall;
	
	public PlayerInfo(Player p){
		this.p = p;
		this.setPreferredSize(new Dimension(200,400));
		p.addObserver(this);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		label = new JLabel(p.getName());
		item = new JLabel("Current: " + p.getCurrentItem());
		numPick = new JLabel("Pickaxes: " + p.getPickaxe());
		numWall = new JLabel("Walls: "+ p.getWall());
		this.add(label);
		label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		this.add(item);
		item.setAlignmentX(JLabel.CENTER_ALIGNMENT);

		this.add(numPick);
		numPick.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		this.add(numWall);
		numWall.setAlignmentX(JLabel.CENTER_ALIGNMENT);

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		item.setText("Current: " + p.getCurrentItem());
		numPick.setText("Pickaxes: " + p.getPickaxe());
		numWall.setText("Walls: " + p.getWall());
	}
	

}
