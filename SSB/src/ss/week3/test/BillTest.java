package ss.week3.test;

import org.junit.Before;
import org.junit.Test;
import ss.week3.hotel.*;
import static org.junit.Assert.*;


public class BillTest {

	private Bill bill;
	private BillItem item;
	private BillItem item2;
	private Double cost;
	private Double cost2;
	
	
	@Before
	public void setUp() {
		item = new BillItem("Item nr 1", cost);
		item2 = new BillItem("Item", cost2);
		bill = new Bill(null);
	}
	
	@Test
	public void testNewItem() {
		bill.newItem(item);
		assert cost == bill.getSum();
	}
	
	@Test
	public void test2NewItem() {
		bill.newItem(item);
		bill.newItem(item2);
		assert cost + cost2 == bill.getSum();
	}
}
