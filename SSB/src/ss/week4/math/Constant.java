package ss.week4.math;

public class Constant implements Function, Integrandable {

	//-------------------- Instance variables --------------------
	
	private double constant;
	
	//-------------------- Constructor -------------------------
	
	public Constant(double constant) {
		this.constant = constant;
	}
	
	//--------------------- Queries ------------------------
	@Override
	public double apply(double value) {
		return constant;
	}

	@Override
	public Function derivative() {
		return new Constant(0);
	}
	
	@Override
	public String toString() {
		return "The constant value is: " + constant;
	}
	
	@Override
	public Function integrand() {
		return new LinearProduct(new Constant(constant), new Exponent(1));
	}

}
