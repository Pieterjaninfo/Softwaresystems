package ss.week3.test;

import org.junit.Before;
import org.junit.Test;
import ss.week3.hotel.*;
import static org.junit.Assert.assertEquals;


public class BillTest {

	private Bill bill;
	private BillItem item;
	private BillItem item2;
	private double cost = 10.3;
	private double cost2 = 1.05;
	
	
	@Before
	public void setUp() {
		item = new BillItem("Item nr 1", cost);
		item2 = new BillItem("Item", cost2);
		bill = new Bill(null);
	}
	
	@Test
	public void testNewItem() {
		bill.newItem(item);
		System.out.println(bill.getSum() + "; " + cost);
		assertEquals(cost, bill.getSum(), 0.001);
	}
	
	@Test
	public void test2NewItem() {
		bill.newItem(item);
		bill.newItem(item2);
		assertEquals(cost + cost2, bill.getSum(), 0.001);
	}
	
	@Test
	public void testClose() {
		bill.newItem(item);
		bill.newItem(item2);
		bill.close();
	}
}
