
/**
 * Trivia Maze TCSS 360 Spring 2021
 */

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * This class provide a tool to work with Data Base.
 * 
 * @author Oleksandr Maistruk 
 *
 */
public class SqliteDB {
    
    /** The field for connection to database  */
    private transient Connection connection;
    
    /** The field for working with database  */
    private transient Statement stmt;
    
    /** The name of database which connect to */
    private transient final String myDBName;
    
    
    /**
     * The constructor to connect to database.
     */
    public SqliteDB(final String theName) {
        myDBName = theName;
        //System.out.println("The db name: " + myDBName);
        try {
           Class.forName("org.sqlite.JDBC");
           connection = DriverManager.getConnection("jdbc:sqlite:QuestionsDB.db");
           
        } catch ( Exception theError) {
           System.err.println( theError.getClass().getName() + ": " + theError.getMessage() );
           System.exit(0);
        }
        //System.out.println("The db name: " + myDBName);
    }
    
    /**
     * Method for printing out all questions and answeresultingSet from database.
     */
    public void listQuestions() {
        
        try {
            this.stmt = connection.createStatement();
            final ResultSet resultingSet = stmt.executeQuery("SELECT * FROM " + myDBName);
            
            while(resultingSet.next()) {
                int dataBaseID = resultingSet.getInt("ID");
                final String question = resultingSet.getString("Question");
                final String answer = resultingSet.getString("Answer");
                System.out.println("ID: " + dataBaseID + "Question: " + question + "Answer: " + answer);
                
            }
         } catch (final Exception theError) {
            System.out.println("Error 1: " + theError.getMessage() );
         }
    }
    
    /**
     * The method is to receive a question by specific ID
     * 
     * @param theId of the question
     * @return the question
     */
    public String getQuestion(final int theId) {
        String question = "There is no question";
        try {
            this.stmt = connection.createStatement();
            
            final ResultSet resultingSet = stmt.executeQuery("select Question from " + myDBName + " where id = " + theId);  
            question = resultingSet.getString("Question");
            
        } catch (final Exception theError) {
            System.out.println("Error 2: " + theError.getMessage() );
        }
        
       return question;
    }
    
    /**
     * The method is to receive an answer by specific ID
     * 
     * @param theId of the question
     * @return the answer
     */
    public String getAnswer(final int theId) {
        String question = "There is no answer";
        try {
            this.stmt = connection.createStatement();
            
            final ResultSet resultingSet = stmt.executeQuery("select Answer from " + myDBName + " where id = " + theId);  
            question = resultingSet.getString("Answer");
            
        } catch (final Exception theError) {
            System.out.println("Error 3: " + theError.getMessage() );
        }
        
       return question;
    }
    
    /**
     * The method is to receive multiple answeresultingSet by specific ID
     * 
     * @param theId of the question
     * @return multiple answeresultingSet
     */
    public String getMultiAnswer(final int theId) {
        String question = "There is no Multiple answer";
        try {
            this.stmt = connection.createStatement();
            
            final ResultSet resultingSet = stmt.executeQuery("select Multianswer from " + myDBName + " where id = " + theId);  
            question = resultingSet.getString("Multianswer"); 
            
        } catch (final Exception theError) {
            System.out.println("Error 3: " + theError.getMessage() );
        }
        
       return question;
    }
    
    /**
     * The method is to update question if this question was used.
     * The method updates IsUsed field in the database to 1 (true).
     * 
     * @param theId of the question
     */
    public void updateIsUsed(final int theId) {
        try {
            this.stmt = connection.createStatement();
            final String query = "UPDATE " + myDBName + " SET IsUsed = 1 WHERE id=" + theId;
            stmt.executeUpdate(query);
//            System.out.println("Updated.");
            
        } catch (final Exception theError ) {
            System.out.println("Error 4: " + theError.getMessage() );
        } finally {
            closeDB();
        }
    }
    
    /**
     * The method to check if a question used or no.
     * 
     * @param id is the question id.
     * @return true if question already used
     * @return false if question doesn't use 
     */
    public boolean getIsUsed(int id) {
        String checkForUse;
        boolean isUsed = false;
        try {
            this.stmt = connection.createStatement();
            
            final ResultSet resultingSet = stmt.executeQuery("select IsUsed from " + myDBName + " where id = " + id);  
            checkForUse = resultingSet.getString("IsUsed");
//            System.out.println("Isused: " + isUsed);
            if (checkForUse.equals("1")) {
                isUsed = true;
            }
        } catch (final Exception theError) {
            System.out.println("Error 5: " + theError.getMessage() );
        } 
        return isUsed;
    }
    
    /**
     * The method to check if a question has multiple choice answer or no.
     * 
     * @param id is the question id
     * @return true if question has multiple choice answer
     * @return false if question has single answer
     */
    public boolean getIsMultipleChoice(int id) {
        final String checkForUse;
        boolean hasMultiA = false;
        try {
            this.stmt = connection.createStatement();
            
            final ResultSet resultingSet = stmt.executeQuery("select Multichoice from " + myDBName + " where id = " + id);  
            checkForUse = resultingSet.getString("Multichoice");
//            System.out.println("Isused: " + isUsed);
            if (checkForUse.equals("1")) {
                hasMultiA = true;
            }
        } catch (final Exception theError) {
            System.out.println("Error 5: " + theError.getMessage() );
        } 
        return hasMultiA;
    }
    
    /**
     * The method updates all questions to not used value.
     * The method updates IsUsed field for all questions in the database to 0 (false).
     */
    public void setIsUsedToDefault() {
        try {
            this.stmt = connection.createStatement();
            
            final ResultSet resultingSet = stmt.executeQuery("select * from " + myDBName);
            final String query = "UPDATE SportQuestions SET IsUsed = 0";
            while(resultingSet.next()) {
                stmt.executeUpdate(query);
//                System.out.println("Changed.");
            } 
            
        } catch (final Exception theError) {
            System.out.println("Error 6: " + theError.getMessage() );
        }
    }
    
    /**
     * The method is to insert new question and answer to the database.
     * 
     * @param theQuestion is the question to insert to the db.
     * @param theAnswer is the answer to insert to the db.
     */
    public void insertToDB(final String theQuestion, final String theAnswer) {
        try {
            this.stmt = connection.createStatement();
            final String sql = "insert into " + myDBName + " (Question, Answer)"
                    + " VALUES (\"" + theQuestion + "\", \"" + theAnswer + "\");";
            stmt.executeUpdate(sql);        
        } catch (final Exception theError) {
            System.out.println("Error 7: " + theError.getMessage() );
        }
    }
    
    /**
     * The method is to provide last id in the Database.
     * 
     * @return the last table ID.
     */
    public int getLastId() {
        int questionID = 0;
        final String lastRow = "SELECT * FROM " + myDBName + " WHERE ID = (SELECT MAX(ID) FROM " + myDBName + ")";
        
        try {
            this.stmt = connection.createStatement();
            final ResultSet resultingSet = stmt.executeQuery(lastRow);  
            questionID = resultingSet.getInt("ID");
            resultingSet.close();
//            System.out.println("get last id: " +id);        
        } catch (final Exception theError) {
            System.out.println("Error 8: " + theError.getMessage() );
        }
        return questionID;
    }
    
    /**
     * The method to close the database after all manipulations.
     */
    public void closeDB() {
        try {
            connection.close();
         } catch (final Exception theError) {
            System.out.println("Error 9: " + theError.getMessage() );
         }
    }
    
}
