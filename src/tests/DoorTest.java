//package tests;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import model.Door;
//import model.Question;
//
///**
// * 
// * @author Zach Hunter
// *
// */
//public class DoorTest {
//    Door myDoor;
//    //NO12123 is not an answer for any question in the database
//    static final String MY_INCORRECT = "NO12123";
//    
//    @BeforeEach
//    void setUp() {
//        myDoor = new Door();
//    }
//    
//    @Test
//    void testGetQuestionInstance() {
//        assertEquals(myDoor.getQuestionInstance(), Question.getQuestionInstance());
//    }
//    
//    @Test
//    void checkLockFalse() {
//        myDoor.checkLock(Question.getQuestionInstance().getSolution(myDoor.getId()));
//        
//        assertFalse(myDoor.isLocked());
//    }
//    
//    @Test
//    void checkLockTrue() {
//        myDoor.checkLock(MY_INCORRECT);
//        
//        assertTrue(myDoor.isLocked());
//    }
//
//    
//    @Test
//    void checkPermaLockFalseWithCorrectSolution() {
//        myDoor.checkLock(Question.getQuestionInstance().getSolution(myDoor.getId()));
//        
//        assertFalse(myDoor.isPermaLocked());
//    }
//    
//    @Test
//    void checkPermaLockTrue() {
//        myDoor.checkLock(MY_INCORRECT);
//        
//        assertTrue(myDoor.isPermaLocked());
//    }
//    
//    @Test
//    void checkGetQuestion() {
//        assertEquals(myDoor.getQuestion(), Question.getQuestionInstance().getQuestion(myDoor.getId()));
//    }
//    
//    @Test
//    void checkGetQuestionFalse() {
//        assert(!myDoor.getQuestion().equals(Question.getQuestionInstance().getQuestion(myDoor.getId() + 1)));
//    }
//    
//    @Test
//    void checkEquals() {
//        Door newDoor = new Door();
//        newDoor = myDoor;
//        
//        assertTrue(myDoor.equals(newDoor));
//    }
//    
//    @Test
//    void testSetPermaLock() {
//        myDoor.setPermaLock(true);
//        
//        assertTrue(myDoor.isPermaLocked());
//    }
//    
//    @Test
//    void testGetId() {
//        assertEquals(Door.myQuestionID, myDoor.getId());
//    }
//}
