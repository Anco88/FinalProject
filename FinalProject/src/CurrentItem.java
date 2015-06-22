import java.util.ArrayList;

/**
 * @author Anco Gietema (s2614154) & Dekel Viner (s2612925)
 *
 *	This class is a simple circular list implementation, 
 *  used to go rounds in the items a player can use
 */

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
