package ss.week4.math;

public class Sum implements Function {

	//---------------- Instance variables ---------------------
	
	private Function f1;
	private Function f2;
	
	//------------------- Constructor ------------------------
	
	public Sum(Function function1, Function function2) {
		f1 = function1;
		f2 = function2;
	}
	
	//----------------- Queries ------------------------
	
	@Override
	public double apply(double value) {
		return f1.apply(value) + f2.apply(value);
	}

	@Override
	public Function derivative() {
		return new Sum(f1.derivative(), f2.derivative());
	}
	
	@Override
	public String toString() {
		return String.format("The sum is: %s + %s.", f1.toString(), f2.toString());
	}


}
