package ss.week3.hotel;

public class PricedRoom extends Room implements Bill.Item {

	//private PricedSafe safe;
	private Double roomPrice;
	private int roomNumber;
	
	public PricedRoom(int roomNumber, Double roomPrice, Double safePrice) {
		super(roomNumber, new PricedSafe(safePrice));
		this.roomPrice = roomPrice;
		this.roomNumber = roomNumber;
		
	}
	
	public String toString() {
		return "Room number: " + roomNumber + " costs " + roomPrice + "per Night";
	}
	
	public double getAmount(){
		return roomPrice;
	}
	
}
