package ss.week3.pw;

public interface Checker {
	
	/**
	 * Check if the password given is acceptable according to this checker.
	 * @param string
	 * @return true if password is acceptable
	 */
	/*@ pure */ public boolean acceptable(String string);
	/**
	 * Generate the standard password.
	 */
	public String generatePassword();
	//public String factoryPassword();
}
