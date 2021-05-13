package model;

public class Maze {
    /**Player object */
    private Player myPlayer;
    /**2-d array of room representing the maze */
    private Room [][] myMaze;
    /**Default width and length of maze */
    private final static int DEFAULT_SIZE = 4;
    /**Boolean for if user has reached the final room */
    private boolean myWin;
    /**Boolean for if all door in a room are permanently locked and the user loses */
    private boolean myLose;
    /**Int counter for how many questions have been asked */
    private int myQuestionCounter;
    /**Int counter for how many question have been answered correctly*/
    private int myCorrectCounter; 
    /**Int value for current x position in maze */
    private int myXCount;
    /**Int value for current y position in maze */
    private int myYCount;
    /**Door object for current selected door*/
    private Door myCurrentDoor;
    /**Int value to indicate up door is selected */
    //private final static int UP = 0;
    /**Int value to indicate left door is selected */
    //private final static int LEFT = 1;
    /**Int value to indicate down door is selected */
    //private final static int DOWN = 2;
    /**Int value to indicate right door is selected */
    //private final static int RIGHT = 3;
    /**Int value to keep track of what direction door is being accessed */
    private int userDir;
    
//    public static enum Direction {
//        UPP(0),
//        
//        LEFTT(1),
//        
//        DOWNN(2),
//        
//        RIGHTT(3);
//        
//    }
    
    
    
    /* Creates default 2-d array maze with 4x4 dimensions
     * 
     */
    public Maze() {
        //2-d array of default size
        myMaze = new Room [DEFAULT_SIZE][DEFAULT_SIZE];
        myWin = false;
        
        myQuestionCounter = 0;
        myCorrectCounter = 0;
        
        myXCount = 0;
        myYCount = 0;
        //current door object initialized
        myCurrentDoor = new Door();
        //default directions is down
        userDir = 2;
                
        //generatePowerUps
    }
    
    /** Creates a 2-d array maze with specified dimensions
     * 
     * @param theX
     * @param theY
     */
    public Maze(final int theX, final int theY) {
        //2-d array of specified size
        myMaze = new Room [theX][theY];
        
        myWin = false;
        
        myQuestionCounter = 0;
        myCorrectCounter = 0;
        
        myXCount = 0;
        myYCount = 0;
        
        myCurrentDoor = new Door();
        
        userDir = 2;
                
        //generatePowerUps
    }
    
    /** Returns current count of how many questions have been asked
     * 
     * @return myQuestionCounter
     */
    public int getQuestionCount() {
        return myQuestionCounter;
    }
    
    /** Returns current count of correctly answered questions
     * 
     * @return myQuestionCounter
     */
    public int getCorrectCount() {
        return myCorrectCounter;
    }
    
    /** Gets question object from specified door
     * 
     * @param theDir
     * @return myCurrentDoor.getQuestion()
     */
    public Question doorQuestion(final int theDir) {
        
        myCurrentDoor = myMaze [myXCount][myYCount].getUserDoor(theDir);         
        userDir = theDir;
        
        return myCurrentDoor.getQuestion();
    }
    
    /** Processes a user answer to question from a door.
     *  If answer is correct, check if user has won and increment maze
     *  Otherwise permanently lock the door and check if user has lost.
     * 
     * @param theSolution
     */
    public void doorSolution(final String theSolution) {
        myQuestionCounter ++;
        if (myCurrentDoor.getQuestion().isSolution(theSolution.trim().toLowerCase()) == true) {
            myCorrectCounter ++;
            myCurrentDoor.setLock(false);
            
            if (checkWin() == true) {
                return;
            } else {
                incrementMaze();
                myPlayer.setLocation(myYCount, myXCount);
            }
        }
        else {
            myCurrentDoor.setPermaLock(true);
            
            if (checkLose() == true) {
                return;
            }
        }
    }
    
    /** Returns boolean of if the door being accessed leads to outside the array bounds
     * 
     * @param theDir
     * @return isIn
     */
    public boolean isInBounds(final int theDir) {
        boolean isIn;
        
        if (theDir == Room.UP && myYCount++ > myMaze[0].length) {
            isIn = false;
        } else if (theDir == Room.LEFT && myXCount-- < 0) {
            isIn = false;
        } else if (theDir == Room.DOWN && myYCount-- < 0) {
            isIn = false;
        } else if (theDir == Room.RIGHT && myXCount++ > myMaze.length) {
            isIn = false;
        } else {
            isIn = true;
        }
        
        return isIn;
    }
    
    /** Increments maze array depending on int input
     * 
     */
    private void incrementMaze() {
        if (userDir == Room.UP) {
            myYCount --;
        } else if (userDir == Room.LEFT) {
            myXCount --;
        } else if (userDir == Room.DOWN) {
            myYCount ++;
        } else if (userDir == Room.RIGHT) {
            myXCount ++;
        } else {
            throw new IllegalArgumentException("Error: Improper door directional value.");
        }
    
    }
        
    /** If x count and y count match the max size of the 2-d array return myWin as true
     * 
     * @return myWin
     */
    private boolean checkWin() {
        if (myXCount == myMaze[0].length && myYCount == myMaze.length) {
            myWin = true;
        }
        return myWin;
    }
    
    /** Checks if three of four doors in the current room are locked
     * 
     * @return myLose
     */
    private boolean checkLose() {
        final Room currentRoom = myMaze [myXCount][myYCount].getRoom();
        
        boolean up = currentRoom.getDoorPermaLock(Room.UP);
        boolean left = currentRoom.getDoorPermaLock(Room.LEFT);
        boolean down = currentRoom.getDoorPermaLock(Room.DOWN);
        boolean right = currentRoom.getDoorPermaLock(Room.RIGHT);

        //If three of the four doors are permanently locked, game is over
        if ((up ? 1:0) + (left ? 1:0) + (down ? 1:0) + (right ? 1:0) == 3) {
            myLose = true;
        }
        
        return myLose;
    }

    private void generatePowerUps() {
        //ToDo
    }
}
