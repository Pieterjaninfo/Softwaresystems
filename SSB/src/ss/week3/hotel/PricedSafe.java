package ss.week3.hotel;

public class PricedSafe extends Safe implements Bill.Item {
	
	//------------------- Instance variables -------------------
	
	private Double price;
	
	//------------------- Constructor -------------------
	
	/**
	 * Create the price of the safe.
	 */
	public PricedSafe(double price) {
		this.price = price;
	}
	
	//------------------- Queries -------------------
	
	/**
	 * Returns the price of the corresponding safe, combined with an adequate text.
	 */
	public String toString() {
		return "safe: " + price;
	}
	
	/**
	 * Returns the price of the safe.
	 * @return price
	 */
	public double getAmount() {
		return price;
	}
}
