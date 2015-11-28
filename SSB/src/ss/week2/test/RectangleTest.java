package ss.week2.test;


import org.junit.Before;
import org.junit.Test;
/*
import org.junit.rules.*;
import org.junit.rules.ExpectedException;
import org.junit.*;
import static org.junit.Assert.assertTrue;
*/
import static org.junit.Assert.assertEquals;
import ss.week2.Rectangle;


/**
 * Testclass for testing the Rectangle class.
 * @author Pieter Jan, Bart
 * @version $Revision: 1.0 $
 */
public class RectangleTest {
    /** Testvariable for a Rectangle object.*/
	private Rectangle rect1;
	/** Testvariable for a Rectangle object.*/
	private Rectangle rect2;
	/** Testvariable for a Rectangle object.*/
	private Rectangle rect3;
	//private Rectangle rect4;

	@Before
	public void setUp() {
		rect1 = new Rectangle(10, 15);
		rect2 = new Rectangle(10, 10);
		rect3 = new Rectangle(10, 10);
		
	}
	/*
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
    public void testNegative() {
		rect4 = new Rectangle(-1, -10);
    	//assertEquals("Test length:", "Length or width can't be negative!", rect4.length());
    	//assertEquals("Test width:", "Length or width can't be negative!", rect4.width());
    	//thrown.expect(IllegalArgumentException.class);
    	exception.expect(IllegalArgumentException.class);
    	//exception.expectMessage("Length or width can't be negative!");
    	//throw new NullPointerException();
    }
	*/
	
    @Test
    public void testSetup() {
        //rect = new Rectangle(10, 15);
        assertEquals("Test length:", 10, rect1.length());
        assertEquals("Test width:", 15, rect1.width());
      
    }

    @Test
    public void testArea() {
        //rect = new Rectangle(10, 10);
        assertEquals("Test area:", 100, rect2.area());
    }

    @Test
    public void testPerimeter() {
        //rect = new Rectangle(10, 10);
        assertEquals("Test perimeter:", 40, rect3.perimeter());
    }
    
}
