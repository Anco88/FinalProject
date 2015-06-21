import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseAction extends MouseAdapter {
	private World world;
	//Point location; // need to see if is used
	private EditPanel panel;
	
	MouseAction(World world, EditPanel panel){
		this.world = world;
		this.panel = panel;
	}
	
	private void action(MouseEvent e){
		int y = e.getY()/ world.getMaze().getSize();
		int x = e.getX()/ world.getMaze().getSize();
		MazePoint point = world.getMaze().getMazeAt(x, y);
		// check if the MazePoint exists
		if(point != null){
			point.setType(panel.getMode());
			// maze is changed so repaint
			panel.repaint();
		}
		//System.out.println("Mousebutton pressed " + y + " "  + x );
	}
	
	@Override
	public void mousePressed(MouseEvent e){
		action(e);
	}
	
	@Override
	public void mouseDragged(MouseEvent e){
		action(e);
	}
}