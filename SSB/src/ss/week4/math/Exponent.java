package ss.week4.math;

public class Exponent implements Function, Integrandable {
	
	//-------------------- Instance variables --------------------

	private int n;
	private double result = 1;
	
	//-------------------- Constructor -------------------------

	public Exponent(int exponent) {
		n = exponent;
	}
	
	//--------------------- Queries ------------------------

	/**
	 * Calculates an exponent for a given value x.
	 * @return result The result of the exponent for x.
	 */
	@Override
	public double apply(double value) {
		for (int i = 0; i < n; i++) {
			result = result * value; 
		}
		return result;
	}

	/**
	 * Calculates the derivative of the exponent.
	 * @return derivative The derivative function.
	 */
	@Override
	public Function derivative() {
		return new LinearProduct(new Constant(n), new Exponent(n - 1));
	}
	
	/**
	 * Calculated the integrand of an exponent.
	 */
	@Override
	public Function integrand() {
		return new LinearProduct(new Constant(1 / (double) (n + 1)), new Exponent(n + 1));
	}

	@Override
	public String toString() {
		return String.format("x^%d", n);
	}
}
