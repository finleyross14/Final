package mistFinalProject;
import java.util.HashSet;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) throws InterruptedException {
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
		if(choice == 1) {
			Coffee drink = new Coffee();
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
			double total = drink.priceDrink();
			System.out.println("Your total is: $" + total);
		}
		
		//Order logic for tea
		else if(choice == 2) {
			Tea drink = new Tea();
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
			System.out.println("What topping would you like??");
			System.out.println("(Please type the exact name case sensitive, type 'No Topping' for no topping.) ");
			String t = scnr.nextLine();
			if(Drink.menu.keySet().contains(t) != true) {
				while(Drink.menu.keySet().contains(t) != true) {
					System.out.println("Invalid input, please type the exact name case sensitive.");
					t = scnr.nextLine();
				}
			}
			drink.setTopping(t);
			System.out.println("What percent sweet?");
			System.out.println("Please input a number 0-100: ");
			int e = scnr.nextInt();
			scnr.nextLine();
			if(e < 0 || e > 100) {
				while(e < 0 || e > 100) {
					System.out.println("Invalid input, please input a valid number of espresso shots.");
					e = scnr.nextInt();
				}
			}
			drink.setPercentSweet(e);
			double total = drink.priceDrink();
			System.out.println("Your total is: $" + total);
		}
	}
}
