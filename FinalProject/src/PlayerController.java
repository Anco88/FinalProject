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
	int up, down, left, right;
	ArrayList<Integer> pressed;
	private Player player;
	
	
	PlayerController(int up, int down, int left, int right, ArrayList<Integer> pressed, Player p){
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
		this.player = p;
		this.pressed = pressed;
		
	}
	
	public void setLastCheck(Long time){
		lastCheck = time;
		System.out.println(time);
	}


	public void update() {
		System.out.println(System.nanoTime());
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
		if(lastUsefullIndex != -1){
			move(pressed.get(lastUsefullIndex));
		}
		
	}

	private void move(Integer key) {

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
		
	}


}
