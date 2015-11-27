package ss.week2;

public class Rectangle {

	//------------------ Instance variables ----------------------
	
	//@ private invariant length >= 0;
	private int length;
	//@ private invariant width >= 0;
	private int width;
	
	//------------------ Constructor ------------------
	
	/*@
	 requires len >= 0;
	 requires wid >= 0;
	 @ensures len == length();
	 @ensures wid == width();
	 */
	public Rectangle(int len, int wid) {
		if (length < 0 || width < 0) {
			throw new IllegalArgumentException("Length or width can't be negative!");
		}
		this.length = len;
		this.width = wid;
		
	}
	
	//------------------ Queries --------------------
	

	/*@ pure */ public int length() {
		return length;
	}

	/*@ pure */ public int width() {
		return width;
	}
	
	//@ ensures \result == length() * width();
	public int area() {
		return length() * width();
	}
	
	//@ ensures \result == length() * 2 + width() * 2;
	public int perimeter() {
		return (length() + width()) * 2;
	}
}
