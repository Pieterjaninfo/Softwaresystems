package ss.test;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "abc: ww";
		
		String[] b = a.split(": ");
		
		System.out.printf("String a: %s, String b: %s and %s, string a na b: %s", a, b[0],b[1], a);

	}

}
