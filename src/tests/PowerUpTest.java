package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.PowerUp;

/**
 * 
 * @author Zach Hunter
 *
 */
public class PowerUpTest {
    private PowerUp myPower;
    
    @BeforeEach
    void setUp() {
        //myPower = new PowerUp();
    }

    @Test
    void testCreateFreeQuestion() {
        myPower = PowerUp.createFreeQuestion();
        
        assertTrue(myPower.isFreeQuestion());
    }

    @Test
    void testReplacePermaUnlcomWithFreeQuestion() {
        myPower = PowerUp.createPermaUnlock();
        
        assertTrue((myPower = PowerUp.createFreeQuestion()).isFreeQuestion());
    }
    
    @Test
    void testCreatePermaUnlock() {
        myPower = PowerUp.createPermaUnlock();
        
        assertTrue(myPower.isPermaUnlock());
    }
    
    @Test
    void testReplaceFreeQuestionWithPermaUnlock() {
        myPower = PowerUp.createFreeQuestion();
        
        assertTrue((myPower = PowerUp.createPermaUnlock()).isPermaUnlock());
    }
    
    @Test
    void testRemovePermaUnlock() {
        myPower = PowerUp.createPermaUnlock();
        myPower.removePermaUnlock();
        
        assertFalse(myPower.isPermaUnlock());
    }
    
    @Test
    void testRemovePermaUnlockWithFreeQuestion() {
        myPower = PowerUp.createFreeQuestion();
        
        myPower.removePermaUnlock();
        
        assertTrue(myPower.isFreeQuestion());
    }
    
    @Test
    void testRemoveFreeQuestionTwice() {
        myPower = PowerUp.createFreeQuestion();
        myPower.removeFreeQuestion();
        
        myPower.removeFreeQuestion();
        
        assertFalse(myPower.isFreeQuestion());
    }
    
    @Test
    void testRemoveFreeQuestion() {
        myPower = PowerUp.createFreeQuestion();
        myPower.removeFreeQuestion();
        
        assertFalse(myPower.isFreeQuestion());
    }
    
    @Test
    void testRemoveFreeQuestionWithPermaUnlock() {
        myPower = PowerUp.createPermaUnlock();
        
        myPower.removeFreeQuestion();
        
        assertTrue(myPower.isPermaUnlock());
    }
    
    @Test
    void testRemovePermaUnlockTwice() {
        myPower = PowerUp.createPermaUnlock();
        myPower.removePermaUnlock();
        myPower.removePermaUnlock();
        
        assertFalse(myPower.isPermaUnlock());
    }
}
