
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
public final class Database {
    
    /** The name of the DataBase  */
    private static String myDataName= "SportQuestions";
//    private static String myDataName= "GeographyQuestions";
    
    private Database() {
    }
    
    /**
     * The main method to work with database class
     * 
     * @param args
     */
    public static void main(final String[] args) {
        final SqliteDB dataBase = new SqliteDB(myDataName);
//        dataBase.listQuestions();
//        dataBase.insertToDB("Sky is", "blue");
//        System.out.println(dataBase.getQuestion(1));
//        System.out.println(dataBase.getAnswer(1));
        dataBase.setIsUsedToDefault();
//        System.out.println("Is Used: " + dataBase.getIsUsed(2));
//        System.out.println("Last ID: " + dataBase.getLastId());
//        dataBase.updateIsUsed(1);
//        dataBase.insertToDB("What’s the diameter of?", "18 inches");

        
        dataBase.closeDB();
     }
}
