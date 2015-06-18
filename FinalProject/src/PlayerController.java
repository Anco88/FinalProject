import java.awt.Color;
import java.util.ArrayList;
import java.util.TimerTask;

/**
 * 
 */

/**
 * @author s2612925
 *
 */
public class PlayerController implements Controller{
	Long lastCheck;
	int up, down, left, right, useItem;
	ArrayList<Integer> pressed;
	private Player player;

	
	
	PlayerController(int up, int down, int left, int right, int useItem, ArrayList<Integer> pressed, Player p){
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
		this.player = p;
		this.pressed = pressed;
		this.useItem = useItem;
		
	}
	
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
