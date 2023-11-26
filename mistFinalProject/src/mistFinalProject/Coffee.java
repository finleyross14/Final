package mistFinalProject;
import java.util.HashMap;

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
	
	public double priceDrink() {
		double p = Drink.menu.get(drinkName);
		if(drinkSize == 16) {
			p += 1;
		}
		else if(drinkSize == 24) {
			p += 2;
		}
		
		p += numShots;
		
		return p;
	}
}