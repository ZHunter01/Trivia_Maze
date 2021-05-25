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
//    private static String myDataName= "SportQuestions";
    private static String myDataName= "GeographyQuestions";

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
        System.out.println(dataBase.getQuestion(1));
        System.out.println(dataBase.getAnswer(1));
//        dataBase.setIsUsedToDefault();
//        System.out.println("Is Used: " + dataBase.getIsUsed(2));
//        System.out.println("Last ID: " + dataBase.getLastId());
//        dataBase.updateIsUsed(1);
//        dataBase.insertToDB("What’s the diameter of?", "18 inches");
//        dataBase.insertToDB("How many continents are there?", "7");
//        dataBase.insertToDB("What is the largest country in the world?", "Russia");
//        dataBase.insertToDB("What country has the largest population in the world?", "China");
//        dataBase.insertToDB("Which desert covers much of northern Africa?", "The Sahara");
//        dataBase.insertToDB("Mumbai, Chennai and Kolkata are major cities in which country?", "India");
//        dataBase.insertToDB("How many states are there in the United States?", "50");
//        dataBase.insertToDB("What is the tallest mountain in the world?", "Everest");
//        dataBase.insertToDB("Which Italian city is famous for its canals?", "Venice");
//        dataBase.insertToDB("In which U.S. city would you find Manhattan, Brooklyn and the Bronx?", "New York City");
//        dataBase.insertToDB("What are the only two countries to have a land border with the US?", "Canada, Mexico");
//        dataBase.insertToDB("What is the longest river in the world?", "Nile");
//        dataBase.insertToDB("What is the capital city of Spain?", "Madrid");
//        dataBase.insertToDB("What is the largest (in area) state in the U.S.?", "Alaska");
//        dataBase.insertToDB("In what country would you find the Eiffel Tower?", "France");
//        dataBase.insertToDB("Helsinki is the capital city of which country?", "Finland");
//        dataBase.insertToDB("In what country would you find the Great Pyramids of Giza?", "Egypt");
//        dataBase.insertToDB("What is the capital of Thailand?", "Bangkok");
//        dataBase.insertToDB("What is the largest sea in the world?", "Caspian Sea");
//        dataBase.insertToDB("Which ocean lies between Africa, Australia and south of Asia?", "Indian Ocean");
//        dataBase.insertToDB("Which large river flows through London?", "Thames");
//        dataBase.insertToDB("What’s the world’s biggest port?", "Port of Shanghai");
//        dataBase.insertToDB("Who was the first geographer?", "Eratosthenes");
//        dataBase.insertToDB("What is the largest continent?", "Asia");
//        dataBase.insertToDB("Which two countries share the longest border in the world?", "The United States of America and Canada");
//        dataBase.insertToDB("Which is the longest continental mountain range in the world?", "The Andes in South America");
//        dataBase.insertToDB("Which is the largest volcano in the world?", "Mouna Loa in Hawaii");
//        dataBase.insertToDB("Which American city is the Golden Gate Bridge in?", "San Francisco");
//        dataBase.insertToDB("What is the capital of Thailand?", "Bangkok");
//        dataBase.insertToDB("Cairo is the capital of which country?", "Egypt");
//        dataBase.insertToDB("What is the capital of the American state of Arizona?", "Phoenix");
//        dataBase.insertToDB("The body of the Egyptian Sphinx was based on which animal?", "Lion");
//        dataBase.insertToDB("How many federal states does Germany have?", "16");
//        dataBase.insertToDB("What is the capital of Denmark?", "Copenhagen");
//        dataBase.insertToDB("What is the Polish city known to Germans as Danzig?", "Gdansk");
//        dataBase.insertToDB("What is the smallest country in the world?", "The Vatican City");
//        dataBase.insertToDB("How many countries does the United Kingdom have?", "4");
//        dataBase.insertToDB("What is the largest non-continental island in the world?", "Greenland");
//        dataBase.insertToDB("What is the capital of Chile?", "Santiago");
//        dataBase.insertToDB("Kuala Lumpur is the capital of which country?", "Malaysia");
//        dataBase.insertToDB("Which African country has Portuguese as its official language?", "Mozambique");
//        dataBase.insertToDB("What is the capital of the State of Washington?", "Olympia");
//        dataBase.insertToDB("The historical city of Timbuktu is in which West African country?", "Mali");
//        dataBase.insertToDB("What is the capital of Senegal?", "Dakar");
//        dataBase.insertToDB("Which country has the abbreviation “CH”?", "Switzerland");
//        dataBase.insertToDB("How many time zones does Russia have?", "11");



        dataBase.closeDB();
    }
}