import java.awt.Rectangle;


/**
 * 
 */

/**
 * @author s2612925
 *
 */
public class MazePoint {
	private int type;
	private Rectangle rectangle;
	
	public MazePoint(int type, Rectangle rectangle) {
		super();
		this.type = type;
		this.rectangle = rectangle;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Rectangle getRectangle() {
		return rectangle;
	}
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	

}
