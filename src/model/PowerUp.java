package model;

import java.io.Serializable;

/**
 * 
 * @author Zach Hunter
 *
 */
public class PowerUp implements Serializable{
  
    public static final long serialVersionUID = 6950740297210484269L;
    //public static PowerUp myPowerUp;
    public boolean myPermaUnlock;
    public boolean myFreeQuestion;
    
    /**
     * 
     * @param theFreeQ
     * @param thePermaUnlock
     */
    public PowerUp(final boolean theFreeQ, final boolean thePermaUnlock) {
        
        myPermaUnlock = thePermaUnlock;
        myFreeQuestion = theFreeQ;
    }
        
    /** Creates a PermaUnlock PowerUp
     * 
     * @return myPowerUp
     */
    public static PowerUp createPermaUnlock() {
        PowerUp myPowerUp = new PowerUp(false, true);
        return myPowerUp;
    }
    
    /** Creates a FreeQuestion PowerUp
     * 
     * @return myPowerUp
     */
    public static PowerUp createFreeQuestion() {
        PowerUp myPowerUp = new PowerUp(true, false);
        return myPowerUp;
    }
    
    /** Creates an empty PowerUp
     * 
     * @return myPowerUp
     */
    public static PowerUp createEmptyPowerUp() {
        PowerUp myPowerUp = new PowerUp(false, false);
        return myPowerUp;
    }
    
    /** Returns if PowerUp is a PermaUnlock
     * 
     * @return myPermaUnlock
     */
    public boolean isPermaUnlock() {
        return myPermaUnlock;
    }
    
    /** Returns if PowerUp is a Free Question
     * 
     * @return myFreeQuestion
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
    
    /** Sets boolean of Free Question to false
     * 
     */
    public void removeFreeQuestion() {
        this.setFreeQuestion(false);
    }

    /** Sets PermaUnlock to boolean input
     * 
     * @param theBoolean
     */
    public void setPermaUnlock(final boolean theBoolean) {
        myPermaUnlock = theBoolean;
    }
    
    /** Sets FreeQuestion to boolean input
     * 
     * @param theBoolean
     */
    public void setFreeQuestion(final boolean theBoolean) {
        myFreeQuestion = theBoolean;
    }
    
    public boolean equals(final PowerUp thePower) { 
        if (this.myFreeQuestion == thePower.myFreeQuestion && this.myPermaUnlock == thePower.myPermaUnlock) {
            return true;
        }
        return false;
    }
}