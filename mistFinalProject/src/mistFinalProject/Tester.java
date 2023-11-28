package mistFinalProject;
import java.util.HashSet;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) throws InterruptedException {
		Customer Finley = new Customer(2193817908L, 100000.0);
		Customer Jordan = new Customer(6789828708L, 2.0);
		Customer.addToHashMap(Finley.getId(), Finley);
		Customer.addToHashMap(Jordan.getId(), Jordan);
		Drink m = new Drink();
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Hi, welcome to Finley and Jordan's drink shop!");
		Thread.sleep(2000);
		System.out.println("Feel free to browse our menu.");
		System.out.println();
		Thread.sleep(1000);
		System.out.println("Teas: Classic Milk Tea, Taro Milk Tea, Matcha Milk Tea, Strawberry Fruit Tea, Mango Fruit Tea, Passionfruit Fruit Tea");
		System.out.println("Coffees: Iced Latte, Frozen Latte");
		System.out.println("Toppings: Tapioca Pearls, Flavored Jelly, Popping Boba, Cream Topping");
		System.out.println();
		Thread.sleep(2000);
		System.out.println("Would you like to order a coffee or tea?");
		Thread.sleep(2000);
		
		System.out.println("Input 1 for coffee or input 2 for tea:");
		int choice = scnr.nextInt();
		scnr.nextLine();
		int b = 0;
		
		//Makes sure they choose coffee or tea
		while(choice != 1 && choice != 2) {
			System.out.println("Invalid input, please input 1 for coffee or 2 for tea.");
			b++;
			if(b > 3) {
				System.out.println("Are you messin' with me?");
			}
			choice = scnr.nextInt();
			scnr.nextLine();
		}
		//Order logic for coffee
		Coffee drink = new Coffee();
		Tea teadrink = new Tea();
		double total = 0.0;
		if(choice == 1) {
			
			System.out.println("What is your drink of choice? (Please type the exact name case sensitive)");
			String drinkOrder = scnr.nextLine();
			//Testing for if drink exists
			if(Drink.menu.keySet().contains(drinkOrder) != true) {
				while(Drink.menu.keySet().contains(drinkOrder) != true) {
					System.out.println("Invalid input, please type the exact name case sensitive.");
					drinkOrder = scnr.nextLine();
				}
			}
			drink.setDrinkName(drinkOrder);
			System.out.println("What size would you like: 12oz, 16oz, or 24oz?");
			System.out.println("Please input 12, 16, or 24.");
			int s = scnr.nextInt();
			scnr.nextLine();
			if(s != Drink.sizes[0] && s != Drink.sizes[1] && s != Drink.sizes[2]) {
				while(s != Drink.sizes[0] && s != Drink.sizes[1] && s != Drink.sizes[2]) {
					System.out.println("Invalid input, please input a valid size.");
					s = scnr.nextInt();
					
				}
			}
			drink.setDrinkSize(s);
			System.out.println("How many shots of espresso?");
			System.out.println("Please input a number 1-4: ");
			int e = scnr.nextInt();
			scnr.nextLine();
			if(e < 1 || e > 4) {
				while(e < 1 || e > 4) {
					System.out.println("Invalid input, please input a valid number of espresso shots.");
					e = scnr.nextInt();
				}
			}
			drink.setNumShots(e);
			Drink.orderHistory.add(drink);
			total = drink.priceDrink();
		}
		
		//Order logic for tea
		else if(choice == 2) {
			
			System.out.println("What is your drink of choice? (Please type the exact name case sensitive)");
			String drinkOrder = scnr.nextLine();
			//Testing for if drink exists
			if(Drink.menu.keySet().contains(drinkOrder) != true) {
				while(Drink.menu.keySet().contains(drinkOrder) != true) {
					System.out.println("Invalid input, please type the exact name case sensitive.");
					drinkOrder = scnr.nextLine();
				}
			}
			teadrink.setDrinkName(drinkOrder);
			System.out.println("What size would you like: 12oz, 16oz, or 24oz?");
			System.out.println("Please input 12, 16, or 24.");
			int s = scnr.nextInt();
			scnr.nextLine();
			if(s != Drink.sizes[0] && s != Drink.sizes[1] && s != Drink.sizes[2]) {
				while(s != Drink.sizes[0] && s != Drink.sizes[1] && s != Drink.sizes[2]) {
					System.out.println("Invalid input, please input a valid size.");
					s = scnr.nextInt();
				}
			}
			teadrink.setDrinkSize(s);
			System.out.println("What topping would you like??");
			System.out.println("(Please type the exact name case sensitive, type 'No Topping' for no topping.) ");
			String t = scnr.nextLine();
			if(Drink.menu.keySet().contains(t) != true) {
				while(Drink.menu.keySet().contains(t) != true) {
					System.out.println("Invalid input, please type the exact name case sensitive.");
					t = scnr.nextLine();
				}
			}
			teadrink.setTopping(t);
			System.out.println("What percent sweet?");
			System.out.println("Please input a number 0-100: ");
			int e = scnr.nextInt();
			scnr.nextLine();
			if(e < 0 || e > 100) {
				while(e < 0 || e > 100) {
					System.out.println("Invalid input, please input a valid percent sweetness.");
					e = scnr.nextInt();
				}
			}
			teadrink.setPercentSweet(e);
			Drink.orderHistory.add(teadrink);
			total = teadrink.priceDrink();
			teadrink.setPrice(total);;
			
		}
		
		System.out.println("Do you have a rewards membership? If so, type YES. If not, and want to create an account, type CREATE. Otherwise, Type NO.");
		String s = scnr.nextLine();
		if(s.equalsIgnoreCase("YES")) {
			System.out.println("Enter your 10 digit account number: ");
			long acc = scnr.nextLong();
			Long key = acc;
			if(Customer.customers.containsKey(key)) {
				System.out.println("Account succesfully accessed.");
				System.out.println("You have " + Customer.customers.get(key).getPoints() + " points.");
				System.out.println("It takes 50 points for a 15% discount reward or 200 points for a free drink reward.");
				System.out.println("Type 1 for discount reward or 2 for drink reward.");
				int r = scnr.nextInt();
				
				if(r == 1) {
					total = total*.85;
				}
				else if(r == 2) {
					total = 0;
				}
				else {
					System.out.println("Invalid Input");
				}
				System.out.println("Your total is: $" + total);
				if(choice == 1) {
					Customer.customers.get(key).individualHistory.add(drink);
				}
				else if (choice == 2) {
					Customer.customers.get(key).individualHistory.add(teadrink);
				}
				
			}
			
			else {
				System.out.println("Account does not exist.");
				System.out.println("Your total is: $" + total);
			}
		
		}
		if(s.equalsIgnoreCase("CREATE")) {
			System.out.println("Enter a 6 digit phone number: ");
			int p = scnr.nextInt();
			scnr.nextLine();
			Customer cust = new Customer(p, total);
			Customer.addToHashMap(cust.getId(), cust);
			System.out.println("Account successfully created.");
			if(choice == 1) {
				cust.individualHistory.add(drink);
			}
			else if (choice == 2) {
				cust.individualHistory.add(teadrink);
			}
			System.out.println("Your total is: $" + total);
		}
		if(s.equalsIgnoreCase("NO")) {
			System.out.println("Your total is: $" + teadrink.getPrice());
		}
		
	}
}
