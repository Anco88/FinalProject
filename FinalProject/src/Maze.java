import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;

/**
 * @author Anco Gietema (s2614154) & Dekel Viner (s2612925)
 *
 * Class to store the maze in and methods to save and load the maze
 */

public class Maze {
	static int  HEIGHT = 30;
	static int WIDTH = 30;
	static int SIZE = 20;
	MazePoint[][] maze =  new MazePoint[HEIGHT][WIDTH];
	String name;
	
	public int getHeigt() {
		return HEIGHT;
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getSize() {
		return SIZE;
	}

	public MazePoint[][] getMaze() {
		return maze;
	}
	
	Maze(){
		// create new maze with MazePoints();
		for(int i = 0; i < HEIGHT;i++){
			for(int j = 0; j < WIDTH; j++){
				maze[i][j] = new MazePoint(0 ,new Rectangle(i*SIZE, j*SIZE,SIZE, SIZE));
			}
			
		}
	}
	
	// return a specific MazePoint at a,b
	public MazePoint getMazeAt(int a, int b){
		if (exist(a, b)){
			return maze[a][b];
		}
		return null;
	}
	
	public void setMazeAt(int a, int b, MazePoint o){
		maze[a][b] = o;
	}

	public void save(String filename, String name){
		BufferedWriter w = null;
		    try {
				w = new BufferedWriter( new FileWriter( filename));
				w.write(name);
				w.newLine();
				w.write(WIDTH +  " " + HEIGHT);
				w.newLine();
				
				for(int h = 0; h < HEIGHT; h++){
					for(int i = 0; i < WIDTH; i++){
						w.write(maze[h][i].getType() + " ");
					}
					w.newLine();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if(w != null){
				try {
					w.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

	public void save(String filename) {
		save(filename, "untitled");
	}

	public void load(String filename){
		Reader inStream;
		BufferedReader input;
		String inLine;
		int width = 0;
		int height = 0;
		
		try{
			inStream = new FileReader(filename);
			input = new BufferedReader(inStream);
			if((inLine = input.readLine()) != null){
				setName(inLine);
			}
			if((inLine = input.readLine()) != null){
				StringTokenizer st = new StringTokenizer(inLine);
				if(st.hasMoreTokens()){
					width = Integer.parseInt(st.nextToken());
				}
				if(st.hasMoreTokens()){
					height = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < height && (inLine = input.readLine()) != null; i++){
				processLine(inLine, width, i);
			}
		}
		catch(IOException e){
			System.err.println("Couldn't load file");
			  e.printStackTrace();
		}		
	}

	private void processLine(String inLine, int width, int currHeight) {
		StringTokenizer st = new StringTokenizer(inLine);
		int i = 0;
		while(st.hasMoreTokens() && i < width){
			maze[currHeight][i].setType(Integer.parseInt(st.nextToken()));
			System.out.print(maze[currHeight][i].getType());
			i++;
			
		}
		System.out.println();
	}

	private void setName(String inLine) {
		// TODO Auto-generated method stub
		
	}

	// checks if the x, y exists in the maze
	public boolean exist(int x, int y) {
	  if(x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT){
		  return true;
	  }
		return false;
	}
}
