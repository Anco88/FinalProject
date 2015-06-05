import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Mouse extends MouseAdapter {
	World world;
	Point location;
	GamePanel panel;
	
	Mouse(World world, GameFrame frame){
		this.world = world;
		panel = frame.gamePanel;
		frame.gamePanel.addMouseListener(this);
		frame.gamePanel.addMouseMotionListener(this);
	}
	
	@Override
	public void mousePressed(MouseEvent e){
		super.mousePressed(e);
		location = e.getPoint();

		System.out.println("Mousebutton pressed" + location);
		
		panel.repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e){
	System.out.println("dragged");
	}
}