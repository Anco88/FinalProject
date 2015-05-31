import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Mouse extends MouseAdapter {
	Maze maze;
	Point location;
	
	GraphMouse(Maze maze){
		this.model = model;
		this.model.frame.graphPanel.addMouseListener(this);
		this.model.frame.graphPanel.addMouseMotionListener(this);
	}
	
	@Override
	public void mousePressed(MouseEvent e){
		super.mousePressed(e);
		GraphVertex selected = null;
		location = e.getPoint();

		System.out.println("Mousebutton pressed");
		
		for(GraphVertex item : model.getVertex()){
			if(item.getRectangle().contains(location)){
				selected = item;
			}
		}
		model.setSelectedVertex(selected);
		model.frame.graphPanel.repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e){
	System.out.println("dragged");
	if(model.getSelectedVertex() != null){
		int newX = (int) ( e.getX() - location.getX() + model.getSelectedVertex().getRectangle().getX());
		int newY = (int) ( e.getY() - location.getY() + model.getSelectedVertex().getRectangle().getY());
		location.setLocation(e.getX(), e.getY());
		model.getSelectedVertex().getRectangle().setLocation(newX, newY);
		model.frame.graphPanel.repaint();
		}
	}
}