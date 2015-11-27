package ss.week2.test;

import org.junit.Before;
import org.junit.Test;
import ss.week2.hotel.Guest;
import ss.week2.hotel.Room2;

import static org.junit.Assert.assertEquals;


public class RoomTest {
    private Guest guest;
    private Room2 room;

    @Before
    public void setUp() {
        guest = new Guest("Jip");
        room = new Room2(101);
    }

    @Test
    public void testSetUp() {
        assertEquals(101, room.getNumber());
    }

    @Test
    public void testSetGuest() {
        room.setGuest(guest);
        assertEquals(guest, room.getGuest());
    }
    //assertNotNull
}
