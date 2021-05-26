package model;

import java.util.Random;

public class Maze {
    /**Player object */
    private Player myPlayer;
    /**2-d array of room representing the maze */
    private final Room [][] myMaze;
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
    /**Int value to keep track of what direction door is being accessed */
    private int userDir;
    
    
    
    /* Creates default 2-d array maze with 4x4 dimensions
     * 
     */
    public Maze() {
        myMaze = new Room [DEFAULT_SIZE][DEFAULT_SIZE];

        //fill maze with rooms
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
        myMaze [myXCount][myYCount].setPlayer(myPlayer);

        //current door object initialized
        myCurrentDoor = new Door();

        //default directions is up
        userDir = Room.UP;

        //Generate PowerUps in the Maze
        generatePowerUps();
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
        myMaze [myXCount][myYCount].setPlayer(myPlayer);

        myCurrentDoor = new Door();
        //default directions is up
        userDir = Room.UP;

        //Generate PowerUps in the Maze
        generatePowerUps();
    }


//    /** Returns current count of how many questions have been asked
//     *
//     * @return myQuestionCounter
//     */
//    public int getQuestionCount() {
//        return myQuestionCounter;
//    }
    
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
    public void doorSolution(final String theSolution) {
        myQuestionCounter ++;
        myCurrentDoor.checkLock(theSolution);

        checkSolution();
    }

    /** Checks how solution effected the door. Changes Maze state based on this.
     *
     */
    private void checkSolution() {
        if (myCurrentDoor.isLocked() == false) {
            myCorrectCounter ++;
            if (checkWin() == true) {
                return;
            } else {
                incrementMaze();
                myPlayer.setLocation(myYCount, myXCount);
                checkRoomPowerUp();
            }
        }
        else {
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
        userDir = theDir;

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

    /** Fills each location the 2-d array maze with Rooms
     *
     */
    private void fillMaze() {
        for (int n = 0; n < myMaze.length; n++) {
            for (int i = 0; i < myMaze[0].length; i++) {
                myMaze [n][i] = new Room();
            }
        }
    }

    /** Increments Maze array depending on current door
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
        final Room currentRoom = myMaze [myXCount][myYCount];

        boolean up = currentRoom.getDoorPermaLock(Room.UP);
        boolean left = currentRoom.getDoorPermaLock(Room.LEFT);
        boolean down = currentRoom.getDoorPermaLock(Room.DOWN);
        boolean right = currentRoom.getDoorPermaLock(Room.RIGHT);

        //If three of the four doors are permanently locked, game is over
        if ((up ? 1:0) + (left ? 1:0) + (down ? 1:0) + (right ? 1:0) == 3 && myPlayer.containsPermaUnlock() == false) {
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

        final int maxX = myMaze.length;
        final int min = 0;
        final int maxY = myMaze[0].length;

        PowerUp tempPower;

        //randNumX = (int) Math.floor(Math.random() * (maxX + 1)) - 1;
        // randNumY = (int) Math.floor(Math.random() * (maxY + 1)) - 1;

        //Generate 2 PowerUps
        randNumX = randNum.nextInt(myMaze.length );
        randNumY = randNum.nextInt(myMaze[0].length);

        tempPower = PowerUp.createFreeQuestion();
        getRoom(randNumX, randNumY).setRoomWithPowerUp(tempPower);


        // randNumX = (int) Math.floor(Math.random() * (maxX + 1));
        //randNumY = (int) Math.floor(Math.random() * (maxY + 1));

        randNumX = randNum.nextInt(myMaze.length);
        randNumY = randNum.nextInt(myMaze[0].length);

        tempPower = PowerUp.createPermaUnlock();
        getRoom(randNumX, randNumY).setRoomWithPowerUp(tempPower);


    }

    /** Checks if current room has a PowerUp and if it does the player picks it up
     *
     */
    private void checkRoomPowerUp() {
        if (this.getCurrentRoom().getRoomPowerUp().isFreeQuestion() || this.getCurrentRoom().getRoomPowerUp().isPermaUnlock()) {
            myPlayer.addPowerUp(this.getCurrentRoom().getRoomPowerUp());
        }
    }

    /*
    TEMPORARY (unless we want to keep it)
     */
    public void setXCount(final int theXCount) {
        this.myXCount = theXCount;
    }

    public void setYCount(final int theYCount) {
        this.myYCount = theYCount;
    }
}
