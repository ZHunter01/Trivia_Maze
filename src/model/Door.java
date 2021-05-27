package model;

/**
 * 
 * @author Zach Hunter
 *
 */
public class Door extends GameObject{
    private boolean myLock;
    private boolean myPermaLock;
    private Question myQuestion;
    
    /** Creates a default door object
     * 
     */
    public Door() { 
        myLock = true;
        myPermaLock = false;
        myQuestion = new Question();
    }
    
    /** Get current Door Question object
     * 
     * @return
     */
    public Question getQuestion() {
        return myQuestion;
    }
    
    /** Set Question object of the Door
     * 
     * @param theQ
     */
    public void setQuestion(final Question theQ) {
        myQuestion = theQ;
    }
    
    /** Checks the input string to see if it matches Question's solution
     * 
     * @param theSolution
     */
    public void checkLock(final String theSolution) {
       // if (myQuestion.isSolution(theSolution)) {
        System.out.println(getQuestion().getSolution());
        if (myQuestion.getSolution().toLowerCase().equals(theSolution.toLowerCase().trim())) {
            myLock = false;
        }
        else {
            myPermaLock = true;
        }
    }
    
    /** Set door permanent lock state to input boolean
     * 
     * @param theBoolean
     */
    protected void setPermaLock(boolean theBoolean) {
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
    
    /** Returns int ID of Question object in the Door
     * 
     * @return
     */
    public int getId() {
        return myQuestion.getId();
    }

}
