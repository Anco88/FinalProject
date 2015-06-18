import java.util.ArrayList;


public class Player extends Character  {
	private ArrayList <Items> inventory = new ArrayList<Items>();
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
		//currentItem.add("wall");
		pickWall();
	}

	private void change(){
		setChanged();
		notifyObservers();
	}
	
	public ArrayList <Items> getInventory() {
		return inventory;
	}


	public void setInventory(ArrayList <Items> inventory) {
		this.inventory = inventory;
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
		if(currentItem.getCurrent()=="pickaxe"){
			pickWall();
		}
		
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
