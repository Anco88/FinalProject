import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * @author Anco Gietema (s2614154) & Dekel Viner (s2612925)
 *
 */

public class KeyAction extends KeyAdapter {
	private ArrayList<Integer> pressedKeys  = new ArrayList<Integer>();
	
	KeyAction(){
		super();
	}
	
	public ArrayList<Integer> getPressedKeys(){
		return pressedKeys;
	}
	
	@Override
 	public void keyPressed(KeyEvent e){
		if(pressedKeys.contains(e.getKeyCode())){
			pressedKeys.remove((Integer) e.getKeyCode());
		}
		pressedKeys.add(e.getKeyCode());
		//System.out.println(pressedKeys);
	}
	
	@Override
 	public void keyReleased(KeyEvent e){
		pressedKeys.remove((Integer) e.getKeyCode());
		//System.out.println(pressedKeys);
	}
	
}
