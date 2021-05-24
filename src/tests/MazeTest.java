package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Maze;
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
    
//    @Test
//    void testQuestionCount() {
//        theMaze.doorSolution((theMaze.getCurrentRoom().getUserDoor(0).getQuestion()).getSolution());
//        final int count = 1;
//        
//        
//        assertTrue(count == theMaze.getQuestionCount());
//    }
    
    @Test
    void testCustomMazeConstructor() {        
        assertTrue(customMaze.getXLength() == 6 && customMaze.getYLength() == 6);
    }
    
    @Test
    void testDoorQuestion() {
        assertEquals(theMaze.doorQuestion(Room.UP), theMaze.getCurrentRoom().getUserDoor(Room.UP).getQuestion());
    }
    
    @Test
    void testGetMyMaze() {
        final Room[][] testRoom = theMaze.getMyMaze();
        assertTrue(theMaze.getMyMaze().equals(testRoom));
    }
    
    @Test
    void testGetMyPlayer() {
        assertTrue(theMaze.getMyPlayer().equals(theMaze.getCurrentRoom().getPlayer()));
    }
    
    @Test
    void testGetCurrentDoor() {
        assertTrue(theMaze.getCurrentDoor(Room.UP).equals(theMaze.getCurrentRoom().getUserDoor(Room.UP)));
    }
    
//    @Test
//    void testGetCorrectCount() {
//        int count = 0;
//        
//        for (int n = 0; n < 4; n++) {
//            theMaze.doorSolution(theMaze.getCurrentDoor(Room.UP).getQuestion().getSolution());
//            System.out.println(theMaze.getCurrentDoor(Room.UP).getQuestion().getQuestion());
//            System.out.println(theMaze.getCurrentDoor(Room.UP).getQuestion().getSolution());
//
//            count ++;
//        }
//        assertEquals(theMaze.getCorrectCount(), count);
//    }
}

