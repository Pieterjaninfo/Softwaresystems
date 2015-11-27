package ss.week1;

public class ThreeWayTests {

	private ThreeWayLamp lamp;

	public ThreeWayTests() {
		lamp = new ThreeWayLamp();
	}

	public void testLamp() {
		testInitial();
		testChange();
	}

	public void testInitial() {
		if (lamp.getSetting() != "OFF") {
			System.out.println("Lamp setting did not start at OFF");
		}
	}

	public void testChange() {
		lamp.switchSetting();
		if (lamp.getSetting() != "LOW") {
			System.out.println("error low");
		}
		lamp.switchSetting(2);
		if (lamp.getSetting() != "HIGH") {
			System.out.println("error med");
		}
		lamp.switchSetting(3);
		if (lamp.getSetting() != "MEDIUM") {
			System.out.println("error high");
		}

		lamp.switchSetting(2);
		if (lamp.getSetting() != "OFF") {
			System.out.println("error off");
		}
		lamp.switchSetting();
		lamp.switchSetting(-1);
		if (lamp.getSetting() != "LOW") {
			System.out.println("error negative");
		}
		System.out.println("all tests were succesfull");

	}
}
