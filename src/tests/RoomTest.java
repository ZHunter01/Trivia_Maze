package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.ImageIcon;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Door;
import model.Maze;
import model.Player;
import model.PowerUp;
import model.Room;

/**
 * 
 * @author Zach Hunter
 *
 */
public class RoomTest {
    public Room myRoom;
    public PowerUp myPowerUp;
    public Door myDoor;
    public Maze myMaze;

    @BeforeEach
    void setUp() {
        myRoom = new Room();
        myPowerUp = PowerUp.createEmptyPowerUp();
        myDoor = new Door();
    }
    
    @Test
    void testGetRoomImage() {
        myRoom.setRoomImage(new ImageIcon("./resources/w.gif").getImage());
        
        assertEquals(myRoom.getRoomImage(), new ImageIcon("./resources/w.gif").getImage());
    }
    
    @Test
    void testSetRoomIcon() {
        myRoom.setRoomImage(new ImageIcon("./resources/ellipse.gif").getImage());
    
        assertEquals(myRoom.getRoomImage(), new ImageIcon("./resources/ellipse.gif").getImage());
    }

    @Test
    void testGetRoomPowerUp() {
        myRoom.setRoomWithPowerUp(myPowerUp);
        
        assertEquals(myRoom.getRoomPowerUp(), myPowerUp);
    }
    
    @Test
    void testUnlockPermaLock() {
        myRoom.getUserDoor(Room.DOWN).getQuestion().setQuestionAndSolution("Question", "Solution");;
        myRoom.getUserDoor(Room.DOWN).checkLock("No");
        
        myRoom.unlockPermaLock(Room.DOWN);
        
        assertFalse(myRoom.getUserDoor(Room.DOWN).isPermaLocked());
    }
//    
//    @Test
//    void testUnlockPermaLock_PlayerHasNoPowerUp() {
//        myPowerUp = PowerUp.createEmptyPowerUp();
//        myRoom.setRoomWithPowerUp(myPowerUp);
//        //Should set door to be perma locked
//        myRoom.getUserDoor(0).checkLock("Not the solution");
//               
//        myRoom.unlockPermaLock(0);
//        
//        assertTrue(myRoom.getUserDoor(0).isPermaLocked());
//    }
    
    @Test
    void testIsCorrectDoor() {
        assertTrue(myRoom.isCorrectDoor(Room.UP, myRoom.getUserDoor(Room.UP)));
    }
    
    @Test
    void testIsCorrectDoorFalse() {
        assertFalse(myRoom.isCorrectDoor(Room.LEFT, myRoom.getUserDoor(Room.UP)));
    }
    
    @Test
    void testGetUserDoorUp() {        
        assertTrue(myRoom.isCorrectDoor(Room.UP, myRoom.getUserDoor(0)));
    }
    
    @Test
    void testGetUserDoorLeft() {
        assertTrue(myRoom.isCorrectDoor(Room.LEFT, myRoom.getUserDoor(1)));
    }

    @Test
    void testGetUserDoorDown() {
        assertTrue(myRoom.isCorrectDoor(Room.DOWN, myRoom.getUserDoor(2)));
    }

    @Test
    void testGetUserDoorRight() {
        assertTrue(myRoom.isCorrectDoor(Room.RIGHT, myRoom.getUserDoor(3)));
    }
    
    @Test
    void testGetUserDoorError() {
        final IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, 
                () -> { myRoom.getUserDoor(4); });
        
        final String expected = "Error: Parameter must be an int value from 0 to 3";
        final String actual = exception.getMessage();
        
        assertTrue(actual.equals(expected));
    }
    
    @Test
    void testGetDoorLock() {
        final int roomNum = 2;
        
        assertEquals(myRoom.getDoorLock(roomNum), myRoom.getUserDoor(2).isLocked());
    }

    @Test
    void testGetDoorPermaLock() {
     final int roomNum = 2;
        
     assertEquals(myRoom.getDoorPermaLock(roomNum), myRoom.getUserDoor(2).isPermaLocked());     
    }
    
    @Test
    void testSetRoomWithPowerUp() {
        myRoom.setRoomWithPowerUp(myPowerUp);
        
        assertEquals(myRoom.getRoomPowerUp(), myPowerUp);
    }
}
