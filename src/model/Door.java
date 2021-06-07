package model;

import java.io.Serializable;

/**
 * 
 * @author Zach Hunter
 *
 */
public class Door extends GameObject implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = -930527126932044388L;
    private boolean myLock;
    private boolean myPermaLock;
    private int myQuestionID;
    
    /** Creates a default door object
     * 
     */
    public Door() { 
        myLock = true;
        myPermaLock = false;
        myQuestionID = Question.getQuestionInstance().getId();
//System.out.println("Door class, ID: " + myQuestionID);
    }
    
    /** Get current Door Question object
     * 
     * @return
     */
    public String getQuestion() {
        System.out.println("Id: " + myQuestionID + " Answer87: " + Question.getQuestionInstance().getSolution(myQuestionID));
        return Question.getQuestionInstance().getQuestion(myQuestionID);
    }
    
    /** Method for getting current question object for the door
     * Testing method
     * @return
     */
    public Question getQuestionInstance() {
        return Question.getQuestionInstance();
    }
    
    /** Checks the input string to see if it matches Question's solution
     * 
     * @param theSolution
     */
    public void checkLock(final String theSolution) {
        if (Question.getQuestionInstance().isSolution(theSolution, myQuestionID)) {
            myLock = false;
        }
        //Incorrect answer. PermaLock door is set to true
        else {
            myPermaLock = true;
        }
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
    
    /** Returns int ID of Question object in the Door
     * 
     * @return
     */
    public int getId() {
        return myQuestionID;
    }

}