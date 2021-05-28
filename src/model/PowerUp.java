package model;

import java.io.Serializable;

/**
 * 
 * @author Zach Hunter
 *
 */
public class PowerUp implements Serializable{
  
    private static final long serialVersionUID = 6950740297210484269L;
    //private static PowerUp myPowerUp;
    private boolean myPermaUnlock;
    private boolean myFreeQuestion;
    
    /**
     * 
     * @param theFreeQ
     * @param thePermaUnlock
     */
    private PowerUp(final boolean theFreeQ, final boolean thePermaUnlock) {
        
        myPermaUnlock = thePermaUnlock;
        myFreeQuestion = theFreeQ;
    }
        
    /** Creates a PermaUnlock PowerUp
     * 
     * @return
     */
    public static PowerUp createPermaUnlock() {
        PowerUp myPowerUp = new PowerUp(false, true);
        return myPowerUp;
    }
    
    /** Creates a FreeQuestion PowerUp
     * 
     * @return
     */
    public static PowerUp createFreeQuestion() {
        PowerUp myPowerUp = new PowerUp(true, false);
        return myPowerUp;
    }
    
    /**
     * 
     * @return
     */
    public boolean isPermaUnlock() {
        return myPermaUnlock;
    }
    
    /**
     * 
     * @return
     */
    public boolean isFreeQuestion() {
        return myFreeQuestion;
    }
    
    /** Sets PermaUnlock boolean value to false
     * 
     */
    public void removePermaUnlock() {      
        this.setPermaUnlock(false);
    }
    
    /**
     * 
     */
    public void removeFreeQuestion() {
        this.setFreeQuestion(false);
    }

    /**
     * 
     * @param theBoolean
     */
    private void setPermaUnlock(final boolean theBoolean) {
        myPermaUnlock = theBoolean;
    }
    
    /**
     * 
     * @param theBoolean
     */
    private void setFreeQuestion(final boolean theBoolean) {
        myFreeQuestion = theBoolean;
    }
}
