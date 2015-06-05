
public class Main {
	static GameFrame frame;
	static Maze maze;
	static World world;
	static Mouse mouse;
	public static void main(String[] args){
		
		newModel();

	}
	
	public static void newModel(){
		maze = new Maze();
		world = new World();
		world.setMaze(maze);
		frame = new GameFrame(world);
		mouse = new Mouse(world, frame);
		
	}
}
