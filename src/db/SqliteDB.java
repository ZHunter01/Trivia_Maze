/**
 * Trivia Maze TCSS 360 Spring 2021
 */

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * 
 * @author Oleksandr Maistruk 
 *
 */
public class SqliteDB {
    Connection c = null;
    Statement stmt = null;
    
    public SqliteDB() {
    try {
       Class.forName("org.sqlite.JDBC");
       c = DriverManager.getConnection("jdbc:sqlite:QuestionsDB.db");
       
    } catch ( Exception e ) {
       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
       System.exit(0);
    }
//    System.out.println("Opened database successfully");
    
    }
    
    public void listQuestions() {
        try {
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM QuestionTable");
            
            while(rs.next()) {
                final int id = rs.getInt("ID");
                final String question = rs.getString("Question");
                final String answer = rs.getString("Answer");
                System.out.println("ID: " + id + "Question: " + question + "Answer: " + answer);
                
            }
         } catch ( Exception e ) {
            System.out.println("Error: " + e.getMessage() );
         }
    }
    
    public String getQuestion(final int theId) {
        String question;
        try {
            this.stmt = c.createStatement();
            
            final ResultSet rs = stmt.executeQuery("select Question from QuestionTable where id = " + theId);  
            question = rs.getString("Question");
            return question; 
            
        } catch ( Exception e ) {
            System.out.println("Error: " + e.getMessage() );
        }
        
       return "There is no question";
    }
    
    public String getAnswer(int id) {
        String question;
        try {
            this.stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("select Answer from QuestionTable where id = " + id);  
            question = rs.getString("Answer");
            return question; 
            
        } catch ( Exception e ) {
            System.out.println("Error: " + e.getMessage() );
        }
        
       return "There is no answer";
    }
    
    public void updateIsUsed(int id) {
        try {
            this.stmt = c.createStatement();
            String query = "UPDATE QuestionTable SET IsUsed = 1 WHERE id=" + id;
            stmt.executeUpdate(query);
//            System.out.println("Updated.");
            
        } catch ( Exception e ) {
            System.out.println("Error: " + e.getMessage() );
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
        String isUsed;
        try {
            this.stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("select IsUsed from QuestionTable where id = " + id);  
            isUsed = rs.getString("IsUsed");
//            System.out.println("Isused: " + isUsed);
            if (isUsed.equals("1")) {
                return true;
            }
        } catch ( Exception e ) {
            System.out.println("Error: " + e.getMessage() );
        }
        return false;
    }
    
    public void setIsUsedToDefault() {
        try {
            this.stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("select * from QuestionTable");
            String query = "UPDATE QuestionTable SET IsUsed = 0";
            while(rs.next()) {
                stmt.executeUpdate(query);
//                System.out.println("Changed.");
            } 
            
        } catch ( Exception e ) {
            System.out.println("Error: " + e.getMessage() );
        }
    }
    
    public void InsertToDB(String Q, String A) {
        try {
            this.stmt = c.createStatement();
            String sql = "insert into QuestionTable (Question, Answer)"
                    + " VALUES (\"" + Q + "\", \"" + A + "\");";
            stmt.executeUpdate(sql);        
        } catch ( Exception e ) {
            System.out.println("Error: " + e.getMessage() );
        }
    }
    
    public int getLastId() {
        int id = 0;
        String lastRow = "SELECT * FROM QuestionTable WHERE ID = (SELECT MAX(ID) FROM QuestionTable)";
        
        try {
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(lastRow);  
            id = rs.getInt("ID");
            
//            System.out.println("get last id: " +id);        
        } catch ( Exception e ) {
            System.out.println("Error: " + e.getMessage() );
        }
        return id;
    }
    
    public void CloseDB() {
        try {
            c.close();
         } catch ( Exception e ) {
            System.out.println("Error: " + e.getMessage() );
         }
    }
    
}
