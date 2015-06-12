import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

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
	
	GamePanel(){

		this.setPreferredSize(new Dimension(602,602));
		//this.model = model;

		
	}
	
	GamePanel(World world){
		this();
		this.maze = world.getMaze();
		repaint();
		
	}
	
	
@Override
	public void paintComponent(Graphics g){
	super.paintComponent(g);
		g.setColor(Color.BLACK);
		
		for(int i = 0; i < maze.getHEIGHT();i++){
			for(int j = 0; j < maze.getWIDTH(); j++){
				g.drawRect(i*maze.getSIZE(), j*maze.getSIZE(), maze.getSIZE(), maze.getSIZE());
				System.out.println("square");
				if(maze.getMaze()[i][j].getType() == 1){
					g.setColor(Color.GRAY);
					g.fillRect(i*maze.getSIZE(), j*maze.getSIZE(),  maze.getSIZE(), maze.getSIZE());
					g.setColor(Color.BLACK);
				}
			}
		}
		
	}
}
