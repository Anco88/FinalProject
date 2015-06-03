import java.awt.Rectangle;



public class Maze {
	int HEIGHT = 30;
	int WIDTH = 30;
	int SIZE = 20;
	public int getHEIGHT() {
		return HEIGHT;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getSIZE() {
		return SIZE;
	}

	public MazePoint[][] getMaze() {
		return maze;
	}

	
	
	MazePoint[][]	maze =  new MazePoint[HEIGHT][WIDTH];
	
	Maze(){
	
		for(int i = 0; i<HEIGHT;i++){
			
			for(int j = 0; j < WIDTH; j++){
				maze[i][j] = new MazePoint(0 ,new Rectangle(j*SIZE, i*SIZE,SIZE, SIZE));
			}
			
		}
	}
	
	public MazePoint getMazeAt(int a, int b){
		return maze[a][b];
	}
	
	public void setMazeAt(int a, int b, MazePoint o){
		maze[a][b] = o;
	}
}
