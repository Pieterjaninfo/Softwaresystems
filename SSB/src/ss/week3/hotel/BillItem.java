package ss.week3.hotel;

public class BillItem implements Bill.Item {
	private String text;
	private Double amount;
	
	public BillItem(String text, Double amount) {
		this.text = text;
		this.amount = amount;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String toString() {
		return text;
	}

}
