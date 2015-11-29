package ss.week3.hotel;

import java.io.PrintStream;
import java.util.ArrayList;
//import java.util.List;

public class Bill {

	//------------------- Instance variables ---------------------
	
	private PrintStream output;
	private ArrayList<Item> itemList;
	private String format = "%-30s %20.2f %n";
	private double sum;
	
	//------------------- Constructor -------------------------
	
	public Bill(PrintStream theOutStream) {
		output = theOutStream;
		itemList = new ArrayList<Item>();
	}
	
	//------------------- Nested interface --------------------------
	
	/**
	 * items that can be added to the bill.
	 * getAmount() return the value of a specific item
	 */
	static interface Item {
		public String toString();
		public double getAmount();
		
	}
	
	//------------------- Commands ------------------------
	
	/**
	 * Add the item to bill. If there is an output, item will be printed on output 
	 *   and the item value will be added to the sum.
	 * @param item the item you want to add
	 */
	public void newItem(Bill.Item item) {
		itemList.add(item);
		if (output != null) {
			output.printf(format, item.toString(), item.getAmount());
		}
		sum = sum + item.getAmount();
		
	}
	
	/**
	 * Print the sum of the bill of all items on the output stream.
	 */
	public void close() {
		if (output != null) {
		output.printf(format, "The total sum is:", getSum());
		}
		//System.out.printf(format, "The total sum is:", this.getSum());
	}
	
	//------------------- Queries -------------------

	/**
	 * Return the sum of the bill.
	 * @return the total sum of all the items
	 */
	public double getSum() {
		return sum;
	}
	
}
