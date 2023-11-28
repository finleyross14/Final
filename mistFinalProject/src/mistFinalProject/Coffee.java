package mistFinalProject;
import java.util.HashMap;
import java.util.Scanner;

public class Coffee extends Drink {

	private int numShots;
	
	public Coffee() {
		drinkType = "Coffee";
	}

	public int getNumShots() {
		return numShots;
	}

	public void setNumShots(int numShots) {
		this.numShots = numShots;
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
			System.out.println("How many shots of espresso?");
			Thread.sleep(500);
			System.out.println("Please input a number 1-4: ");
			int e = scnr.nextInt();
			scnr.nextLine();
			if(e < 1 || e > 4) {
				while(e < 1 || e > 4) {
					System.out.println("Invalid input, please input a valid number of espresso shots.");
					e = scnr.nextInt();
				}
			}
			this.setNumShots(e);
			total = this.priceDrink();
			this.setPrice(total);
			Drink.orderHistory.add(this);
			this.printInfo();
		
		return total;
	}
	public double priceDrink() {
		double p = menu.get(drinkName);
		if(drinkSize == 16) {
			p += 1;
		}
		else if(drinkSize == 24) {
			p += 2;
		}
		
		p += numShots;
		
		return p;
	}
	
	@Override
	public void printInfo(){
		super.printInfo();
		System.out.println(" with " + numShots + " espresso shots.");
		System.out.println("Our " + drinkType + " is brewed fresh every morning. It is also 100% vegan and ethically sourced from Ethiopia.");
		System.out.println();
	}
	
}