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
    
    
    private PowerUp(final boolean theFreeQ, final boolean thePermaUnlock) {
        
        myPermaUnlock = thePermaUnlock;
        myFreeQuestion = theFreeQ;
    }
        
    public static PowerUp createPermaUnlock() {
        PowerUp myPowerUp = new PowerUp(false, true);
        return myPowerUp;
    }
    
    public static PowerUp createFreeQuestion() {
        PowerUp myPowerUp = new PowerUp(true, false);
        return myPowerUp;
    }
    
    public static PowerUp createEmptyPowerUp() {
        PowerUp myPowerUp = new PowerUp(false, true);
        return myPowerUp;
    }
    
    public boolean isPermaUnlock() {
        return myPermaUnlock;
    }
    
    public boolean isFreeQuestion() {
        return myFreeQuestion;
    }
    
    /** Sets PermaUnlock boolean value to false
     * 
     */
    public void removePermaUnlock() {
//        if (!this.isPermaUnlock()) {
//            return;
//        }
        
        this.setPermaUnlock(false);
    }
    
    public void removeFreeQuestion() {
//        if (!this.isFreeQuestion()) {
//            return;
//        }
        
        this.setFreeQuestion(false);
    }
    
    private void setPermaUnlock(final boolean theBoolean) {
        myPermaUnlock = theBoolean;
    }
    
    private void setFreeQuestion(final boolean theBoolean) {
        myFreeQuestion = theBoolean;
    }
}
