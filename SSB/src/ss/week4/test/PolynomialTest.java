package ss.week4.test;

import org.junit.Test;
import ss.week4.math.Polynomial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PolynomialTest {
	
	public static final double CONSTANT_VALUE = 10;
	public static final double[] CONSTANTS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final double[] CONSTANTS1 = {1, 3, 3, 7};
	private static final double DELTA = 1e-15;
	
	@Test
	public void testApply() {
		assertEquals(123456789, new Polynomial(CONSTANTS).apply(CONSTANT_VALUE), DELTA);
		assertEquals(1337, new Polynomial(CONSTANTS1).apply(CONSTANT_VALUE), DELTA);
		assertEquals(7, new Polynomial(CONSTANTS1).apply(0), DELTA);
		assertEquals(6, new Polynomial(CONSTANTS1).apply(-1), DELTA);
	}
	
	@Test
	public void testDerivative() {
		Polynomial pol = new Polynomial(CONSTANTS);
		assertTrue(pol.derivative() instanceof Polynomial);
		assertEquals(96021948, pol.derivative().apply(CONSTANT_VALUE), DELTA);
	}
	
	@Test
	public void testIntegandable() {
		Polynomial pol = new Polynomial(CONSTANTS1);
		assertTrue(pol.integrand() instanceof Polynomial);
		assertEquals(3720, pol.integrand().apply(CONSTANT_VALUE), DELTA);
	}
}
