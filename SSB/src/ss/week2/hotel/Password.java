package ss.week2.hotel;

/**
 * Standard password that can be changed.
 * 
 * @author Pieter Jan en Bart
 * @version $Revision: 1.1 $
 */
public class Password {

	// ------------------ Instance variables ----------------
	
	public static final String INITIAL = "password";
	private String password;

	// ------------------ Constructor ----------------

	/**
	 * Creates a Password with the initial value.
	 */
	public Password() {
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
		// return suggestion.indexOf(' ') == -1 && suggestion.length()>=6;
		if (suggestion.length() < 6) {
			return false;
		}
		
		for (int i = 0; i < suggestion.length(); i++) {
			if (suggestion.charAt(i) == ' ') {
				return false;
			}
		}
		return true;
	}

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
		if (testWord(oldpass) && acceptable(newpass)) {
			password = newpass;
			return true;
		}
		return false;
	}
	
	/*@ pure */ public String toString() {
		return password;
	}
}
