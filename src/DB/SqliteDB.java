package db;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqliteDB {
    Connection c = null;
    Statement stmt = null;
    
    SqliteDB() {
    try {
       Class.forName("org.sqlite.JDBC");
       c = DriverManager.getConnection("jdbc:sqlite:QuestionsDB.db");
       
    } catch ( Exception e ) {
       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
       System.exit(0);
    }
    System.out.println("Opened database successfully");
    
    }
    
    public void listQuestions() {
        try {
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM QuestionTable");
            
            while(rs.next()) {
                int id = rs.getInt("ID");
                String question = rs.getString("Question");
                String answer = rs.getString("Answer");
                System.out.println("ID: " + id + "Question: " + question + "Answer: " + answer);
                
            }
         } catch ( Exception e ) {
            System.out.println("Error: " + e.getMessage() );
         }
    }
    
    public String getQuestion(int id) {
       
      return "23";  
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
    
    public void CloseDB() {
        try {
            c.close();
         } catch ( Exception e ) {
            System.out.println("Error: " + e.getMessage() );
         }
    }
    
}
