package ss.week2;

import ss.week2.hotel.Safe;

public class MainClass {

	public static void main(String[] args) {
		//TEST RESULT OF THIS TEST MUST BE: OFF, LOW, MED, HIGH, OFF
		ThreeWayLamp lamp = new ThreeWayLamp();
		//CHECK IF THE INITIAL VALUE IS CORRECT
		System.out.println(lamp.getSetting());
		// CHECK IF THE SWITCHSETTING AND GETSETTING WORKS
		lamp.switchSetting();
		System.out.println(lamp.getSetting());
		lamp.switchSetting();
		System.out.println(lamp.getSetting());
		lamp.switchSetting();
		System.out.println(lamp.getSetting());
		lamp.switchSetting();
		System.out.println(lamp.getSetting());
		
		Safe safe = new Safe();
		System.out.println(safe.getPassword());
		
	}

}
