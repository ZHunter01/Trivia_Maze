package tests;

import model.Question;
import model.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    Question myQuestion1;
    Question myQuestion2;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        myQuestion1 = new Question("Random Question", "Answer");
        myQuestion2 = new Question("random questiOn", "AnSwEr");
    }

    @Test
    void getQuestion() {
    }

    @Test
    void getSolution() {
    }

    @Test
    void isSolution() {
    }

    @Test
    void testEquals() {
        assertEquals(myQuestion1, myQuestion2);
    }
}