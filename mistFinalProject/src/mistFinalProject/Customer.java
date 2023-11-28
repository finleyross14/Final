package mistFinalProject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Customer {
	private long id;
	private double points; 
	private int numToppingReward;
	private int numDiscountReward;
	private int numDrinkReward;
	private static int numCustomers;
	protected HashSet<Drink> individualHistory = new HashSet<Drink>();
  	protected static HashMap<Long, Customer> customers = new HashMap<Long, Customer>();
			
	public Customer() {
		numCustomers++;
	}
	public Customer(long i, double p) {
		id = i;
		points = p;
		numCustomers++;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
		System.out.println("Points accumulated: " + points);
		System.out.println("Customer has " + numToppingReward + "free topping rewards.");
		System.out.println("Customer has " + numDiscountReward + "15% off rewards.");
		System.out.println("Customer has " + numDrinkReward + "free small drink rewards.");
	}
	
	public int discountReward() {
		if(points > 50.00) {
			numDiscountReward++;
			points -= 50.00;
			System.out.println("Discount reward applied.");
			return 1;
		}
		else {
			System.out.println("Insufficient point balance.");
			return 0;
		}
	}
	public int drinkReward() {
		if(points > 200.00) {
			numToppingReward++;
			points -= 200.00;
			System.out.println("Free drink reward applied.");
			return 1;
		}
		else {
			System.out.println("Insufficient point balance.");
			return 1;
		}
	}
	
	public static void addToHashMap(long i, Customer e) {
		customers.put(i, e);
	}
	
}
