package ss.week1;

/**
 * Standard password that can be changed.
 * 
 * @author Pieter Jan en Bart
 * @version $Revision: 1.0 $
 */
public class Password2 {

	// ------------------ Instance variables ----------------
	
	public static final String INITIAL = "password";
	public String password;

	// ------------------ Constructor ----------------

	/**
	 * Creates a Password with the initial value.
	 */
	public Password2() {
		password = INITIAL;
	}

	// ------------------ Queries ----------------

	/**
	 * Check if the password is acceptable. The password is acceptable if it has
	 * more or equal to 6 characters and no spaces.
	 * 
	 * @param suggestion
	 *            The word you want to check if it is a valid password
	 * @return true If password is acceptable
	 */
	public boolean acceptable(String suggestion) {
		return false;
	}

	/**
	 * Test if the word is equal to the current password.
	 * 
	 * @param test
	 *            The word you want to compare with the current password
	 * @return true If password is equal to current password
	 */
	public boolean testWord(String test) {
		return false;
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
	public boolean setWord(String oldpass, String newpass) {
		return false;
	}
}
