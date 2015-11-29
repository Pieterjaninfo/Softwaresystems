package ss.week3.hotel;

public class PricedRoom extends Room implements Bill.Item {

	//------------------- Instance variables -------------------
	
	//private PricedSafe safe;
	private Double roomPrice;
	private int roomNumber;
	
	//------------------- Constructor -------------------
	
	/**
	 * Creates the room price to the corresponding room number.
	 * @param roomNumber the number of the room
	 * @param roomPrice the price of the room
	 * @param safePrice the price of the safe
	 */
	public PricedRoom(int roomNumber, Double roomPrice, Double safePrice) {
		super(roomNumber, new PricedSafe(safePrice));
		this.roomPrice = roomPrice;
		this.roomNumber = roomNumber;	
	}
	
	//------------------- Queries -------------------
	
	/**
	 * Return the room number and the roomprice per night.
	 */
	public String toString() {
		return "Room number: " + roomNumber + " costs " + roomPrice + "per Night";
	}
	
	/**
	 * Return the price of the room.
	 */
	public double getAmount(){
		return roomPrice;
	}
	
}
