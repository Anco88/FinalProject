import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
// MouseAction replaced this class

public class Mouse extends MouseAdapter {
	World world;
	Point location;
	GamePanel panel;
	GameFrame frame;
	
	Mouse(World world, GameFrame frame){
		this.world = world;
		this.frame = frame;
		panel = frame.gamePanel;
		frame.gamePanel.addMouseListener(this);
		frame.gamePanel.addMouseMotionListener(this);
	}
	
	private void action(MouseEvent e){
		int y = e.getY()/ world.getMaze().getSIZE();
		int x = e.getX()/ world.getMaze().getSIZE();
		MazePoint point = world.getMaze().getMazeAt(x, y);
		point.setType(frame.getMode());
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