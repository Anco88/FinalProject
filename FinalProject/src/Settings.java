/**
 * @author Anco Gietema (s2614154) & Dekel Viner (s2612925)
 *
 */

public class Settings {
	private int numberOfPlayers;
	//private int numberOfAI;		not used yet
	//private int numberOfItems; 	not used yet
	private int numberOfZombies =2;
	
	Settings(){
		numberOfPlayers = 2;
		numberOfZombies = 2;
	}
	
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public int getNumberOfZombies() {
		return numberOfZombies;
	}

	public void setNumberOfZombies(String text) {
		try {
			int n = Integer.parseInt(text);
			if(n > 0 && n < 50){
				numberOfZombies = n;
			}
		} catch (NumberFormatException e) {
			System.err.println("Input isn't good number");
			e.printStackTrace();
		}		
	}
	
}
