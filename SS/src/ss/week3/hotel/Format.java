package ss.week3.hotel;

public class Format {

	private static String format;

	/**
	 * prints out the formatted line.
	 * @param text name of the item
	 * @param amount corresponding value of the item
	 */
	//@ requires text.length() <= 30;
	public static void printLine(String text, double amount) {
		assert text.length() <= 30;
		format = "%-30s %20.2f %n";
		System.out.printf(format, text, amount);
	}

	/**
	 * Main method in order to test printLine.
	 * @param args
	 */
	public static void main(String[] args) {
		printLine("text1", 1);
		printLine("other text", -12.12);
		printLine("something", 0.2);
		//String a = args;
		//System.out.println(a);

	}
}
