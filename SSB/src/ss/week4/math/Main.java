package ss.week4.math;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function pol;
		double[] doubles = {1, 2, 3, 4};
/*		doubles[0] = 1.0;
		doubles[1] = 2.0;
		doubles[2] = 3.0;
		doubles[3] = 4.0;*/
		pol = new Polynomial(doubles);
		System.out.println(pol.toString());
		
		System.out.println((double) 1 / 2);
	}

}
