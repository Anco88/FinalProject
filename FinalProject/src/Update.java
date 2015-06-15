import java.util.ArrayList;
import java.util.TimerTask;

/**
 * 
 */

/**
 * @author s2612925
 *
 */
public class Update extends TimerTask {
	ArrayList<Controller> controllers = new ArrayList<Controller>();
	private GamePanel panel = null;
	
	Update(GamePanel panel){
		this.panel = panel;
	}
	
	public ArrayList<Controller> getControllers(){
		return controllers;
	}

	@Override
	public void run() {
		System.out.println(controllers);
		
		for(Object  c: controllers){
			System.out.println("contoller: "+c);
			((Controller) c).update();
			
		}
		panel.repaint();
		
	}

}
