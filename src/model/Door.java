package model;

import java.util.Objects;

public class Door extends GameObject {
    private boolean myLock;
    private boolean myPermaLock;
    private Question myQuestion;
    private int myId;
    
    public Door() {
        //Grab question from database
        //Question object class
        //Make a question object class
        myLock = true;
        myPermaLock = false;
        myQuestion = new Question();
        myId = 0;
    }

//    public void setDoorLeftAndRight() {
//        setImage("src/resources/doorRightAndLeft.png");
//    }
//
//    public void setDoorUpAndDown() {
//        setImage("src/resources/doorUpAndDown.png");
//    }
    
    public Question getQuestion() {
        return myQuestion;
    }

    public void setQuestion(final Question theQ) {
        myQuestion = theQ;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Door door = (Door) o;
        return myLock == door.myLock && myPermaLock == door.myPermaLock && myQuestion.equals(door.myQuestion);
    }

    public void setId(final int theId) {
        myId = theId;
    }

    public int getId() {
        return myId;
    }

}
