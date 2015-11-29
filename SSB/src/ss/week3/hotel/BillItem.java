package ss.week3.hotel;

public class BillItem implements Bill.Item {
	private String text;
	private Double amount;
	
	/**
	 * Constructor for Items that can be added to the bill.
	 * @param text
	 * @param amount
	 */
	
	public BillItem(String text, Double amount) {
		this.text = text;
		this.amount = amount;
	}
	
	/**
	 * Returns the cost of an item.
	 */
	public double getAmount() {
		return amount;
	}
	
	/**
	 * Returns the name of the item.
	 */
	public String toString() {
		return text;
	}

}
