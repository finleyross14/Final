package mistFinalProject;
import java.util.HashMap;
import java.util.ArrayList;

public class Drink {
	private String drinkName;
	private int drinkSize;
	private double price;
	private static final int[] sizes = {12, 16, 24};
	private static HashMap<String, Double> menu = new HashMap<String, Double>();
	private static ArrayList<Drink> orderHistory = new ArrayList<Drink>();
	

	public Drink() {
		menu.put("Classic Milk Tea", 5.00);
		menu.put("Taro Milk Tea", 5.50);
		menu.put("Matcha Milk Tea", 5.50);
		menu.put("Strawberry Fruit Tea", 6.00);
		menu.put("Mango Fruit Tea", 6.00);
		menu.put("Passionfruit Fruit Tea", 6.00);
		menu.put("Iced Latte", 4.00);
		menu.put("Frozen Latte", 5.00);
		menu.put("Tapioca Pearls", 1.25);
		menu.put("Flavored Jelly", 1.00);
		menu.put("Popping Boba", 1.50);
		menu.put("Cream Topping", 1.00);
	}
	
	public void setName(String newName) {
		drinkName = newName;
	}

	public void setSize(int newSize) {
	drinkSize = newSize;	
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void printItem() {
		System.out.println(drinkName + " " + drinkSize);
	}


}

