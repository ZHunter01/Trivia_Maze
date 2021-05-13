package db;

public class Database {
    
    
    public static void main(String[] args) {
        SqliteDB db = new SqliteDB();
        db.listQuestions();
//        db.InsertToDB("Sky is", "blue");
        db.CloseDB();
     }
}
