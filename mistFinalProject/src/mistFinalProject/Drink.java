package mistFinalProject;

public class Drink {
	private String drinkName;
	private int drinkSize;
	private static final int[] sizes = {12, 16, 24};
	
	public void setName(String newName) {
		drinkName = newName;
	}

	public void setSize(int newSize) {
	drinkSize = newSize;	
	}
	
	public void printItem() {
		System.out.println(drinkName + " " + drinkSize);
	}


}

