package model;

public class Door {
    private boolean myLock;
    private boolean myPermaLock;
    private Question myQuestion;
    
    public Door() {
        //Grab question from database
        //Question object class
        //Make a question object class
        myLock = true;
        myPermaLock = false;
        myQuestion = new Question();
        
    }
    
    public Question getQuestion() {
        return myQuestion;
    }
    
    public void checkLock(final String theSolution) {
        if (myQuestion.isSolution(theSolution)) {
            myLock = false;
        }
        else {
            myPermaLock = true;
        }
    }
    
    public void setLock(boolean theBoolean) {
        myLock = theBoolean;
    }
    
    public void setPermaLock(boolean theBoolean) {
        myPermaLock = theBoolean;
    }
    
    public boolean isLocked() {
        return myLock;
    }
    
    public boolean isPermaLocked() {
        return myPermaLock;
    }

}
