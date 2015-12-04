package ss.week4.math;

public class Constant implements Function, Integrandable {

	//-------------------- Instance variables --------------------
	
	private double constant;
	
	//-------------------- Constructor -------------------------
	
	public Constant(double constant) {
		this.constant = constant;
	}
	
	//--------------------- Queries ------------------------
	/**
	 * @return constant The value of the constant.
	 */
	@Override
	public double apply(double value) {
		return constant;
	}

	/**
	 * @return 0 The derivative of a constant.
	 */
	@Override
	public Function derivative() {
		return new Constant(0);
		
	}
	
	/**
	 * Calculates the integrand of a constant.
	 * @return integrand The integrant funcion.	
	 */
	@Override
	public Function integrand() {
		return new LinearProduct(this, new Exponent(1));
	}
	
	@Override
	public String toString() {
		return "The constant value is: " + constant;
	}

}
