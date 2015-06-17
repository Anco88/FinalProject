import java.util.ArrayList;
import java.util.Random;

/**
 * 
 */

/**
 * @author s2612925
 *
 */
public class ZombieController implements Controller {
	
	private Zombie zombie;
	private World world;

	ZombieController(Zombie z, World w){
		this.zombie = z;
		this.world = w;
	}

	/* (non-Javadoc)
	 * @see Controller#update()
	 */
	@Override
	public void update() {
		Random random = new Random();
		ArrayList<Character> temp = (ArrayList<Character>) world.getCharacters().clone();
		Character closest =  null;
		double distance = -1;
		for(Character c : temp){
			if(c.getType() == "human"){
				if(closest == null || zombie.getLocation().distance(c.getLocation()) < distance ){
					distance = zombie.getLocation().distance(c.getLocation());
					closest = c;
				}
			}
		}
		
		if(random.nextBoolean()){
			if(zombie.getLocation().getY() - closest.getLocation().getY() < 0 ){
				zombie.moveDown();
			}
			else{ zombie.moveUp();}
		}
		else{
			if(zombie.getLocation().getX() - closest.getLocation().getX() > 0 ){
				zombie.moveLeft();
			}
			else{ zombie.moveRight();}
		}
		
		
		for(Character c : temp){
			if(c.getType() == "human" && zombie.getLocation().distance(c.getLocation()) < 10){
				System.out.println("remove" + c);
				world.getCharacters().remove(c);
			}
		}
	}

}
