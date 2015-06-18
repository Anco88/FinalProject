import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author s2614154
 *
 */
public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Maze maze;
	private World world;
	
	GamePanel(){

		this.setPreferredSize(new Dimension(602,602));
		//this.model = model;

		
	}
	
	GamePanel(World world){
		this();
		this.maze = world.getMaze();
		this.world = world;
		repaint();
		
	}
	
	
@Override
	public void paintComponent(Graphics g){
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D)g;

	   // Assume x, y, and diameter are instance variables.
   		g.setColor(Color.LIGHT_GRAY);
		
		for(int i = 0; i < maze.getHEIGHT();i++){
			for(int j = 0; j < maze.getWIDTH(); j++){
				//g.drawRect(i*maze.getSIZE(), j*maze.getSIZE(), maze.getSIZE(), maze.getSIZE());
				g2d.draw(maze.getMaze()[i][j].getRectangle());
				if(maze.getMaze()[i][j].getType() == 1){
					g.setColor(Color.GRAY);
					g2d.fill(maze.getMaze()[i][j].getRectangle());
					g.setColor(Color.BLACK);
				}
			}
		}
		
		for(Character c : world.getCharacters()){
			Ellipse2D.Double circle = new Ellipse2D.Double(c.getLocation().getX()-5, c.getLocation().getY()-5, 10, 10);
			g.setColor(c.getColor());
			g2d.fill(circle);
		}
		
	}

	public World getWorld() {
		return world;
	}
}
