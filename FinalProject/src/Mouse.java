import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


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
	
	
	
	@Override
	public void mousePressed(MouseEvent e){
		super.mousePressed(e);
		location = e.getPoint();
		int y = e.getY()/ world.getMaze().getSIZE();
		int x = e.getX()/ world.getMaze().getSIZE();
		MazePoint point = world.getMaze().getMazeAt(x, y);
		point.setType(frame.getMode());
		System.out.println("Mousebutton pressed " + y + " "  + x );
		//TODO: catch if out of range
		panel.repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e){
	System.out.println("dragged");
	//TODO: catch if out of range, fix duplicate code.
	int y = e.getY()/ world.getMaze().getSIZE();
	int x = e.getX()/ world.getMaze().getSIZE();
	MazePoint point = world.getMaze().getMazeAt(x, y);
	point.setType(frame.getMode());
	System.out.println("Mousebutton pressed " + y + " "  + x );
	panel.repaint();
	}
}