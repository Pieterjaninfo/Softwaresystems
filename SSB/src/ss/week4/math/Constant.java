package ss.week4.math;

public class Constant implements Function {

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
	
	@Override
	public String toString() {
		return "The constant value is: " + constant;
	}

}
