package ss.week4.math;
import java.util.Formatter;

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
	
	@Override
	public double apply(double value) {
		return f1.apply(value) * f2.apply(value);
	}

	@Override
	public Function derivative() {
		p1 = new Product(f1, f2.derivative());
		p2 = new Product(f2, f1.derivative());
		return new Sum(p1, p2);
	}
	
	@Override
	public String toString() {
		//return "The product is: " + f1.toString() + " * " + f2.toString();
		return String.format("The product is: %s * %s.", f1.toString(), f2.toString());
	}

}
