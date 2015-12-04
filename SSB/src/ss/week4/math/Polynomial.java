package ss.week4.math;

public class Polynomial implements Function, Integrandable {

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
		derivativeConstants[0] = 0;
		for (int i = 0; i < constants.length - 1; i++) {
			derivativeConstants[i + 1] = constants[i] * (constants.length - i - 1);
		} 
		return new Polynomial(derivativeConstants);
	}
	
	@Override
	public Function integrand() {
		//derivativeConstants[constants.length] = 0;
		for (int i = 0; i < constants.length - 1; i++) {
			derivativeConstants [i] = constants[i] * (1 / (double) (constants.length - i));
		}
		derivativeConstants[constants.length] = 0;
		return new Polynomial(derivativeConstants);
	}
}
