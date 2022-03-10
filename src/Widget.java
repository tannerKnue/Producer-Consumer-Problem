//Tanner Knue
//Widget class with a constructor having a name and a variable count
public class Widget {
	
	private String name;
	private int count;
	
	public Widget(String name, int count) {
		this.name = name;
		this.count = count;
	}
	
	//getter and setter methods
	public String getName() {
		return this.name; 
	}
	
	public int getCount() {
		return this.count; 
	}
	
	public void setCount(int count) {
		this.count = count; 
	}
}
