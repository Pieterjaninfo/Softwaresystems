package ss.week4.math;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function pol;
		double[] doubles = {1, 3, 3, 7};

		pol = new Polynomial(doubles).integrand();
		System.out.println(pol.toString());
		int[] array;
		array = new int[20];
		System.out.println(array.length);
		
		
		
		
	}

}
