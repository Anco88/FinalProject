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
	//private GraphModel model;
	
	GamePanel(){

		this.setPreferredSize(new Dimension(820,820));
		//this.model = model;
		repaint();
		
	}
	
	
@Override
	public void paintComponent(Graphics g){
	super.paintComponent(g);
		g.setColor(Color.BLACK);
		for(int i = 0; i<100;i++){
			for(int j = 0; j < 100; j++){
				g.drawRect(j*10, i*10,10, 10);
				
			}
			
		}
	}
}
