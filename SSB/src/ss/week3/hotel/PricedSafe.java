package ss.week3.hotel;

public class PricedSafe extends Safe implements Bill.Item {
	
	private Double price;
	
	public PricedSafe(double price) {
		this.price = price;
	}

	public String toString() {
		return "safe: " + price;
	}
	
	public double getAmount() {
		return price;
	}
}
