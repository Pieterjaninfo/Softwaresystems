package ss.week3.pw;

public class StrongChecker extends BasicChecker {

	public static final String INITPASS = "password3";
	
	//@ requires suggestion != null;
	/*@ ensures \result == Character.isLetter(suggestion.charAt(0)) 
		&& Character.isDigit(suggestion.charAt(suggestion.length() - 1));
	 */
	
	/*@ pure */ public boolean checkFirstLastLetter(String suggestion) {
		assert suggestion != null;
		return Character.isLetter(suggestion.charAt(0)) 
				&& Character.isDigit(suggestion.charAt(suggestion.length() - 1));
	}
	
	//@ requires suggestion != null;
	//@ ensures \result == checkFirstLastLetter(suggestion) && super.acceptable(suggestion);
	/*@ pure */ public boolean acceptable(String suggestion) {
		assert suggestion != null;
		return checkFirstLastLetter(suggestion) && super.acceptable(suggestion);
	}
	
	//@ ensures (acceptable(\result) == true);
	public String generatePassword() {
		return INITPASS;
	}
}
