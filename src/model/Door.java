package model;

public class Door extends GameObject {
    private boolean myLock;
    private boolean myPermaLock;
    private Question myQuestion;
    
    public Door() {
        myLock = true;
        myPermaLock = false;
        myQuestion = new Question();
    }

    /**
     *
     * @return
     */
    public Question getQuestion() {
        return myQuestion;
    }

    /**
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

//    @Override
//    public boolean equals(final Object theObj) {
//        return this.getQuestion().equals(theObj);
//    }

//    protected void setId(final int theId) {
//        myId = theId;
//    }

    public int getId() {
        return myQuestion.getId();
    }

}
