package ss.week1;

public class DollarsAndCentsCounter {
	// ------------------ Instance variables ----------------

	private int counter;

	// ------------------ Constructor ------------------------

	public DollarsAndCentsCounter() {
		counter = 0;

	}

	// ------------------ Queries --------------------------

	/**
	 * The dollar count.
	 * 
	 * @ensure this.dollars() >= 0
	 */

	public int dollars() {
		return counter / 100;
	}

	/**
	 * The cents count.
	 * 
	 * @ensure this.cents() >= 0 && this.cents() <= 99
	 */

	public int cents() {
		return counter % 100;
	}

	// ------------------ Commands --------------------------

	/**
	 * Add the specified dollars and cents to this DollarsAndCentsCounter.
	 * 
	 * @param dollars
	 * @param cents
	 */
	public void add(int dollars, int cents) {
	
		counter += 100 * dollars + cents;
	}

	/**
	 * Reset this DollarsAndCentsCounter to 0.
	 * 
	 * @ensure this.dollars() == 0 && this.cents() == 0
	 */
	public void reset() {
		counter = 0;
	}

	/** Substract the specified dollars and cents from this DollarsAndCentsCounter.
	 * 
	 * 
	 * @param dollars
	 * @param cents
	 *
	public void substract(int dollars, int cents) {

	}
	*/
}
