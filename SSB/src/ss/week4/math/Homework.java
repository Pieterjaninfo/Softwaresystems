package ss.week4.math;

public class Homework {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] array = {1, 3, 3, 7};
		Constant f1 = new Constant(666);
		Exponent f2 = new Exponent(10);
		Sum f3 = new Sum(f1, f2);
		Product f4 = new Product(f2, f2);
		LinearProduct f5 = new LinearProduct(f1, f2);
		Polynomial f6 = new Polynomial(array);
		String format = "f(x) = %-75s, f(4) =  %f\n";
		System.out.printf(format, f3, f3.apply(4));
		System.out.printf(format, f4, f4.apply(4));
		System.out.printf(format, f5, f5.apply(4));
		System.out.printf(format, f6, f6.apply(4));
	}

}
