package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Maze;
import model.PowerUp;
import model.Question;
import model.Room;

public class MazeTest {
    private Maze theMaze;
    private Maze customMaze;
    
    @BeforeEach
    void setUp() {
        theMaze = new Maze();
        customMaze = new Maze(6,6);
    }
    
    @Test
    void testGetXLength() {
        assertEquals(theMaze.getXLength(), 4);
    }
    
    @Test
    void testQuestionCount() {
        int count = 0;
        
        theMaze.userDir = Room.DOWN;
        
        for (int n = 0; n < 3; n++) {
            theMaze.doorSolution(theMaze.getCurrentRoom().getUserDoor(Room.DOWN).getQuestion().getSolution(), Room.DOWN);
            //System.out.println(theMaze.getCurrentRoom().getUserDoor(Room.DOWN).getQuestion().getSolution());
            //System.out.println(theMaze.getCurrentRoom().getUserDoor(Room.DOWN).getQuestion().getSolution());

            count ++;
        }
        assertEquals(theMaze.getQuestionCount(), count);
    }
    
    @Test
    void testCustomMazeConstructor() {        
        assertTrue(customMaze.getXLength() == 6 && customMaze.getYLength() == 6);
    }
//    
//    @Test
//    void testDoorQuestion() {
//        assertEquals(theMaze.doorQuestion(Room.UP), theMaze.getCurrentRoom().getUserDoor(Room.UP).getQuestion());
//    }
    
    @Test
    void testGetMyMaze() {
        final Room[][] testRoom = theMaze.getMaze();
        assertTrue(theMaze.getMaze().equals(testRoom));
    }
    
    @Test
    void testGetMyPlayer() {
        assertTrue(theMaze.getPlayer().equals(theMaze.getCurrentRoom().getPlayer()));
    }
    
    @Test
    void testUsePowerUpFreeQuestion() {
        final int x = theMaze.getXCount();
        final int y = theMaze.getYCount();
        
        final PowerUp power = PowerUp.createFreeQuestion();
        
        theMaze.getPlayer().addPowerUp(power);
        theMaze.usePowerUp(power, Room.DOWN);
        
        assertTrue(theMaze.getXCount() == x  && theMaze.getYCount() == y + 1);
        
        
    }
    
    @Test
    void testUsePowerUpPermaUnlock_DoorIsPermaLocked() {
        theMaze.getCurrentRoom().getUserDoor(Room.UP).getQuestion().setQuestionAndSolution("Does this work?", "Yes");
        theMaze.getCurrentRoom().getUserDoor(Room.UP).checkLock("NO");
        
        
        final PowerUp power = PowerUp.createPermaUnlock();
        
        theMaze.getPlayer().addPowerUp(power);
        theMaze.usePowerUp(power, Room.UP);
        
        
        assertFalse(theMaze.getCurrentRoom().getUserDoor(Room.UP).isPermaLocked());  
    }
    
    @Test
    void testUsePowerUpPermaUnlock_DoorIsNotPermaLocked() {
        final PowerUp power = PowerUp.createPermaUnlock();
        
        theMaze.getPlayer().addPowerUp(power);
        theMaze.usePowerUp(power, Room.UP);
        
        
        assertTrue(theMaze.getCurrentRoom().getUserDoor(Room.UP).isLocked());  
    }
    
    @Test
    void testIncrementMaze_Up() {
        theMaze.userDir = Room.UP;
        
        theMaze.incrementMaze();
        
        assertEquals(theMaze.getYCount(), -1);
    }
    
    @Test
    void testIncrementMaze_Down() {
        theMaze.userDir = Room.DOWN;
        
        theMaze.incrementMaze();
        
        assertEquals(theMaze.getYCount(), 1);
    }
    
    @Test
    void testIncrementMaze_Left() {
        theMaze.userDir = Room.LEFT;
        
        theMaze.incrementMaze();
        
        assertEquals(theMaze.getXCount(), -1);
    }
    
    @Test
    void testIncrementMaze_Right() {
        theMaze.userDir = Room.RIGHT;
        
        theMaze.incrementMaze();
        
        assertEquals(theMaze.getXCount(), 1);
    }
    
    @Test
    void testHasWon_False() {
        assertFalse(theMaze.hasWon());
    }
    
//    @Test
//    void testReverseDoorPermaLock_Up() {
//        theMaze.reverseDoorPermaLock(Room.UP);
//        
//        assertTrue(theMaze.getCurrentRoom().getUserDoor(Room.DOWN).isPermaLocked());
//    }
    
    @Test
    void testHasWon() {
        theMaze.setRoom(3, 3);
        assertTrue(theMaze.hasWon());
    }
    
    @Test
    void testHasWon_False_OneRoomCorrect() {
        theMaze.setRoom(3, 2);
        assertFalse(theMaze.hasWon());
    }
    
    @Test
    void testGetCorrectCount() {
        int count = 0;
        
        for (int n = 0; n < 3; n++) {
            theMaze.doorSolution(theMaze.getCurrentRoom().getUserDoor(Room.DOWN).getQuestion().getSolution(), Room.DOWN);

            count ++;
        }
        assertEquals(theMaze.getCorrectCount(), count);
    }
    
    @Test
    void testCheckSolution_True() {
      //  theMaze.setRoom(3, 3);
        theMaze.doorSolution(theMaze.getCurrentRoom().getUserDoor(Room.DOWN).getQuestion().getSolution(), Room.DOWN);
   
        assertEquals(theMaze.getYCount(), 1);
    }
    
    @Test
    void testHasLost() {
        theMaze.getCurrentRoom().getUserDoor(Room.UP).getQuestion();
        theMaze.getCurrentRoom().getUserDoor(Room.UP).checkLock("NO");
        theMaze.getCurrentRoom().getUserDoor(Room.LEFT).getQuestion();
        theMaze.getCurrentRoom().getUserDoor(Room.LEFT).checkLock("NO");
        theMaze.getCurrentRoom().getUserDoor(Room.DOWN).getQuestion();
        theMaze.getCurrentRoom().getUserDoor(Room.DOWN).checkLock("NO");
        theMaze.getCurrentRoom().getUserDoor(Room.RIGHT).getQuestion();
        theMaze.getCurrentRoom().getUserDoor(Room.RIGHT).checkLock("NO");
        
        assertTrue(theMaze.hasLost());
    }

}

