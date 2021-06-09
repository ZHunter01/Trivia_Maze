/**
 * Trivia Maze TCSS 360 Spring 2021
 */
package model;

import java.io.Serializable;

/**Door object class containing a question object
 * 
 * @author Zach Hunter
 *
 */
public class Door extends GameObject implements Serializable{
    /**Serializable generated number */
    private static final long serialVersionUID = -930527126932044388L;
    /**Boolean field for current lock state of the door */
    private boolean myLock;
    /**Boolean field for current Perma-Lock state of the door */
    private boolean myPermaLock;
    /**int field for door's question ID */
    private int myQuestionID;
    /**String that holds cheat value. If this is the input, the door is unlocked */
    private static final String CHEAT = "TOM";
    
    /** Creates a default door object
     * 
     */
    public Door() { 
        myLock = true;
        myPermaLock = false;
        myQuestionID = Question.getQuestionInstance().getId();
    }
    
    /** Get current Door Question object
     * 
     * @return
     */
    public String getQuestion() {
        System.out.println(" Answer: " + Question.getQuestionInstance().getSolution(myQuestionID)); //Left in for ease of testing our code. Prints solution
        return Question.getQuestionInstance().getQuestion(myQuestionID);
    }
   
    /** Checks the input string to see if it matches Question's solution
     * 
     * @param theSolution
     */
    public void checkLock(final String theSolution) {
        if (Question.getQuestionInstance().isSolution(theSolution, myQuestionID) || theSolution.equalsIgnoreCase(CHEAT)) {
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