package ss.week2;

/**
 * Three-way Lamp with four different modes: OFF, LOW, MEDIUM and HIGH.
 * @author Pieter Jan and Bart
 * @version $Revision: 2.0 $
 */
public class ThreeWayLamp2 {
	// ------------------ Instance variables ----------------
	//@ private invariant setting >= 0 && setting <= 3;
	private int setting;

	// ------------------ Constructor ------------------------
	
	//@ ensures getSetting() == 0;
	public ThreeWayLamp2() {
		setting = 0;
	}
	
	// ------------------ Queries --------------------------
	
	/**
	 * Retrieve the current setting, namely OFF, LOW, MEDIUM and HIGH.
	 * @return returns the setting
	 */
	/*@ pure */ public int getSetting() {
		return setting;
		/*if (setting == 0) {
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
		return "ERROR";*/

	}
	
	// ------------------ Commands --------------------------

	/**
	 * Press the button to go to the next setting.
	 * When no parameter is given, it will assume as if it was given with the parameter 1.
	 * @param times the amount of times you want to press the button is given as parameter
	 */
	
	//@ requires times >= 0;
	//@ ensures getSetting() == (\old(getSetting()) + times) % 4;
	public void switchSetting(int times) {
		if (times < 0) {
			//System.out.println("Given value can't be negative");
			throw new AssertionError("Given value can't be negative");
		}
		setting = (setting + times) % 4;
	}
	
	//@ ensures getSetting() == (\old(getSetting()) + 1) % 4;
	public void switchSetting() {
		switchSetting(1);
	}

	
}
