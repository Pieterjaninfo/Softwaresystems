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
	
	@Override
	public Function integrand() {
		
		if (f1 instanceof Integrandable && f2 instanceof Integrandable) {
			return new Sum(((Integrandable) f1).integrand(), ((Integrandable) f2).integrand());
		}
		if (f1 instanceof Integrandable) {
			return ((Integrandable) f1).integrand();
		}
		
		if (f2 instanceof Integrandable) {
			return ((Integrandable) f2).integrand();
		}
		return null;
		
		
		/*p1 = new LinearProduct(new Constant(1 / (constant + 1)), new Exponent(value));
		p2 = new LinearProduct(new Constant(1 / (constant + 1)), new Exponent(value));
		return new Sum(p1, p2);*/
	}


}
