import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class KeyAction extends KeyAdapter {
	private ArrayList<Integer> pressedKeys  = new ArrayList<Integer>();
	
	KeyAction(){
		super();
		System.out.println("keylisteren done");
	}
	
	@Override
 	public void keyPressed(KeyEvent e){
		System.out.println("key");
		System.out.println(e);
	}
	
}
