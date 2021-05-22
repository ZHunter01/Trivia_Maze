package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.ImageIcon;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Door;
import model.PowerUp;
import model.Room;

public class RoomTest {
    private Room myRoom;
    private PowerUp myPowerUp;
    private Door myDoor;

    @BeforeEach
    void setUp() {
        myRoom = new Room();
        myPowerUp = new PowerUp();
        myDoor = new Door();
    }
    
    @Test
    void testGetRoomIcon() {
        assertEquals(myRoom.getRoomIcon(), new ImageIcon("./resources/w.gif").getImage());
    }
    
    @Test
    void testSetRoomIcon() {
        myRoom.setRoomIcon(new ImageIcon("./resources/ellipse.gif").getImage());
    
        assertEquals(myRoom.getRoomIcon(), new ImageIcon("./resources/ellipse.gif").getImage());
    }

    @Test
    void testGetRoomPowerUp() {
        myRoom.setRoomWithPowerUp(myPowerUp);
        
        assertEquals(myRoom.getRoomPowerUp(), myPowerUp);
    }
    
    @Test
    void testUnlockPermaLock() {
        myPowerUp.createPermaUnlock();
        myRoom.setRoomWithPowerUp(myPowerUp);
        myRoom.getPlayer().addPowerUp(myPowerUp);
        //Should set door to be perma locked
        myRoom.getUserDoor(0).checkLock("Not the solution");
               
        myRoom.unlockPermaLock(0);
        
        assertFalse(myRoom.getUserDoor(0).isPermaLocked());
    }
    
    @Test
    void testUnlockPermaLock_PlayerHasNoPowerUp() {
        myPowerUp.createPermaUnlock();
        myRoom.setRoomWithPowerUp(myPowerUp);
        //Should set door to be perma locked
        myRoom.getUserDoor(0).checkLock("Not the solution");
               
        myRoom.unlockPermaLock(0);
        
        assertTrue(myRoom.getUserDoor(0).isPermaLocked());
    }

}
