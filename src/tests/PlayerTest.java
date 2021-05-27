package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

import javax.swing.ImageIcon;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Player;
import model.PowerUp;

/**
 * 
 * @author Zach Hunter
 *
 */
public class PlayerTest {
    private Player myPlayer;  
    private PowerUp myPowerUp;
    
    @BeforeEach
    void setUp() {
        myPlayer = new Player();
        //myPowerUp = new PowerUp();
    }
    
    @Test
    void testGetIconDefault() {        
        assertTrue(myPlayer.getIcon().equals(new ImageIcon("./resources/w.gif").getImage()));
    }
    
    @Test
    void testGetX() {
        myPlayer.setLocation(10, 0);
        
        assertEquals(10, myPlayer.getX());
    }
    
    @Test
    void testGetY() {
        myPlayer.setLocation(0, 10);
        
        assertEquals(10, myPlayer.getY());
    }
    
    @Test
    void testSetImage() {
        myPlayer.setImage(new ImageIcon("./resources/ellipse.gif").getImage());
        
        assertEquals(myPlayer.getIcon(), (new ImageIcon("./resources/ellipse.gif").getImage()));
    }
    
    @Test
    void testSetLocationThrow_BothValuesIllegal() {
        final IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, 
                () -> { myPlayer.setLocation(-1, -1); });
        
        final String expected = "Input Error: Values must be greater than or equal to 0.";
        final String actual = exception.getMessage();
        
        assertTrue(actual.equals(expected));
    }

    @Test
    void testAddPowerUp_FreeQuestion() {
        myPlayer.addPowerUp(myPowerUp = PowerUp.createFreeQuestion());
        
        assertTrue(myPlayer.containsFreeQuestion());
    }
    
    @Test
    void testAddPowerUp_PermaUnlock() {
        myPlayer.addPowerUp(myPowerUp = PowerUp.createPermaUnlock());
    
        assertTrue(myPlayer.containsPermaUnlock());
    }
    
    @Test
    void testRemoveFreeQuestion() {
        myPlayer.addPowerUp(myPowerUp = PowerUp.createFreeQuestion());
        myPlayer.removePowerUp(myPowerUp);
        
        assertFalse(myPlayer.containsFreeQuestion());      
    }
    
    @Test
    void testRemovePermaUnlock() {
        myPlayer.addPowerUp(myPowerUp = PowerUp.createPermaUnlock());
        myPlayer.removePowerUp(myPowerUp);
        
        assertFalse(myPlayer.containsPermaUnlock());
    }
    
    @Test
    void testRemoveDefault() {
        myPlayer.addPowerUp(myPowerUp = PowerUp.createFreeQuestion());
        myPlayer.removePowerUp(myPowerUp);
        myPlayer.removePowerUp(myPowerUp);
        
        assertFalse(myPlayer.containsFreeQuestion() || myPlayer.containsPermaUnlock());
    }
    
    @Test
    void testToString() {
        myPlayer.setLocation(10, 10);
        
        final String expected = "10, 10";
        
        assertTrue(myPlayer.toString().equals(expected));
    }
    
    @Test
    void testPlayerWithImage() {
        myPlayer = new Player(new ImageIcon("./resources/ellipse.gif").getImage());
        
        assertTrue(myPlayer.getIcon().equals(new ImageIcon("./resources/ellipse.gif").getImage()));
    }
    
    @Test
    void testMove() {
        //ToDo
    }
    
    @Test
    void testGetPowerUps() {
        //ToDo
    }

}
