package tests;

import model.Player;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player myPlayer;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        myPlayer = new Player();
    }

    // how to test?
    @Test
    void getIcon() {
    }

    @Test
    void getDefaultColor() {
        assertEquals(myPlayer.getColor(), Color.BLACK);
    }

    @Test
    void getX() {
        myPlayer.setLocation(420, 69);

        assertEquals(420, myPlayer.getX());
    }

    @Test
    void getY() {
        myPlayer.setLocation(420, 69);

        assertEquals(69, myPlayer.getY());
    }
}