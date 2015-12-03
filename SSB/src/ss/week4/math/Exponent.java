package ss.week4.math;

public class Exponent implements Function {
	
	private int n;
	private double result = 1;
	
	public Exponent(int exponent) {
		n = exponent;
	}

	@Override
	public double apply(double value) {
		for (int i = 0; i < n; i++) {
			result = result * value; 
		}
		return result;
	}

	@Override
	public Function derivative() {
		return new LinearProduct(new Constant(n), new Exponent(n - 1));
	}
	
	@Override
	public String toString() {
		return String.format("The exponent is: x^%d", n);
	}
}
