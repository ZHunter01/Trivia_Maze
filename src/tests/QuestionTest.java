package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Question;

/**
 * 
 * @author Zach Hunter
 *
 */
public class QuestionTest {
    private Question myQ;
    private final static String QUESTION = "What color is the sky?";
    
    
    @BeforeEach
    void setUp() {
       myQ = new Question(); 
    }
    
    
    @Test
    void getQuestionTest() {
        assertEquals(QUESTION, myQ.getQuestion());
    }
    
    @Test
    void isSolutionTest() {
        assertTrue(myQ.isSolution(myQ.getSolution()));
    }
    
}
