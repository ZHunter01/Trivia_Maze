package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Maze;

public class MazeTest {
    private Maze theMaze;
    private Maze customMaze;
    
    @BeforeEach
    void SetUp() {
        theMaze = new Maze();
        //customMaze = new Maze(6,6);
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
    
//    @Test
//    void testCustomMazeConstructor() {        
//        assertTrue(customMaze.getXLength() == 6 && customMaze.getYLength() == 6);
//    }
}
