package mistFinalProject;

public class Customer {
	private int id;
	private String name;
	private double points; 
	private int numToppingReward;
	private int numDiscountReward;
	private int numDrinkReward;
	private static int numCustomers;
	
	public Customer() {
		numCustomers++;
	}
	public Customer(int i, String n, double p) {
		id = i;
		name = n;
		points = p;
		numCustomers++;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}
	public int getNumToppingReward() {
		return numToppingReward;
	}
	public void setNumToppingReward(int numToppingReward) {
		this.numToppingReward = numToppingReward;
	}
	public int getNumDiscountReward() {
		return numDiscountReward;
	}
	public void setNumDiscountReward(int numDiscountReward) {
		this.numDiscountReward = numDiscountReward;
	}
	public int getNumDrinkReward() {
		return numDrinkReward;
	}
	public void setNumDrinkReward(int numDrinkReward) {
		this.numDrinkReward = numDrinkReward;
	}
	public static int getNumCustomers() {
		return numCustomers;
	}
	public static void setNumCustomers(int numCustomers) {
		Customer.numCustomers = numCustomers;
	}
	
	public void printCustomerInfo() {
		System.out.println("Customer ID: " + id);
		System.out.println("Customer name: " + name);
		System.out.println("Points accumulated: " + points);
		System.out.println("Customer has " + numToppingReward + "free topping rewards.");
		System.out.println("Customer has " + numDiscountReward + "15% off rewards.");
		System.out.println("Customer has " + numDrinkReward + "free small drink rewards.");
	}
	
	public void generateToppingReward() {
		if(points > 50.00) {
			numToppingReward++;
			points -= 50.00;
			System.out.println("Successfully added 1 topping reward.");
		}
		else {
			System.out.println("Insufficient point balance.");
		}
	}
	public void generateDiscountReward() {
		if(points > 50.00) {
			numDiscountReward++;
			points -= 50.00;
			System.out.println("Successfully added 1 discount reward.");
		}
		else {
			System.out.println("Insufficient point balance.");
		}
	}
	public void generateDrinkReward() {
		if(points > 200.00) {
			numToppingReward++;
			points -= 200.00;
			System.out.println("Successfully added 1 drink reward.");
		}
		else {
			System.out.println("Insufficient point balance.");
		}
	}
	
}
