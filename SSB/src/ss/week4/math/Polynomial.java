package ss.week4.math;

public class Polynomial implements Function, Integrandable {

	private double[] constants;
	private double result = 0;
	private Function nextExponent;
	private Function nextConstant;
	private double[] derivativeConstants;
	private double[] integralConstants;
	private String string;
	
	public Polynomial(double[] constants) {
		this.constants = constants;
		derivativeConstants = new double[constants.length];
		integralConstants = new double[constants.length + 1];
	}
	
	/**
	 * Calculate the value of a polynomial for a given value.
	 * @param value
	 * @return double the value of the polynomial
	 */
	
	@Override
	public double apply(double value) {
		for (int i = 0; i < constants.length; i++) {
			nextConstant = new Constant(constants[constants.length - i - 1]);
			nextExponent = new LinearProduct(nextConstant, new Exponent(i));
			result += nextExponent.apply(value);
		}
		return result;
	}

	/**
	 * Calculates the derivative of a given polynomial.
	 * @return polynomial the derivative of the polynomial
	 */
	@Override
	public Function derivative() {
		derivativeConstants[0] = 0;
		for (int i = 0; i < constants.length - 1; i++) {
			derivativeConstants[i + 1] = constants[i] * (constants.length - i - 1);
		}
		return new Polynomial(derivativeConstants);
	}
	
	/**
	 * Calculates the integrand of a polynomial.
	 */
	@Override
	public Function integrand() {
		integralConstants[constants.length] = 0;
		for (int i = 0; i < constants.length; i++) {
			integralConstants[i] = constants[i] * (1 / (double) (constants.length - i));
		}
		return new Polynomial(integralConstants);
	}

	@Override
	public String toString() {
		String format = "%s %f(x^%d) +";
		for (int i = 0; i < constants.length; i++) {
			string = String.format(format, string, constants[i], constants.length - 1 - i); 
		}
		return string;
	}
}
