package mistFinalProject;

public class Drink {
	private String drinkName;
	private int drinkSize;
	
	// static array of all toppings          
	private String[] size = new String[3]; {
		size[1]= "12 oz";
		size[2]= "16 oz";
		size[3]= "24 oz";
	}
	
	public void setName(String newName) {
		drinkName = newName;
	}

	public void setSize(int newSize) {
	drinkSize = newSize;	
	}
	
	public void printItem() {
		System.out.println(drinkName + " " + drinkSize);
	}
	

	

	
	//create topping
	
}
