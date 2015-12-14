package ss.week6;

import java.util.Scanner;

public class Words {
	
	private static String input;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int i = 0;
		
		do {
			System.out.print("Line (or \"end\"):");
		
			@SuppressWarnings("resource")
			Scanner lineScan = new Scanner(in.nextLine());
			if (lineScan.hasNext("end")) {
				lineScan.close();
				break;
			}

			while (lineScan.hasNext()) {
				input = lineScan.next();
				i++;
				System.out.printf("Word %d: %s\n", i, input);
			}
		} while (true);
		System.out.print("End of programme.");
		in.close();
		
	}

}
