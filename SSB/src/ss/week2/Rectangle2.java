package ss.week2;

public class Rectangle2 {

	//------------------ Instance variables ----------------------
	
	private int length;
	private int width;
	
	//------------------ Constructor ------------------
	
	/*@
	 requires length >= 0;
	 requires width >= 0;
	 */
	public Rectangle2(int length, int width) {
		
	}
	
	//------------------ Queries --------------------
	

	/*@ pure */ public int length() {
		return 0;
	}
	
	/*@ pure */ public int width() {
		return 0;
	}
	
	//@ ensures \result == length() * width();
	public int area() {
		return 0;
	}
	
	//@ ensures \result == length() * 2 + width() * 2;
	public int perimeter() {
		return 0;
	}
}
