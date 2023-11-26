package mistFinalProject;

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
	
}