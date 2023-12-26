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
		Scanner scnr = new Scanner(System.in);
		
		Drink.intro();
		int choice = Drink.coffeeOrTea(scnr);
		
		Coffee coffee = new Coffee();
		Tea tea = new Tea();
		double total = 0;
		if(choice == 1) {
			total = coffee.order(scnr, choice);
			coffee.rewards(scnr, choice, total);
		}
		else if(choice == 2) {
			total = tea.order(scnr, choice);
			tea.rewards(scnr, choice, total);
		}
		
	}
}
