package model;

import java.util.Objects;
import java.util.Random;

import db.SqliteDB;

/**
 * 
 * @author Zach Hunter 
 * @author Oleksandr Maistruk
 *
 */
public class Question {
    private String myQuestion;
    private String mySolution;
    private SqliteDB myDatabase;
    private final int myId;
    
    public Question() {
        //myQ = new Question();
        //getQuestion();
        myQuestion = "What color is the sky?";
        mySolution = "blue";
        myDatabase = new SqliteDB();
        myId = idHelper();
    }
    
    /**
     * This method is used to assign question id randomly. 
     * 
     * @return question id
     */
    private int idHelper() {
        final Random rand = new Random();
        final int random = rand.nextInt(myDatabase.getLastId())+1;
        System.out.println("random #: " + random);
        if (myDatabase.getIsUsed(random) == true) {
            idHelper();
        } else {
            myDatabase.updateIsUsed(random);
        }
        
        return random;
    }
    
    //getQuestion - say they're a string for now
    public String getQuestion() {
        myQuestion = myDatabase.getQuestion(myId);
        return myQuestion;
    }
    
    public String getSolution() {
        mySolution = myDatabase.getAnswer(myId);
        return mySolution;
    }
    
    public void setQuestionAndSolution(final String theQ, final String theSol) {
        myQuestion = theQ;
        mySolution = theSol;
    }
    
     
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
