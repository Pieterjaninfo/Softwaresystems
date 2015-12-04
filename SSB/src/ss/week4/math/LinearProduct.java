package ss.week4.math;

public class LinearProduct extends Product {

	//---------------- Instance variables ---------------------
	
	private Function f1;
	private Function f2;
	private Boolean linear;
		
		//------------------- Constructor ------------------------
		
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
	
	public Function derivative() {
		if (linear) {
			return new LinearProduct((Constant) f1, f2.derivative());
		}
		return super.derivative();
	}
}
