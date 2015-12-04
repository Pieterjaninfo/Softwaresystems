package ss.week4.math;

public interface Integrandable extends Function {
	
	/**
	 * Returns the integrand function.
	 * @return integrand
	 */
	public Function integrand();

}
