package model;

import java.io.Serializable;
import java.util.Random;


/**
 *
 * @author Zach Hunter
 *
 */
public class Maze implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 8788743892671639398L;
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
//    /**Int value to keep track of what direction door is being accessed */
//    private int userDir;


    /* Creates default 2-d array maze with 4x4 dimensions
     *
     */
    public Maze() {
        this(DEFAULT_SIZE, DEFAULT_SIZE);
    }

    /** Creates a 2-d array maze with specified dimensions
     *
     * @param theX
     * @param theY
     */
    public Maze(final int theX, final int theY) {
        //2-d array of specified size
        myMaze = new Room [theX][theY];
        //Fill maze with Rooms
        fillMaze();

        myWin = false;

        myPlayer = new Player();

        //How many questions have been asked
        myQuestionCounter = 0;
        //How many question have been answered correctly
        myCorrectCounter = 0;

        //Counters for the location in the 2-d array Maze
        myXCount = 0;
        myYCount = 0;
        //Add Player to initial Room
        //myMaze [myXCount][myYCount].setPlayer(myPlayer);

        myCurrentDoor = new Door();
        //default directions is up
        Room.userDir = 0;

        //Generate PowerUps in the Maze
        generatePowerUps();
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

    /** Returns current X count of the Maze
     *
     * @return myMaze.length
     */
    public int getXLength() {
        return myMaze.length;
    }

    /** Returns current Y count of the Maze
     *
     * @return myMaze[0].length
     */
    public int getYLength() {
        return myMaze[0].length;
    }

    /** Returns current x location in the Maze
     *
     * @return myXCount
     */
    public int getXCount() {
        return myXCount;
    }

    /** Returns current y location in the Maze
     *
     * @return myYCount
     */
    public int getYCount() {
        return myYCount;
    }

    /** Returns boolean if user has won the game
     *
     * @return myWin
     */
    public boolean getWin() {
        return myWin;
    }

    /** Returns boolean if user has lost the game
     *
     * @return myLose
     */
    public boolean getLose() {
        return myLose;
    }



    /** Returns current room
     *
     * @return myMaze [myXCount][myYCount]
     */
    public Room getCurrentRoom() {
        return myMaze [myXCount][myYCount];
    }

    /** Returns Room specified by the inputs theX and theY
     *
     * @param theX
     * @param theY
     * @return myMaze [theX][theY]
     */
    public Room getRoom(final int theX, final int theY) {
        return myMaze [theX][theY];
    }

    /** Returns current state of the 2-d array Maze
     *
     * @return myMaze
     */
    public Room[][] getMaze() {
        return myMaze;
    }

    /** Returns current state of the Player object
     *
     * @return myPlayer
     */
    public Player getPlayer() {
        return myPlayer;
    }

    /** Processes a user answer to question from a door.
     *  If answer is correct, check if user has won and increment maze
     *  Otherwise permanently lock the door and check if user has lost.
     *
     * @param theSolution
     */
    public void doorSolution(final String theSolution, final int theDir) {
        myQuestionCounter ++;
        Room.userDir = theDir;
        // myCorrectCounter++;
        myCurrentDoor = this.getCurrentRoom().getUserDoor(theDir);
        myCurrentDoor.checkLock(theSolution);

        checkSolution();
    }

    /** Checks how solution effected the door. Changes Maze state based on this.
     *
     */
    private void checkSolution() {
        //If answer was correct door should be unlocked
        if (!myCurrentDoor.isLocked()) {
            myCorrectCounter ++;
            incrementMaze();
            //Check for if the user has won the game
            if (hasWon()) {
                return;
            }
            //If answer was incorrect
        } else {
            //Check if user has lost
            if (hasLost()) {
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
        //Check if door attempting to be accessed is on the edge of the Maze
        if (theDir == Room.UP && myYCount - 1 < 0) {
            isIn = false;
        } else if (theDir == Room.LEFT && myXCount - 1 < 0) {
            isIn = false;
        } else if (theDir == Room.DOWN && myYCount + 1 >= myMaze.length) {
            isIn = false;
        } else if (theDir == Room.RIGHT && myXCount + 1 >= myMaze.length) {
            isIn = false;
        } else {
            isIn = true;
        }
        return isIn;
    }

    /** Processes PowerUp ability and updates maze. Removes PowerUp from Player object
     *
     * @param thePowerUp
     */
    public void usePowerUp(final PowerUp thePowerUp, final int theDir) {
        Room.userDir = theDir;

        if (thePowerUp.isFreeQuestion()) {
            incrementMaze();
        } else if (thePowerUp.isPermaUnlock()){
            if (!getCurrentRoom().getUserDoor(theDir).isPermaLocked()) {
                return;
            } else {
                getCurrentRoom().unlockPermaLock(theDir);
            }
        } else {
            return;
        }

        myPlayer.removePowerUp(thePowerUp);
    }

    /** Sets the door opposite of the input to be PermaLocked
     *
     */
    public void reverseDoorPermaLock(final int theDir) {
        //UP to DOWN
        if (theDir == Room.UP) {
            this.getCurrentRoom().getUserDoor(Room.DOWN).setPermaLock(true);
            //LEFT to RIGHT
        } else if (theDir == Room.LEFT) {
            this.getCurrentRoom().getUserDoor(Room.RIGHT).setPermaLock(true);
            //DOWN to UP
        } else if (theDir == Room.DOWN) {
            this.getCurrentRoom().getUserDoor(Room.UP).setPermaLock(true);
            //RIGHT to LEFT
        } else if (theDir == Room.RIGHT) {
            this.getCurrentRoom().getUserDoor(Room.LEFT).setPermaLock(true);
            //Value not within 0-3
        } else {
            throw new IllegalArgumentException("Error: Improper door directional value.");
        }
    }

    /** Checks if current room has a PowerUp and if it does the player picks it up
     *
     */
    public void checkRoomPowerUp() {
        if (this.getCurrentRoom().getRoomPowerUp().isFreeQuestion() || this.getCurrentRoom().getRoomPowerUp().isPermaUnlock()) {
            myPlayer.addPowerUp(this.getCurrentRoom().getRoomPowerUp());
        }
    }

    /** Fills each location the 2-d array maze with Rooms
     *
     */
    private void fillMaze() {
        for (int n = 0; n < myMaze.length; n++) {
            for (int i = 0; i < myMaze[0].length; i++) {
                myMaze [n][i] = new Room();
                if (n == 0) {
                    myMaze [n][i].getUserDoor(Room.LEFT).setPermaLock(true);
                }
                if (i == 0) {
                    myMaze [n][i].getUserDoor(Room.UP).setPermaLock(true);
                }
                if (n == myMaze.length - 1) {
                    myMaze [n][i].getUserDoor(Room.RIGHT).setPermaLock(true);
                }
                if (i == myMaze[0].length - 1) {
                    myMaze [n][i].getUserDoor(Room.DOWN).setPermaLock(true);
                }
            }
        }
    }


    /** Increments Maze array depending on current door
     *
     */
    private void incrementMaze() {
        if (Room.userDir == Room.UP) {
            myYCount --;
        } else if (Room.userDir == Room.LEFT) {
            myXCount --;
        } else if (Room.userDir == Room.DOWN) {
            myYCount ++;
        } else if (Room.userDir == Room.RIGHT) {
            myXCount ++;
        } else {
            throw new IllegalArgumentException("Error: Improper door directional value.");
        }
        myPlayer.move(Room.userDir);
    }

    /** If x count and y count match the max size of the 2-d array return myWin as true
     *
     * @return myWin
     */
    private boolean hasWon() {
        if (myXCount == myMaze[0].length - 1 && myYCount == myMaze.length - 1) {
            myWin = true;
        }
        return myWin;
    }

    /** Checks if three of four doors in the current room are locked
     *
     * @return myLose
     */
    private boolean hasLost() {
        final Room currentRoom = myMaze [myXCount][myYCount];

        boolean up = currentRoom.getDoorPermaLock(Room.UP);
        boolean left = currentRoom.getDoorPermaLock(Room.LEFT);
        boolean down = currentRoom.getDoorPermaLock(Room.DOWN);
        boolean right = currentRoom.getDoorPermaLock(Room.RIGHT);

        //If three of the four doors are permanently locked, game is over
        if ((up ? 1:0) + (left ? 1:0) + (down ? 1:0) + (right ? 1:0) == 4 && !myPlayer.containsPermaUnlock()) {
            myLose = true;
        }

        return myLose;
    }

    /** Generates 2 PowerUps in 2 random rooms in the maze
     *
     */
    private void generatePowerUps() {
        //ToDo
        Random randNum = new Random();

        int randNumX;
        int randNumY;

        PowerUp tempPower;

        //Generate FreeQuestion PowerUp
        randNumX = randNum.nextInt(myMaze.length );
        randNumY = randNum.nextInt(myMaze[0].length);

        tempPower = PowerUp.createFreeQuestion();
        getRoom(randNumX, randNumY).setRoomWithPowerUp(tempPower);

        //Generate PermaUnlock PowerUp
        randNumX = randNum.nextInt(myMaze.length);
        randNumY = randNum.nextInt(myMaze[0].length);

        tempPower = PowerUp.createPermaUnlock();
        getRoom(randNumX, randNumY).setRoomWithPowerUp(tempPower);


    }

}