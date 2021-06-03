/**
 * Trivia Maze TCSS 360 Spring 2021
 */

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import db.SqliteDB;
import view.MyMenuBar;

/**
 * 
 * @author Zach Hunter 
 * @author Oleksandr Maistruk
 *
 */
public class Question implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1721924346865745075L;

    /** static variable single_instance of type Singleton */
    private static Question questionInstance = null;
    
    /** The name of current database */
    private String myDataBaseName;
    
    /** The database is the source of questions */
    private transient SqliteDB myDatabase;
    
    /** The question ID */
    private int myId = 0;
    
    /** The array list with sport questions */
    private List<QuestionQuery> mySportQuestions = new ArrayList<QuestionQuery>();
    
    /** The array list with geography questions */
    private List<QuestionQuery> myGeographyQuestions = new ArrayList<QuestionQuery>();
    
    /** Service field to assign specific question */
    private QuestionQuery mySpecificQuestion;
    
    
    /**
     * Private constructor to create Question class as singleton.
     */
    private Question() {
        myDataBaseName = MyMenuBar.getDataBaseName();
        idHelper("SportQuestions");
        idHelper("GeographyQuestions");
    }
    

    /**
     * Static method to create instance of Question class
     * 
     * @return instance of the question class
     */
    public static Question getQuestionInstance() {
        if (questionInstance == null)
            questionInstance = new Question();
        return questionInstance;
    }
    
    
    /**
     * This method is used to create array list with questions. 
     * Then shuffle the array.
     * 
     * @return question id
     */
    private void idHelper(final String theDBName) {
        myDatabase = new SqliteDB(theDBName);
        final int lastID = myDatabase.getLastId();
        
        if(theDBName.equals("SportQuestions")) {
            for(int i = 1; i <= lastID; i++ ) {
                mySportQuestions.add(new QuestionQuery(myDatabase.getQuestion(i),
                        myDatabase.getAnswer(i), myDatabase.getMultiAnswer(i),
                        myDatabase.getIsMultipleChoice(i)));
            }
            Collections.shuffle(mySportQuestions);
        } else {
            for(int i = 1; i <= lastID; i++ ) {
                myGeographyQuestions.add(new QuestionQuery(myDatabase.getQuestion(i),
                        myDatabase.getAnswer(i), myDatabase.getMultiAnswer(i),
                        myDatabase.getIsMultipleChoice(i)));
            }
            Collections.shuffle(myGeographyQuestions);
        }
        myDatabase.closeDB();
    }

    /**
     * This class create an question object.
     *
     */
    public class QuestionQuery {
        
        private String myQueryQuestion;
        private String myQueryAnswer;
        private String myQueryMultipleAnswer;
        private boolean myQueryIsMultiple;

        private QuestionQuery(final String theQuestion, final String theAnswer,
                final String theMultipleAnswers, final boolean isMultiple) {
            myQueryQuestion = theQuestion;
            myQueryAnswer = theAnswer;
            myQueryMultipleAnswer = theMultipleAnswers;
            myQueryIsMultiple = isMultiple;
        } 
    }
    
    /**
     * 
     * @return question by id
     */
    public String getQuestion(final int theId) {
        mySpecificQuestion = getMySpecificQuestion(theId);
        return mySpecificQuestion.myQueryQuestion;
    }
    
    /**
     * 
     * @return answer by id
     */
    public String getSolution(final int theId) {
        //System.out.println(myDatabase.getAnswer(myId));
        mySpecificQuestion = getMySpecificQuestion(theId);
        
        return mySpecificQuestion.myQueryAnswer;
    }
    
    /**
     * 
     * @return multiple answers
     */
    public String getMultiAnswer(final int theId) {
        mySpecificQuestion = getMySpecificQuestion(theId);
        return mySpecificQuestion.myQueryMultipleAnswer;
    }
    
    /**
     * 
     * @return true if the question has multiple answer
     */
    public boolean isMultiple(final int theId) {
        mySpecificQuestion = getMySpecificQuestion(theId);
        return mySpecificQuestion.myQueryIsMultiple;
    }
    
//    /** Manually set question and solution for question object
//     * 
//     * @param theQ
//     * @param theSol
//     */
//    public void setQuestionAndSolution(final String theQ, final String theSol) {
//        myQuestion = theQ;
//        mySolution = theSol;
//    }
    
     
    public int getId() {
        int x = myId;
        if(myId < mySportQuestions.size() - 1) {
           myId++; 
        } else {
            myId = 0;
        }
        return x;
    }
    
    /**
     * Determine if input is solution
     * 
     * @param theInput
     * @return mySolution.toLowerCase().equals(theInput.toLowerCase())
     */
    public boolean isSolution(final String theInput, final int theId) {
        mySpecificQuestion = getMySpecificQuestion(theId);
        return  mySpecificQuestion.myQueryAnswer.toLowerCase().equals(theInput.toLowerCase());
    }
    
//    @Override
//    public boolean equals(final Object theObj) {
//        if (this == theObj) return true;
//        if (theObj == null || getClass() != theObj.getClass()) return false;
//        
//        Question question = (Question) theObj;
//        return Objects.equals(myQuestion, question.myQuestion) && Objects.equals(mySolution, question.mySolution);
//    }
    
    /**
     * 
     * @param theName
     */
    public void setDataBaseName(final String theName) {
        myDataBaseName = theName;
    }
    
    /**
     * 
     * @param theId
     * @return
     */
    public QuestionQuery getMySpecificQuestion(final int theId) {
        if(myDataBaseName.equals("SportQuestions")) {
            mySpecificQuestion = mySportQuestions.get(theId);
        } else {
            mySpecificQuestion = myGeographyQuestions.get(theId);
        }
        
        return mySpecificQuestion;
    }
}