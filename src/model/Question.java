/**
 * Trivia Maze TCSS 360 Spring 2021
 */

package model;

import java.io.Serial;
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
     * Serial number
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

    @Serial
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

        @Serial
        private static final long serialVersionUID = 7959006783647339512L;

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

        @Serial
        protected Object readResolve()  {
            return this;
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
        } else if(myDataBaseName.equals("GeographyQuestions")) {
            mySpecificQuestion = myGeographyQuestions.get(theId);
        } else {
            mySpecificQuestion = myMusicQuestions.get(theId);
        }

        return mySpecificQuestion;
    }
}

///**
// * Trivia Maze TCSS 360 Spring 2021
// */
//
//package model;
//
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.Serial;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import db.SqliteDB;
//import view.MyMenuBar;
//
///**
// *
// * @author Zach Hunter
// * @author Oleksandr Maistruk
// *
// */
//public class Question implements Serializable {
//
//    @Serial
//    private static final long serialVersionUID = -1065392673122444615L;
//
//    /** static variable single_instance of type Singleton */
//    private static Question questionInstance = null;
//
//    /** The name of current database */
//    private String myDataBaseName;
//
//    /** The database is the source of questions */
//    private transient SqliteDB myDatabase;
//
//    /** The question ID */
//    private int myId = 0;
//
//    /** The array list with sport questions */
//    private List<QuestionQuery> mySportQuestions = new ArrayList<QuestionQuery>();
//
//    /** The array list with geography questions */
//    private List<QuestionQuery> myGeographyQuestions = new ArrayList<QuestionQuery>();
//
//    /** Service field to assign specific question */
//    private QuestionQuery mySpecificQuestion;
//
//
//    /**
//     * Private constructor to create Question class as singleton.
//     */
//    private Question() {
//        myDataBaseName = MyMenuBar.getDataBaseName();
//        idHelper("SportQuestions");
//        idHelper("GeographyQuestions");
//    }
//
//
//    /**
//     * Static method to create instance of Question class
//     *
//     * @return instance of the question class
//     */
//    public static Question getQuestionInstance() {
//        if (questionInstance == null)
//            questionInstance = new Question();
//        return questionInstance;
//    }
//
//    @Serial
//    protected Object readResolve()  {
//        return this;
//    }
//
//
//    /**
//     * This method is used to create array list with questions.
//     * Then shuffle the array.
//     *
//     * @return question id
//     */
//    private void idHelper(final String theDBName) {
//        myDatabase = new SqliteDB(theDBName);
//        final int lastID = myDatabase.getLastId();
//
//        if(theDBName.equals("SportQuestions")) {
//            for(int i = 1; i <= lastID; i++ ) {
//                mySportQuestions.add(new QuestionQuery(myDatabase.getQuestion(i),
//                        myDatabase.getAnswer(i), myDatabase.getMultiAnswer(i),
//                        myDatabase.getIsMultipleChoice(i)));
//            }
//            Collections.shuffle(mySportQuestions);
//        } else {
//            for(int i = 1; i <= lastID; i++ ) {
//                myGeographyQuestions.add(new QuestionQuery(myDatabase.getQuestion(i),
//                        myDatabase.getAnswer(i), myDatabase.getMultiAnswer(i),
//                        myDatabase.getIsMultipleChoice(i)));
//            }
//            Collections.shuffle(myGeographyQuestions);
//        }
//        myDatabase.closeDB();
//    }
//
//    /**
//     * This class create an question object.
//     *
//     */
//    public class QuestionQuery implements Serializable{
//
//        @Serial
//        private static final long serialVersionUID = 7959006783647339512L;
//
//        private String myQueryQuestion;
//        private String myQueryAnswer;
//        private String myQueryMultipleAnswer;
//        private boolean myQueryIsMultiple;
//
//        private QuestionQuery(final String theQuestion, final String theAnswer,
//                              final String theMultipleAnswers, final boolean isMultiple) {
//            myQueryQuestion = theQuestion;
//            myQueryAnswer = theAnswer;
//            myQueryMultipleAnswer = theMultipleAnswers;
//            myQueryIsMultiple = isMultiple;
//        }
//
//        @Serial
//        protected Object readResolve()  {
//            return this;
//        }
//
//    }
//
//    /**
//     *
//     * @return question by id
//     */
//    public String getQuestion(final int theId) {
//        mySpecificQuestion = getMySpecificQuestion(theId);
//        return mySpecificQuestion.myQueryQuestion;
//    }
//
//    /**
//     *
//     * @return answer by id
//     */
//    public String getSolution(final int theId) {
//        //System.out.println(myDatabase.getAnswer(myId));
//        mySpecificQuestion = getMySpecificQuestion(theId);
//
//        return mySpecificQuestion.myQueryAnswer;
//    }
//
//    /**
//     *
//     * @return multiple answers
//     */
//    public String getMultiAnswer(final int theId) {
//        mySpecificQuestion = getMySpecificQuestion(theId);
//        return mySpecificQuestion.myQueryMultipleAnswer;
//    }
//
//    /**
//     *
//     * @return true if the question has multiple answer
//     */
//    public boolean isMultiple(final int theId) {
//        mySpecificQuestion = getMySpecificQuestion(theId);
//        return mySpecificQuestion.myQueryIsMultiple;
//    }
//
////    /** Manually set question and solution for question object
////     *
////     * @param theQ
////     * @param theSol
////     */
////    public void setQuestionAndSolution(final String theQ, final String theSol) {
////        myQuestion = theQ;
////        mySolution = theSol;
////    }
//
//
//    public int getId() {
//        int x = myId;
//        if(myId < mySportQuestions.size() - 1) {
//            myId++;
//        } else {
//            myId = 0;
//        }
//        return x;
//    }
//
//    /**
//     * Determine if input is solution
//     *
//     * @param theInput
//     * @return mySolution.toLowerCase().equals(theInput.toLowerCase())
//     */
//    public boolean isSolution(final String theInput, final int theId) {
//        mySpecificQuestion = getMySpecificQuestion(theId);
//        return  mySpecificQuestion.myQueryAnswer.toLowerCase().equals(theInput.toLowerCase());
//    }
//
////    @Override
////    public boolean equals(final Object theObj) {
////        if (this == theObj) return true;
////        if (theObj == null || getClass() != theObj.getClass()) return false;
////
////        Question question = (Question) theObj;
////        return Objects.equals(myQuestion, question.myQuestion) && Objects.equals(mySolution, question.mySolution);
////    }
//
//    public void setDataBaseName(final String theName) {
//        myDataBaseName = theName;
//    }
//
//    public QuestionQuery getMySpecificQuestion(final int theId) {
//        if(myDataBaseName.equals("SportQuestions")) {
//            mySpecificQuestion = mySportQuestions.get(theId);
//        } else {
//            mySpecificQuestion = myGeographyQuestions.get(theId);
//        }
//
//        return mySpecificQuestion;
//    }
//}
//
////
////package model;
////
////import java.io.Serial;
////import java.io.Serializable;
////import java.util.Objects;
////import java.util.Random;
////
////import db.SqliteDB;
////import view.MyMenuBar;
////
/////**
//// *
//// * @author Zach Hunter
//// * @author Oleksandr Maistruk
//// *
//// */
////public class Question implements Serializable {
////
////    @Serial
////    private static final long serialVersionUID = -3465229471718238308L;
////
////    private String myQuestion;
////    private String mySolution;
////    private String myMultiAnswer;
////    private transient SqliteDB myDatabase;
////    private final int myId;
////
////    public Question() {
////        myDatabase = new SqliteDB(MyMenuBar.getDataBaseName());
////        myId = idHelper();
////        myQuestion = getQuestion();
////        mySolution = getSolution();
////    }
////
////    /**
////     * This method is used to assign question id randomly.
////     *
////     * @return question id
////     */
////    private int idHelper() {
////        final Random rand = new Random();
////        int random = rand.nextInt(myDatabase.getLastId())+1;
////       // System.out.println(random);
////      //  while (myDatabase.getIsUsed(random)) {
////         //  random = rand.nextInt(myDatabase.getLastId())+1;
////       // }
////
////        //myDatabase.updateIsUsed(random);
////
////        return random;
////    }
////
////
////    /**
////     *
////     * @return question by id
////     */
////    public String getQuestion() {
////        //System.out.println(myDatabase.getQuestion(myId));
////        return myDatabase.getQuestion(myId);
////    }
////
////    /**
////     *
////     * @return answer by id
////     */
////    public String getSolution() {
////        //System.out.println(myDatabase.getAnswer(myId));
////        return myDatabase.getAnswer(myId);
////    }
////
////    /**
////     *
////     * @return multiple answers
////     */
////    public String getMultiAnswer() {
////        myMultiAnswer = myDatabase.getMultiAnswer(myId);
////        return myMultiAnswer;
////    }
////
////    /**
////     *
////     * @return true if the question has multiple answer
////     */
////    public boolean isMultiple() {
////        return myDatabase.getIsMultipleChoice(myId);
////    }
////
////    /** Manually set question and solution for question object
////     *
////     * @param theQ
////     * @param theSol
////     */
////    public void setQuestionAndSolution(final String theQ, final String theSol) {
////        myQuestion = theQ;
////        mySolution = theSol;
////    }
////
////
////    public int getId() {
////        return myId;
////    }
////
////    /**
////     * Determine if input is solution
////     *
////     * @param theInput
////     * @return mySolution.toLowerCase().equals(theInput.toLowerCase())
////     */
////    public boolean isSolution(final String theInput) {
////        return  mySolution.toLowerCase().equals(theInput.toLowerCase());
////    }
////
////    @Override
////    public boolean equals(final Object theObj) {
////        if (this == theObj) return true;
////        if (theObj == null || getClass() != theObj.getClass()) return false;
////
////        Question question = (Question) theObj;
////        return Objects.equals(myQuestion, question.myQuestion) && Objects.equals(mySolution, question.mySolution);
////    }
////}