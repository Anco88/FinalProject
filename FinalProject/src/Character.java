import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;



public class Character {
	int speed=0;
	private String type = "";
	World world = null;
	private Color color = Color.RED;
	Object direction;
	private Point2D.Double location;
	
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
		Point2D.Double p = new Point2D.Double(this.getLocation().getX()-1, this.getLocation().getY() );
		if(canMove(p)){
			this.setLocation(p);
		}
	}




	public void moveDown() {
		Point2D.Double p = new Point2D.Double(this.getLocation().getX(), this.getLocation().getY()+1 );
		if(canMove(p)){
			this.setLocation(p);
		}
		
	}

	public void moveUp() {
		Point2D.Double p = new Point2D.Double(this.getLocation().getX(), this.getLocation().getY()-1 );
		if(canMove(p)){
			this.setLocation(p);
		}
		
	}

	private boolean canMove(Double p) {
		Ellipse2D.Double c = new Ellipse2D.Double(p.getX()-5, p.getY()-5, 10, 10);
		ArrayList<MazePoint> rect = new ArrayList<MazePoint>();
		int a = (int) (p.getX() / world.getMaze().getSIZE());
		int b = (int) (p.getY() / world.getMaze().getSIZE());
		for(int x = a-1; x <= a + 1; x++){
			for(int y = b - 1; y <= b + 1; y++){
				if(x >= 0 && x < world.getMaze().getWIDTH() && y >= 0 && y < world.getMaze().getHEIGHT()){
					if(world.getMaze().getMazeAt(x, y).getType() == 1){
							rect.add(world.getMaze().getMazeAt(x, y));
					}
				}
			}
		}
		for(MazePoint m : rect){
			if( c.intersects(m.getRectangle()) ){
				return false;
			}
		}
		
		if(p.getY() - 5 < 0 || p.getY() + 5 > world.getMaze().getHEIGHT() * world.getMaze().getSIZE() ||
				p.getX() - 5 < 0 || p.getX() + 5 > world.getMaze().getHEIGHT() * world.getMaze().getSIZE()){
			return false;
		}
			
		return true;
	}

	public void moveRight() {
		Point2D.Double p = new Point2D.Double(this.getLocation().getX()+1, this.getLocation().getY() );
		if(canMove(p)){
			this.setLocation(p);
		}
		
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