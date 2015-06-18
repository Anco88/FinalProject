import javax.swing.JFrame;


public class Main {
	static MainFrame frame;
	static Maze maze;
	static World world;
	public static void main(String[] args){
		
		newModel();

	}
	
	public static void newModel(){
		maze = new Maze();
		world = new World();
		world.setMaze(maze);
		//frame = new GameFrame(world);
		frame = new MainFrame(world);
		world.setFrame(frame);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
