package ss.week3;

public class Addition implements OperatorWithIdentity {


	//------------ Commands ---------------
	public int operate(int left, int right) {
		return left + right;
	}
	
	
	
	//----------- Queries -----------------
	public int identity() {
		return 0;
	}
}
