package ss.week3.hotel;

public class Safe {

	// ------------------ Instance variables ----------------
	
	private Password password;
	private boolean active;
	private boolean open;
	
	
	//------------------Main------------------------------------
	
	public static void main(String[] args) {
		Safe test = new Safe();
		test.activate(null);
		System.out.println("Safe active: " + test.isActive());
		test.open(null);
		System.out.println("Safe open: " + test.isOpen());
	}
	
	// ------------------ Constructor ----------------
	
	public Safe() {
		active = false;
		open = false;
		password = new Password();
	}
	
	
	// ------------------ Queries ----------------
	
	/*@ pure */ public boolean isActive() {
		return active;
	}
	
	/*@ pure */ public boolean isOpen() {
		return open;
	}
	
	/*@ pure */ public Password getPassword() {
		return password;
	}
	
	// ------------------ Commands ----------------
	
	//@ requires pass != null;
	//@ ensures getPassword().testWord(pass) ==> isActive();
	//@ ensures \old(isActive()) ==> isActive();
	public void activate(String pass) {
		assert pass != null;
		active = getPassword().testWord(pass) || isActive();
		/*
		if (getPassword().testWord(pass) || isActive()) {
			active = true;
		} else {
			active = false;
		}*/
	}
	
	//@ ensures isActive() == false;
	//@ ensures isOpen() == false;
	public void deactivate() {
		active = false;
		open = false;
	}
	
	//@ requires pass != null;
	//@ ensures getPassword().testWord(pass) && isActive() ==> isOpen();
	//@ ensures \old(isOpen()) ==> isOpen();
	public void open(String pass) {
		assert pass != null;
		open = getPassword().testWord(pass) && isActive() || isOpen();
		/*if ((getPassword().testWord(pass) && isActive()) || isOpen()) {
			open = true;
		} else {
			open = false;
		}*/
	}
	
	//@ ensures isOpen() == false;
	public void close() {
		open = false;
	}
}
