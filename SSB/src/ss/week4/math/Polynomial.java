package ss.week4.math;

public class Polynomial implements Function {

	private double[] constants;
	private double result = 0;
	private Function nextExponent;
	private Constant nextConstant;
	private double[] derivativeConstants;
	
	public Polynomial(double[] constants) {
		this.constants = constants;
	}
	
	@Override
	public double apply(double value) {
		for (int i = 0; i < constants.length; i++) {
			nextConstant = new Constant(constants[constants.length - i - 1]);
			nextExponent = new LinearProduct(nextConstant, new Exponent(i));
			result += nextExponent.apply(value);
		}
		return result;
	}

	@Override
	public Function derivative() {
		for (int i = 0; i < constants.length; i++) {
			
		}
	return null;
	}
}
