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
	private PlayPanel playPanel;
	
	Update(GamePanel panel, PlayPanel playPanel){
		this.panel = panel;
		this.playPanel = playPanel;
	}
	
	public ArrayList<Controller> getControllers(){
		return controllers;
	}
	
	public void checkEnd() {
		if(panel.getWorld().getCharacters().size() - panel.getWorld().getSettings().getNumberOfZombies() <= 1){
			System.out.println("GAME OVER");
			playPanel.stopTimer();
		}
		
	}

	@Override
	public void run() {
		//System.out.println(controllers);
		
		for(Object  c: controllers){
			//System.out.println("contoller: "+c);
			((Controller) c).update();
			
		}
		checkEnd();
		panel.repaint();
		
	}

}
