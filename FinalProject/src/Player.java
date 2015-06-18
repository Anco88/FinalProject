import java.awt.geom.Ellipse2D;
import java.util.ArrayList;


public class Player extends Character  {
	private long startTimer = -1;
	private int pickaxe = 5;
	private int wall = 0;
	private Boolean hasWon = false;
	private CurrentItem currentItem = new CurrentItem();
	private String name = "player";
	public Player(int x, int y, World world, String name) {
		super(x,y,world);
		this.setType("human");
		this.setName(name);
		currentItem.add("pickaxe");
		currentItem.add("wall");
		pickWall();
	}

	private void change(){
		setChanged();
		notifyObservers();
	}

	public void pickWall(){
		//System.out.println("pickwall");
		if(pickaxe > 0){
			if(getWallCloseBy() != null && getWallCloseBy().getType() == 1){
				//System.out.println("test");
				if(startTimer == -1){
					startTimer = System.currentTimeMillis();
					System.out.println("time start: " + startTimer);
				}
				else{
					//System.out.println(System.currentTimeMillis());
					if(System.currentTimeMillis() - startTimer > 20){
						getWallCloseBy().setType(0);
						wall++;
						pickaxe--;
						change();
						startTimer = -1;
						System.out.println("break down the wall");
					}
				}
			}
		}
		else{
			System.out.println("no Pickaxe");
		}
	}


	private MazePoint getWallCloseBy() {
		double x = location.getX();
		double y = location.getY();
		System.out.println(direction);
		switch (direction){
			case 'n': 
				y -= 7;
				break;
			case 's': 
				y += 7;
				break;
			case 'e':
				x += 7;
				break;
			case 'w':
				x -= 7;
				break;
		}
		MazePoint p = world.getMaze().getMazeAt((int) x / world.getMaze().getSIZE(), (int) y / world.getMaze().getSIZE()); 
		System.out.println(p + " : " + p.getType());
		return p;
		
	}


	public int getPickaxe() {
		return pickaxe;
	}


	public void setPickaxe(int pickaxe) {
		this.pickaxe = pickaxe;
	}


	public int getWall() {
		return wall;
	}


	public void setWall(int wall) {
		this.wall = wall;
	}


	public void useItem() {
		
		switch(currentItem.getCurrent()){
		case "pickaxe":	pickWall();
		//				System.out.println("pcik wall");
						break;
		case "wall": 	buildWall();
		//System.out.println("Buildwall");
						break;
		}
		
	}


	private void buildWall() {
		MazePoint m = canBuildWall();
		System.out.println("MP: " + m);
		if(wall > 0){
			if(m != null){
				//System.out.println("test");
				if(startTimer == -1){
					startTimer = System.currentTimeMillis();
					System.out.println("time start: " + startTimer);
				}
				else{
					//System.out.println(System.currentTimeMillis());
					if(System.currentTimeMillis() - startTimer > 20){
						checkLocationAfterBuildWall(m);
						m.setType(1);
						wall--;
						change();
						
						startTimer = -1;
						System.out.println("break down the wall");
					}
				}
			}
		}
		else{
			System.out.println("no Pickaxe");
		}
	}

	private void checkLocationAfterBuildWall(MazePoint p) {
		System.out.println("chekc stuk: " + p);
		Ellipse2D.Double c = new Ellipse2D.Double(location.getX()-5, location.getY()-5, 10, 10);
		while(c.intersects(p.getRectangle())){
			System.out.println("stuk");
			switch(direction){
			case 'n': 	location.setLocation(location.getX(), location.getY() + 1);
			break;
			case 's': 	location.setLocation(location.getX(), location.getY() - 1);
			break;	
			case 'e': 	location.setLocation(location.getX() - 1, location.getY());
			break;
			case 'w': 	location.setLocation(location.getX() + 1, location.getY());
			break;
			}
			c = new Ellipse2D.Double(location.getX()-5, location.getY()-5, 10, 10);
		}
		
	}

	private MazePoint canBuildWall() {
		int n = 0;
		int x = (int) location.getX();
		int y = (int) location.getY();
		if(direction == 'n' || direction == 's'){
			n = y;
		}
		else{
			n = x;
		}
		
		// check if player is in good half of square
		n = n % world.getMaze().getSIZE();
		if( (direction == 'n' || direction == 'w') && n >= world.getMaze().getSIZE()/2){
			return null;
		}
		if( (direction == 's' || direction == 'e') && n <= world.getMaze().getSIZE()/2){
			return null;
		}
		// check if there is no wall in square next to it
		x = x / world.getMaze().getSIZE();
		y = y / world.getMaze().getSIZE();
		
		switch(direction){
			case 'n': 	y -= 1;
			break;
			case 's': 	y += 1;
			break;
			case 'e': 	x += 1;
			break;
			case 'w': 	x -= 1;
			break;
		}
		MazePoint m = world.getMaze().getMazeAt(x, y);
		if(m != null && m.getType() == 0){
			System.out.println("can build wall");
			return m;
		}
		
		return null;
	}

	public void stopUseItem() {
		startTimer = -1;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCurrentItem() {
		return currentItem.getCurrent();
	}
	
	public void nextItem() {
		currentItem.next();
		change();
	}

	public Boolean getHasWon() {
		return hasWon;
	}

	public void setHasWon(Boolean hasWon) {
		this.hasWon = hasWon;
		if(hasWon){
			change();			
		}
	}
	
}
