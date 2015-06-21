import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Anco Gietema (s2614154) & Dekel Viner (s2612925)
 *
 */
public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Maze maze;
	private World world;
	// EDITMODE and PLAYMODE used to create easier use of setMode() method
	public static final int EDITMODE = 1;
	public static final int PLAYMODE = 0;
	private int mode; // used to decide if characters must be shown
	
	GamePanel(){
		mode = PLAYMODE;
		this.setPreferredSize(new Dimension(602,602));
	}
	
	GamePanel(World world){
		this();
		this.maze = world.getMaze();
		this.world = world;
		repaint();
	}
	
	public void setMode(int mode){
		this.mode = mode;
	}
	
	public World getWorld() {
		return world;
	}
	
	@Override
	public void paintComponent(Graphics g){
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D)g;

	   	for(int i = 0; i < maze.getHeigt();i++){
			for(int j = 0; j < maze.getWidth(); j++){
				g.setColor(Color.LIGHT_GRAY);
				g2d.draw(maze.getMaze()[i][j].getRectangle());
				if(maze.getMaze()[i][j].getType() == 1){
					g.setColor(Color.GRAY);
					g2d.fill(maze.getMaze()[i][j].getRectangle());
					g.setColor(Color.BLACK);
				}
			}
		}
		if(mode == PLAYMODE){
			for(Character c : world.getCharacters()){
				Ellipse2D.Double circle = new Ellipse2D.Double(c.getLocation().getX()-5, c.getLocation().getY()-5, 10, 10);
				g.setColor(c.getColor());
				g2d.fill(circle);
			}
		}
	}

}
