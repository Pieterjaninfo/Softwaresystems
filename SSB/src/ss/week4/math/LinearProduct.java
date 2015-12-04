package ss.week4.math;

public class LinearProduct extends Product implements Integrandable {

	//---------------- Instance variables ---------------------
	
	private Function f1;
	private Function f2;
	private Boolean linear;
		
	//------------------- Constructor ------------------------
		
	/**
	 * Gets two functions of which one should be a constant. 
	 * If none is a constant it will calculate the product of two functions.
	 * @param function1
	 * @param function2
	 */
	public LinearProduct(Function function1, Function function2) {
		super(function1, function2);
		linear = true;
		if (function1 instanceof Constant) {
			f1 = function1;
			f2 = function2;
		} else if (function2 instanceof Constant) {
			f1 = function2;
			f2 = function1;
		} else {
			System.out.println("Not a linear product, calculating using the normal product");
			linear = false;
		}
	}
	
	//--------------------- Queries ------------------------

	/**
	 * Calculates the derivative for a linear product if more than one constant is given.
	 * If neither functions are a constant it will calculate the derivative using Product.
	 * @return derivative The derivative of the (linear) product.
	 */
	public Function derivative() {
		if (linear) {
			return new LinearProduct((Constant) f1, f2.derivative());
		}
		return super.derivative();
	}
	
	/**
	 * Calculates the interand of a linear product. If it is not linear 
	 * or if the non-constant function is not integradable, it will return null .
	 */
	public Function integrand() {
		if (linear && f2 instanceof Integrandable) {
			return new LinearProduct((Constant) f1, ((Integrandable) f2).integrand());
		}	
		return null;
	}

}
