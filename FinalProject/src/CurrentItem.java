import java.util.ArrayList;
public class CurrentItem {
	private int current = 0;
	private ArrayList<String> array = new ArrayList<String>();
	
	// add item to array
	public void add(String s){
		array.add(s);
	}
	
	public String getCurrent(){
		return array.get(current);
	}
	
	// go to next item
	public void next(){
		current++;
		current %= array.size();
	}
}
