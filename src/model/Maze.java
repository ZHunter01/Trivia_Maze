package model;

public class Maze {
    private Player myPlayer;
    private Room [][] myMaze;
    private final static int DEFAULT_SIZE = 4;
    /**Boolean for if user has reached the final room */
    private boolean myWin;
    private int myQuestionCounter; 
    private int myXCount;
    private int myYCount;
    private Door myCurrentDoor;
    
    
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
    }
    
    
    public Maze(final int theX, final int theY) {
        myMaze = new Room [theX][theY];
        myWin = false;
        myQuestionCounter = 0;
        myXCount = 0;
        myYCount = 0;
        myCurrentDoor = new Door();
    }
    
    public Question doorUpQuestion() {
        myCurrentDoor = myMaze [myXCount][myYCount].accessUp(); 
        
        return myCurrentDoor.getQuestion();
    }
    
    public void doorUpSolution(final String theSolution) {
        if (myCurrentDoor.getQuestion().isSolution(theSolution.trim()) == true) {
            myYCount ++;
            myQuestionCounter ++;
            myCurrentDoor.setLock(false);
            myPlayer.setLocation(myYCount, myXCount);

        }
        else {
            myCurrentDoor.setPermaLock(true);
        }
    }
    
    public Question doorLeftQuestion() {
        myCurrentDoor = myMaze [myXCount][myYCount].accessLeft(); 
        
        return myCurrentDoor.getQuestion();
    }
    
    public void doorLeftSolution(final String theSolution) {
        if (myCurrentDoor.getQuestion().isSolution(theSolution.trim()) == true) {
            myXCount --;
            myQuestionCounter ++;
            myCurrentDoor.setLock(false);
            myPlayer.setLocation(myYCount, myXCount);

        }
        else {
            myCurrentDoor.setPermaLock(true);
        }
    }
    
    public Question doorRightQuestion() {
        myCurrentDoor = myMaze [myXCount][myYCount].accessRight(); 
        
        return myCurrentDoor.getQuestion();
    }
    
    public void doorRightSolution(final String theSolution) {
        if (myCurrentDoor.getQuestion().isSolution(theSolution.trim()) == true) {
            myXCount ++;
            myQuestionCounter ++;
            myCurrentDoor.setLock(false);
            myPlayer.setLocation(myYCount, myXCount);

        }
        else {
            myCurrentDoor.setPermaLock(true);
        }
        
    }  
        public Question doorDownQuestion() {
            myCurrentDoor = myMaze [myXCount][myYCount].accessDown(); 
            
            return myCurrentDoor.getQuestion();
        }
        
        public void doorDownSolution(final String theSolution) {
            if (myCurrentDoor.getQuestion().isSolution(theSolution.trim()) == true) {
                myYCount --;
                myQuestionCounter ++;
                myCurrentDoor.setLock(false);
                myPlayer.setLocation(myYCount, myXCount);
            }
            else {
                myCurrentDoor.setPermaLock(true);
            }
        }
        
    
}
