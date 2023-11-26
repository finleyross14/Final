package mistFinalProject;
import java.util.HashMap;
import java.util.ArrayList;

public class Drink {
	protected String drinkName;
	protected int drinkSize;
	protected double price;
	protected String drinkType;
	protected String topping;
	protected static final int[] sizes = {12, 16, 24};
	protected static HashMap<String, Double> menu = new HashMap<String, Double>();
	protected static ArrayList<Drink> orderHistory = new ArrayList<Drink>();
	

	public Drink() {
		menu.put("Classic Milk Tea", 5.00);
		menu.put("Taro Milk Tea", 5.50);
		menu.put("Matcha Milk Tea", 5.50);
		menu.put("Strawberry Fruit Tea", 6.00);
		menu.put("Mango Fruit Tea", 6.00);
		menu.put("Passionfruit Fruit Tea", 6.00);
		menu.put("Iced Latte", 4.00);
		menu.put("Frozen Coffee", 5.00);
		menu.put("Tapioca Pearls", 1.25);
		menu.put("Flavored Jelly", 1.00);
		menu.put("Popping Boba", 1.50);
		menu.put("Cream Topping", 1.00);
	}
	

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public int getDrinkSize() {
		return drinkSize;
	}


	public void setDrinkSize(int drinkSize) {
		this.drinkSize = drinkSize;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getDrinkType() {
		return drinkType;
	}


	public void setDrinkType(String drinkType) {
		this.drinkType = drinkType;
	}


	public String getTopping() {
		return topping;
	}


	public void setTopping(String topping) {
		this.topping = topping;
	}


	public void printItem() {
		System.out.println(drinkName + " " + drinkSize);
	}
	
	public static void printSizes() {
		for(int i: sizes) {
			System.out.print(i + "oz ");
		}
	}
	
	


}

