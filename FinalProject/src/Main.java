
public class Main {
	static GameFrame frame;
	static Maze maze;
	public static void main(String[] args){
		
		newModel();

	}
	
	public static void newModel(){
		maze = new Maze();
		frame = new GameFrame(maze);
	}
}
