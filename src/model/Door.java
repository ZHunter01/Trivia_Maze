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
    
    /** Set door lock state to input boolean
     * 
     * @param theBoolean
     */
    public void setLock(boolean theBoolean) {
        myLock = theBoolean;
    }
    
    /** Set door permanent lock state to input boolean
     * 
     * @param theBoolean
     */
    public void setPermaLock(boolean theBoolean) {
        myPermaLock = theBoolean;
    }
    
    /** Returns boolean if door is currently locked
     * 
     * @return myLock
     */
    public boolean isLocked() {
        return myLock;
    }
     
    /** Returns boolean if door is permanently locked
     * 
     * @return myPermaLock
     */
    public boolean isPermaLocked() {
        return myPermaLock;
    }

}
