/**
 * Trivia Maze TCSS 360 Spring 2021
 */

package db;

/**
 * This class is only for demonstrate all functions of SqliteDB.java class
 * 
 * @author Oleksandr Maistruk 
 *
 */
public class Database {
    
    
    public static void main(String[] args) {
        SqliteDB db = new SqliteDB();
        db.listQuestions();
//        db.InsertToDB("Sky is", "blue");
        System.out.println(db.getQuestion(1));
        System.out.println(db.getAnswer(1));
        db.setIsUsedToDefault();
        System.out.println("Is Used: " + db.getIsUsed(2));
        System.out.println("Last ID: " + db.getLastId());
//        db.updateIsUsed(1);
        db.CloseDB();
     }
}
