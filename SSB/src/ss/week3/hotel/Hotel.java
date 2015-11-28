package ss.week3.hotel;

//import ss.week2.hotel.*;

public class Hotel {
  
	// ------------------ Instance variables ----------------
	private String name;
	private Room room1;
	private Room room2;
	private Password password;
	
	// ------------------ Constructor -----------------------
	public Hotel(String hotelName) {
		name = hotelName;
		password = new Password();
		room1 = new Room(1);
		room2 = new Room(2);
	}

	// ------------------ Queries ---------------------------
	/*@ pure */ public Room getFreeRoom() {
		if (room1.getGuest() == null) {
			return room1;
		} else if (room2.getGuest() == null) {
			return room2;
		}
		return null;
	}
	
	/*@ pure */ public Room getRoom(String nameGuest) {
		if (room1.getGuest() == null) {
			if (room2.getGuest() == null) {
				return null;
			} else if (room2.getGuest().getName() == nameGuest) {
				return room2;
			}
		} else if (room1.getGuest().getName() == nameGuest) {
			return room1;
		}
		return null;
	}
	
	/*@ pure */ public Password getPassword() {
		return password;
		//return room.getSafe().getPassword();
	}
	
	public String toString() {
		return "room: " + room1.getNumber() + " with guest: " + room1.getGuest() 
			+ " and safe activation state: " + room1.safe.isActive();
	}
	
	public String getHotelName() {
		return name;
	}
	
	// ------------------ Commands --------------------------
	//@ requires pass != null;
	//@ requires nameGuest != null;
	//@ requires getFreeRoom() != null;
	//@ ensures getRoom(nameGuest).getGuest().getName() == nameGuest;
	//@ ensures \result == getRoom(nameGuest);
	public Room checkIn(String pass, String nameGuest) {
		assert pass != null;
		assert nameGuest != null;
		assert getFreeRoom() != null;
		if (getPassword().testWord(pass)
		   	&& getRoom(nameGuest) == null
			   && getFreeRoom() != null) {
			Room free = getFreeRoom();
			Guest newGuest = new Guest(nameGuest);
			newGuest.checkin(free);
			return free;
		}
		return null;
	}
	
	//@ requires nameGuest != null;
	//@ ensures getRoom(nameGuest).getGuest().getName() == null;
	//@ ensures getRoom(nameGuest).getSafe().isActive() == false;
	public void checkOut(String nameGuest) {
		assert nameGuest != null;
		if (getRoom(nameGuest) != null) {
			getRoom(nameGuest).getSafe().deactivate();
			getRoom(nameGuest).getGuest().checkout();
			
			//getRoom(nameGuest).setGuest(null);
		}
	}
	
}
