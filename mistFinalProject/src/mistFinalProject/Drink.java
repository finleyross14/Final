package mistFinalProject;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

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
		menu.put("No Topping", 0.00);
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


	public void printInfo() {
		System.out.print("Your order is: " + drinkSize + "oz " + drinkName);
	}
	
	public static void printSizes() {
		for(int i: sizes) {
			System.out.print(i + "oz ");
		}
		System.out.println();
	}

	public static void intro() throws InterruptedException{
		System.out.println("Hi, welcome to Finley and Jordan's drink shop!");
		Thread.sleep(1000);
		System.out.println("Feel free to browse our menu.");
		System.out.println();
		Thread.sleep(1000);
		System.out.println("Teas: Classic Milk Tea, Taro Milk Tea, Matcha Milk Tea, Strawberry Fruit Tea, Mango Fruit Tea, Passionfruit Fruit Tea");
		System.out.println("Coffees: Iced Latte, Frozen Latte");
		System.out.println("Toppings: Tapioca Pearls, Flavored Jelly, Popping Boba, Cream Topping");
		System.out.println();
		Thread.sleep(1000);
		System.out.println("Would you like to order a coffee or tea?");
		Thread.sleep(1000);
		
		System.out.println("Input 1 for coffee or input 2 for tea:");
	}
	
	
	public void rewards(Scanner scnr, int choice, double total) throws InterruptedException{
		System.out.println("Do you have a rewards membership? If so, type YES. If not, and want to create an account, type CREATE. Otherwise, Type NO.");
		String s = scnr.nextLine();
		if(s.equalsIgnoreCase("YES")) {
			System.out.println("Enter your 10 digit account number: ");
			long acc = scnr.nextLong();
			Long key = acc;
			if(Customer.customers.containsKey(key)) {
				System.out.println("Account succesfully accessed.");
				Thread.sleep(500);
				System.out.println("You have " + Customer.customers.get(key).getPoints() + " points.");
				Thread.sleep(500);
				System.out.println("It takes 50 points for a 15% discount reward or 200 points for a free drink reward.");
				Thread.sleep(500);
				System.out.println("Type 0 for no rewards, 1 for discount reward or 2 for drink reward.");
				int r = scnr.nextInt();
				
				if(r == 1) {
					System.out.println("You may compund multiple rewards on this order, but it will still cost 50 points per redeemeed reward");
					System.out.println("Do you wish to redeem multiple rewards? Type 1 for YES, Type 2 for NO");
					int y = scnr.nextInt();
					scnr.nextLine();
					if(y == 2) {
						int x = Customer.customers.get(key).discountReward();
						if(x == 1) {
							total *= .85;
						}
						else {
							
						}
					}
					else if(y == 1) {
						System.out.println("How many rewards do you wish to redeem?");
						int o = scnr.nextInt();
						int x = Customer.customers.get(key).discountReward(o);
						if(x == 1) {
							total *= Math.pow(.85, o);
						}
						else {
							
						}
					}
					
					
				}
				else if(r == 2) {
					int x = Customer.customers.get(key).drinkReward();
					if(x == 1) {
						total = 0;
					}
					else {
						
					}
				}
				else if(r == 0) {
					
				}
				else {
					System.out.println("Invalid Input");
				}
				Customer.customers.get(key).setPoints(Customer.customers.get(key).getPoints() + total);
				Customer.customers.get(key).printCustomerInfo();
				System.out.println("Your total is: $" + total);
				if(choice == 1) {
					Customer.customers.get(key).individualHistory.add(this);
				}
				else if (choice == 2) {
					Customer.customers.get(key).individualHistory.add(this);
				}
				
			}
			
			else {
				System.out.println("Account does not exist.");
				System.out.println("Your total is: $" + total);
			}
		
		}
		if(s.equalsIgnoreCase("CREATE")) {
			System.out.println("Enter a 10 digit phone number: ");
			long p = scnr.nextLong();
			scnr.nextLine();
			Customer cust = new Customer(p, total);
			Customer.addToHashMap(cust.getId(), cust);
			System.out.println("Account successfully created.");
			Thread.sleep(500);
			if(choice == 1) {
				cust.individualHistory.add(this);
			}
			else if (choice == 2) {
				cust.individualHistory.add(this);
			}
			cust.setPoints(total);
			cust.printCustomerInfo();
			System.out.println("Your total is: $" + total);
		}
		if(s.equalsIgnoreCase("NO")) {
			System.out.println("Your total is: $" + total);
		}
	}
	public static int coffeeOrTea(Scanner scnr) {
		int b = 0;
		int choice = scnr.nextInt();
		scnr.nextLine();
		while(choice != 1 && choice != 2) {
			System.out.println("Invalid input, please input 1 for coffee or 2 for tea.");
			b++;
			if(b > 3) {
				System.out.println("Are you messin' with me?");
			}
			choice = scnr.nextInt();
			scnr.nextLine();
		}
		return choice;
	}
	
}

