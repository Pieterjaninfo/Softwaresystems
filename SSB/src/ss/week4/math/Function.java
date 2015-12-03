package ss.week4.math;

public interface Function {

	/**
	 * execute function to an argument of double type.
	 */
	public double apply(double value);
	
	/**
	 * returns the Function object that is the derivative if the current object.
	 */
	public Function derivative();
	
	/**
	 * returns a nice string representation of the function.
	 */
	public String toString();
}
