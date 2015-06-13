import java.util.ArrayList;

/**
 * 
 */

/**
 * @author anco
 *
 */
public class World {
	private Maze maze;
	private Settings settings;
	private ArrayList<Character> characters  = new ArrayList<Character>();
	
	World(){
		settings = new Settings();
	}

	public Maze getMaze() {
		return maze;
	}

	public void setMaze(Maze maze) {
		this.maze = maze;
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	public ArrayList<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(ArrayList<Character> characters) {
		this.characters = characters;
	}
	

}
