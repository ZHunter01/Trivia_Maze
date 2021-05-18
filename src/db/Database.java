
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
    
    private Database() {
        
    }
    
    /**
     * The main method to work with database class
     * 
     * @param args
     */
    public static void main(final String[] args) {
        final SqliteDB db = new SqliteDB();
//        db.listQuestions();
//        db.insertToDB("Sky is", "blue");
        System.out.println(db.getQuestion(1));
        System.out.println(db.getAnswer(1));
        db.setIsUsedToDefault();
//        System.out.println("Is Used: " + db.getIsUsed(2));
//        System.out.println("Last ID: " + db.getLastId());
//        db.updateIsUsed(1);
//        db.insertToDB("What’s the diameter of a basketball hoop in inches?", "18 inches");
//        db.insertToDB("The Olympics are held every how many years?", "4 years");
//        db.insertToDB("What sport is best known as the ‘king of sports’?", "Soccer");
//        db.insertToDB("What do you call it when a bowler makes three strikes in a row?", "Turkey");
//        db.insertToDB("What’s the national sport of Canada?", "Lacrosse");
//        db.insertToDB("How many dimples does an average golf ball have?", "336");
//        db.insertToDB("What country has competed the most times in the Summer Olympics yet hasn’t won a gold medal?", "The Philippines");
//        db.insertToDB("Who has won more tennis grand slam titles, Venus Williams or Serena Williams?", "Serena Williams");
//        db.insertToDB("How many medals did China win at the Beijing Olympics?", "100");
//        db.insertToDB("What does NBA stand for?", "National Basketball Association");
//        db.insertToDB("In motor racing, what color is the flag they wave to indicate the winner?", "Checkered flag");
//        db.insertToDB("How many holes are played in an average round of golf?", "18");
//        db.insertToDB("What color are the goalposts in football?", "Yellow");
//        db.insertToDB("How long is a marathon?", "26.2 miles");
//        db.insertToDB("In what game is “love” a score?", "Tennis");
//        db.insertToDB("What sport is a lot like softball?", "Baseball");
//        db.insertToDB("In football, how many points does a touchdown hold?", "6 points");
//        db.insertToDB("How many players are on a baseball team?", "9 players");
//        db.insertToDB("In soccer, what body part can’t touch the ball?", "Hands");
//        db.insertToDB("What sporting equipment is used for striking a tennis ball?", "Tennis racquet");
//        db.insertToDB("Which sport uses a net, a racket, and a shuttlecock?", "Badminton");
//        db.insertToDB("Which of the following sports does not use a ball? Golf, tennis, hockey, or polo?", "Hockey");
//        db.insertToDB("What type of race is the Tour de France?", "Bicycle race");
//        db.insertToDB("How much does an NFL football weigh?", "1 pound");
//        db.insertToDB("What material was first used to cover baseballs?", "Cowhide");
//        db.insertToDB("What is the most stolen base?", "Second base");
//        db.insertToDB("What is a soccer field called?", "A pitch");
//        db.insertToDB("What do the rings in the Olympics represent?", "The continents of the world");
//        db.insertToDB("What sport is called the “sport of kings”?", "Polo");
//        db.insertToDB("In baseball, how many strikes does it take before the umpire calls out?", "3");
//        db.insertToDB("When an Olympic athlete wins first place, what color medal do they get?", "Gold");
        
        db.closeDB();
     }
}
