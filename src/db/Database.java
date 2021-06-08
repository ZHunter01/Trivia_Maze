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
    private static String myDataName= "MusicQuestions";

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

//        dataBase.insertToDB("What is the highest selling album of all time?", "Thriller - Michael Jackson");
//        dataBase.insertToDB("Who is the lead singer of the band Panic! At the Disco?", "Brendan Urie");
//        dataBase.insertToDB("The Beatles final studio album before breaking up was..?", "Abbey Road");
//        dataBase.insertToDB("David Bowie appeared in what fantasy film?", "Labyrinth");
//        dataBase.insertToDB("What musical act preformed at Super Bowl 50 in 2016?", "All of the Above");
//        dataBase.insertToDB("What is the title of Twenty One Pilots' second self-released album?", "Regional At Best");
//        dataBase.insertToDB("Eminem's greatest hits album was titled...?", "Curtain Call");
//        dataBase.insertToDB("All of these were members of the original N.W.A. group except...?", "Snoop Dogg");
//        dataBase.insertToDB("Which of these bands is famous for pioneering the Grunge Rock genre in the early 1990s?", "Nirvana");
//        dataBase.insertToDB("Queen and David Bowie collaborated on which song?", "Under Pressure");
//        dataBase.insertToDB("Which if these artists was not in 'The Bens'", "Ben Harper"); // Ben Folds, Ben Harper, Ben Lee, Ben Kweller
//        dataBase.insertToDB("What is on the cover of The Velvet Underground's debut album?", "A banana"); // A banana, A picture of the band, A photo of Andy Warhol, A cartoon drawing of subway stairs
//        dataBase.insertToDB("Who is the lead singer of Blue King Brown?", "Nattali Rize"); // Mama Kin, Nattali Rize, Angel Olsen, Natalie Imbruglia
//        dataBase.insertToDB("How many studio albums has Bob Dylan released?", "39"); // 1, 17, 39, 62
//        dataBase.insertToDB("What band is Jae Laffer lead singer of?", "The Panics"); // The Panics, The Cops, Faker, Dallas Crane
//        dataBase.insertToDB("Where is singer-songwriter Tracy McNeil originally from?", "Canada"); // Canada, Finland, Brazil, China
//        dataBase.insertToDB("Who was awarded the very first gold record?", "Perry Como"); // The Beatles, Elvis Presley, Perry Como, Nat King Cole
//        dataBase.insertToDB("What pop singer is known as 'The Material Girl'?", "Madonna"); // Christina Aguilera, Taylor Swift, Madonna, Britney Spears
//        dataBase.insertToDB("What is the oldest surviving musical instrument?", "Flute"); // Flute, Trumpet, Drum, Lyre
//        dataBase.insertToDB("What singer holds the world record for most words in a hit single?", "Eminem"); // 50 Cent, Eminem, Kanye West, Busta Rhymes
//        dataBase.insertToDB("Which jazz musician was known for playing a bent trumpet?", "Dizzy Gillespie"); // Chet Baker, Miles David, Dizzy Gillespie, Louis Armstrong
//        dataBase.insertToDB("Which rapper is famous for wearing parachute pants?", "MC Hammer"); // MC Hammer, Ice Cube, Snoop Dogg, Lauryn Hill
//        dataBase.insertToDB("What was the band known as Linkin Park originally called?", "Xero"); // Meteora, Hybrid Theory, Xero, Reanimators
//        dataBase.insertToDB("What are piano keys made out of?", "Plastic"); // Ivory, Plastic, Marble, Porcelain
//        dataBase.insertToDB("How many pieces of wood are there in a modern violin?", "70"); // 2, 30, 15, 70
//        dataBase.insertToDB("Which Beatle had dyslexia?", "John Lennon"); // George Harrison, Paul McCartney, Ringo Starr, John Lennon
//        dataBase.insertToDB("The largest game of musical chairs included how many participants?", "8238"); // 1511, 2657, 4876, 8238
//        dataBase.insertToDB("According Kelis’ song, what drink brings all the boys to the yard?", "Milkshake");
//        dataBase.insertToDB("Who was the youngest Beatle?", "George Harrison");
//        dataBase.insertToDB("Folklore, Red and 1989 are albums by which singer?", "Taylor Swift");
//        dataBase.insertToDB("Who famously wore a dress made of meat to the MTV Awards?", "Lady Gaga");
//        dataBase.insertToDB("In which year did Justin Bieber release Baby?", "2009");
//        dataBase.insertToDB("Who is considered the 'King of Pop'?", "Michael Jackson");
//        dataBase.insertToDB("What dance craze did Michael Jackson popularize in 1983?", "The Moonwalk");
//        dataBase.insertToDB("Which pop singer wrote the 'Like a good neighbor' State Farm jingle?", "Barry Manilow");
//        dataBase.insertToDB("Who is the youngest solo artist with a No. 1 hit on the Billboard Hot 100?", "Stevie Wonder");
//        dataBase.insertToDB("What was the title of Taylor Swift's first album?", "Taylor Swift");
//        dataBase.insertToDB("How many nominations did post Malone get at the 2020 billboard music awards?", "16");
//        dataBase.insertToDB("Who made the song, 'In Your Eyes?'", "The Weeknd");
//        dataBase.insertToDB("Adam Levine is the lead singer of which pop group?", "Maroon 5");
//        dataBase.insertToDB("Who had a number one hit single in both the US and the UK in 2017, with the single “Perfect”?", "Ed Sheeran");
//        dataBase.insertToDB("Which DJ wrote and produced the hit song “We Found Love” for Rihanna?", "Calvin Harris");
//        dataBase.insertToDB("Which artist produced the song 'Faded'", "Alan Walker");
//        dataBase.insertToDB("How many members are there in the band Rascal Flatts?", "3");
//        dataBase.insertToDB("What was Elvis Presley’s middle name?", "Aaron");









        dataBase.closeDB();
    }
}