package ss.week3.hotel;

public class TestItem implements Bill.Item {

	//------------------- Instance variables ---------------------
	
	private String text;
	private double amount;
	
	//------------------- Constructor ---------------------
	
	public TestItem(String text, double amount) {
		this.text = text;
		this.amount = amount;
	}
	
	
	//------------------- Queries ---------------------
	
	public String toString() {
		return text;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public static void main(String[] args) {
		TestItem firstcar = new TestItem("golf", 200);
		TestItem fruit = new TestItem("pear", 30);
		Bill bill = new Bill(System.out);
		bill.newItem(firstcar);
		bill.newItem(fruit);
		bill.close();
		
	}
	

}
