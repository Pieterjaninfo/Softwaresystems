package ss.week2.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ss.week2.hotel.*;
import ss.week2.hotel.Password;

public class SafeTest {
	private Safe safe;

	@Before
	public void setUp() throws Exception {
		safe = new Safe();	
	}
	
	@Test
	public void checkInitial() {
		assertFalse(safe.isActive());
		assertFalse(safe.isOpen());
	}
	
	@Test
	public void checkActivate() {
		safe.activate(Password.INITIAL);
		assertTrue(safe.isActive());
	}
	
	@Test
	public void checkOpen() {
		safe.open(Password.INITIAL);
		assertFalse(safe.isOpen());
	}
	
	@Test
	public void checkActivateOpen() {
		safe.activate(Password.INITIAL);
		safe.open(Password.INITIAL);
		assertTrue(safe.isOpen());
	}
	
	@Test
	public void checkActivateInvalid() {
		safe.activate(Password.INITIAL + "e");
		assertFalse(safe.isActive());
	}
	
	@Test
	public void checkOpenInvalid() {
		safe.activate(Password.INITIAL);
		safe.open(Password.INITIAL + "e");
		assertFalse(safe.isOpen());
	}
	
	@Test
	public void checkDeactivateActivated() {
		safe.activate(Password.INITIAL);
		safe.deactivate();
		assertFalse(safe.isActive());
	}
	
	@Test
	public void checkDeactivateActivatedOpen() {
		safe.activate(Password.INITIAL);
		safe.open(Password.INITIAL);
		safe.deactivate();
		assertFalse(safe.isActive());
		assertFalse(safe.isOpen());
	}
	
	@Test
	public void checkDeactivateNotActivated() {
		safe.deactivate();
		assertFalse(safe.isActive());
	}
	/*
	@Test
	public void checkPassword() {
		safe.deactivate();
		assertEquals(Password.INITIAL, safe.getPassword());
	}
	*/
	@Test
	public void checkClose() {
		safe.open(Password.INITIAL);
		safe.close();
		assertFalse(safe.isOpen());
	}
	
	@Test
	public void nullPassActivate() {
		safe.activate(null);
	}
	
	@Test
	public void nullPAssOpen() {
		safe.open(null);
	}

}
