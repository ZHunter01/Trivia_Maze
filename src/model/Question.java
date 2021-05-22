
package model;

import java.util.Objects;
import java.util.Random;

import db.SqliteDB;
import view.MyMenuBar;

/**
 * 
 * @author Zach Hunter 
 * @author Oleksandr Maistruk
 *
 */
public class Question {
    private String myQuestion;
    private String mySolution;
    private String myMultiAnswer;
    private SqliteDB myDatabase;
    private final int myId;
    
    public Question() {
        myDatabase = new SqliteDB(MyMenuBar.getDataBaseName());
        myId = idHelper();
    }
    
    /**
     * This method is used to assign question id randomly. 
     * 
     * @return question id
     */
    private int idHelper() {
        final Random rand = new Random();
        int random = rand.nextInt(myDatabase.getLastId())+1;
//        System.out.println("random #: " + random);
        while (myDatabase.getIsUsed(random)) {
            random = rand.nextInt(myDatabase.getLastId())+1;
        }

//        myDatabase.updateIsUsed(random);
        
        return random;
    }

    
    /**
     * 
     * @return question by id
     */
    public String getQuestion() {
        myQuestion = myDatabase.getQuestion(myId);
        return myQuestion;
    }
    
    /**
     * 
     * @return answer by id
     */
    public String getSolution() {
        mySolution = myDatabase.getAnswer(myId);
        return mySolution;
    }
    
    /**
     * 
     * @return multiple answers
     */
    public String getMultiAnswer() {
        myMultiAnswer = myDatabase.getMultiAnswer(myId);
        return myMultiAnswer;
    }
    
    /**
     * 
     * @return true if the question has multiple answer
     */
    public boolean isMultiple() {
        return myDatabase.getIsMultipleChoice(myId);
    }
    
//    public void setQuestionAndSolution(final String theQ, final String theSol) {
//        myQuestion = theQ;
//        mySolution = theSol;
//    }
    
     
    /**
     * Determine if input is solution
     * 
     * @param theInput
     * @return mySolution.toLowerCase().equals(theInput.toLowerCase())
     */
    public boolean isSolution(final String theInput) {
        return  mySolution.toLowerCase().equals(theInput.toLowerCase());
    }
    
    @Override
    public boolean equals(final Object theObj) {
        if (this == theObj) return true;
        if (theObj == null || getClass() != theObj.getClass()) return false;
        
        Question question = (Question) theObj;
        return Objects.equals(myQuestion, question.myQuestion) && Objects.equals(mySolution, question.mySolution);
    }
}