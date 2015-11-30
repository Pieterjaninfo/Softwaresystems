package ss.week3.pw;

/**
 * Standard password that can be changed.
 * 
 * @author Pieter Jan en Bart
 * @version $Revision: 1.1 $
 */
public class Password {

	// ------------------ Instance variables ----------------
	
	//public static final String INITIAL = "password";
	private String password;
	private Checker checker;
	private String factoryPassword;

	// ------------------ Constructor ----------------

	public Password(Checker checker) {
		this.checker = checker;
		factoryPassword = checker.generatePassword();
		password = factoryPassword;
	}
	/**
	 * Creates a Password with the initial value.
	 */
	public Password() {
		this(new BasicChecker());
	}

	// ------------------ Queries ----------------

	/**
	 * Test if the word is equal to the current password.
	 * 
	 * @param test
	 *            The word you want to compare with the current password
	 * @return true If password is equal to current password
	 */
	/*@ pure */ public boolean testWord(String test) {
		return password.equals(test);
	}
	
	/*@ pure */ public Checker getChecker() {
		return checker;
	}
	
	/*@ pure */ public String getFactoryPassword() {
		return factoryPassword;
	}

	// ------------------ Commands ----------------

	/**
	 * Change the current password to the new password. The old password must be
	 * equal to the current password and the new password must be an acceptable
	 * password.
	 * 
	 * @param oldpass
	 *            The current password
	 * @param newpass
	 *            The password that you want to current password to be
	 * @return true If the method was successful
	 */
	
	//@ requires oldpass != null;
	//@ requires newpass != null;
	//@ ensures getChecker().acceptable(newpass) && testWord(oldpass) == \result;
	public boolean setWord(String oldpass, String newpass) {
		assert oldpass != null;
		assert newpass != null;
		if (testWord(oldpass) && checker.acceptable(newpass)) {
			password = newpass;
			return true;
		}
		return false;
	}
}
