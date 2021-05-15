package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Door;
import model.Question;

/**
 * 
 * @author Zach Hunter
 *
 */
public class DoorTest {
    Door myDoor;
    Question myQ;
    
    
    @BeforeEach
    void setUp() {
        myDoor = new Door();
        myQ = new Question();
        
        //myDoor.setQuestion(myQ);
    }
    
    @Test
    void checkLockFalse() {
        myQ.setQuestionAndSolution("Does this work?", "Yes");
        myDoor.setQuestion(myQ);
        myDoor.checkLock("YES");
        
        assertFalse(myDoor.isLocked());
    }
    
    @Test
    void checkLockTrue() {
        myQ.setQuestionAndSolution("Does this work?", "Yes");
        myDoor.setQuestion(myQ);
        myDoor.checkLock("NO");
        
        assertTrue(myDoor.isLocked());
    }
    
    @Test
    void checkPermaLockTrue() {
        myQ.setQuestionAndSolution("Does this work?", "Yes");
        myDoor.setQuestion(myQ);
        myDoor.checkLock("NO");
        
        assertTrue(myDoor.isPermaLocked());
    }
}
