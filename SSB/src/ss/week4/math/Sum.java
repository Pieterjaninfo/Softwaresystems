package ss.week4.math;

public class Sum implements Function, Integrandable {

	//---------------- Instance variables ---------------------
	
	private Function f1;
	private Function f2;
	
	//------------------- Constructor ------------------------
	
	public Sum(Function function1, Function function2) {
		f1 = function1;
		f2 = function2;
	}
	
	//----------------- Queries ------------------------
	
	/**
	 * Calculates the sum of two functions.
	 */
	@Override
	public double apply(double value) {
		// TODO Auto-generated method stub
		return f1.apply(value) + f2.apply(value);
	}

	/**
	 * Calculates the derivative of the sum of two functions.
	 */
	@Override
	public Function derivative() {
		return new Sum(f1.derivative(), f2.derivative());
	}
	
	/**
	 * Calculates the integrand of the sum of two functions if both are integrandable.
	 * Else return null.
	 */
	@Override
	public Function integrand() {
		if (f1 instanceof Integrandable && f2 instanceof Integrandable) {
			return new Sum(((Integrandable) f1).integrand(), ((Integrandable) f2).integrand());
		}
		return null;
		
	}
	
	@Override
	public String toString() {
		return String.format("The sum is: %s + %s.", f1.toString(), f2.toString());
	}


}
