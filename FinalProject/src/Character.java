import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.Observable;



/**
 * @author anco
 *
 */
public abstract class Character extends Observable{
	protected int speed=0; // not used yet
	private String type = "";
	protected World world = null;
	private Color color = Color.RED;
	protected char direction = 'n';
	protected Point2D.Double location;
	
	Character(){
		 setLocation(new Point2D.Double());
	}
	
	Character(int x, int y, World world){
		 setLocation(new Point2D.Double(x, y));
		 this.world = world;

	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Object getDirection() {
		return direction;
	}
	public void setDirection(char direction) {
		this.direction = direction;
	}

	public Point2D.Double getLocation() {
		return location;
	}

	public void setLocation(Point2D.Double location) {
		this.location = location;
	}
	
	
	public void moveLeft() {
		Point2D.Double p = new Point2D.Double(this.getLocation().getX()-1, this.getLocation().getY() );
		if(canMove(p)){
			this.setLocation(p);
		}
		direction = 'w';
	}




	public void moveDown() {
		Point2D.Double p = new Point2D.Double(this.getLocation().getX(), this.getLocation().getY()+1 );
		if(canMove(p)){
			this.setLocation(p);
		}
		direction = 's';
		
	}

	public void moveUp() {
		Point2D.Double p = new Point2D.Double(this.getLocation().getX(), this.getLocation().getY()-1 );
		if(canMove(p)){
			this.setLocation(p);
		}
		direction = 'n';
	}
	
	public void moveRight() {
		Point2D.Double p = new Point2D.Double(this.getLocation().getX()+1, this.getLocation().getY() );
		if(canMove(p)){
			this.setLocation(p);
		}
		direction = 'e';
	}


	private boolean canMove(Double p) {
		Ellipse2D.Double c = new Ellipse2D.Double(p.getX()-5, p.getY()-5, 10, 10);
		ArrayList<MazePoint> rect = new ArrayList<MazePoint>();
		int a = (int) (p.getX() / world.getMaze().getSIZE());
		int b = (int) (p.getY() / world.getMaze().getSIZE());
		
		// add the 9 surrounding mazepoints to array to check overlap
		for(int x = a-1; x <= a + 1; x++){
			for(int y = b - 1; y <= b + 1; y++){
				if(x >= 0 && x < world.getMaze().getWIDTH() && y >= 0 && y < world.getMaze().getHEIGHT()){
					if(world.getMaze().getMazeAt(x, y).getType() == 1){
							rect.add(world.getMaze().getMazeAt(x, y));
					}
				}
			}
		}
		// check if there is a overlap with surrounding mazepoints
		for(MazePoint m : rect){
			if( c.intersects(m.getRectangle()) ){
				return false;
			}
		}
		// check if the char want to go out of the maze
		if(p.getY() - 5 < 0 || p.getY() + 5 > world.getMaze().getHEIGHT() * world.getMaze().getSIZE() ||
				p.getX() - 5 < 0 || p.getX() + 5 > world.getMaze().getHEIGHT() * world.getMaze().getSIZE()){
			return false;
		}
		return true;
	}


	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
