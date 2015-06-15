/**
 * 
 */

/**
 * @author anco
 *
 */
public class Settings {
	int numberOfPlayers;
	int numberOfAI;
	int numberOfItems;
	
	Settings(){
		numberOfPlayers = 1;
		numberOfAI = 0;
		numberOfItems = 0;
	}
	
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	public int getNumberOfAI() {
		return numberOfAI;
	}
	public void setNumberOfAI(int numberOfAI) {
		this.numberOfAI = numberOfAI;
	}
	public int getNumberOfItems() {
		return numberOfItems;
	}
	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	
}
