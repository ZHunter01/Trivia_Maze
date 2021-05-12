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
    /**Int counter for how many question have been answered correctly*/
    private int myQuestionCounter; 
    /**Int value for current x position in maze */
    private int myXCount;
    /**Int value for current y position in maze */
    private int myYCount;
    /**Door object for current selected door*/
    private Door myCurrentDoor;
    /**Int value to indicate up door is selected */
    private final static int UP = 0;
    /**Int value to indicate left door is selected */
    private final static int LEFT = 1;
    /**Int value to indicate down door is selected */
    private final static int DOWN = 2;
    /**Int value to indicate right door is selected */
    private final static int RIGHT = 3;
    /**Int value to keep track of what direction door is being accessed */
    private int userDir;
    
    
    
    /*Default maze constructor with a 4x4 2d array
     * 
     */
    public Maze() {
        myMaze = new Room [DEFAULT_SIZE][DEFAULT_SIZE];
        myWin = false;
        myQuestionCounter = 0;
        myXCount = 0;
        myYCount = 0;
        myCurrentDoor = new Door();
        userDir = 0;
    }
    
    
    public Maze(final int theX, final int theY) {
        myMaze = new Room [theX][theY];
        myWin = false;
        myQuestionCounter = 0;
        myXCount = 0;
        myYCount = 0;
        myCurrentDoor = new Door();
        userDir = 0;
    }
    
    public int getQuestionCount() {
        return myQuestionCounter;
    }
    
    
    public Question doorQuestion(final int theDir) {
        
        myCurrentDoor = myMaze [myXCount][myYCount].getUserDoor(theDir);         
        userDir = theDir;
        
        return myCurrentDoor.getQuestion();
    }
    
    public void doorSolution(final String theSolution) {
        if (myCurrentDoor.getQuestion().isSolution(theSolution.trim()) == true) {
            myQuestionCounter ++;
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
    
//    private Door getUserDoor(final int theDir) {
//        Door userDoor = new Door();
//        
//        if (theDir == UP) {
//            userDoor = myMaze [myXCount][myYCount].accessUp(); 
//        } else if (theDir == LEFT) {
//            userDoor = myMaze [myXCount][myYCount].accessLeft(); 
//        } else if (theDir == DOWN) {
//            userDoor = myMaze [myXCount][myYCount].accessDown(); 
//        } else if (theDir == RIGHT) {
//            userDoor = myMaze [myXCount][myYCount].accessRight(); 
//        } else {
//            throw new IllegalArgumentException("Error: Parameter must be an int value from 0 to 3");
//        }
//        
//        return userDoor;
//    }
    
    private void incrementMaze() {
        if (userDir == UP) {
            myYCount ++;
        } else if (userDir == LEFT) {
            myXCount --;
        } else if (userDir == DOWN) {
            myYCount --;
        } else if (userDir == RIGHT) {
            myXCount ++;
        } else {
            throw new IllegalArgumentException("Error: Improper door directional value.");
        }
    
    }
        
    private boolean checkWin() {
        if (myXCount == myMaze[0].length && myYCount == myMaze.length) {
            myWin = true;
        }
        return myWin;
    }
    
    /** Checks if three of four doors in the current room are locked
     * 
     * @return permaLock
     */
    private boolean checkLose() {
        final Room currentRoom = myMaze [myXCount][myYCount].getRoom();
        boolean permaLock = false;
        
        boolean up = currentRoom.getDoorPermaLock(UP);
        boolean left = currentRoom.getDoorPermaLock(LEFT);
        boolean down = currentRoom.getDoorPermaLock(DOWN);
        boolean right = currentRoom.getDoorPermaLock(RIGHT);

        //If three of the four doors are permanently locked, game is over
        if ((up ? 1:0) + (left ? 1:0) + (down ? 1:0) + (right ? 1:0) == 3) {
            permaLock = true;
        }
        
        return permaLock;
    }
    
}
