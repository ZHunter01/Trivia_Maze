package model;

/**
 * 
 * @author Zach Hunter
 *
 */
public class PowerUp {
    private boolean myPermaUnlock;
    private boolean myFreeQuestion;
    
    
    public PowerUp() {
        myPermaUnlock = false;
        myFreeQuestion = false;
    }
        
    public PowerUp createPermaUnlock() {
        if (myFreeQuestion == true) {
            myFreeQuestion = false;
        }
        
        myPermaUnlock = true;
        
        return this;
    }
    
    public PowerUp createFreeQuestion() {
        if (myPermaUnlock == true) {
            myPermaUnlock = false;
        }
        
        myFreeQuestion = true;
        
        return this;
    }
    
    public boolean isPermaUnlock() {
        return myPermaUnlock;
    }
    
    public boolean isFreeQuestion() {
        return myFreeQuestion;
    }
    
    public void setPermaUnlock(final boolean theBoolean) {
        myPermaUnlock = theBoolean;
    }
    
    public void setFreeQuestion(final boolean theBoolean) {
        myFreeQuestion = theBoolean;
    }
}