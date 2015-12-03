package ss.week4.math;

public class LinearProduct extends Product {

	//---------------- Instance variables ---------------------
	
	private Constant f1;
	private Function f2;
		
	//------------------- Constructor ------------------------
		
	public LinearProduct(Constant function1, Function function2) {
		super(function1, function2);
		f1 = function1;
		f2 = function2;
	}
	
	//---------------------- Queries --------------------------
	
	@Override
	public Function derivative() {
		return new LinearProduct(f1, f2.derivative()); 
	}
}
