package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.PowerUp;

public class PowerUpTest {
    private PowerUp myPower;
    
    @BeforeEach
    void setUp() {
        myPower = new PowerUp();
    }

    @Test
    void testCreateFreeQuestion() {
        myPower.createFreeQuestion();
        
        assertTrue(myPower.isFreeQuestion());
    }

    @Test
    void testReplacePermaUnlcomWithFreeQuestion() {
        myPower.createPermaUnlock();
        
        assertTrue(myPower.createFreeQuestion().isFreeQuestion());
    }
    
    @Test
    void testCreatePermaUnlock() {
        myPower.createPermaUnlock();
        
        assertTrue(myPower.isPermaUnlock());
    }
    
    @Test
    void testReplaceFreeQuestionWithPermaUnlock() {
        myPower.createFreeQuestion();
        
        assertTrue(myPower.createPermaUnlock().isPermaUnlock());
    }
    
    @Test
    void testRemovePermaUnlock() {
        myPower.createPermaUnlock();
        myPower.removePermaUnlock();
        
        assertFalse(myPower.isPermaUnlock());
    }
    
    @Test
    void testRemovePermaUnlockWithFreeQuestion() {
        myPower.createFreeQuestion();
        
        myPower.removePermaUnlock();
        
        assertTrue(myPower.isFreeQuestion());
    }
    
    @Test
    void testRemovePermaUnlockBasePowerUp() {
        myPower.removePermaUnlock();
        
        assertFalse(myPower.isPermaUnlock());
    }
    
    @Test
    void testRemoveFreeQuestion() {
        myPower.createFreeQuestion();
        myPower.removeFreeQuestion();
        
        assertFalse(myPower.isFreeQuestion());
    }
    
    @Test
    void testRemoveFreeQuestionWithPermaUnlock() {
        myPower.createPermaUnlock();
        
        myPower.removeFreeQuestion();
        
        assertTrue(myPower.isPermaUnlock());
    }
    
    @Test
    void testRemoveFreeQuestionBasePowerUp() {
        myPower.removeFreeQuestion();
        
        assertFalse(myPower.isFreeQuestion());
    }
}
