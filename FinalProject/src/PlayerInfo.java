import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Anco Gietema (s2614154) & Dekel Viner (s2612925)
 *
 * Panel to show information about a player
 */

public class PlayerInfo extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private Player p;
	private JLabel label, item, numPick, numWall, winner;
	
	public PlayerInfo(Player p) {
		winner = new JLabel("WINNER");
		winner.setFont(new Font("Serif", Font.PLAIN, 20));
		this.p = p;
		setPreferredSize(new Dimension(200,400));
		p.addObserver(this);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		label = new JLabel(p.getName());
		item = new JLabel("Current: " + p.getCurrentItem());
		numPick = new JLabel("Pickaxes: " + p.getPickaxe());
		numWall = new JLabel("Walls: "+ p.getWall());
		add(label);
		label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		add(item);
		item.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		add(numPick);
		numPick.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		add(numWall);
		numWall.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		add(winner);
		winner.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		winner.setVisible(false);

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		item.setText("Current: " + p.getCurrentItem());
		numPick.setText("Pickaxes: " + p.getPickaxe());
		numWall.setText("Walls: " + p.getWall());
		if(p.getHasWon()) {
			System.out.println("winner " + p);
			winner.setVisible(true);
		}
	}

}
