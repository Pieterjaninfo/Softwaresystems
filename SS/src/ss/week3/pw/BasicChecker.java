package ss.week3.pw;

public class BasicChecker implements Checker {

	public static final String INITPASS = "password3";
	
	//@ requires suggestion != null;
	//@ ensures \result == (suggestion.indexOf(' ') == -1 && suggestion.length() >= 6);
	/*@ pure */ public boolean acceptable(String suggestion) {
		assert suggestion != null;
		return suggestion.indexOf(' ') == -1 && suggestion.length() >= 6;
	}
	
	//@ ensures (acceptable(\result) == true);
	public String generatePassword() {
		return INITPASS;
	}
}
