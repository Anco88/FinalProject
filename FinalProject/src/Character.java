import java.awt.Point;
import java.awt.geom.Point2D;


public class Character {
	int speed=0;
	Object direction;
	private Point2D.Double location;
	
	Character(){
		 setLocation(new Point2D.Double());
	}
	
	Character(int x, int y){
		 setLocation(new Point2D.Double(x, y));
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
	public void setDirection(Object direction) {
		this.direction = direction;
	}

	public Point2D.Double getLocation() {
		return location;
	}

	public void setLocation(Point2D.Double location) {
		this.location = location;
	}
	
	
	public void moveLeft() {
		this.setLocation(new Point2D.Double(this.getLocation().getX()-1, this.getLocation().getY() ));
		
	}

	public void moveDown() {
		this.setLocation(new Point2D.Double(this.getLocation().getX(), this.getLocation().getY()+1 ));
		
		
	}

	public void moveUp() {
		this.setLocation(new Point2D.Double(this.getLocation().getX(), this.getLocation().getY()-1 ));
	
		
	}

	public void moveRight() {
		this.setLocation(new Point2D.Double(this.getLocation().getX()+1, this.getLocation().getY() ));
		
		
	}
	
	
	
}
