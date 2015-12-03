package ss.week4.math;

public class LinearProduct extends Product {

	//---------------- Instance variables ---------------------
	
		private Function f1;
		private Function f2;
		
		//------------------- Constructor ------------------------
		
		public LinearProduct(Function function1, Function function2) {
			f1 = function1;
			f2 = function2;
		}
}
