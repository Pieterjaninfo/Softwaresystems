package ss.week2;

/**
 * Three-way Lamp with four different modes: OFF, LOW, MEDIUM and HIGH.
 * @author Pieter Jan and Bart
 * @version $Revision: 2.1 $
 */
public class ThreeWayLamp {
	// ------------------ Instance variables ----------------
	
	public enum Setting { OFF, LOW, MED, HIGH }
	private Setting setting;
	
	// ------------------ Constructor ------------------------
	
	//@ ensures getSetting() == Setting.OFF;
	public ThreeWayLamp() {
		this.setting = Setting.OFF;
	}
	
	// ------------------ Queries --------------------------
	
	/**
	 * Retrieve the current Setting, namely OFF, LOW, MEDIUM and HIGH.
	 * @return returns the Setting
	 */
	/*@ pure */ public Setting getSetting() {
		return setting;

	}
	
	// ------------------ Commands --------------------------

	/**
	 * Press the button to go to the next Setting.
	 * When no parameter is given, it will assume as if it was given with the parameter 1.
	 * @param times the amount of times you want to press the button is given as parameter
	 */
	
	//@ ensures \old (getSetting()) == Setting.OFF ==> getSetting() == Setting.LOW;
	//@ ensures \old (getSetting()) == Setting.LOW ==> getSetting() == Setting.MED;
	//@ ensures \old (getSetting()) == Setting.MED ==> getSetting() == Setting.HIGH;
	//@ ensures \old (getSetting()) == Setting.HIGH ==> getSetting() == Setting.OFF;
	
	public void switchSetting() {
		switch (setting) {
			case OFF: 
				setting = Setting.LOW;
				break;
			case LOW:
				setting = Setting.MED;
				break;
			case MED:
				setting = Setting.HIGH;
				break;
			case HIGH:
				setting = Setting.OFF;
				break;
		}
	}
}
