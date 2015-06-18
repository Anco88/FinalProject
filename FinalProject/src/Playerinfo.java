import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Playerinfo extends JPanel {
	Player p;
	JLabel label, item, numPick, numWall;

	public Playerinfo(Player p){
		this.p = p;
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		label = new JLabel(p.getName());
		item = new JLabel(p.getCurrentItem());
		numPick = new JLabel("Pickaxes: "+p.getPickaxe());
		numWall = new JLabel("Walls: "+ p.getWall());
		this.add(label);
		this.add(item);
		this.add(numPick);
		this.add(numWall);
	}
	

}
