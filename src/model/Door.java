package model;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author Zach Hunter
 *
 */
public class Door extends GameObject implements Serializable {

    @Serial
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
    }

    /** Get current Door Question object
     *
     * @return
     */
    public String getQuestion() {
        System.out.println("Answer: " + Question.getQuestionInstance().getSolution(myQuestionID));
        return Question.getQuestionInstance().getQuestion(myQuestionID);
    }

    /** Checks the input string to see if it matches Question's solution
     *
     * @param theSolution
     */
    public void checkLock(final String theSolution) {
        // if (myQuestion.isSolution(theSolution)) {
        //System.out.println(Question.getQuestionInstance().getSolution(myQuestionID));
        System.out.println("checkLock: \nQ: " + Question.getQuestionInstance().getQuestion(myQuestionID) + "\nA: " +
                Question.getQuestionInstance().getSolution(myQuestionID));
        if (Question.getQuestionInstance().isSolution(theSolution, myQuestionID)) {
            //Question.getQuestionInstance().getSolution(myQuestionID).
            //toLowerCase().equals(theSolution.toLowerCase().trim())

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

    public void setLock(final boolean theLock) {
        myLock = theLock;
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