import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * 
 */

/**
 * @author s2612925
 *
 */
public class PlayerController implements Controller{
	Long lastCheck;
	private int up, down, left, right, useItem;
	ArrayList<Integer> pressed;
	private Player player;
	private JPanel panel;
	private int nextItem;

	
	
	PlayerController(int up, int down, int left, int right, int useItem, int nextItem, ArrayList<Integer> pressed, 
			Player p, JPanel panel){
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
		this.player = p;
		this.pressed = pressed;
		this.useItem = useItem;
		this.panel = panel;
		this.nextItem = nextItem;
		InputMap im = panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = panel.getActionMap();
		
		im.put(KeyStroke.getKeyStroke(nextItem, 0), this);        

	    am.put(this, new ChangeItem(p, this));

		
	}
	
	public class ChangeItem extends AbstractAction {

	    private Player p;
	    private PlayerController c;

	    public ChangeItem(Player p, PlayerController c) {
	        this.p = p;
	        this.c = c;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        c.player.nextItem();
	        System.out.println("change item");
	    }
	}
	
	
	// need to implemented futher, will be used to change distance travelled
	public void setLastCheck(Long time){
		lastCheck = time;
		//System.out.println(time);
	}


	public void update() {
		//System.out.println(System.nanoTime());
		int lastUsefullIndex=-1;
		if(pressed.lastIndexOf(up) > lastUsefullIndex){
			lastUsefullIndex = pressed.lastIndexOf(up);
		}
		if(pressed.lastIndexOf(left) > lastUsefullIndex){
			lastUsefullIndex = pressed.lastIndexOf(left);
		}
		if(pressed.lastIndexOf(right) > lastUsefullIndex){
			lastUsefullIndex = pressed.lastIndexOf(right);
		}
		if(pressed.lastIndexOf(down) > lastUsefullIndex){
			lastUsefullIndex = pressed.lastIndexOf(down);
		}
		if(pressed.lastIndexOf(useItem) > lastUsefullIndex){
			lastUsefullIndex = pressed.lastIndexOf(useItem);
		}
		if(lastUsefullIndex != -1){
			action(pressed.get(lastUsefullIndex));
		}
		else{
			player.stopUseItem();
		}
		
		
	}

	private void action(Integer key) {

		if(key == up){
			player.moveUp();
		}	
		if(key == down){
			player.moveDown();
		}	
		if(key == left){
			player.moveLeft();
		}	
		if(key == right){
			player.moveRight();
		}
		if(key == useItem){
			player.useItem();
			System.out.println("use item");
		}
		else{
			player.stopUseItem();
		}
		
	}




}
