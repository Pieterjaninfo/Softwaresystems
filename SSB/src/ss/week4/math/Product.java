package ss.week4.math;

public class Product implements Function {

	//---------------- Instance variables ------------------
	
	private Function f1;
	private Function f2;
	private Function p1;
	private Function p2;
	
	//------------------- Constructor ------------------------
	
	public Product(Function function1, Function function2) {
		f1 = function1;
		f2 = function2;
	}
	
	//------------------- Queries -----------------------------
	
	/**
	 * Calculates the value of a product.
	 */
	@Override
	public double apply(double value) {
		return f1.apply(value) * f2.apply(value);
	}

	/**
	 * Calculates the derivative of the product of two functions.
	 */
	@Override
	public Function derivative() {
		p1 = new Product(f1, f2.derivative());
		p2 = new Product(f2, f1.derivative());
		return new Sum(p1, p2);
	}
	
	@Override
	public String toString() {
		//return "The product is: " + f1.toString() + " * " + f2.toString();
		return String.format("%s * %s", f1.toString(), f2.toString());
	}

}
