package ss.week2.hotel;
/* JavaDoc can be very useful, as you and other can easily see how the entire program is structured.
	if you want to copy an entire class.
*/

/**
 * Guest with name and possibly hotel room.
 * @author Pieter Jan en Bart
 * @version $Revision: 2.0 $
 */
public class Guest {

	// ------------------ Instance variables ----------------

	private String name;
	private Room number;
	
	// ------------------ Constructor ----------------

	/**
     * Creates a <code>Guest</code> with a given name.
     * @param n name of the new <code>Guest</code>
     */
	public Guest(String n) {
		name = n;
		number = null;
	}

	// ------------------ Queries --------------------------

	/**
	 * Returns the name of this <code>Guest</code>.
	 * @return name of the <code>Guest</code>
	 */
	/*@ pure */ public String getName() {
		return name;
	}

	/**
	 * Returns the <code>Room</code> that is rented by the <code>Guest</code>.
	 * @return <code>Room</code>, null if the room is not rented by any <code>Guest</code>
	 */
	/*@ pure */ public Room getRoom() {
		
		return number;
	}

	// ------------------ Commands --------------------------

	/**
	 * Check <code>Guest</code> in, if the room isn't rented 
	 * and if the guest wasn't checked in already.
	 * 
	 * @param r room to be rented, can't be null
	 * @return boolean value if method was successful
	 */
	public boolean checkin(Room r) {
		if (getRoom() == null && r.getGuest() == null) {
			r.setGuest(this);
			number = r;
			return true;
		}
		return false;
	}

	/**
	 * Check <code>Guest</code> out, if the guest was checked in, set room to null.
	 * @return boolean value if method was successful
	 */
	public boolean checkout() {
		if (getRoom() != null) {
			number.setGuest(null);
			number = null;
			return true;
		}
		return false;
	}

	public String toString() {
		
		return "The name of the guest: " + getName();
	}

}
