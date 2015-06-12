import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseAction extends MouseAdapter {
	World world;
	Point location;
	EditPanel panel;
	
	MouseAction(World world, EditPanel panel){
		this.world = world;
		this.panel = panel;
		//frame.gamePanel.addMouseListener(this);
		//frame.gamePanel.addMouseMotionListener(this);
	}
	
	private void action(MouseEvent e){
		int y = e.getY()/ world.getMaze().getSIZE();
		int x = e.getX()/ world.getMaze().getSIZE();
		MazePoint point = world.getMaze().getMazeAt(x, y);
		point.setType(panel.getMode());
		System.out.println("Mousebutton pressed " + y + " "  + x );
	}
	
	
	@Override
	public void mousePressed(MouseEvent e){
		//super.mousePressed(e);
		action(e);
		panel.repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e){
		action(e);
		panel.repaint();
	}
}