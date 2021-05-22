package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Door;
import model.Question;

<<<<<<< HEAD
public class DoorTest {
    private Question myQ;
    private Door myDoor;
    
    @BeforeAll
    void setUp() {
        myQ = new Question();
        myDoor = new Door();
    }
    
    
=======
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
    void checkPermaLockNoSolution() {
        myQ.setQuestionAndSolution("Does this work?", "Yes");
        myDoor.setQuestion(myQ);
        
        assertFalse(myDoor.isPermaLocked());
    }
    
    @Test
    void checkPermaLockFalseWithCorrectSolution() {
        myQ.setQuestionAndSolution("Does this work?", "Yes");
        myDoor.setQuestion(myQ);
        myDoor.checkLock("YES");
        
        assertFalse(myDoor.isPermaLocked());
    }
    
    @Test
    void checkPermaLockTrue() {
        myQ.setQuestionAndSolution("Does this work?", "Yes");
        myDoor.setQuestion(myQ);
        myDoor.checkLock("NO");
        
        assertTrue(myDoor.isPermaLocked());
    }
<<<<<<< HEAD
>>>>>>> zach_branch
=======
    
    @Test
    void checkGetQuestion() {
        myQ.setQuestionAndSolution("Does this work?", "Yes");
        myDoor.setQuestion(myQ);
        
        assertEquals(myDoor.getQuestion(), myQ);
    }
    
    @Test
    void checkGetQuestionFalse() {
        myQ.setQuestionAndSolution("Does this work?", "Yes");
        myDoor.setQuestion(myQ);
        
        assert(!myDoor.getQuestion().equals(new Question()));
    }
    
    @SuppressWarnings("unlikely-arg-type") //To compare doors, we compare their question
    @Test
    void checkEquals() {
        Door newDoor = new Door();
        newDoor = myDoor;
        
        assertTrue(myDoor.equals(newDoor.getQuestion()));
    }
>>>>>>> zach_branch
}
