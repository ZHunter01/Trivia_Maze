package tests;

import model.Room;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    Room room;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        room = new Room();
    }

    @org.junit.jupiter.api.Test
    void getUserDoorUp() {
        //assertEquals(room.getUserDoor(Room.UP), );
    }

    @org.junit.jupiter.api.Test
    void getDoorLock() {
        //assertTrue(room.getDoorLock(Room.UP));
    }

    @org.junit.jupiter.api.Test
    void getDoorPermaLock() {
    }
}