package mistFinalProject;

import java.util.Scanner;

public class Tea extends Drink {
	
	private int percentSweet;
	
	public Tea() {
		drinkType = "Tea";
	}

	public int getPercentSweet() {
		return percentSweet;
	}

	public void setPercentSweet(int percentSweet) {
		this.percentSweet = percentSweet;
	}
	
	public double order(Scanner scnr, int choice) throws InterruptedException{
		double total = 0.0;

			System.out.println("What is your drink of choice? (Please type the exact name case sensitive)");
			String drinkOrder = scnr.nextLine();
			//Testing for if drink exists
			if(Drink.menu.keySet().contains(drinkOrder) != true) {
				while(Drink.menu.keySet().contains(drinkOrder) != true) {
					System.out.println("Invalid input, please type the exact name case sensitive.");
					drinkOrder = scnr.nextLine();
				}
			}
			this.setDrinkName(drinkOrder);
			System.out.println("What size would you like: ");
			Drink.printSizes();
			Thread.sleep(500);
			System.out.println("Please input 12, 16, or 24.");
			int s = scnr.nextInt();
			scnr.nextLine();
			if(s != Drink.sizes[0] && s != Drink.sizes[1] && s != Drink.sizes[2]) {
				while(s != Drink.sizes[0] && s != Drink.sizes[1] && s != Drink.sizes[2]) {
					System.out.println("Invalid input, please input a valid size.");
					s = scnr.nextInt();
				}
			}
			this.setDrinkSize(s);
			System.out.println("What topping would you like?");
			Thread.sleep(500);
			System.out.println("Please type the exact name case sensitive, type 'No Topping' for no topping. ");
			String t = scnr.nextLine();
			if(Drink.menu.keySet().contains(t) != true) {
				while(Drink.menu.keySet().contains(t) != true) {
					System.out.println("Invalid input, please type the exact name case sensitive.");
					t = scnr.nextLine();
				}
			}
			this.setTopping(t);
			System.out.println("What percent sweet?");
			Thread.sleep(500);
			System.out.println("Please input a number 0-100: ");
			int e = scnr.nextInt();
			scnr.nextLine();
			if(e < 0 || e > 100) {
				while(e < 0 || e > 100) {
					System.out.println("Invalid input, please input a valid percent sweetness.");
					e = scnr.nextInt();
				}
			}
			this.setPercentSweet(e);
			total = this.priceDrink();
			this.setPrice(total);
			Drink.orderHistory.add(this);
			this.printInfo();
			
		
		return total;
}
	
	public double priceDrink() {
		double p = menu.get(drinkName);
		if(drinkSize == sizes[1]) {
			p += 1;
		}
		else if(drinkSize == sizes[2]) {
			p += 2;
		}
		double t = menu.get(topping);
		p += t;
		
		return p;
	}
	
	@Override
	public void printInfo(){
		super.printInfo();
		System.out.println(" with " + topping + " and " + percentSweet + "% sweetness.");
		System.out.println("Our " + drinkType + " is brewed fresh every morning. It is also 100% vegan and ethically sourced from India and Thailand.");
		System.out.println();
	}
	
}