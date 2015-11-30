package ss.week3.hotel;

import java.io.PrintStream;

//import ss.week2.hotel.*;

public class Hotel {
  
	// ------------------ Instance variables ----------------
	private String name;
	private Room room1;
	private Room room2;
	private Password password;
	private Bill bill;
	private Room billRoom;
	
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
	
	/**
	 * Creates the bill for the guest.
	 * @param guestName name of the guest
	 * @param nights the amount of nights the guest sleeps in a room
	 * @param output the specified output location
	 * @return bill the bill, null if guest doesn't have a room or the room is not priced
	 */
	public Bill getBill(String guestName, int nights, PrintStream output) {
		billRoom = getRoom(guestName);
		if (billRoom == null || !(billRoom instanceof PricedRoom)) {
			return null;
		}
		bill = new Bill(output);
		
		for (int i = 0; i < nights; i++) {
			bill.newItem((PricedRoom) billRoom);
		}
		if (billRoom.getSafe() instanceof PricedSafe && billRoom.getSafe().isActive()) {
			for (int i = 0; i < nights; i++) {
				bill.newItem((PricedSafe) billRoom.getSafe());
			}
		}
		bill.close();
		return bill;
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
