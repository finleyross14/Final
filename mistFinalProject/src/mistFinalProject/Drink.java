package mistFinalProject;

public class Drink {
	private String drinkName;
	private int drinkSize;
	
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
public class Tea extends Drink {
	private int percentSweetener;
}
public class Coffee extends Drink {
private int numShots;

}
}
