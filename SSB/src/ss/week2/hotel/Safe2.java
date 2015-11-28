package ss.week2.hotel;

public class Safe2 {

	// ------------------ Instance variables ----------------
	
	public Password password;
	private boolean active;
	private boolean open;
	
	// ------------------ Constructor ----------------
	
	public Safe2() {
		active = false;
		open = false;
		password = new Password();
	}
	
	
	// ------------------ Queries ----------------
	
	/*@ pure */ public boolean isActive() {
		return false;
	}
	
	/*@ pure */ public boolean isOpen() {
		return false;
	}
	//@ ensures \result == password.toString();
	public String getPassword() {
		//return password.toString();
		return null;
	}
	
	// ------------------ Commands ----------------
	
	//@ ensures password.testWord(pass) == true ==> isActive() == true;
	/*@ ensures password.testWord(pass) == false && isActive() == true 
		? isActive() == true : isActive() == false; 
	*/
	public void activate(String pass) {
		
	}
	//@ ensures isActive() == false;
	public void deactivate() {
		
	}
	//@ ensures password.testWord(pass) == true ==> isOpen() == true;
	/*@ ensures password.testWord(pass) == false && isOpen() == true 
		? isOpen() == true : isOpen() == false; 
	*/
	public void open(String pass) {
		
	}
	//@ ensures isOpen() == false;
	public void close() {
		
	}
}
