package ss.week1;

/**
 * Three-way Lamp with four different modes: OFF, LOW, MEDIUM and HIGH.
 * @author Pieter Jan and Bart
 * @version $Revision: 1.0 $
 */
public class ThreeWayLamp {
	// ------------------ Instance variables ----------------
	
	private int setting;

	// ------------------ Constructor ------------------------
	
	public ThreeWayLamp() {
		setting = 0;
	}
	
	// ------------------ Queries --------------------------
	
	/**
	 * Retrieve the current setting, namely OFF, LOW, MEDIUM and HIGH.
	 * @return returns the setting
	 */
	public String getSetting() {
		if (setting == 0) {
			return "OFF";
		}
		if (setting == 1) {
			return "LOW";
		}
		if (setting == 2) {
			return "MEDIUM";
		}
		if (setting == 3) {
			return "HIGH";
		}
		return "ERROR";

	}
	
	// ------------------ Commands --------------------------

	/**
	 * Press the button to go to the next setting.
	 * When no parameter is given, it will assume as if it was given with the parameter 1.
	 * @param times the amount of times you want to press the button is given as parameter
	 */
	public void switchSetting(int times) {
		if (times < 0) {
			System.out.println("Given value can't be negative");
			return;
		}
		setting = (setting + times) % 4;
	}
	
	public void switchSetting() {
		switchSetting(1);
	}

	
}
