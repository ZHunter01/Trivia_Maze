/**
 * Trivia Maze TCSS 360 Spring 2021
 */

package model;

//import java.io.Serial;
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
    
    //@Serial number
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
    
    /** The array list with music questions */
    private List<QuestionQuery> myMusicQuestions = new ArrayList<QuestionQuery>();
    
    /** Service field to assign specific question */
    private QuestionQuery mySpecificQuestion;
    
    
    /**
     * Private constructor to create Question class as singleton.
     */
    private Question() {
        myDataBaseName = MyMenuBar.getDataBaseName();
        idHelper("SportQuestions");
        idHelper("GeographyQuestions");
        idHelper("MusicQuestions");
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
    
    //@Serial for serialization 
    protected Object readResolve()  {
        return this;
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
        } else if(theDBName.equals("GeographyQuestions")) {
            for(int i = 1; i <= lastID; i++ ) {
                myGeographyQuestions.add(new QuestionQuery(myDatabase.getQuestion(i),
                        myDatabase.getAnswer(i), myDatabase.getMultiAnswer(i),
                        myDatabase.getIsMultipleChoice(i)));
            }
            Collections.shuffle(myGeographyQuestions);
        } else {
            for(int i = 1; i <= lastID; i++ ) {
                myMusicQuestions.add(new QuestionQuery(myDatabase.getQuestion(i),
                        myDatabase.getAnswer(i), myDatabase.getMultiAnswer(i),
                        myDatabase.getIsMultipleChoice(i)));
            }
            Collections.shuffle(myMusicQuestions);
        }
        myDatabase.closeDB();
    }

    /**
     * This class create an question object.
     *
     */
    public class QuestionQuery implements Serializable {
        
        //@Serial number
        private static final long serialVersionUID = 1880121979725207215L;
        
        /** Question field for QuestionQuery class */
        private String myQueryQuestion;
        
        /** Answer field for QuestionQuery class */
        private String myQueryAnswer;
        
        /** Multiple answer field for QuestionQuery class */
        private String myQueryMultipleAnswer;
        
        /** If the question has multiple answer field for QuestionQuery class */
        private boolean myQueryIsMultiple;

        /**
         * Constructor to construct QuestionQuery object with given inputs
         * 
         * @param theQuestion is the question
         * @param theAnswer is the answer
         * @param theMultipleAnswers is the multiple answer
         * @param isMultiple if question has multiple answer
         */
        private QuestionQuery(final String theQuestion, final String theAnswer,
                final String theMultipleAnswers, final boolean isMultiple) {
            myQueryQuestion = theQuestion;
            myQueryAnswer = theAnswer;
            myQueryMultipleAnswer = theMultipleAnswers;
            myQueryIsMultiple = isMultiple;
        } 
    }
    
    /**
     * Retrieve question by id
     * 
     * @return question by id
     */
    public String getQuestion(final int theId) {
        mySpecificQuestion = getMySpecificQuestion(theId);
        return mySpecificQuestion.myQueryQuestion;
    }
    
    /**
     * Retrieve answer by id
     * 
     * @return answer by id
     */
    public String getSolution(final int theId) {
        //System.out.println(myDatabase.getAnswer(myId));
        mySpecificQuestion = getMySpecificQuestion(theId);
        
        return mySpecificQuestion.myQueryAnswer;
    }
    
    /**
     * Retrieve multiple answers by id
     * 
     * @return multiple answers
     */
    public String getMultiAnswer(final int theId) {
        mySpecificQuestion = getMySpecificQuestion(theId);
        return mySpecificQuestion.myQueryMultipleAnswer;
    }
    
    /**
     * Retrieve if question has multiple answers by id
     * 
     * @return true if the question has multiple answer
     */
    public boolean isMultiple(final int theId) {
        mySpecificQuestion = getMySpecificQuestion(theId);
        return mySpecificQuestion.myQueryIsMultiple;
    }
    
    /**
     * Autoincrement id for questions
     * 
     * @return the question ID
     */
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
     * Determine if input is equal to the answer
     * 
     * @param theInput
     * @return mySolution.toLowerCase().equals(theInput.toLowerCase())
     */
    public boolean isSolution(final String theInput, final int theId) {
        mySpecificQuestion = getMySpecificQuestion(theId);
        return  mySpecificQuestion.myQueryAnswer.toLowerCase().equals(theInput.toLowerCase());
    }
    
    
    /**
     * Sets current database name.
     * 
     * @param theName
     */
    public void setDataBaseName(final String theName) {
        myDataBaseName = theName;
    }
    
    /**
     * This method determine current type of questions and return its specific question object 
     * 
     * @param theId the Id of the question
     * @return return question object for current type of question.
     */
    public QuestionQuery getMySpecificQuestion(final int theId) {
        if(myDataBaseName.equals("SportQuestions")) {
            mySpecificQuestion = mySportQuestions.get(theId);
        } else if(myDataBaseName.equals("GeographyQuestions")) {
            mySpecificQuestion = myGeographyQuestions.get(theId);
        } else {
            mySpecificQuestion = myMusicQuestions.get(theId);
        }
        
        return mySpecificQuestion;
    }
}