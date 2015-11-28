package ss.week3.pw;

public class TimedPassword extends Password {

	// ------------------ Instance variables ----------------

	private long validTime;
	private long startTime;

	// ------------------ Constructor ----------------
	
	public TimedPassword(long expirationTime) {
		validTime = expirationTime;
		startTime = System.currentTimeMillis();
	}
	
	public TimedPassword() {
		validTime = 10000;
		startTime = System.currentTimeMillis();
	}
	
	// ------------------ Commands ----------------
	
	//@ requires oldpass != null;
	//@ requires newpass != null;
	//@ ensures getChecker().acceptable(newpass) && testWord(oldpass) == \result;
	public boolean setWord(String oldpass, String newpass) {
		assert oldpass != null;
		assert newpass != null;
		if (super.setWord(oldpass, newpass)) {
			startTime = System.currentTimeMillis();
			return true;
		}
		return false;
	}
	
	// ------------------ Queries ----------------
	
	/*@ pure */ public boolean isExpired() {
		return !(System.currentTimeMillis() - startTime <= validTime);
	}
}
