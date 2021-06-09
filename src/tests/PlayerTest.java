package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.ImageIcon;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Player;
import model.PowerUp;
import model.Room;

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
    void testGetImageDefault() {        
        assertTrue(myPlayer.getImage().equals(new ImageIcon("resources/Oldman.gif").getImage()));
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
    void testGetPowerUps() {
        final PowerUp free = PowerUp.createFreeQuestion();
        final PowerUp perma = PowerUp.createPermaUnlock();
        myPlayer.addPowerUp(free);
        myPlayer.addPowerUp(perma);
        
        assertTrue(myPlayer.getPowerUps().contains(free) && myPlayer.getPowerUps().contains(perma));
    }
    
    @Test
    void testMove_X_Y() {
        final int x = myPlayer.getX();
        final int y = myPlayer.getY();
        
        myPlayer.move(x, y);
        
        assertTrue(myPlayer.getX() == x + x && myPlayer.getY() == y + y);
    }
    
    @Test
    void testMove_Up() {
        final int x = myPlayer.getX();
        final int y = myPlayer.getY();
        
        myPlayer.move(Room.UP);
        
        assertTrue(myPlayer.getX() == x && myPlayer.getY() == (y - 110));
    }

    @Test
    void testMove_Left() {
        final int x = myPlayer.getX();
        final int y = myPlayer.getY();
        
        myPlayer.move(Room.LEFT);
        
        assertTrue(myPlayer.getX() == (x - 166) && myPlayer.getY() == y);
    }    
    
    @Test
    void testMove_Down() {
        final int x = myPlayer.getX();
        final int y = myPlayer.getY();
        
        myPlayer.move(Room.DOWN);
        
        assertTrue(myPlayer.getX() == x && myPlayer.getY() == (y + 110));
    }
    
    @Test
    void testMove_Right() {
        final int x = myPlayer.getX();
        final int y = myPlayer.getY();
        
        myPlayer.move(Room.RIGHT);
        
        assertTrue(myPlayer.getX() == (x + 166) && myPlayer.getY() == y);
    }
//    @Test
//    void testPlayerWithImage() {
//        myPlayer = new Player(new ImageIcon("./resources/ellipse.gif").getImage());
//        
//        assertTrue(myPlayer.getImage().equals(new ImageIcon("./resources/ellipse.gif").getImage()));
//    }

}
