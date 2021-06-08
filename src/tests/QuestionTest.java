/**
 * Trivia Maze TCSS 360 Spring 2021
 */

package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.Question;
import model.Question.QuestionQuery;

/**
 * The Question Test class provide test cases for all methods in the Question class
 * 
 * @author Oleksandr Maistruk
 *
 */
class QuestionTest {

    /** Field for work with Question Class */
    private static Question myQuestionClass;
    
    /**
     * @throws java.lang.Exception
     */
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        myQuestionClass = Question.getQuestionInstance();
    }

    /**
     * Test method for getQuestionInstans method.
     * it Checks for returning class instance if it was not create
     */
    @Test
    void testGetQuestionInstanceIfNull() {
        assertNotNull(Question.getQuestionInstance());
    }
    
    /**
     * Test method for getQuestionInstans method.
     * it Checks for returning the same instance of class every time 
     */
    @Test
    void testGetQuestionInstanceTheSame() {
        assertEquals(myQuestionClass, Question.getQuestionInstance(), "The question class instance is not the same.");
    }

    /**
     * Test method for testing getQuestion method.
     * It tests that getQuestion method returns every time the same question for the same ID.
     */
    @Test
    void testGetQuestion() {
        final String question = myQuestionClass.getQuestion(1);
        assertEquals(question, myQuestionClass.getQuestion(1), "The question is not the same.");
    }

    /**
     * Test method for testing getSolution method.
     * It tests that getSolution method returns every time the same answer for the same ID.
     */
    @Test
    void testGetSolution() {
        final String answer = myQuestionClass.getSolution(5);
        assertEquals(answer, myQuestionClass.getSolution(5), "The answer is not the same.");
    }

    /**
     * Test method for testing getMultiAnswer method.
     * It tests that getMultiAnswer method returns every time the same multiple answer for the same ID.
     */
    @Test
    void testGetMultiAnswer() {
        final String multipleAnswer = myQuestionClass.getMultiAnswer(15);
        assertEquals(multipleAnswer, myQuestionClass.getMultiAnswer(15), "The multiple answer is not the same.");
    }

    /**
     * Test method for testing isMultiple method.
     * It tests that isMultiple method returns string for true and null for false.
     */
    @Test
    void testIsMultiple() {
        if (!myQuestionClass.isMultiple(2)) {
            assertNull(myQuestionClass.getMultiAnswer(2));
        } else {
            assertNotNull(myQuestionClass.getMultiAnswer(2));
        }
    }

    /**
     * Test method for testing getId method.
     * The getId method should return id from 0 to 45
     */
    @Test
    void testGetId() {
        int x;
        for(int i = 0; i < 50; i++) {
            x = myQuestionClass.getId();
            assert  x >= 0 : "Wrong ID: it is less than 0";
            assert  x <= 45 : "Wrong ID: it is greater than 45";
        }
    }
    

    /**
     * Test method for testing isSolution method.
     * It compares inputed answer with answer on the database.
     */
    @Test
    void testIsSolution() {
        final String answer = myQuestionClass.getSolution(15);
        assertTrue(myQuestionClass.isSolution(answer, 15), "The isSolution isn't right.");
    }


    /**
     * Test method for testing getMySpecificQuestion method.
     * It should return the same questionQuery for the same ID
     */
    @Test
    void testGetMySpecificQuestionSame() {
        myQuestionClass.setDataBaseName("GeographyQuestions");
        final QuestionQuery answer = myQuestionClass.getMySpecificQuestion(5);
        assertEquals(answer, myQuestionClass.getMySpecificQuestion(5), "The SpecificQuestion should be the same.");
    }
    
    /**
     * Test method for testing getMySpecificQuestion method.
     * It should return the different questionQuery for the same ID
     */
    @Test
    void testGetMySpecificQuestionDifferent() {
        myQuestionClass.setDataBaseName("GeographyQuestions");
        final QuestionQuery answer = myQuestionClass.getMySpecificQuestion(5);
        myQuestionClass.setDataBaseName("SportQuestions");
        assertNotEquals(answer, myQuestionClass.getMySpecificQuestion(5), "The SpecificQuestion should not be the same.");
    }


}