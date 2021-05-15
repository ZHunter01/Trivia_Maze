package model;

import java.util.Objects;

import db.SqliteDB;

/**
 * 
 * @author Zach Hunter 
 *
 */
public class Question {
    private String myQuestion;
    private String mySolution;
    private SqliteDB database;
    
    public Question() {
        //myQ = new Question();
        //getQuestion();
        myQuestion = "What color is the sky?";
        mySolution = "blue";
        database = new SqliteDB();
    }
    
    
    //getQuestion - say they're a string for now
    public String getQuestion() {
        return myQuestion;
    }
    
    public String getSolution() {
        return mySolution;
    }
    
    public void setQuestionAndSolution(final String theQ, final String theSol) {
        myQuestion = theQ;
        mySolution = theSol;
    }
    
    //Determine if input is solution 
    /**
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
