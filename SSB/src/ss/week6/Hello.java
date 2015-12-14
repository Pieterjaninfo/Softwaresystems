package ss.week6;

import java.util.Scanner;

public class Hello {

	private static String input;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		do {
			System.out.print("Name:");
			input = in.nextLine();
			if (input.isEmpty()) {
				break;
			}
			System.out.println("Hello " + input);
		} while (true);

		in.close();
		System.out.println("quited");
	}	
}


