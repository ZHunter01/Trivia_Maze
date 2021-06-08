//package tests;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import model.Question;
//
///**
// * 
// * @author Zach Hunter
// *
// */
//public class QuestionTest {
//    private Question myQ;
//    private final static String QUESTION = "What color is the sky?";
//    private final static String SOLUTION = "Blue";
//    
//    @BeforeEach
//    void setUp() {
//       myQ = new Question();
//       myQ.setQuestionAndSolution("Question" , "Answer");
//    }
//    
//    
//    @Test
//    void testGetQuestion() {
//        assertEquals(myQ.getQuestion(), "Question");
//    }
//    
//    @Test
//    void isSolutionTest() {
//        assertTrue(myQ.isSolution(myQ.getSolution()));
//    }
//    
//    @Test
//    void testEqualsTrue() {
//        Question newQ = new Question();
//        newQ = myQ;
//        
//        assertTrue(myQ.equals(newQ));
//        
//    }
//    
//    @Test
//    void testEqualsSameSolAndQ() {
//        Question newQ = new Question();
//        newQ.setQuestionAndSolution("What color is the sky?", "blue");
//        
//        
//        assertTrue(myQ.equals(newQ));
//    }
//    
//    @Test
//    void testEqualsFalse() {
//        Question newQ = new Question();
//        newQ.setQuestionAndSolution("This will Fail?", "Yes");
//        
//        
//        assertFalse(myQ.equals(newQ));
//    }
//    
//    @Test
//    void testEqualFalseNull() {
//        assertFalse(myQ.equals(null));
//    }
//    
//    @SuppressWarnings("unlikely-arg-type")
//    @Test
//    void testEqualsFalseWrongInput() {
//        assertFalse(myQ.equals("Failed"));
//    }
//    
//    @Test
//    void testEqualsFalseWrongSolution() {
//        Question newQ = new Question();
//        newQ.setQuestionAndSolution("What color is the sky?", "green");
//        
//        
//        assertFalse(myQ.equals(newQ));
//    }
//    @Test
//    void testEqualsFalseWrongQuestion() {
//        Question newQ = new Question();
//        newQ.setQuestionAndSolution("Will this test fail?", "blue");
//        
//        
//        assertFalse(myQ.equals(newQ));
//    }
//
//}