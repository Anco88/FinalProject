
public class Maze {
	Object maze[][]; 
	
	public Object getMazeAt(int a, int b){
		return maze[a][b];
	}
	
	public void setMazeAt(int a, int b, Object o){
		maze[a][b] = o;
	}
}
